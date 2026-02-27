package edu.luc.cs.laufer.cs371.shapes

import com.typesafe.scalalogging.StrictLogging

import Shape.*

object scale extends StrictLogging:
  def apply(factor: Int)(s: Shape): Shape = 
    logger.debug(s"Scaling shape by factor $factor: $s")
    val result = s match
      case Rectangle(w, h) => 
        val r = Rectangle(w * factor, h * factor)
        logger.debug(s"Rectangle($w, $h) scaled by $factor -> $r")
        r
      case Ellipse(r, radiusY) => 
        val result = Ellipse(r * factor, radiusY * factor)
        logger.debug(s"Ellipse($r, $radiusY) scaled by $factor -> $result")
        result
      case Location(x, y, shape) => 
        val scaled = apply(factor)(shape)
        val result = Location(x * factor, y * factor, scaled)
        logger.debug(s"Location($x, $y, ...) scaled by $factor -> $result")
        result
      case Group(shapes*) => 
        val scaled: Seq[Shape] = shapes.map(apply(factor))
        val result = Group(scaled*)
        logger.debug(s"Group with ${shapes.length} shapes scaled by $factor")
        result
    logger.info(s"Scaling complete by factor $factor: $result")
    result

end scale
