public class Session7Problem4 {
    static class TrafficLight {
        private final String id;
        private String color = "RED";

        TrafficLight(String id) {
            if (id == null) {
                throw new IllegalArgumentException("ID cannot be null");
            }
            this.id = id;
        }

        String getId() {
            return id;
        }

        String getColor() {
            return color;
        }

        String next() {
            if (color.equals("RED")) {
                color = "GREEN";
            } else if (color.equals("GREEN")) {
                color = "YELLOW";
            } else {
                color = "RED";
            }
            return color;
        }
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight("TL-9");
        System.out.println(light.getColor());
        System.out.println(light.next());
        System.out.println(light.next());
        System.out.println(light.next());
    }
}