import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeClassifierPathTest {

    private final GradeClassifier classifier = new GradeClassifier();

    @Test
    void pathInvalid() {
        assertEquals("Invalid", classifier.classifyGrade(-1));
    }

    @Test
    void pathExcellent() {
        assertEquals("Excellent", classifier.classifyGrade(100));
    }

    @Test
    void pathGood() {
        assertEquals("Good", classifier.classifyGrade(75));
    }

    @Test
    void pathAverage() {
        assertEquals("Average", classifier.classifyGrade(50));
    }

    @Test
    void pathFail() {
        assertEquals("Fail", classifier.classifyGrade(0));
    }

    @Test
    void pathBoundary90() {
        assertEquals("Excellent", classifier.classifyGrade(90));
    }

    @Test
    void pathBoundary89() {
        assertEquals("Good", classifier.classifyGrade(89));
    }

    @Test
    void pathBoundary49() {
        assertEquals("Fail", classifier.classifyGrade(49));
    }

    @Test
    void pathLoopZeroTimes() {
        String[] results = classifier.classifyAll(new int[]{});

        assertEquals(0, results.length);
    }

    @Test
    void pathLoopMultipleTimes() {
        int[] scores = {100, 75, 50, 0, -1};
        String[] results = classifier.classifyAll(scores);

        assertArrayEquals(
                new String[]{"Excellent", "Good", "Average", "Fail", "Invalid"},
                results
        );
    }
}