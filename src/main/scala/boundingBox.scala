package edu.luc.cs.laufer.cs371.shapes

import com.typesafe.scalalogging.StrictLogging

import Shape.*

object boundingBox extends StrictLogging:
  def apply(s: Shape): Location =
    logger.debug(s"Computing bounding box for shape: $s")
    val result = s match
      case Rectangle(w, h) => 
        val r = Location(0, 0, Rectangle(w, h))
        logger.debug(s"Rectangle($w, $h) -> $r")
        r

      case Ellipse(r, radiusY) => 
        // ellipse centered at origin; bounding box extends r and radiusY in each direction
        val result = Location(-r, -radiusY, Rectangle(2 * r, 2 * radiusY))
        logger.debug(s"Ellipse($r, $radiusY) -> $result")
        result

      case Location(x, y, shape) => 
        val Location(u, v, Rectangle(w, h)) = boundingBox(shape)
        val result = Location(x + u, y + v, Rectangle(w, h))
        logger.debug(s"Location($x, $y, ...) -> $result")
        result

      case Group(shapes*) if shapes.isEmpty =>
        val result = Location(0,0,Rectangle(0,0))
        logger.debug(s"Empty group -> $result")
        result
      case Group(shapes*) => 
        // compute bounding boxes for children and fold
        val boxes: Seq[Location] = shapes.map(s => boundingBox(s))
        val xMin = boxes.map(_.x).min
        val yMin = boxes.map(_.y).min
        val xMax = boxes.map {
          case Location(x, _, Rectangle(w, _)) => x + w
        }.max
        val yMax = boxes.map {
          case Location(_, y, Rectangle(_, h)) => y + h
        }.max
        val result = Location(xMin, yMin, Rectangle(xMax - xMin, yMax - yMin))
        logger.debug(s"Group with ${shapes.length} shapes -> $result")
        result
    logger.info(s"Bounding box computed: $result")
    result

end boundingBox
