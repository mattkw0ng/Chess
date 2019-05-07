
public class Pawn extends ChessPiece
{

    public Pawn(int x, int y)
    {
        super(x,y);
        super.type = "p";
    }

    public String getType()
    {
        return super.type;
    }

    public void move(int x, int y)
    {
        super.positionX = x;
        super.positionY = y;
    }

    public String toString()
    {
        String statement = "-P-";
        return statement;
    }



}