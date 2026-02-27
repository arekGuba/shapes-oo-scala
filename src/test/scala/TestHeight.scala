package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestHeight extends AnyFunSuite:

  def testHeight(description: String, s: Shape, expectedHeight: Int): Unit =
    test(description):
      val result = height(s)
      assert(result == expectedHeight)

  testHeight("simple rectangle", simpleRectangle, 1)
  testHeight("simple ellipse", simpleEllipse, 1)
  testHeight("simple location wraps rectangle", simpleLocation, 2)
  testHeight("basic group height", basicGroup, 2)
  testHeight("simple group height", simpleGroup, 3)
  testHeight("complex group with multiple nesting levels", complexGroup, 6)

end TestHeight
