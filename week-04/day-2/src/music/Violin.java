package music;

public class Violin extends StringedInstrument {

    public Violin() {
        numberOfStrings = 4;
    }

    public Violin(int numberOfStrings) {
        super(numberOfStrings);
    }

    @Override
    public String sound() {
        String sound = "Screech";
        return sound;
    }
}
