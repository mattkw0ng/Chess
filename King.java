
public class King extends ChessPiece
{

    public King(int x, int y)
    {
        super(x,y);
        super.type = "k";
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
        String statement = "-K-";
        return statement;
    }



}