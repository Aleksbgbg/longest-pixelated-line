import java.util.function.Function;

public class Program {
  // Naive solution: nice and simple. runtime O(n^3), space O(1).
  public static int getLongestPixelatedLineNaive(boolean[][] matrix) {
    int n = matrix.length;

    int max = 0;

    for (int x = 0; x < n; ++x) {
      for (int y = 0; y < n; ++y) {        
        if (matrix[x][y]) {
          int length = 0;

          // Vertical lines
          for (int xOffset = 0; xOffset < (n - x); ++xOffset) {
            if (matrix[x + xOffset][y]) {
              ++length;
            } else {
              break;
            }
          }
          
          max = Math.max(max, length);
          length = 0;

          // Horizontal lines
          for (int yOffset = 0; yOffset < (n - y); ++yOffset) {
            if (matrix[x][y + yOffset]) {
              ++length;
            } else {
              break;
            }
          }
          
          max = Math.max(max, length);
          length = 0;

          // Diagonal lines
          for (int offset = 0; offset < (n - Math.max(x, y)); ++offset) {
            if (matrix[x + offset][y + offset]) {
              ++length;
            } else {
              break;
            }
          }

          max = Math.max(max, length);
        }
      }
    }

    return max;
  }

  // Optional solution: runtime O(n^2), space O(n) - space can be made O(1) by
  // generating points using a function or an iterator implementation.
  public static int getLongestPixelatedLine(boolean[][] matrix) {
    int n = matrix.length;

    if (n == 0) {
      return 0;
    }

    int max = 0;

    // Vertical lines
    Point[] startingPoints = new Point[n];
    for (int i = 0; i < n; ++ i) {
      startingPoints[i] = new Point(i, 0);
    }
    max = Math.max(max, findMaxLineLength(matrix, startingPoints, p -> new Point(p.x, p.y + 1)));

    // Vertical lines
    for (int i = 0; i < n; ++ i) {
      startingPoints[i] = new Point(0, i);
    }
    max = Math.max(max, findMaxLineLength(matrix, startingPoints, p -> new Point(p.x + 1, p.y)));

    // Right-diagonal lines
    startingPoints = new Point[(2 * n) - 1];
    for (int i = 0; i < n; ++ i) {
      startingPoints[i] = new Point(i, 0);
    }
    for (int i = 1; i < n; ++ i) {
      startingPoints[n + i - 1] = new Point(0, i);
    }
    max = Math.max(max, findMaxLineLength(matrix, startingPoints, p -> new Point(p.x + 1, p.y + 1)));

    // Left-diagonal lines
    for (int i = 0; i < n; ++ i) {
      startingPoints[i] = new Point(i, 0);
    }
    for (int i = 1; i < n; ++ i) {
      startingPoints[n + i - 1] = new Point(n - 1, i);
    }
    max = Math.max(max, findMaxLineLength(matrix, startingPoints, p -> new Point(p.x + 1, p.y + 1)));

    return max;
  }

  private static int findMaxLineLength(boolean[][] matrix, Point[] startingPoints, Function<Point, Point> next) {
    int n = matrix.length;
    int max = 0;

    for (Point p : startingPoints) {
      int x = p.x;
      int y = p.y;

      int length = 0;

      while ((x < n) && (y < n)) {
        if (matrix[x][y]) {
          ++length;
        } else {
          max = Math.max(length, max);
          length = 0;
        }

        Point nextPoint = next.apply(new Point(x, y));

        x = nextPoint.x;
        y = nextPoint.y;
      }

      max = Math.max(length, max);
    }

    return max;
  }
}
