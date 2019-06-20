public class TennisGame3 implements TennisGame {

    private Player player1;
    private Player player2;
    /*
    enum umpire {
        LOVE,FIFTEEN,THIRTY,FORTY
    }
     */
    String[] umpire = new String[]{"Love", "Fifteen", "Thirty", "Forty", "Advantage", "Deuce", "Win for "};
    int maximumScore = 4;

    public TennisGame3(String p1N, String p2N) {
        player1 = new Player(p1N);
        player2 = new Player(p2N);
    }

    public String getScore() {
        if (player1.getScore() < maximumScore && player2.getScore() < maximumScore) {
            return earlyGame();
        } else {
            return lateGame();
        }
    }

    public String lateGame() {
        if (player1.getScore() == player2.getScore())
            return "Deuce";
        String gameScore = getWinningPlayer();
        return ((isDifferenceOne()) ? "Advantage " : "Win for ") + gameScore;
    }

    public boolean isDifferenceOne() {

        return Math.abs((player1.getScore() - player2.getScore())) == 1;

    }

    public String getWinningPlayer() {
        return player1.getScore() > player2.getScore() ? player1.getName() : player2.getName();
    }

    public String earlyGame() {
        String gameScore = umpire[player1.getScore()];
        return (player1.getScore() == player2.getScore()) ? gameScore + "-All" : gameScore + "-" + umpire[player2.getScore()];
    }

    public void wonPoint(String name) {
        if (player1.getName().equals(name)) {
            player1.incrementScore();
            return;
        }
        player2.incrementScore();

    }


}