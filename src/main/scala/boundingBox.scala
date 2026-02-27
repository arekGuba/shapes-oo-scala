package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(w, h) => Location(0, 0, Rectangle(w, h))

    case Ellipse(r, radiusY) => Location(0, 0, Rectangle(2 * r, 2 * radiusY))

    case Location(x, y, shape) => 
      val Location(u, v, Rectangle(w, h)) = boundingBox(shape)
      Location(x + u, y + v, Rectangle(w, h))

    case Group(shapes*) => 
      val boxes = shapes.map(boundingBox)
      val xMin = boxes.map(_.x).min
      val yMin = boxes.map(_.y).min
      val xMax = boxes.map(_.x + _.width).max
      val yMax = boxes.map(_.y + _.height).max
      Location(xMin, yMin, Rectangle(xMax - xMin, yMax - yMin))

end boundingBox
