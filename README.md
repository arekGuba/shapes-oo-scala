# Shapes OO Scala

This repository implements an object-oriented representation of shapes in Scala.

## Features implemented

- Algebraic data type `Shape` with cases for `Rectangle`, `Ellipse`, `Location`, and `Group`.
- Behaviors:
  - `boundingBox` computes a minimal enclosing rectangle for any shape, using recursive pattern matching and Scala collections methods (`map`, `min`, `max`, `sum`).
  - `size` counts the number of leaf shapes (rectangles and ellipses).
  - `height` computes the height of the shape tree.
  - `scale` recursively scales all dimensions by a factor.
- Constructor validation with `require(...)` to enforce non-negative dimensions.
- Logging support using `scala-logging` and `logback` with debug output enabled for the `edu.luc.cs.laufer.cs371.shapes` package.
- Comprehensive unit tests, including `TestBoundingBox`, `TestSize`, `TestHeight`, `TestScale`, and validity tests in `TestValidation`.

## Extra Credit

- Logging configuration included; debug messages printed when behaviors are executed.
- **Graphical rendering** (not implemented) would be potential extra credit with Doodle or BufferedImage.


## Running

Run the main application or tests using `sbt` (not available in this environment).

```sh
sbt run
sbt test
```

## Notes

All code is immutable and functional where appropriate. The project structure is preserved as required.
