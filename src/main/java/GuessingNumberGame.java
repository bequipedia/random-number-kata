public class GuessingNumberGame {

    private int triesCount = 0;

    private final RandomNumberGenerator randomNumberGenerator;

    public GuessingNumberGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String guessNumber(int numberToGuess) {
        triesCount++;
        String outputMessage = "";
        if(this.randomNumberGenerator.generateNumber() < numberToGuess) {
            outputMessage = "The number is lower";
        }
        if(this.randomNumberGenerator.generateNumber() > numberToGuess) {
            outputMessage = "The number is higher";
        }
        boolean winningCondition = this.randomNumberGenerator.generateNumber() == numberToGuess;
        if(winningCondition) {
            outputMessage = "correct! You won";
        }
        if(triesCount == 3 && !winningCondition) {
            outputMessage = "You lose";
        }
        return outputMessage;
    }
}
