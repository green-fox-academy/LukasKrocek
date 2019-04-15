// IN PROGRESS

import java.io.IOException;
import java.lang.reflect.Array;
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
        int i = 0;
        try {
            Path pathToFile = Paths.get(path);
            lines = Files.readAllLines(pathToFile);

            for (String line : lines) {
                int lineChecker = 0;

                for (int j = 0; j < line.length(); j++) {

                    // Line check
                    if (line.indexOf(j) == line.indexOf(j + 1)) {
                        lineChecker++;
                        if (lineChecker >= line.length()) {
                            result = "win - " + line.indexOf(j);
                            return result;
                        }
                    }
                }
            }

        } catch (IOException e) {
            result = path + " not found";
        }

        return result;
    }
}