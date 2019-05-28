public class Player {
    private String name;
    private int score;
    private static int playerNumber = 1;

    public Player(String name) {
        this.name = name;
        score = 0;


    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

}
