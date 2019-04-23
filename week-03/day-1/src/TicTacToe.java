// IN PROGRESS

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

    public static void main(String[] args) {
        // Write a function that takes a filename as a parameter
        // The file contains an ended Tic-Tac-Toe match
        // We have provided you some example files (draw.txt, win-x.txt, win-o.txt)
        // Return "X", "O" or "Draw" based on the input file

        System.out.println(ticTacResult("win-o.txt"));
    }

    public static String ticTacResult(String path) {
        List<String> lines = new ArrayList<>();
        String result = "Draw";
        try {
            Path pathToFile = Paths.get(path);
            lines = Files.readAllLines(pathToFile);

        } catch (IOException e) {
            result = path + " not found";
        }
        return recursive(0,3,3,lines);
    }

    public static String recursive (int counter, int row , int column, List <String> lines){
        if (row>lines.size()-1||column>lines.size()-1){
            return "blabla";
        } else if (lines.get(row).charAt(column)==lines.get(row).charAt(column+1)){
            counter ++;
            if (counter== lines.size()-1){
                return lines.get(row).charAt(column) + " - won";
            }
        }
        recursive(counter,row+1,column,lines);

      return "ops" ;
    }
}