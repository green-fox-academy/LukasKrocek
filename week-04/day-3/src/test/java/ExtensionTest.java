import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ExtensionTest {
    Extension extension = new Extension();

    @Test
    public void testIsVowel_y() {
        assertTrue(extension.isVowel('y'));
    }

    @Test
    public void testIsVowel_c() {
        assertFalse(extension.isVowel('c'));
    }

    @Test
    public void testMedian_three() {
        assertEquals(30, extension.median(Arrays.asList(7, 73, 30)));
    }

    @Test
    public void testMedian_eight() {
        assertEquals(9, extension.median(Arrays.asList(7, 73, 3, 5, 8, 9, 20, 40)));
    }

    @Test
    public void testMaxOfThree_second() {
        assertEquals(10, extension.maxOfThree(3, 10, 5));
    }

    @Test
    public void testAdd_2and4is6() {
        assertEquals(6, extension.add(2, 4));
    }

    @Test
    public void testAdd_2and3is5() {
        assertEquals(5, extension.add(2, 3));
    }

    @Test
    public void testAdd_1and4is5() {
        assertEquals(5, extension.add(1, 4));
    }

    @Test
    public void testMaxOfThree_first() {
        assertEquals(5, extension.maxOfThree(5, 4, 3));
    }

    @Test
    public void testMaxOfThree_third() {
        assertEquals(5, extension.maxOfThree(3, 4, 5));
    }

    @Test
    public void testMedian_four() {
        assertEquals(5, extension.median(Arrays.asList(7, 5, 3, 5)));
    }

    @Test
    public void testMedian_five() {
        assertEquals(3, extension.median(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void testIsVowel_a() {
        assertTrue(extension.isVowel('a'));
    }

    @Test
    public void testIsVowel_u() {
        assertTrue(extension.isVowel('u'));
    }

    @Test
    public void testTranslate_bemutatkozik() {
        assertEquals("bevemuvutavatkovozivik", extension.translate("bemutatkozik"));
    }

    @Test
    public void testTranslate_lagopus() {
        assertEquals("lavagovopuvus", extension.translate("lagopus"));
    }
}
