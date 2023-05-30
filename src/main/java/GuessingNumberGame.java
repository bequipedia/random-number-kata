public class GuessingNumberGame {


    private final RandomNumberGenerator randomNumberGenerator;

    public GuessingNumberGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String guessNumber(int numberToGuess) {
        if(this.randomNumberGenerator.generateNumber() == 8) {
            return "The number is lower";
        }
        return "correct! You won";
    }
}
