public class Session7Problem1 {
    static class Character {
        private final int maxHealth;
        private int health;

        Character(int maxHealth) {
            if (maxHealth < 0) {
                throw new IllegalArgumentException("Maximum health cannot be negative");
            }
            this.maxHealth = maxHealth;
            health = maxHealth;
        }

        void takeDamage(int amount) {
            if (amount > 0) {
                health = Math.max(0, health - amount);
            }
        }

        void heal(int amount) {
            if (amount > 0) {
                health = (int) Math.min(maxHealth, (long) health + amount);
            }
        }

        int getHealth() {
            return health;
        }
    }

    public static void main(String[] args) {
        Character character = new Character(100);
        character.takeDamage(30);
        System.out.println(character.getHealth());
        character.heal(50);
        System.out.println(character.getHealth());
        character.takeDamage(150);
        System.out.println(character.getHealth());
    }
}