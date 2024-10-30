package org.example;


public class TennisScoreSheet {
    private int player1Score;
    private int player2Score;

    public TennisScoreSheet() {
        player1Score = 0;
        player2Score = 0;
    }

    public void addPoint(int player) {
        if (player == 1) {
            if (player1Score == 3 && player2Score == 3) {
                player1Score++; // Move to advantage
            } else if (player1Score < 4) {
                player1Score++;
            } else if (player1Score == 4 && player2Score == 3) {
                // Player 1 wins the game
                player1Score = 0;
                player2Score = 0; // Reset for simplicity, could track games won
            }
        } else if (player == 2) {
            if (player2Score == 3 && player1Score == 3) {
                player2Score++; // Move to advantage
            } else if (player2Score < 4) {
                player2Score++;
            } else if (player2Score == 4 && player1Score == 3) {
                // Player 2 wins the game
                player1Score = 0;
                player2Score = 0; // Reset for simplicity, could track games won
            }
        } else {
            System.out.println("Invalid player number. Use 1 or 2.");
        }
    }

    public String getScore() {
        if (player1Score == 4 && player2Score < 3) return "Player 1: Game - Player 2: Love";
        if (player2Score == 4 && player1Score < 3) return "Player 1: Love - Player 2: Game";

        return "Player 1: " + convertScore(player1Score) + " - Player 2: " + convertScore(player2Score);
    }

    private String convertScore(int score) {
        switch (score) {
            case 0: return "Love";
            case 1: return "15";
            case 2: return "30";
            case 3: return "40";
            case 4: return "Advantage"; // Not strictly necessary for this implementation
            default: return "Game"; // Simplified; in a real scenario, we could track games won
        }
    }
}
