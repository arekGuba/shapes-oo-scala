package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.LazyLogging

/** Recursively scales the dimensions of a shape by a given factor */
object scale extends LazyLogging:
  def apply(factor: Double, s: Shape): Shape = 
    logger.debug(s"Scaling shape by factor $factor: $s")
    val result = s match
    case Rectangle(w, h) => Rectangle((w * factor).toInt, (h * factor).toInt)
    case Ellipse(r, radiusY) => Ellipse((r * factor).toInt, (radiusY * factor).toInt)
    case Location(x, y, shape) => Location((x * factor).toInt, (y * factor).toInt, apply(factor, shape))
    case Group(shapes*) => Group(shapes.map(s => apply(factor, s))*)
    
    logger.debug(s"Scale result: $result")
    result

end scale
