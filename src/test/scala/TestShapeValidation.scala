package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import Shape.*

class TestShapeValidation extends AnyFunSuite:

  test("Rectangle with positive dimensions should be valid"):
    Shape.requireValidRectangle(10, 20)
    val rect = Rectangle(10, 20)
    rect match
      case Rectangle(w, h) =>
        assert(w == 10)
        assert(h == 20)
      case _ => fail("Expected Rectangle")

  test("Rectangle with zero width should throw"):
    assertThrows[IllegalArgumentException]:
      Shape.requireValidRectangle(0, 20)

  test("Rectangle with zero height should throw"):
    assertThrows[IllegalArgumentException]:
      Shape.requireValidRectangle(10, 0)

  test("Rectangle with negative width should throw"):
    assertThrows[IllegalArgumentException]:
      Shape.requireValidRectangle(-10, 20)

  test("Rectangle with negative height should throw"):
    assertThrows[IllegalArgumentException]:
      Shape.requireValidRectangle(10, -20)

  test("Ellipse with positive radii should be valid"):
    Shape.requireValidEllipse(15, 25)
    val ellipse = Ellipse(15, 25)
    ellipse match
      case Ellipse(r, radiusY) =>
        assert(r == 15)
        assert(radiusY == 25)
      case _ => fail("Expected Ellipse")

  test("Ellipse with zero radius should throw"):
    assertThrows[IllegalArgumentException]:
      Shape.requireValidEllipse(0, 25)

  test("Ellipse with negative radius should throw"):
    assertThrows[IllegalArgumentException]:
      Shape.requireValidEllipse(-15, 25)

  test("Group with shapes should be valid"):
    Shape.requireValidGroup(Seq(Rectangle(10, 20), Ellipse(5, 10)))
    val group = Group(Rectangle(10, 20), Ellipse(5, 10))
    group match
      case Group(shapes*) =>
        assert(shapes.size == 2)
      case _ => fail("Expected Group")

  test("Group with no shapes should throw"):
    assertThrows[IllegalArgumentException]:
      Shape.requireValidGroup(Seq())

  test("Location with valid shape should be valid"):
    val location = Location(10, 20, Rectangle(30, 40))
    location match
      case Location(x, y, _) =>
        assert(x == 10)
        assert(y == 20)
      case _ => fail("Expected Location")

end TestShapeValidation

