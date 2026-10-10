public class Session2Problem1 {
    public static boolean hasValidPinLength(String pin) {
        return pin != null && pin.length() == 4;
    }

    public static void main(String[] args) {
        System.out.println(hasValidPinLength("482"));
        System.out.println(hasValidPinLength("4820"));
    }
}