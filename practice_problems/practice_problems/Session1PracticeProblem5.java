package practice_problems;

public class Session1PracticeProblem5 {
    public static String reverseCustomerName(String customerName) {
        return new StringBuilder(customerName).reverse().toString();
    }

    public static void main(String[] args) {
        String customerName = "Sunil";
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reverseCustomerName(customerName));
    }
}