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
