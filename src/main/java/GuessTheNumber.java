import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        GuessTheNumber guessTheNumber = new GuessTheNumber();
        Scanner scan = new Scanner(System.in);
            do
                try {
                    guessTheNumber.setGuess(Integer.parseInt(scan.nextLine()));
                } catch (NumberFormatException e) {
                    System.err.println(guessTheNumber.getGuess() + " is not a valid number.");
                }
            while (!guessTheNumber.isWithinRange(1, 20));

        System.out.println(guessTheNumber.secretNumber);
    }

    private Integer guess;
    private int secretNumber;

    public GuessTheNumber() {
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
}
