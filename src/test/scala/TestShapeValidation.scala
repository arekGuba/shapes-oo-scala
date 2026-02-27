package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import Shape.*

class TestShapeValidation extends AnyFunSuite:

  test("Rectangle with positive dimensions should be valid"):
    val rect = Rectangle(10, 20)
    assert(rect.width == 10)
    assert(rect.height == 20)

  test("Rectangle with zero width should throw"):
    assertThrows[IllegalArgumentException]:
      Rectangle(0, 20)

  test("Rectangle with zero height should throw"):
    assertThrows[IllegalArgumentException]:
      Rectangle(10, 0)

  test("Rectangle with negative width should throw"):
    assertThrows[IllegalArgumentException]:
      Rectangle(-10, 20)

  test("Rectangle with negative height should throw"):
    assertThrows[IllegalArgumentException]:
      Rectangle(10, -20)

  test("Ellipse with positive radii should be valid"):
    val ellipse = Ellipse(15, 25)
    assert(ellipse.r == 15)
    assert(ellipse.radiusY == 25)

  test("Ellipse with zero radius should throw"):
    assertThrows[IllegalArgumentException]:
      Ellipse(0, 25)

  test("Ellipse with negative radius should throw"):
    assertThrows[IllegalArgumentException]:
      Ellipse(-15, 25)

  test("Group with shapes should be valid"):
    val group = Group(Rectangle(10, 20), Ellipse(5, 10))
    assert(group.shapes.size == 2)

  test("Group with no shapes should throw"):
    assertThrows[IllegalArgumentException]:
      Group()

  test("Location with valid shape should be valid"):
    val location = Location(10, 20, Rectangle(30, 40))
    assert(location.x == 10)
    assert(location.y == 20)

end TestShapeValidation
