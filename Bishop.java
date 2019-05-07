
public class Bishop extends ChessPiece
{


    public Bishop(int x, int y)
    {
        super(x,y);
        super.type = "b";
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
        String statement = "-B-";
        return statement;
    }


}