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
/* CodeWars TestCases
import org.junit.Test;
        import static org.junit.Assert.assertEquals;
        import org.junit.runners.JUnit4;

        import java.util.Random;

public class SolutionTest {
    private static String[] names = new String[]{"Brian", "Marilyn", "Pamela", "Timothy", "Jesse", "Heather", "Terry", "Carlos",
            "Bonnie", "Randy", "Lillian", "Emily", "Louis", "Chris", "Howard", "Helen", "Ralph", "Jennifer", "Mark", "Laura",
            "Jason", "Shirley", "Diane", "Phillip", "David", "Joan", "Wanda", "Jimmy", "Carl", "Betty", "Adam", "Lawrence",
            "Kathleen", "Mildred", "Rose", "Tina", "Jose", "Keith", "Janice", "Maria", "Kenneth", "Arthur", "James", "Catherine",
            "Henry", "Denise", "Ruby", "Cynthia", "Anthony", "Jeffrey", "Eugene", "Dorothy", "Lori", "Bobby", "Peter", "Alice",
            "Eric", "Wayne", "Phyllis", "Roger", "Clarence", "Scott", "John", "Philip", "Teresa", "Andrea", "Douglas", "Earl",
            "Melissa", "Benjamin", "Rebecca", "Michelle", "Alan", "Brenda", "William", "Frank", "Matthew", "George", "Anna",
            "Cheryl", "Roy", "Paula", "Tammy", "Gerald", "Christina", "Russell", "Kelly", "Albert", "Donna", "Todd", "Jessica",
            "Kimberly", "Johnny", "Dennis", "Jack", "Doris", "Martha", "Stephanie", "Stephen", "Christine"};

    @Test
    public void staticTests() {
        assertEquals("no one likes this", Solution.whoLikesIt());
        assertEquals("Peter likes this", Solution.whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", Solution.whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", Solution.whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", Solution.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
        assertEquals("Brian, Marilyn and 98 others like this", Solution.whoLikesIt(names));
    }

    @Test
    public void randomTests() {
        Random rand = new Random();
        for (int i = 0; i < 24; i++) {
            int r = rand.nextInt(100);
            String[] randNames = new String[r];
            for (int j = 0; j < r; j++) randNames[j] = names[rand.nextInt(100)];
            assertEquals(whoLikesIt(randNames), Solution.whoLikesIt(randNames));
        }
    }

    private String whoLikesIt(String... names) {
        switch (names.length) {
            case 0:  return "no one likes this";                //feels bad man
            case 1:  return names[0] + " likes this";
            case 2:  return String.format("%s and %s like this", names[0], names[1]);
            case 3:  return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            default: return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
        }
    }
}
*/