import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Session8Problem5 {
    private interface Plan {
        LocalDate renewalDate();

        String name();
    }

    private abstract static class SubscriptionPlan implements Plan {
        private final String subscriberName;
        private final LocalDate startDate;

        SubscriptionPlan(String subscriberName, LocalDate startDate) {
            this.subscriberName = subscriberName;
            this.startDate = startDate;
        }

        abstract int validityDays();

        public LocalDate renewalDate() {
            return startDate.plusDays(validityDays());
        }

        public String name() {
            return subscriberName;
        }
    }

    private static final class BasicPlan extends SubscriptionPlan {
        BasicPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        int validityDays() {
            return 30;
        }
    }

    private static final class StandardPlan extends SubscriptionPlan {
        StandardPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        int validityDays() {
            return 90;
        }
    }

    private static final class PremiumPlan extends SubscriptionPlan {
        PremiumPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        int validityDays() {
            return 365;
        }
    }

    private static Plan createPlan(String type, String name, LocalDate startDate) {
        switch (type) {
            case "BASIC": return new BasicPlan(name, startDate);
            case "STANDARD": return new StandardPlan(name, startDate);
            case "PREMIUM": return new PremiumPlan(name, startDate);
            default: throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Plan> plans = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String type = scanner.next();
                String name = scanner.next();
                LocalDate startDate = LocalDate.parse(scanner.next());
                plans.add(createPlan(type, name, startDate));
            }

            for (Plan plan : plans) {
                System.out.println(plan.name() + ": " + plan.renewalDate());
            }
        }
    }
}