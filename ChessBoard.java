import java.util.Arrays;
public class ChessBoard
{

    private ChessPiece[][] board;
    public ChessBoard()
    {
        board = new ChessPiece[8][8];
    }

    public ChessPiece getPiece(int x, int y)
    {
        return board[x][y];
    }

    public void setPiece(int x, int y, String type)
    {
        if(type.equals("pawn")){
            board[x][y] = new Pawn(x,y);
        }else if(type.equals("rook")){
            board[x][y] = new Rook(x,y);
        }else if(type.equals("knight")){
            board[x][y] = new Knight(x,y);
        }else if(type.equals("bishop")){
            board[x][y] = new Bishop(x,y);
        }else if(type.equals("king")){
            board[x][y] = new King(x,y);
        }else if(type.equals("queen")){
            board[x][y] = new Queen(x,y);
        }
    }

    public String toString()
    {
        String statement = "";
        for(int y = 7 ; y>=0 ; y--){

            statement += "=" + y + "= ";
            for(int x = 0 ; x<8 ; x++){
                if(board[x][y] == null){
                    statement += "--- ";
                }else{
                    statement += board[x][y] + " ";
                }
            }
            statement += "\n";
        }
        statement += "=== =0= =1= =2= =3= =4= =5= =6= =7= \n";
        return statement;
    }

    public void move(int x, int y, int x_new, int y_new)
    {
        if(x==x_new && y== y_new){
            System.out.println("Nothing was done");
        }else {
            ChessPiece temp = board[x][y];
            temp.move(x_new, y_new);
            board[x_new][y_new] = temp;
            board[x][y] = null;
        }
    }


}