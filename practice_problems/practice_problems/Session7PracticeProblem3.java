package practice_problems;

public class Session7PracticeProblem3 {
    static final class NameTag {
        private final String firstName;
        private final String lastNameInitial;

        NameTag(String fullName) {
            if (fullName == null) {
                throw new IllegalArgumentException("Full name cannot be null");
            }
            String[] parts = fullName.split(" ", -1);
            if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
                throw new IllegalArgumentException("Full name must contain one first and one last name");
            }
            firstName = parts[0];
            lastNameInitial = parts[1].substring(0, 1);
        }

        String getNickname() {
            return firstName + " " + lastNameInitial + ".";
        }
    }

    public static void main(String[] args) {
        System.out.println(new NameTag("Maria Gomez").getNickname());
    }
}