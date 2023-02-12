package kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class StringSplitTest {
    @Test
    public void testEmptyString() {
        String s = "";
        assertEquals("[]", Arrays.toString(StringSplit.solution(s)));
    }

    @Test
    public void testEvenString() {
        String s = "abcdef";
        String s1 = "HelloWorld";
        assertEquals("[ab, cd, ef]",  Arrays.toString(StringSplit.solution(s)));
        assertEquals("[He, ll, oW, or, ld]", Arrays.toString(StringSplit.solution(s1)));
    }

    @Test
    public void testOddString() {
        String s = "abcde";
        String s1 = "LovePizza";
        assertEquals("[ab, cd, e_]", Arrays.toString(StringSplit.solution(s)));
        assertEquals("[Lo, ve, Pi, zz, a_]", Arrays.toString(StringSplit.solution(s1)));
    }

    @Test
    public void testSpaceString() {
        String s = "Hello World";
        String s1 = "I Love Pizza";
        assertEquals("[He, ll, o , Wo, rl, d_]", Arrays.toString(StringSplit.solution(s)));
        assertEquals("[I , Lo, ve,  P, iz, za]", Arrays.toString(StringSplit.solution(s1)));
    }

    private final String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890    ";
    private final Random rand = new Random();
    private char randomChar() {
        return alphabet.charAt(rand.nextInt(alphabet.length()));
    }
    @Test
    public void randomTests() {
        for (int trial = 1; trial <= 100; trial++) {
            String[] expected = new String[rand.nextInt(21)];
            for (int i = 0; i < expected.length; i++)
                expected[i] = "" + randomChar() + randomChar();
            if ( 0 < expected.length && rand.nextBoolean() )
                expected[expected.length-1] = randomChar() + "_";
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < expected.length; i++)
                sb.append(expected[i]);
            assertEquals(Arrays.toString(expected),
                    Arrays.toString(StringSplit.solution(sb.toString().replace("_$", ""))));
        }
    }
}