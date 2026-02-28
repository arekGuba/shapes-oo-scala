package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.LazyLogging

object Main extends LazyLogging:
  def main(args: Array[String]): Unit =
    // Define shapes inline since this is in main source
    val simpleEllipse = Ellipse(50, 30)
    val simpleRectangle = Rectangle(80, 120)
    val simpleLocation = Location(70, 30, Rectangle(80, 120))
    val basicGroup = Group(Ellipse(50, 30), Rectangle(20, 40))
    val simpleGroup = Group(
      Location(200, 100, Ellipse(50, 30)),
      Location(400, 300, Rectangle(100, 50))
    )
    val complexGroup =
      Location(50, 100,
        Group(
          Ellipse(20, 40),
          Location(150, 50,
          Group(
            Rectangle(50, 30),
            Rectangle(300, 60),
            Location(100, 200,
              Ellipse(50, 30)
            )
        )),
        Rectangle(100, 200)
      ))
    
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

