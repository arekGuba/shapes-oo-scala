package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:

  def testScale(description: String, s: Shape, factor: Int, expected: Shape): Unit =
    test(description):
      assert(expected == scale(factor)(s))

  testScale("scale ellipse by 2", simpleEllipse, 2, Ellipse(100, 60))
  testScale("scale rectangle by 2", simpleRectangle, 2, Rectangle(160, 240))
  testScale("scale location by 2", simpleLocation, 2, Location(140, 60, Rectangle(160, 240)))
  testScale("scale basic group by 2", basicGroup, 2, Group(Ellipse(100, 60), Rectangle(40, 80)))
  testScale("scale simple group by 2", simpleGroup, 2, 
    Group(
      Location(400, 200, Ellipse(100, 60)),
      Location(800, 600, Rectangle(200, 100))
    ))
  testScale("scale complex group by 1", complexGroup, 1, complexGroup)

end TestScale
