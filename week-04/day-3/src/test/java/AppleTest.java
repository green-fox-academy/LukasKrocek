import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

public class AppleTest {

    @Test
    public void getApple_returnName_equalsGivenName() {
        Apple apple1 = new Apple("Apple");

        assertEquals("Apple", apple1.getApple());
    }
}
