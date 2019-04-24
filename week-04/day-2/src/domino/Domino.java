package domino;

import interfaces.Printable;

import java.util.Arrays;

public class Domino implements Printable,Comparable<Domino> {
    private final int left;
    private final int right;

    @Override
    public void printAllFields() {
        System.out.print(this);
    }

    public Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeftSide() {
        return left;
    }

    public int getRightSide() {
        return right;
    }

    @Override
    public String toString() {
        return "[" + left + ", " + right + "]";
    }

    @Override
    public int compareTo(Domino o) {
        return Integer.compare(this.left, o.left); }
}
