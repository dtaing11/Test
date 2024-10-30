package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TennisScoreSheetTest {
    private TennisScoreSheet scoreSheet;

    @BeforeEach
    public void setUp() {
        scoreSheet = new TennisScoreSheet();
    }

    @Test
    public void testInitialScore() {
        assertEquals("Player 1: Love - Player 2: Love", scoreSheet.getScore());
    }

    @Test
    public void testPlayer1Scores() {
        scoreSheet.addPoint(1);
        assertEquals("Player 1: 15 - Player 2: Love", scoreSheet.getScore());

        scoreSheet.addPoint(1);
        assertEquals("Player 1: 30 - Player 2: Love", scoreSheet.getScore());

        scoreSheet.addPoint(1);
        assertEquals("Player 1: 40 - Player 2: Love", scoreSheet.getScore());

        scoreSheet.addPoint(1);
        assertEquals("Player 1: Game - Player 2: Love", scoreSheet.getScore());
    }

    @Test
    public void testPlayer2Scores() {
        scoreSheet.addPoint(2);
        assertEquals("Player 1: Love - Player 2: 15", scoreSheet.getScore());

        scoreSheet.addPoint(2);
        assertEquals("Player 1: Love - Player 2: 30", scoreSheet.getScore());

        scoreSheet.addPoint(2);
        assertEquals("Player 1: Love - Player 2: 40", scoreSheet.getScore());

        scoreSheet.addPoint(2);
        assertEquals("Player 1: Love - Player 2: Game", scoreSheet.getScore());
    }

    @Test
    public void testInvalidPlayer() {
        // Attempt to add a point to an invalid player
        scoreSheet.addPoint(3);
        assertEquals("Player 1: Love - Player 2: Love", scoreSheet.getScore()); // No change expected
    }

}
