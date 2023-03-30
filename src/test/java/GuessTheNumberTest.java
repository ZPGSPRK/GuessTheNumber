import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuessTheNumberTest {
    private GuessTheNumber guessTheNumber;

    @BeforeEach
    public void setUp() {
        guessTheNumber = new GuessTheNumber();
    }

    @Test
    public void testInitializeSecretNumber() {
        int min = 1;
        int max = 20;

        for (int i = 0; i < 1000; i++)
            assertTrue(guessTheNumber.initializeSecretNumber() <= max && guessTheNumber.getSecretNumber() >= min);
    }
}
