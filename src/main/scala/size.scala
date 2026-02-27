package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.LazyLogging

/** Counts the number of concrete leaf shapes (Ellipses and Rectangles) */
object size extends LazyLogging:
  def apply(s: Shape): Int = 
    logger.debug(s"Computing size for shape: $s")
    val result: Int = s match
    case Rectangle(_, _) => 1
    case Ellipse(_, _) => 1
    case Location(_, _, shape) => apply(shape)
    case Group(shapes*) => shapes.map(apply).sum
    
    logger.debug(s"Size result: $result")
    result

end size
