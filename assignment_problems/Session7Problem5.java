public class Session7Problem5 {
    static class Cart {
        private final String cartId;
        private final double[] prices;
        private int itemCount;

        Cart(String cartId, int capacity) {
            if (cartId == null || capacity < 0) {
                throw new IllegalArgumentException("A cart ID and non-negative capacity are required");
            }
            this.cartId = cartId;
            prices = new double[capacity];
        }

        String getCartId() {
            return cartId;
        }

        boolean addItem(double price) {
            if (!Double.isFinite(price) || price < 0 || itemCount == prices.length) {
                return false;
            }
            prices[itemCount++] = price;
            return true;
        }

        double getTotal() {
            double total = 0;
            for (int i = 0; i < itemCount; i++) {
                total += prices[i];
            }
            return total;
        }

        int getItemCount() {
            return itemCount;
        }
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println(cart.getTotal());
        System.out.println(cart.getItemCount());
    }
}