import java.util.Scanner;
import java.util.regex.Pattern;

public class GuessTheNumber {
    public static void main(String[] args) {
        GuessTheNumber guessTheNumber = new GuessTheNumber();
        Scanner scanner = new Scanner(System.in);

        System.out.println(guessTheNumber.getIntroduction());

        boolean isValidName;

        do {
            String name = scanner.nextLine();
            isValidName = guessTheNumber.isValidName(name);
            if (isValidName)
                guessTheNumber.setName(name);
            else
                System.err.println("That name is invalid.");
        } while (!isValidName);

        System.out.println(String.format(guessTheNumber.getIntroductionResponse(), guessTheNumber.getName()));

            do
                try {
                    guessTheNumber.setGuess(Integer.parseInt(scanner.nextLine()));
                } catch (NumberFormatException e) {
                    System.err.println(guessTheNumber.getGuess() + " is not a valid number.");
                }
            while (!guessTheNumber.isWithinRange(1, 20));

        System.out.println(guessTheNumber.getExitPrompt());
    }

    private final String introduction;

    public String getIntroductionResponse() {
        return introductionResponse;
    }

    private final String introductionResponse;
    private final String exitPrompt;
    private Integer guess;
    private int secretNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public GuessTheNumber() {
        this.introduction = "Hello! What is your name?";
        this.introductionResponse = "Well, %s, I am thinking of a number between 1 and 20.\nTake a guess.";
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
        boolean isWithinRange = guess >= lowerBound && guess <= upperBound;

        if (!isWithinRange)
            System.err.println("Number is not within range.");

        return isWithinRange;
    }

    public boolean isValidName(String name) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
        return pattern.matcher(name).matches();
    }

    public Integer getGuess() {
        return guess;
    }

    public void setGuess(Integer guess) {
        this.guess = guess;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getExitPrompt() {
        return exitPrompt;
    }

}
