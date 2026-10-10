public class Session1Problem4 {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;
        for (int value : sectionA) totalA += value;
        for (int value : sectionB) totalB += value;
        int maxVal = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex = -1;
        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxVal) {
                maxVal = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxVal) {
                maxVal = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1;
            }
        }
        String status = totalA == totalB ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB + " | Status: " + status
                + " | Highest Quantity: " + maxVal + " (" + maxSection + ", Item " + maxIndex + ")");
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}