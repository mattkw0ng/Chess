
public class Queen extends ChessPiece
{

    public Queen(int x, int y)
    {
        super(x,y);
        super.type = "q";
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
        String statement = "-Q-";
        return statement;
    }



}