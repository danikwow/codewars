package kyu6;


import static kyu6.WhoLikesIt.whoLikesIt;
import static org.junit.Assert.assertEquals;

class WhoLikesItTest {
    @org.junit.jupiter.api.Test
    public void whoLikesItZero() {
        WhoLikesIt whoLikesIt = new WhoLikesIt();
        whoLikesIt();
        assertEquals("no one likes this", whoLikesIt());
    }
    @org.junit.jupiter.api.Test
    public void whoLikesItOnePeople() {
        WhoLikesIt whoLikesIt = new WhoLikesIt();
        whoLikesIt("Peter");
        assertEquals("Peter likes this", whoLikesIt("Peter"));
    }
    @org.junit.jupiter.api.Test
    public void whoLikesItTwoOnePeople() {
        WhoLikesIt whoLikesIt = new WhoLikesIt();
        whoLikesIt("Jacob", "Alex");
        assertEquals("Jacob and Alex like this", whoLikesIt("Jacob", "Alex"));
    }
    @org.junit.jupiter.api.Test
    public void whoLikesItThreePeople() {
        WhoLikesIt whoLikesIt = new WhoLikesIt();
        whoLikesIt("Max", "John", "Mark");
        assertEquals("Max, John and Mark like this", whoLikesIt("Max", "John", "Mark"));
    }
    @org.junit.jupiter.api.Test
    public void whoLikesItManyPeople() {
        WhoLikesIt whoLikesIt = new WhoLikesIt();
        whoLikesIt("Alex", "Jacob", "Mark", "Max", "Jacob", "Mark", "Max", "Jacob", "Mark", "Max");
        assertEquals("Alex, Jacob and 2 others like this", whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }

}