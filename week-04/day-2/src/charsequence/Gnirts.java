package charsequence;

public class Gnirts implements CharSequence {
    String text;

    public Gnirts(String text) {
        this.text = text;
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        return text.charAt(length()-index-1);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
