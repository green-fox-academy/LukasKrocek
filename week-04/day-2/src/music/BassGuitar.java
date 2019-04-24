package music;

public class BassGuitar extends StringedInstrument {

    public BassGuitar() {
        numberOfStrings = 4;
    }

    public BassGuitar(int numberOfStrings) {
        super(numberOfStrings);
    }

    @Override
    public String sound() {
        String sound = "Duum-duum-duum";
        return sound;
    }
}
