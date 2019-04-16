package pokemons;

public class Pokemon {
    String name;
    String type;

    Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String isEffectiveAgainst() {
        String effectiveAgainst = "";
        switch (this.type) {
            case "fire":
                effectiveAgainst = "water";
                break;
            case "water":
                effectiveAgainst = "fire";
                break;
            case "wind":
                effectiveAgainst = "water";
                break;
            case "stone":
                effectiveAgainst = "fire";
                break;
            case "wild":
                effectiveAgainst = "wind";
                break;
            default:
                effectiveAgainst = "unbeatable";
        }
        return effectiveAgainst;
    }
}
