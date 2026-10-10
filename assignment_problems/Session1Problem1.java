public class Session1Problem1 {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            boolean alreadyReported = false;
            for (int j = 0; j < i; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    alreadyReported = true;
                    break;
                }
            }
            if (alreadyReported) continue;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    break;
                }
            }
        }
        if (!foundDuplicate) System.out.println("No Duplicate Seats Found");
    }

    public static void main(String[] args) {
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
    }
}