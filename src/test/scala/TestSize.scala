package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestSize extends AnyFunSuite:

  def testSize(description: String, s: Shape, expectedSize: Int): Unit =
    test(description):
      val result = size(s)
      assert(result == expectedSize)

  testSize("simple rectangle", simpleRectangle, 1)
  testSize("simple ellipse", simpleEllipse, 1)
  testSize("simple location", simpleLocation, 1)
  testSize("basic group with 2 shapes", basicGroup, 2)
  testSize("simple group with 2 shapes", simpleGroup, 2)
  testSize("complex group with multiple shapes", complexGroup, 5)

end TestSize
