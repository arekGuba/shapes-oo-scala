package edu.luc.cs.laufer.cs371.shapes

/** A geometric shape hierarchy */
enum Shape derives CanEqual:

  /** Rectangle with non-negative width and height */
  case Rectangle(width: Int, height: Int) :
    require(width >= 0 && height >= 0,
      s"Rectangle dimensions must be non-negative, got ($width, $height)")

  /** Location offset for a shape (x and y coordinates may be negative) */
  case Location(x: Int, y: Int, shape: Shape)

  /** Ellipse with non-negative radii */
  case Ellipse(radiusX: Int, radiusY: Int) :
    require(radiusX >= 0 && radiusY >= 0,
      s"Ellipse radii must be non-negative, got ($radiusX, $radiusY)")

  /** Group of shapes; no shape may be null */
  case Group(shapes: Shape*) :
    require(shapes.forall(_ != null), "Group shapes cannot contain null")

