import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingNumberGameShould {

    @Test
    void player_wins_on_first_move() {

        RandomNumberGeneratorStub randomNumberGenerator = new RandomNumberGeneratorStub();
        GuessingNumberGame guessingNumberGame = new GuessingNumberGame(randomNumberGenerator);
        int numberToGuess = 0;

        String guessingMessage = guessingNumberGame.guessNumber(numberToGuess);

        assertEquals("correct! You won", guessingMessage);

    }}
