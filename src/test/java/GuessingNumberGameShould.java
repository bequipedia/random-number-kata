import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GuessingNumberGameShould {

    @Mock
    RandomNumberGenerator randomNumberGenerator;

    @Test
    void player_wins_on_first_move() {
        GuessingNumberGame guessingNumberGame = new GuessingNumberGame(randomNumberGenerator);
        when(randomNumberGenerator.generateNumber()).thenReturn(0);
        int numberToGuess = 0;

        String guessingMessage = guessingNumberGame.guessNumber(numberToGuess);

        assertEquals("correct! You won", guessingMessage);

    }

    @Test
    void tell_player_number_is_lower_on_first_try() {
        GuessingNumberGame guessingNumberGame = new GuessingNumberGame(randomNumberGenerator);
        when(randomNumberGenerator.generateNumber()).thenReturn(5);
        int numberToGuess = 8;

        String guessingMessage = guessingNumberGame.guessNumber(numberToGuess);

        assertEquals("The number is lower", guessingMessage);
    }

    @Test
    void tell_player_number_is_higher_on_first_try() {
        GuessingNumberGame guessingNumberGame = new GuessingNumberGame(randomNumberGenerator);
        when(randomNumberGenerator.generateNumber()).thenReturn(11);
        int numberToGuess = 8;

        String guessingMessage = guessingNumberGame.guessNumber(numberToGuess);

        assertEquals("The number is higher", guessingMessage);
    }
}
