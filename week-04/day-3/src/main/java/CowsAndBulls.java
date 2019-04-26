import java.util.Scanner;

public class CowsAndBulls {

    int randomNumber;
    int guessCounter;
    boolean playing;


    public CowsAndBulls() {
        randomNumber = (int) (Math.random() * 8999 + 1000);
        guessCounter = 0;
        playing = true;
    }

    public String guess(int guessedNumber) {
        increaseGuessCounter();
        if (guessedNumber == randomNumber) {
            playing = false;
            return "This is the number! " + guessCounter + " guesses";
        }

        int bull = 0;
        int cow = 0;
        int temporaryNumber = randomNumber;
        for (int i = 0; i < 4; i++) {
            if (temporaryNumber % 10 == guessedNumber % 10) {
                cow++;
            } else {
                bull++;
            }
            temporaryNumber /= 10;
            guessedNumber /= 10;
        }
        return "The result is " + cow + " Cows and " + bull + " Bulls.";
    }

    public void increaseGuessCounter() {
        guessCounter++;
    }
}
