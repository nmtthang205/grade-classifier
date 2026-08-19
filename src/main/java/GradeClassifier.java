public class GradeClassifier {

    public String classifyGrade(int score) {
        if (score < 0 || score > 100) {
            return "Invalid";
        } else if (score >= 90) {
            return "Excellent";
        } else if (score >= 75) {
            return "Good";
        } else if (score >= 50) {
            return "Average";
        } else {
            return "Fail";
        }
    }

    public String[] classifyAll(int[] scores) {
        String[] results = new String[scores.length];
        for (int i = 0; i < scores.length; i++) {
            results[i] = classifyGrade(scores[i]);
        }
        return results;
    }

    public static void main(String[] args) {
        GradeClassifier classifier = new GradeClassifier();
        int[] scores = {95, 80, 60, 40, -5, 105};
        String[] results = classifier.classifyAll(scores);

        for (int i = 0; i < scores.length; i++) {
            System.out.println("Score " + scores[i] + " -> " + results[i]);
        }
    }
}