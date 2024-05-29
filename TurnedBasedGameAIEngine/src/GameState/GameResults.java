package GameState;

public class GameResults {
    public boolean isOver;
    public String winner;
    public GameResults(boolean isOver, String winner){
        this.isOver = isOver;
        this.winner = winner;
    }
    public boolean isOver(){
        return isOver;
    }
    public String getWinner(){
        return winner;
    }
}
