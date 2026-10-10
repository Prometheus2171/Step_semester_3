package practice_problems;

public class Session1PracticeProblem3 {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights.length != weights.length) {
            throw new IllegalArgumentException("Height and weight arrays must have equal lengths");
        }
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%d | %.2f | %.2f | %.2f | %s%n", i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        printWellnessReport(new double[]{1.75, 1.60}, new double[]{70, 90});
    }
}