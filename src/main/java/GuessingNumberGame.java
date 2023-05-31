public class GuessingNumberGame {


    private final RandomNumberGenerator randomNumberGenerator;

    public GuessingNumberGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String guessNumber(int numberToGuess) {
        if(this.randomNumberGenerator.generateNumber() < numberToGuess) {
            return "The number is lower";
        }
        if(this.randomNumberGenerator.generateNumber() > numberToGuess) {
            return "The number is higher";
        }
        return "correct! You won";
    }
}
