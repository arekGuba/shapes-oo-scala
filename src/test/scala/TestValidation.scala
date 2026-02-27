package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import Shape.*

class TestValidation extends AnyFunSuite:

  test("Rectangle negative width"):
    assertThrows[IllegalArgumentException](Rectangle(-1, 10))

  test("Rectangle negative height"):
    assertThrows[IllegalArgumentException](Rectangle(10, -5))

  test("Ellipse negative radius"):
    assertThrows[IllegalArgumentException](Ellipse(-2, 5))

  test("Ellipse negative radiusY"):
    assertThrows[IllegalArgumentException](Ellipse(5, -3))

  test("Group null shapes"):
    assertThrows[IllegalArgumentException](Group(null: _*))

  // valid shapes should not throw
  test("Valid rectangle"):
    Rectangle(0,0)
  test("Valid ellipse"):
    Ellipse(1,1)
  test("Valid group"):
    Group()

end TestValidation
