import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CowsAndBullsTest {

    CowsAndBulls newGame;
    CowsAndBulls anotherGame;

    @Before
    public void beforeTest() {
        this.newGame = new CowsAndBulls();
        this.anotherGame = new CowsAndBulls();
    }


    @Test
    public void CowsAndBulls_Constructor_randomNumberGeneration() {

        assertNotSame(newGame.randomNumber, anotherGame.randomNumber);
    }

    @Test
    public void CowsAndBulls_Constructor_randomNumberInBounds() {
        List<Integer> randomNumbers = new ArrayList<>();


        assertTrue(newGame.randomNumber < 10000 && newGame.randomNumber > 999);
    }
}
