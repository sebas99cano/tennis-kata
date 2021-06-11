public class TennisGame2 implements TennisGame {


    public String resultPlayer1 = "";
    public String resultPlayer2 = "";

    private final Player player1;
    private final Player player2;

    private String score;

    public TennisGame2(String namePlayer1, String namePlayer2) {
        player1 = new Player(namePlayer1);
        player2 = new Player(namePlayer2);
    }

    public void wonPoint(String player) {
        if (player.equals(player1.getName())) {
            player1.addPoint();
        } else {
            player2.addPoint();
        }
    }

    public String getScore() {
        equalPoints();
        resultPlayerInitial();
        resultPlayer();
        calculateAdvantage();
        calculateWinner();
        return score;
    }

    private void calculateWinner() {
        if (calculateWinnerByPlayer(player1.getScore(), player2.getScore())) {
            score = "Win for player1";
        }
        if (calculateWinnerByPlayer(player2.getScore(), player1.getScore())) {
            score = "Win for player2";
        }
    }

    private boolean calculateWinnerByPlayer(int firstPoints, int secondPoints) {
        return (firstNumGreaterThan(firstPoints,3) && firstNumGreaterThan(secondPoints,-1) && firstNumGreaterThan((firstPoints - secondPoints),1));
    }

    private void calculateAdvantage() {
        if (calculateAdvantageByPlayer(player1.getScore(), player2.getScore())) {
            score = "Advantage player1";
        }

        if (calculateAdvantageByPlayer(player2.getScore(), player1.getScore())) {
            score = "Advantage player2";
        }
    }

    private boolean calculateAdvantageByPlayer(int firstPoints, int secondPoints) {
        return (firstNumGreaterThan(firstPoints,secondPoints) && firstNumGreaterThan(secondPoints,2));
    }

    private void resultPlayer() {
        String[] options = {"Love", "Fifteen", "Thirty", "Forty"};
        if (resultByPlayer(player1.getScore(), player2.getScore()) || resultByPlayer(player2.getScore(), player1.getScore())) {
            resultPlayer1 = options[player1.getScore()];
            resultPlayer2 = options[player2.getScore()];

            score = resultPlayer1 + "-" + resultPlayer2;
        }
    }

    private boolean resultByPlayer(int firstPoints, int secondPoints) {
        return (firstNumGreaterThan(firstPoints,secondPoints) && firstNumGreaterThan(4,firstPoints));
    }

    private void resultPlayerInitial() {
        String[] options = {"Love", "Fifteen", "Thirty", "Forty"};
        if (resultByPlayerInitial(player1.getScore(), player2.getScore())) {
            resultPlayer1 = options[player1.getScore()];
            resultPlayer2 = options[0];
            score = resultPlayer1 + "-" + resultPlayer2;
        }
        if (resultByPlayerInitial(player2.getScore(), player1.getScore())) {
            resultPlayer2 = options[player2.getScore()];
            resultPlayer1 = options[0];
            score = resultPlayer1 + "-" + resultPlayer2;
        }

    }

    private boolean resultByPlayerInitial(int firstPoints, int secondPoints) {
        return (firstNumGreaterThan(firstPoints,0) && firstNumGreaterThan(4,firstPoints) && secondPoints == 0);
    }

    private void equalPoints() {
        String[] options = {"Love", "Fifteen", "Thirty", "Deuce"};
        if (player1.getScore() == player2.getScore() && firstNumGreaterThan(3,player1.getScore())) {
            score = options[player1.getScore()];
            score += "-All";
        } else {
            score = options[3];
        }
    }

    private boolean firstNumGreaterThan(int firstNum, int secondNum){
        return (firstNum > secondNum);
    }

}