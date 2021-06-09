public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;

    private String score = "";

    public TennisGame1(String namePlayer1, String namePlayer2) {
        this.player1 = new Player(namePlayer1);
        this.player2 = new Player(namePlayer2);
    }

    public void wonPoint(String playerName) {
        if ((playerName.equals(player1.getName()))) {
            player1.addPoint();
        } else {
            player2.addPoint();
        }
    }

    public String getScore() {
        if (player1.getScore().equals(player2.getScore())) {
            equalPoints();
        } else if (player1.getScore() >= 4 || player2.getScore() >= 4) {
            advantageValidate();
        } else {
            calculatePoints();
        }
        return score;
    }

    private void equalPoints() {
        String[] options = {"Love-All", "Fifteen-All", "Thirty-All"};
        score = (player1.getScore() > 2) ? "Deuce" : options[player1.getScore()];
    }

    private void calculatePoints() {
        String[] options = {"Love", "Fifteen", "Thirty", "Forty"};
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1.getScore();
            else {
                score += "-";
                tempScore = player2.getScore();
            }
            score += options[tempScore];
        }
    }

    private void advantageValidate() {
        int minusResult = player1.getScore() - player2.getScore();
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
    }
}
