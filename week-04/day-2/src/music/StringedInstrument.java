package music;

public abstract class StringedInstrument extends Instrument {

    int numberOfStrings;

    StringedInstrument() {
    }

    StringedInstrument(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public void play() {
        sound();
    }

    public abstract void sound();
}
