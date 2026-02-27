package edu.luc.cs.laufer.cs371.shapes

enum Shape derives CanEqual:

  case Rectangle(width: Int, height: Int) extends Shape:
    require(width >= 0 && height >= 0, s"Rectangle dimensions must be non-negative, got ($width,$height)")

  case Location(x: Int, y: Int, shape: Shape) extends Shape
    // location coordinates may be negative; no additional validation

  case Ellipse(r: Int, radiusY: Int) extends Shape:
    require(r >= 0 && radiusY >= 0, s"Ellipse radii must be non-negative, got ($r,$radiusY)")

  case Group(shapes: Shape*) extends Shape:
    require(shapes.forall(_ != null), "Group shapes cannot contain null")

