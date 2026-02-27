package edu.luc.cs.laufer.cs371.shapes

import TestFixtures.*
import Shape.Rectangle
import com.typesafe.scalalogging.LazyLogging

object Main extends LazyLogging:
  def main(args: Array[String]): Unit =
    logger.info("=== Demonstrating Shape Behaviors ===")
    
    logger.info(s"\n1. Bounding Box for simpleLocation:")
    logger.info(s"   Shape: $simpleLocation")
    logger.info(s"   Bounding Box: ${boundingBox(simpleLocation)}")
    
    logger.info(s"\n2. Size (count leaf shapes) for complexGroup:")
    logger.info(s"   Shape: $complexGroup")
    logger.info(s"   Size: ${size(complexGroup)}")
    
    logger.info(s"\n3. Height (tree depth) for complexGroup:")
    logger.info(s"   Shape: $complexGroup")
    logger.info(s"   Height: ${height(complexGroup)}")
    
    logger.info(s"\n4. Scale complexGroup by 2.0:")
    logger.info(s"   Original: $complexGroup")
    val scaled = scale(2.0, complexGroup)
    logger.info(s"   Scaled: $scaled")
    
    logger.info(s"\n5. Verify equality:")
    logger.info(s"   Rectangle(2, 3) == Rectangle(2, 3): ${Rectangle(2, 3) == Rectangle(2, 3)}")
    
    logger.info("\n=== Demonstration Complete ===")

end Main
