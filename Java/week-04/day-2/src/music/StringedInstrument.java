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
        System.out.println(getClass().getSimpleName() + ", a " + numberOfStrings + "-stringed instrument that goes " + sound());
    }

    public abstract String sound();
}
