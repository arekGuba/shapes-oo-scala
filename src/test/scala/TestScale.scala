package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:

  def testScale(description: String, factor: Double, s: Shape, expected: Shape): Unit =
    test(description):
      val result = scale(factor, s)
      assert(result == expected)

  testScale("scale rectangle by 2", 2.0, simpleRectangle, Rectangle(160, 240))
  testScale("scale rectangle by 0.5", 0.5, simpleRectangle, Rectangle(40, 60))
  testScale("scale ellipse by 2", 2.0, simpleEllipse, Ellipse(100, 60))
  testScale("scale location by 2", 2.0, simpleLocation, Location(140, 60, Rectangle(160, 240)))
  testScale("scale location by 0.5", 0.5, simpleLocation, Location(35, 15, Rectangle(40, 60)))
  testScale("scale group by 2", 2.0, basicGroup, Group(Ellipse(100, 60), Rectangle(40, 80)))
  testScale("scale complex nested shape", 2.0, complexGroup, 
    Location(100, 200,
      Group(
        Ellipse(40, 80),
        Location(300, 100,
        Group(
          Rectangle(100, 60),
          Rectangle(600, 120),
          Location(200, 400,
            Ellipse(100, 60)
          )
      )),
      Rectangle(200, 400)
    )))

end TestScale
