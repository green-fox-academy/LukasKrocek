package charsequence;

public class Shifter implements CharSequence {
String text;
int numberOfChars;
    public Shifter (String text, int numberOfChars){
        this.text = text;
        this.numberOfChars = numberOfChars;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {

        if (index>numberOfChars)
            return text.charAt (index);
        else {
            return text.charAt (numberOfChars-index);
        }
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
