package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Ellipse(r: Int, radiusY: Int)
  case Group(shapes: Shape*)

object Shape:
  def requireValidRectangle(width: Int, height: Int): Unit =
    require(width > 0 && height > 0, "Rectangle dimensions must be positive")

  def requireValidEllipse(r: Int, radiusY: Int): Unit =
    require(r > 0 && radiusY > 0, "Ellipse radii must be positive")

  def requireValidGroup(shapes: Seq[Shape]): Unit =
    require(shapes.nonEmpty, "Group must contain at least one shape")
