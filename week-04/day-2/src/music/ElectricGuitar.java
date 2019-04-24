package music;

public class ElectricGuitar extends StringedInstrument {

    public ElectricGuitar() {
        this.numberOfStrings = 6;
    }

    public ElectricGuitar(int numberOfStrings) {
        super(numberOfStrings);
    }

    @Override
    public String sound() {
        String sound = "Twang";
        return sound;
    }
}
