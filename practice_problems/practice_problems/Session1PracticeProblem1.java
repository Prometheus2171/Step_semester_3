package practice_problems;

public class Session1PracticeProblem1 {
    public static String playRound(String playerMove, String computerMove) {
        String player = playerMove.trim().toLowerCase();
        String computer = computerMove.trim().toLowerCase();
        if (!isValidMove(player) || !isValidMove(computer)) return "Invalid Move";
        if (player.equals(computer)) return "Draw";
        boolean playerWins = (player.equals("rock") && computer.equals("scissors"))
                || (player.equals("paper") && computer.equals("rock"))
                || (player.equals("scissors") && computer.equals("paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    private static boolean isValidMove(String move) {
        return move.equals("rock") || move.equals("paper") || move.equals("scissors");
    }

    public static void printGameSummary(String[] playerMoves, String[] computerMoves) {
        if (playerMoves.length != computerMoves.length) {
            throw new IllegalArgumentException("Each player move needs a matching computer move");
        }
        int wins = 0;
        int losses = 0;
        int draws = 0;
        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < playerMoves.length; i++) {
            String result = playRound(playerMoves[i], computerMoves[i]);
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
            System.out.println((i + 1) + " | " + playerMoves[i] + " | " + computerMoves[i] + " | " + result);
        }
        double winPercentage = playerMoves.length == 0 ? 0 : wins * 100.0 / playerMoves.length;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }

    public static void main(String[] args) {
        printGameSummary(new String[]{"Rock", "Paper", "Scissors"}, new String[]{"Scissors", "Paper", "Rock"});
    }
}