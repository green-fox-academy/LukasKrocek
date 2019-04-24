package domino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dominoes {
    public static void main(String[] args) {
        List<Domino> dominoes = initializeDominoes();
        // You have the list of Dominoes
        // Order them into one snake where the adjacent dominoes have the same numbers on their adjacent sides
        // eg: [2, 4], [4, 3], [3, 5] ...
        System.out.println("Sorted by size of left");
        for (Domino d : dominoes) {
            d.printAllFields();
        }
        System.out.println();
        System.out.println();
        System.out.println("Ordered");
        sortDominoes(dominoes);
        for (Domino d : dominoes) {
            d.printAllFields();
        }
    }

    static List<Domino> sortDominoes(List<Domino> dominoes) {

        for (int i = 0; i < dominoes.size() - 1; i++) {
            int move = i + 1;
            while (dominoes.get(i).getRightSide() != dominoes.get(move).getLeftSide() && move < dominoes.size() - 1) {
                move++;
            }
            Domino temporaryDomino = dominoes.get(move);
            dominoes.remove(dominoes.get(move));
            dominoes.add(i + 1, temporaryDomino);
        }
        return dominoes;
    }

    static List<Domino> initializeDominoes() {
        List<Domino> dominoes = new ArrayList<>();
        dominoes.add(new Domino(5, 2));
        dominoes.add(new Domino(4, 6));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(6, 7));
        dominoes.add(new Domino(2, 4));
        dominoes.add(new Domino(7, 1));
        Collections.sort(dominoes);
        return dominoes;
    }
}
