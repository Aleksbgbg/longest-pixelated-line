import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProgramTest {
  @Test
  public void emptyTest() {
    boolean[][] matrix = {};

    assertEquals(0, Program.getLongestPixelatedLine(matrix));
  }

  @Test
  public void singleCellTest() {
    boolean[][] matrix = {{true}};

    assertEquals(1, Program.getLongestPixelatedLine(matrix));
  }

  @Test
  public void noLinesTest() {
    boolean[][] matrix = {
        { false, false, false, false, false, false, false, false, },
        { false, false, false, false, false, false, false, false, },
        { false, false, false, false, false, false, false, false, },
        { false, false, false, false, false, false, false, false, },
        { false, false, false, false, false, false, false, false, },
        { false, false, false, false, false, false, false, false, },
        { false, false, false, false, false, false, false, false, },
        { false, false, false, false, false, false, false, false, },
    };

    assertEquals(0, Program.getLongestPixelatedLine(matrix));
  }

  @Test
  public void filledTest() {
    boolean[][] matrix = {
        { true, true, true, true, true, true, true, true, },
        { true, true, true, true, true, true, true, true, },
        { true, true, true, true, true, true, true, true, },
        { true, true, true, true, true, true, true, true, },
        { true, true, true, true, true, true, true, true, },
        { true, true, true, true, true, true, true, true, },
        { true, true, true, true, true, true, true, true, },
        { true, true, true, true, true, true, true, true, },
    };

    assertEquals(8, Program.getLongestPixelatedLine(matrix));
  }

  @Test
  public void exampleTest() {
    boolean[][] matrix = {
        { false, false, false, false, false, false, false, false, },
        { false, false, true, false, true, false, false, false, },
        { false, true, false, true, false, false, false, false, },
        { true, true, true, true, true, true, true, false, },
        { false, true, false, false, false, true, false, false, },
        { true, true, false, false, false, false, true, false, },
        { false, true, false, false, false, false, false, true, },
        { false, false, false, false, false, false, false, false, },
    };

    assertEquals(7, Program.getLongestPixelatedLine(matrix));
  }
}
