package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int):
    require(width > 0 && height > 0, "Rectangle dimensions must be positive")
  
  case Location(x: Int, y: Int, shape: Shape)
  
  case Ellipse(r: Int, radiusY: Int):
    require(r > 0 && radiusY > 0, "Ellipse radii must be positive")
  
  case Group(shapes: Shape*):
    require(shapes.nonEmpty, "Group must contain at least one shape")
