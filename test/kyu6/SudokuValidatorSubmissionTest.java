package kyu6;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SudokuValidatorSubmissionTest {

    record TestCase(String strBoard, int[][] board, boolean expected) {
        public TestCase(String strBoard, boolean expected) { this(strBoard, null, expected); };
        public TestCase(int[][] board, boolean expected) { this(null, board, expected); };
    }

    private final TestCase[] fixedBoards = {
            new TestCase("555555555 555555555 555555555 555555555 555555555 555555555 555555555 555555555 555555555", false), // A board full of fives. Suggested by a user, breaks solutions which sum cells.
            new TestCase("123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789", false), // All rows are 1..9
            new TestCase("111111111 222222222 333333333 444444444 555555555 666666666 777777777 888888888 999999999", false)  // All cols are 1..9
    };

    private final TestCase[] templates = {
            new TestCase("534678912 672195348 198342567 859761423 426853791 713924856 961537284 287419635 345286179", true),
            new TestCase("132579468 498261375 756384219 643158792 521793846 987426531 214935687 365817924 879642153", true),
            new TestCase("784159326 539672841 612438759 928715463 357846192 461923587 876394215 243561978 195287634", true),
            new TestCase("926583471 713426985 845971362 362857149 471269538 598314726 657138294 284795613 139642857", true),
            new TestCase("715623849 624819375 398745621 539276418 462198537 871534962 253967184 186452793 947381256", true),
            new TestCase("783456129 692187345 145239678 817362954 564798213 329541867 476823591 931675482 258914736", true),
            new TestCase("173268954 425193768 869745123 612837495 398456217 547912386 954381672 236579841 781624539", true),
            new TestCase("847265193 136798245 952143867 429671538 678532914 315489726 564917382 781324659 293856471", true),

            new TestCase("847265103 136708245 052143867 420671538 678532014 315480726 564017382 781324650 203856471", false), // a valid board, but with 0 instead of 9
            new TestCase("132579468 498261375 756384219 643158792 521793846 987426531 214935687 365817924 879642135", false), // duplicated '3' in eighth column
            new TestCase("123456789 234567891 345678912 456789123 567891234 678912345 789123456 891234567 912345678", false), // valid rows and cols, but invalid boxes
            new TestCase("034678912 672195348 198342567 859761423 426853791 713924856 961537284 287419635 345286179", false), // suggested by a user, no repeats but has a zero
            new TestCase("123456699 456699123 699123456 234566991 566991234 991234566 345669912 669912345 912345669", false), // suggested by a user, breaks solutions which sum cells
            new TestCase("123123123 456456456 789789789 231231231 564564564 897897897 312312312 645645645 978978978", false), // suggested by a user, breaks solutions which check only rows
            new TestCase("123456789 456789123 789123456 123456789 456789123 789123456 123456789 456789123 789123456", false), // valid boxes and rows, repeats in cols
            new TestCase("123456789 456789123 789123456 234567891 567891234 678912345 345678912 891234567 912345678", false)  // all rows and cols are valid, and the top row of boxes is valid
    };

    private int[][] parse(String strBoard) {
        Function<String, int[]> parseRow = strRow -> strRow.chars().map(n -> Character.digit(n, 10)).toArray();
        return Arrays.stream(strBoard.split(" ")).map(parseRow).toArray(int[][]::new);
    }
    private int[][] clone(int[][] board) {
        return Arrays.stream(board).map(row -> Arrays.copyOf(row, row.length)).toArray(int[][]::new);
    }
    private String stringify(int[][] board) {
        Function<int[], String> stringifyRow = row ->
                String.format("%d%d%d|%d%d%d|%d%d%d",
                        row[0], row[1], row[2],
                        row[3], row[4], row[5],
                        row[6], row[7], row[8]);
        List<String> rows = Arrays.stream(board).map(stringifyRow).toList();
        return String.join("\n", rows.subList(0,3)) +
                "\n---+---+---\n" +
                String.join("\n", rows.subList(3, 6)) +
                "\n---+---+---\n" +
                String.join("\n", rows.subList(6, 9));
    }

    void doTest(int[][] board, boolean expected) {
        int[][] input = clone(board);
        boolean actual = SudokuValidator.validate(input);
        assertEquals(expected, actual, String.format("Incorrect answer for board:\n\n%s\n", stringify(board)));
        for(int rowNo=0; rowNo < 9; ++rowNo) {
            assertArrayEquals(board[rowNo], input[rowNo], "Input board must not be modified");
        }
    }

    @Test
    @Order(1)
    void fixedTests() {

        Stream<TestCase> allFixedTests =
                Stream.concat(
                        Arrays.stream(fixedBoards),
                        Arrays.stream(templates)
                );
        allFixedTests.forEachOrdered(test -> doTest(parse(test.strBoard), test.expected));
    }

    private int[][] transpose(int[][]board) {
        int[][] transposed = new int[9][9];
        for(int r=0; r<9; ++r)
            for(int c=0; c<9; ++c)
                transposed[r][c] = board[c][r];
        return transposed;
    }
    private int[][] fliph(int[][]board) {
        int[][] transposed = new int[9][9];
        for(int r=0; r<9; ++r)
            for(int c=0; c<9; ++c)
                transposed[r][c] = board[r][8-c];
        return transposed;
    }
    private int[][] flipv(int[][]board) {
        int[][] transposed = new int[9][9];
        for(int r=0; r<9; ++r)
            for(int c=0; c<9; ++c)
                transposed[r][c] = board[8-r][c];
        return transposed;
    }
    private int[][] shuffleRowsInBands(int[][] board) {
        List<int[]> rows = Arrays.asList(board);
        Collections.shuffle(rows.subList(0, 3));
        Collections.shuffle(rows.subList(3, 6));
        Collections.shuffle(rows.subList(6, 9));
        return rows.stream().toArray(int[][]::new);
    }

    private int[][] shuffleRowBands(int[][] board) {
        List<int[]> rows = Arrays.asList(board);
        List<List<int[]>> bands = new ArrayList<>();
        bands.add(rows.subList(0,3));
        bands.add(rows.subList(3, 6));
        bands.add(rows.subList(6, 9));
        Collections.shuffle(bands);
        return bands.stream().flatMap(List::stream).toArray(int[][]::new);
    }

    private int[][] shuffleColsInBands(int[][] board) {
        return transpose(shuffleRowsInBands(transpose(board)));
    }
    private int[][] shuffleColBands(int[][] board) {
        return transpose(shuffleRowBands(transpose(board)));
    }

    private int[][] randomRelabel(int[][] board) {
        List<Integer> newLabels = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(newLabels);
        int[][] relabeled = new int[9][9];
        for(int r=0; r<9; ++r)
            for(int c=0; c<9; ++c)
                relabeled[r][c] = board[r][c] == 0 ? 0 : newLabels.get(board[r][c] - 1);
        return relabeled;
    }

    private int[][] applyTransforms(int[][] board) {
        int[][] shuffled_board =
                randomRelabel(
                        shuffleColsInBands(
                                shuffleColBands(
                                        shuffleRowsInBands(
                                                shuffleRowBands(
                                                        board
                                                )))));
        boolean fliph = ThreadLocalRandom.current().nextBoolean();
        if (fliph) shuffled_board = fliph(shuffled_board);
        boolean flipv = ThreadLocalRandom.current().nextBoolean();
        if (flipv) shuffled_board = flipv(shuffled_board);
        return shuffled_board;
    }

    private Stream<TestCase> transformTemplate(TestCase template) {
        boolean expected = template.expected;
        int[][] board = parse(template.strBoard);
        int[][] board_h = applyTransforms(board);
        int[][] board_v = applyTransforms(transpose(board));
        return Stream.of(new TestCase(board_h, expected), new TestCase(board_v, expected));
    }

    @Test
    @Order(2)
    void randomTests() {

        // Random tests: iterate through all template boards, and:
        // - the template is duplicated and transposed, to transfer errors from rows to columns (and vice versa), and then
        // - each of the two is mixed by a set of validity-preserving transformations:
        //   flips, shuffles of row/col bands, shuffles inside of row/col bands, relabelings.
        // All transformed boards and fixed boards are brought together, shuffled, and tests verify each of them.
        // There is no tests which generate boards from scratch, all tested boards are fixed or derived from templates.

        Stream<TestCase> fixedParsedBoards =
                Arrays.stream(fixedBoards)
                        .map(testCase -> new TestCase(parse(testCase.strBoard), testCase.expected));

        Stream<TestCase> templatesToTransform =
                Stream.generate(() -> Arrays.stream(templates))
                        .limit(10)
                        .flatMap(Function.identity());

        Stream<TestCase> transformedTemplates =
                templatesToTransform
                        .flatMap(this::transformTemplate);

        List<TestCase> allCases = Stream.concat(
                fixedParsedBoards,
                transformedTemplates
        ).collect(Collectors.toCollection(ArrayList::new)); // collect to a mutable collection

        Collections.shuffle(allCases);
        for (TestCase testCase: allCases) {
            doTest(testCase.board, testCase.expected);
        }
    }
}