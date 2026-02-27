package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*
import com.typesafe.scalalogging.LazyLogging

object boundingBox extends LazyLogging:
  def apply(s: Shape): Location = 
    logger.debug(s"Computing bounding box for shape: $s")
    val result: Location = s match
    case Rectangle(w, h) => Location(0, 0, Rectangle(w, h))

    case Ellipse(r, radiusY) => Location(-r, -radiusY, Rectangle(2 * r, 2 * radiusY))

    case Location(x, y, shape) => 
      val Location(u, v, Rectangle(w, h)) = boundingBox(shape) : @unchecked
      Location(x + u, y + v, Rectangle(w, h))

    case Group(shapes*) => 
      val boxes: scala.collection.immutable.Seq[Location] = shapes.map(apply)
      val (xMin, yMin, xMax, yMax) = boxes.foldLeft((Int.MaxValue, Int.MaxValue, Int.MinValue, Int.MinValue)) {
        case ((xMin, yMin, xMax, yMax), Location(x, y, Rectangle(w, h))) =>
          (math.min(xMin, x), math.min(yMin, y), math.max(xMax, x + w), math.max(yMax, y + h))
      }
      Location(xMin, yMin, Rectangle(xMax - xMin, yMax - yMin))
    
    logger.debug(s"Bounding box result: $result")
    result

end boundingBox
