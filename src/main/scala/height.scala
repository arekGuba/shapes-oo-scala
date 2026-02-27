package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.LazyLogging

/** Computes the height of the shape tree (considering all kinds of shape nodes) */
object height extends LazyLogging:
  def apply(s: Shape): Int = 
    logger.debug(s"Computing height for shape: $s")
    val result = s match
    case Rectangle(_, _) => 1
    case Ellipse(_, _) => 1
    case Location(_, _, shape) => 1 + apply(shape)
    case Group(shapes*) => 1 + (if shapes.isEmpty then 0 else shapes.map(apply).max)
    
    logger.debug(s"Height result: $result")
    result

end height
