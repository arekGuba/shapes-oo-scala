package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*
import com.typesafe.scalalogging.LazyLogging

object boundingBox extends LazyLogging:
  def apply(s: Shape): Location = 
    logger.debug(s"Computing bounding box for shape: $s")
    val result: Location = s match
    case Rectangle(w, h) => Location(0, 0, Rectangle(w, h))

    case Ellipse(r, radiusY) => Location(0, 0, Rectangle(2 * r, 2 * radiusY))

    case Location(x, y, shape) => 
      val Location(u, v, Rectangle(w, h)) = boundingBox(shape) : @unchecked
      Location(x + u, y + v, Rectangle(w, h))

    case Group(shapes*) => 
      val boxes = shapes.map(apply)
      val xMin = boxes.map(_.x).min
      val yMin = boxes.map(_.y).min
      val xMax = boxes.map { case Location(x, _, Rectangle(w, _)) => x + w }.max
      val yMax = boxes.map { case Location(_, y, Rectangle(_, h)) => y + h }.max
      Location(xMin, yMin, Rectangle(xMax - xMin, yMax - yMin))
    
    logger.debug(s"Bounding box result: $result")
    result

end boundingBox
