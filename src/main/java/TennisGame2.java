public class TennisGame2 implements TennisGame {

    public int pointsPlayer1 = 0;
    public int pointsPlayer2 = 0;

    public String resultPlayer1 = "";
    public String resultPlayer2 = "";
    private String namePlayer1;
    private String namePlayer2;

    private String scoree;

    public TennisGame2(String namePlayer1, String namePlayer2) {

        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }

    public void P1Score() {
        pointsPlayer1++;
    }

    public void P2Score() {
        pointsPlayer2++;
    }

    public String getScore() {
        equalPoints();
        resultPlayerInitial();
        resultPlayer();
        calculateAdvantage();
        calculateWinner();
        return scoree;
    }

    private void calculateWinner() {
        if (calculateWinnerByPlayer(pointsPlayer1,pointsPlayer2)) {
            scoree = "Win for player1";
        }
        if (calculateWinnerByPlayer(pointsPlayer2,pointsPlayer1)) {
            scoree = "Win for player2";
        }
    }
    private boolean calculateWinnerByPlayer(int firstPoints, int secondPoints) {
        return (firstPoints >= 4 && secondPoints >= 0 && (firstPoints - secondPoints) >= 2);
    }

    private void calculateAdvantage() {
        if (calculateAdvantageByPlayer(pointsPlayer1,pointsPlayer2)) {
            scoree = "Advantage player1";
        }

        if (calculateAdvantageByPlayer(pointsPlayer2,pointsPlayer1)) {
            scoree = "Advantage player2";
        }
    }
    private boolean calculateAdvantageByPlayer(int firstPoints, int secondPoints) {
        return (firstPoints > secondPoints && secondPoints >= 3);
    }

    private void resultPlayer() {
        String[] options = {"Love", "Fifteen", "Thirty", "Forty"};
        if (resultByPlayer(pointsPlayer1, pointsPlayer2) || resultByPlayer(pointsPlayer2, pointsPlayer1)) {
            resultPlayer1 = options[pointsPlayer1];
            resultPlayer2 = options[pointsPlayer2];

            scoree = resultPlayer1 + "-" + resultPlayer2;
        }


    }

    private boolean resultByPlayer(int firstPoints, int secondPoints) {
        return (firstPoints > secondPoints && firstPoints < 4);
    }

    private void resultPlayerInitial() {
        String[] options = {"Love", "Fifteen", "Thirty", "Forty"};
        if (resultByPlayerInitial(pointsPlayer1, pointsPlayer2)) {
            resultPlayer1 = options[pointsPlayer1];
            resultPlayer2 = options[0];
            scoree = resultPlayer1 + "-" + resultPlayer2;
        }
        if (resultByPlayerInitial(pointsPlayer2, pointsPlayer1)) {
            resultPlayer2 = options[pointsPlayer2];
            resultPlayer1 = options[0];
            scoree = resultPlayer1 + "-" + resultPlayer2;
        }

    }

    private boolean resultByPlayerInitial(int firstPoints, int secondPoints) {
        return (firstPoints > 0 && firstPoints < 4 && secondPoints == 0);
    }

    private void equalPoints() {
        String[] options = {"Love", "Fifteen", "Thirty", "Deuce"};
        if (pointsPlayer1 == pointsPlayer2 && (pointsPlayer1 < 3)) {
            scoree = options[pointsPlayer1];
            scoree += "-All";
        } else {
            scoree = options[3];
        }

    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }


}