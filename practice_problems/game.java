package practice_problems;
import java.util.*;

public class game{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Game!");

        String[] moves = {"rock","paper","scissors"};

        System.out.print("enter player move :");
        String playermove = sc.next();

        Random rand = new Random();
        String computermove = moves[rand.nextInt(3)];

        System.out.println("Player: " + playermove);
        System.out.println("Computer: " + computermove);

        if(playermove.equals(computermove)) {
            System.out.println("It's a tie!");
        } else if((playermove.equals("rock") && computermove.equals("scissors")) ||
                  (playermove.equals("paper") && computermove.equals("rock")) ||
                  (playermove.equals("scissors") && computermove.equals("paper"))) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Computer wins!");
        }




    }
}