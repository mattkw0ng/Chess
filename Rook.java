
public class Rook extends ChessPiece
{


    public Rook(int x, int y)
    {
        super(x,y);
        super.type = "r";
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
        String statement = "-R-";
        return statement;
    }



}