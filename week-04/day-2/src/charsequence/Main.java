package charsequence;

import charsequence.Gnirts;

public class Main {
    public static void main(String[] args) {
        Gnirts text = new Gnirts("this example");
        System.out.println(text.charAt(2));
        Shifter s = new Shifter("example", 2);
        System.out.println(s.charAt(0));
    }
}
