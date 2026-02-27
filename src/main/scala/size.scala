package edu.luc.cs.laufer.cs371.shapes

import com.typesafe.scalalogging.StrictLogging

import Shape.*

object size extends StrictLogging:
  def apply(s: Shape): Int = 
    logger.debug(s"Computing size for shape: $s")
    val result = s match
      case Rectangle(w, h) => 
        logger.debug(s"Rectangle($w, $h) has size 1")
        1
      case Ellipse(r, radiusY) => 
        logger.debug(s"Ellipse($r, $radiusY) has size 1")
        1
      case Location(x, y, shape) => 
        val result = apply(shape)
        logger.debug(s"Location($x, $y, ...) has size $result")
        result
      case Group(shapes*) => 
        val sizes: Seq[Int] = shapes.map(s => apply(s))
        val result = sizes.sum
        logger.debug(s"Group with ${shapes.length} shapes has total size $result")
        result
    logger.info(s"Size computed: $result")
    result

end size
