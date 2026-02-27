package edu.luc.cs.laufer.cs371.shapes

import com.typesafe.scalalogging.StrictLogging

import Shape.*

object height extends StrictLogging:
  def apply(s: Shape): Int = 
    logger.debug(s"Computing height for shape: $s")
    val result = s match
      case Rectangle(w, h) => 
        logger.debug(s"Rectangle($w, $h) has height 1")
        1
      case Ellipse(r, radiusY) => 
        logger.debug(s"Ellipse($r, $radiusY) has height 1")
        1
      case Location(x, y, shape) => 
        val innerHeight = apply(shape)
        val result = 1 + innerHeight
        logger.debug(s"Location($x, $y, ...) has height $result")
        result
      case Group(shapes*) => 
        val childHeights: Seq[Int] = shapes.map(apply)
        val result = if childHeights.isEmpty then 1 else 1 + childHeights.max
        logger.debug(s"Group with ${shapes.length} shapes has height $result")
        result
    logger.info(s"Height computed: $result")
    result

end height
