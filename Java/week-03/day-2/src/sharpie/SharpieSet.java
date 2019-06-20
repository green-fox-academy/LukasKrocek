package sharpie;

import java.util.ArrayList;
import java.util.List;

public class SharpieSet {
    /*
    Reuse your Sharpie class
    Create SharpieSet class
    it contains a list of Sharpie
    countUsable() -> sharpie is usable if it has ink in it
    removeTrash() -> removes all unusable sharpies
    */
    List<Sharpie> sharpies;

    SharpieSet() {
        this.sharpies = new ArrayList();
    }

    public int countUsable() {
        int numberOfUsable = 0;
        for (Sharpie sharpie : this.sharpies) {
            if (sharpie.inkAmount != 0) {
                numberOfUsable++;
            }
        }
        return numberOfUsable;
    }

    public void removeTrash() {
        for (Sharpie sharpie : this.sharpies) {
            if (sharpie.inkAmount == 0) {
                sharpies.remove(sharpie);
            }
        }
    }
}
