
public class Knight extends ChessPiece
{


    public Knight(int x, int y)
    {
        super(x,y);
        super.type = "h";
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
        String statement = "-H-";
        return statement;
    }


}