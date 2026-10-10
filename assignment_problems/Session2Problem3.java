public class Session2Problem3 {
    public static String parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            return "Invalid Record";
        }
        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3) {
            return "Invalid Record";
        }
        return "Product: " + fields[0] + " | SKU: " + fields[1] + " | Qty: " + fields[2];
    }

    public static void main(String[] args) {
        System.out.println(parseInventoryRecord("Wireless Mouse,WM-2201,150"));
        System.out.println(parseInventoryRecord("Wireless Mouse,150"));
    }
}