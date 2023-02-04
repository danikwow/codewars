package kyu6;

import java.util.ArrayList;
import java.util.List;


public class SudokuValidator {
    public static boolean validate(int[][] board) {

        return checkHorizontal(board) && checkVertical(board) && checkBox(board) && checkZero(board);
    }
    private static boolean checkZero(int[][] board){
        for (int i = 0; i < board.length; i++){
            for (int b = 0; b < board.length; b++){
                if (board[i][b] == 0) return false;
            }
        }
        return true;
    }
    private static boolean checkVertical(int[][] board){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int b = 0; b < board.length; b++){
                result.add(board[i][b]);
            }
            result = result.stream().distinct().toList();
            if (result.size() != board.length) return false;
            result = new ArrayList<>();
        }
        return true;
    }
    private static boolean checkHorizontal(int[][] board){
        List<Integer> result2 = new ArrayList<>();
        for (int b = 0; b < board.length; b++) {
            for (int i = 0; i < board.length; i++){
                result2.add(board[i][b]);
            }
            result2 = result2.stream().distinct().toList();
            if (result2.size() != board.length) return false;
            result2 = new ArrayList<>();
        }
        return true;
    }
    private static boolean checkBox(int[][] board) {
        List<Integer> result3 = new ArrayList<>();
        int horizontalLine = -1, verticalLine = -1;
        for (int z = 0; z < 3; z++) {
            for (int c = 0; c < 3; c++) {
                for (int b = 0; b < 3; b++) {
                    verticalLine++;
                    for (int i = 0; i < 3; i++) {
                        horizontalLine++;
                        result3.add(board[verticalLine][horizontalLine]);
                    }
                    horizontalLine -= 3;
                }
                result3 = result3.stream().distinct().toList();
                if (result3.size() != board.length) return false;
                result3 = new ArrayList<>();
            } horizontalLine += 3; verticalLine -= 9;
        }
        return true;
    }
}

/* Other Version
public class SudokuValidator {

    public static boolean validate(int[][] x) {
        int pri [] = {0,2,3,5,7,11,13,17,19,23};
        int row [] = new int [9]; one(row);
        int col [] = new int [9]; one(col);
        int cen [] = new int [9]; one(cen);
        for (int i=0; i<9 ;i++){
            for (int j=0; j<9; j++){
                int c = pri[x[i][j]]; if(c==0)return false;
                int index=(i/3)*3+j/3;
                row[i]*=c; col[j]*=c; cen[index]*=c; c=c*c;
                if((row[i]%c)*(col[j]%c)*(cen[index]%c)==0) return false;
            }
        }
        return true;
    }
    public static void one (int x [] ) {
        for (int i=0 ;i<9; i++) x[i]=1;
    }

}*/

/* Other Version
import java.util.function.BiFunction;
        import java.util.stream.*;
        import java.util.*;


public class SudokuValidator {

    private static Set<Integer> BASE = Set.of(1,2,3,4,5,6,7,8,9);

    public static boolean validate(int[][] board) {

        BiFunction<Integer,Integer,Integer>
                rows  = (i,j) -> board[i][j],
                cols  = (i,j) -> board[j][i],
                boxes = (i,j) -> board[ i/3*3 + j/3 ][ i%3*3 + j%3 ];

        return check(rows) && check(cols) && check(boxes);
    }

    private static boolean check(BiFunction<Integer,Integer,Integer> extract){
        return IntStream.range(0,9).boxed()
                .map( i -> IntStream.range(0,9).boxed()
                        .map(j -> extract.apply(i,j) )
                        .collect(Collectors.toSet()) )
                .allMatch( set -> set.equals(BASE) );
    }
}*/
