# Shapes OO Scala Project

This project demonstrates object-oriented programming concepts in Scala, including algebraic data types, pattern matching, recursive functions, and their relationships with composite, decorator, and visitor patterns.

## Project Structure

- `src/main/scala/shapes.scala` - Defines the Shape algebraic data type with case classes for Rectangle, Location, Ellipse, and Group
- `src/main/scala/boundingBox.scala` - Computes bounding boxes for shapes (composite pattern)
- `src/main/scala/size.scala` - Counts concrete leaf shapes (visitor pattern)
- `src/main/scala/height.scala` - Computes shape tree height (visitor pattern)
- `src/main/scala/scale.scala` - Recursively scales shape dimensions (decorator pattern)
- `src/test/scala/` - Comprehensive test suites with fixtures

## Implemented Behaviors

### 1. BoundingBox
Computes the axis-aligned bounding box for any shape:
- **Rectangle**: Returns box at origin with same dimensions
- **Ellipse**: Returns rectangular box at origin with diameter dimensions
- **Location**: Returns offset box based on inner shape
- **Group**: Returns box encompassing all contained shapes
- Uses: `map`, `min`/`max` on collections

**Tests**: 6 test cases in `TestBoundingBox`

### 2. Size
Counts the number of concrete leaf shapes (Rectangle and Ellipse only):
- **Rectangle/Ellipse**: Count as 1
- **Location**: Forwards count to inner shape
- **Group**: Sums counts of all contained shapes
- Uses: `map`, `sum` on collections

**Tests**: 6 test cases in `TestSize`

### 3. Height
Computes the height of the shape tree (depth including all node types):
- **Rectangle/Ellipse**: Height is 1
- **Location**: Height is 1 + inner shape's height
- **Group**: Height is 1 + maximum height of children
- Uses: `map`, `max` on collections

**Tests**: 6 test cases in `TestHeight`

### 4. Scale
Recursively scales all shape dimensions by a factor:
- **Rectangle/Ellipse**: Multiply dimensions by factor
- **Location**: Scale both coordinates and inner shape
- **Group**: Recursively scale all contained shapes
- Converts results to Int using `toInt`

**Tests**: 7 test cases in `TestScale`

## Constructor Validity Checking

The Shape enum includes `require` statements to validate:
- **Rectangle**: Width and height must be positive (> 0)
- **Ellipse**: Both radii must be positive (> 0)
- **Group**: Must contain at least one shape (non-empty)
- **Location**: No explicit validation (coordinates can be any Int)

**Tests**: `TestShapeValidation` with 10 validation test cases

## Logging Configuration

The project uses `scala-logging` with `logback-classic` for configurable debug output:
- Configuration: `src/main/resources/logback.xml`
- All behavior functions (boundingBox, size, height, scale) include debug logging
- Root logger level can be configured; shape logger is set to DEBUG
- Logs are output to console with timestamp, level, logger name, and message

## Test Fixtures

Common test fixtures are defined in `TestFixtures`:
- `simpleRectangle`: Basic 80x120 rectangle
- `simpleEllipse`: Ellipse with radii 50x30
- `simpleLocation`: Rectangle at coordinates (70, 30)
- `basicGroup`: Contains ellipse and rectangle
- `simpleGroup`: Two located shapes
- `complexGroup`: Deeply nested structure with multiple levels

## Functional Requirements Met

✓ All behaviors implemented using functional/immutable programming  
✓ Extensive use of `map`, `foldLeft`/`sum`, and `min`/`max`  
✓ Test suites for all behaviors using ScalaTest  
✓ Constructor validity checking with comprehensive tests  
✓ Configurable logging output using logback  
✓ Original project structure retained  

## Building and Testing

```bash
# Run all tests
sbt test

# Compile only
sbt compile

# Run main application
sbt "runMain edu.luc.cs.laufer.cs371.shapes.Main"

# Clean build
sbt clean
```

## Dependencies

- Scala 3.7.3
- ScalaTest 3.2.19 (testing)
- ScalaCheck 1.19.0 (property-based testing)
- Doodle 0.32.0 (graphics library)
- scala-logging 3.9.5 (logging)
- logback-classic 1.5.6 (logging backend)

## Design Patterns

This project demonstrates several classic design patterns:

1. **Composite Pattern**: The Shape ADT with Group allows building hierarchical structures
2. **Visitor Pattern**: Behaviors like size, height, and scale visit each node
3. **Decorator Pattern**: Location "decorates" a shape with positioning information

## Scala Features Demonstrated

- Algebraic Data Types (enums with case classes)
- Pattern Matching (exhaustive matching on Shape variants)
- Recursive Functions (all behaviors recurse through shape structure)
- Scala Collections Library (map, sum, min, max, fold operations)
- Object-Oriented and Functional Programming Integration
- Require statements for constructor validation
- LazyLogging trait for debug output
