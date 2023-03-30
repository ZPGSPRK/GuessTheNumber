import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        GuessTheNumber guessTheNumber = new GuessTheNumber();
        Scanner scan = new Scanner(System.in);

        System.out.println(guessTheNumber.getIntroduction());

            do
                try {
                    guessTheNumber.setGuess(Integer.parseInt(scan.nextLine()));
                } catch (NumberFormatException e) {
                    System.err.println(guessTheNumber.getGuess() + " is not a valid number.");
                }
            while (!guessTheNumber.isWithinRange(1, 20));

        System.out.println(guessTheNumber.getExitPrompt());
    }



    private final String introduction;

    private final String exitPrompt;
    private Integer guess;
    private int secretNumber;

    public GuessTheNumber() {
        this.introduction = "Hello! What is your name?";
        this.exitPrompt = "Would you like to play again? (y or n)";
        initializeSecretNumber();
        this.guess = null;

    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public int initializeSecretNumber() {
        setSecretNumber((int) Math.round(1 + Math.random() * 19));
        return getSecretNumber();
    }

    public boolean isWithinRange(Integer lowerBound, Integer upperBound) {
        if (this.guess == null)
            return false;
        else
            return guess >= lowerBound && guess <= upperBound;
    }

    public Integer getGuess() {
        return guess;
    }

    public void setGuess(Integer guess) {
        this.guess = guess;
    }

    public String generateResponse(String input) {
        return "";
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getExitPrompt() {
        return exitPrompt;
    }

}
