package hello;

/**
 * Created by ahmadholpa on 2/9/2017.
 */
public class TicTacToe {

    private String name;
    private int move;
    public TicTacToe(){
        this.name = "habli";
    }

    public int getRvalue()
    {
        return 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
}
