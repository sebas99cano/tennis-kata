public class Player {
    private final String name;
    private Integer score = 0;

    public Player(String name) {
        this.name = name;
    }

    public void addPoint(){
        this.score+=1;
    }

    public Integer getScore(){
        return this.score;
    }
    public String getName(){
        return this.name;
    }
}
