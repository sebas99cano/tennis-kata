public class TennisGame3 implements TennisGame {

    private final Player player1;
    private final Player player2;


    public TennisGame3(String namePlayer1, String namePlayer2) {
        this.player1 = new Player(namePlayer1);
        this.player2 = new Player(namePlayer2);
    }

    public String getScore() {
        if (isScoreIsLessThan4() && isSumScoreDifferentFrom6()) {
            return case1();
        }
        return case2();
    }

    private boolean isSumScoreDifferentFrom6() {
        return player1.getScore() + player2.getScore() != 6;
    }

    private boolean isScoreIsLessThan4() {
        return player1.getScore() < 4 && player2.getScore() < 4;
    }

    private String case1() {
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        String s = p[player1.getScore()];
        return (player1.getScore() == player2.getScore()) ? s + "-All" : s + "-" + p[player2.getScore()];
    }

    private String case2() {
        if (player1.getScore() == player2.getScore()){
            return "Deuce";
        }
        return advantageOrWin();
    }

    private String advantageOrWin() {
        String s = choosePlayer();
        return ((player1.getScore()-player2.getScore())*(player1.getScore()-player2.getScore()) == 1) ? "Advantage " + s : "Win for " + s;
    }

    private String choosePlayer() {
        return player1.getScore() > player2.getScore() ? player1.getName() : player2.getName();
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName()))
            player1.addPoint();
        else
            player2.addPoint();
    }
}