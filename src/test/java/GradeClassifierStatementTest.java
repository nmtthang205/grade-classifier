import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeClassifierStatementTest {

    private final GradeClassifier classifier = new GradeClassifier();

    @Test
    void testInvalidNegative() {
        assertEquals("Invalid", classifier.classifyGrade(-5));
    }

    @Test
    void testInvalidOver100() {
        assertEquals("Invalid", classifier.classifyGrade(105));
    }

    @Test
    void testExcellent() {
        assertEquals("Excellent", classifier.classifyGrade(95));
    }

    @Test
    void testGood() {
        assertEquals("Good", classifier.classifyGrade(80));
    }

    @Test
    void testAverage() {
        assertEquals("Average", classifier.classifyGrade(60));
    }

    @Test
    void testFail() {
        assertEquals("Fail", classifier.classifyGrade(40));
    }

    @Test
    void testClassifyAllLoopExecutes() {
        int[] scores = {95, 40};
        String[] results = classifier.classifyAll(scores);

        assertEquals(2, results.length);
        assertEquals("Excellent", results[0]);
        assertEquals("Fail", results[1]);
    }
}