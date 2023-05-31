import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GuessingNumberGameShould {

    @Mock
    RandomNumberGenerator randomNumberGenerator;

    @Test
    void player_wins_on_first_try() {
        GuessingNumberGame guessingNumberGame = new GuessingNumberGame(randomNumberGenerator);
        when(randomNumberGenerator.generateNumber()).thenReturn(0);
        int firstTryNumber = 0;

        String guessingMessage = guessingNumberGame.guessNumber(firstTryNumber);

        assertEquals("correct! You won", guessingMessage);

    }

    @Test
    void tell_player_number_is_lower_on_first_try() {
        GuessingNumberGame guessingNumberGame = new GuessingNumberGame(randomNumberGenerator);
        when(randomNumberGenerator.generateNumber()).thenReturn(5);
        int firstTryNumber = 8;

        String guessingMessage = guessingNumberGame.guessNumber(firstTryNumber);

        assertEquals("The number is lower", guessingMessage);
    }

    @Test
    void tell_player_number_is_lower_on_first_try_v2() {
        GuessingNumberGame guessingNumberGame = new GuessingNumberGame(randomNumberGenerator);
        when(randomNumberGenerator.generateNumber()).thenReturn(5);
        int firstTryNumber = 7;

        String guessingMessage = guessingNumberGame.guessNumber(firstTryNumber);

        assertEquals("The number is lower", guessingMessage);
    }

    @Test
    void tell_player_number_is_higher_on_first_try() {
        GuessingNumberGame guessingNumberGame = new GuessingNumberGame(randomNumberGenerator);
        when(randomNumberGenerator.generateNumber()).thenReturn(5);
        int firstTryNumber = 2;

        String guessingMessage = guessingNumberGame.guessNumber(firstTryNumber);

        assertEquals("The number is higher", guessingMessage);
    }

    @Test
    void tell_player_number_is_higher_on_first_try_v2() {
        GuessingNumberGame guessingNumberGame = new GuessingNumberGame(randomNumberGenerator);
        when(randomNumberGenerator.generateNumber()).thenReturn(5);
        int firstTryNumber = 3;

        String guessingMessage = guessingNumberGame.guessNumber(firstTryNumber);

        assertEquals("The number is higher", guessingMessage);
    }

    @Test
    void tell_player_loses() {
        GuessingNumberGame guessingNumberGame = new GuessingNumberGame(randomNumberGenerator);
        when(randomNumberGenerator.generateNumber()).thenReturn(5);

        int firstTryNumber = 3;
        int secondTryNumber = 8;
        int thirdTryNumber = 6;

        ArrayList<String>guessingMessages = new ArrayList<>(List.of(
                guessingNumberGame.guessNumber(firstTryNumber),
                guessingNumberGame.guessNumber(secondTryNumber),
                guessingNumberGame.guessNumber(thirdTryNumber)
        ));

        assertEquals(new ArrayList<>(List.of(
                "The number is higher",
                "The number is lower",
                "You lose"
        )), guessingMessages);
    }
}
