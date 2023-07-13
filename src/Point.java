import java.util.Objects;

public class Point {
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public final int x;
  public final int y;

  @Override
  public String toString() {
    return String.format("Point(%d, %d)", x, y);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (!(o instanceof Point)) {
      return false;
    }

    Point other = (Point) o;
    return (x == other.x) && (y == other.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
