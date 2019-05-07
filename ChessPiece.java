abstract public class ChessPiece
{
    protected int positionX;
    protected int positionY;
    protected String type = "";

    public ChessPiece(int x , int y)
    {
        positionX = x;
        positionY = y;
    }

    public int getPositionX()
    {
        return positionX;
    }

    public int getPositionY()
    {
        return positionY;
    }

    public String getType()
    {
        return type;
    }

    public abstract void move(int x, int y);


}