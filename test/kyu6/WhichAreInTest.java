package kyu6;

import static org.junit.Assert.*;
import org.junit.Test;

public class WhichAreInTest {
    @Test
    public void test1() {
        String a[] = new String[]{ "arp", "live", "strong" };
        String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        String r[] = new String[] { "arp", "live", "strong" };
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }
    @Test
    public void test2() {
        String a[]  = new String[] { "arp", "mice", "bull" };
        String b[]  = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        String r[]  = new String[] { "arp" };
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }
    @Test
    public void test3() {
        String a[]  = new String[] { "cod", "code", "wars", "ewar", "pillow", "bed", "phht" };
        String b[]  = new String[] { "lively", "alive", "harp", "sharp", "armstrong", "codewars" };
        String r[]  = new String[] { "cod", "code", "ewar", "wars" };
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }
    @Test
    public void test4() {
        String a[]  = new String[] { "cod", "code", "wars", "ewar", "ar" };
        String b[]  = new String[] { "lively", "alive", "harp", "sharp", "armstrong", "codewars" };
        String r[]  = new String[] { "ar", "cod", "code", "ewar", "wars" };
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }
    @Test
    public void test5() {
        String a[]  = new String[] { "cod", "code", "wars", "ewar", "ar" };
        String b[]  = new String[] {  };
        String r[]  = new String[] {  };
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }
    @Test
    public void test6() {
        String a[]  = new String[] { "1295", "code", "1346", "1028", "ar" };
        String b[]  = new String[] { "12951295", "ode", "46", "10281066", "par" };
        String r[]  = new String[] { "1028", "1295", "ar" };
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }
    @Test
    public void test7() {
        String a[]  = new String[] { "&()", "code", "1346", "1028", "ar" };
        String b[]  = new String[] { "12&()95", "coderange", "46", "1066", "par" };
        String r[]  = new String[] { "&()", "ar", "code" };
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }
    @Test
    public void test8() {
        String a[]  = new String[] { "ohio", "code", "1346", "1028", "art" };
        String b[]  = new String[] { "Carolina", "Ohio", "4600", "NY", "California" };
        String r[]  = new String[] {  };
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }

}