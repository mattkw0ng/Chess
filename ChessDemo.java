import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.lang.Math;

public class ChessDemo
{
    public static ChessBoard board;
    public static void main(String[] args) throws Exception
    {
        board = new ChessBoard();

        Scanner scan = new Scanner(new File("new_input.txt"));
        String line;
        String[] lineSegment;

        IllegalChessMoveException illegalChessMove = new IllegalChessMoveException("Illegal chess move");



        while(scan.hasNextLine())
        {
            line = scan.nextLine();
            lineSegment = line.split(" ");
            if (lineSegment[0].equals("move")){
                int orgX = Integer.valueOf(lineSegment[1]);
                int orgY = Integer.valueOf(lineSegment[2]);
                int x = Integer.valueOf(lineSegment[3]);
                int y = Integer.valueOf(lineSegment[4]);
                System.out.println(board.getPiece(orgX,orgY).getType() + " at " + orgX + "," + orgY + " to " + x + "," + y);
                tryMove(orgX,orgY,x,y);
                System.out.println(board);
            }else if (lineSegment[0].equals("")){
            }else{
                String type = lineSegment[0];
                int x = Integer.valueOf(lineSegment[1]);
                int y = Integer.valueOf(lineSegment[2]);
                board.setPiece(x, y, type);
            }

        }

    }
    public static void tryMove(int orgX, int orgY, int x, int y)
    {
        //IllegalChessMoveException illegalChessMove = new IllegalChessMoveException("Illegal chess move");
        //OutOfBoardException outOfBoard = new OutOfBoardException("Out of board");
        try {
            int difX = Math.abs(orgX - x);
            int difY = Math.abs(orgY - y);
            ChessPiece chosen = board.getPiece(orgX,orgY);


            if(x>7||y>7){
                throw new OutOfBoardException("Out of bounds");
            }
            //ILLEGAL MOVE EXCEPTIONS
            else if(chosen.getType().equals("p")){ //for pawns, it makes sure that it does not move in the X direction, and only moves 1 in the y direction
                if(difX != 0 || difY > 2){
                    throw new IllegalChessMoveException("Illegal move for pawn");
                }
            }else if(chosen.getType().equals("r")){  //for rooks, it makes sure that the piece only moves in one direction
                if (difX > 0 && difY > 0) {
                    throw new IllegalChessMoveException("Illegal move for rook");
                }
            }else if(chosen.getType().equals("h")){
                if ((difX + difY)!=3 || difX == difY) {
                    throw new IllegalChessMoveException("Illegal move for knight");
                }
            }else if(chosen.getType().equals("b")){
                if ( difX != difY) {
                    throw new IllegalChessMoveException("Illegal move for bishop");
                }
            }else if(chosen.getType().equals("k")){
                if (difX>1 || difY>1) {
                    throw new IllegalChessMoveException("Illegal move for king");
                }
            }else if(chosen.getType().equals("q")){
                if (difX!=difY && difX>0 && difY>0) {
                    throw new IllegalChessMoveException("Illegal move for queen");
                }
            }
            //PATHWAY EXCEPTIONS
            if(chosen.getType()!="h"){
                int startX, finalX, startY, finalY;
                if(orgX>x){
                    startX = x;
                    finalX = orgX;
                }else{
                    startX = orgX;
                    finalX = x;
                }
                if(orgY>y){
                    startY = y;
                    finalY = orgY;
                }else{
                    startY = orgY;
                    finalY = y;
                }
                //diagonal check
                if(chosen.getType() == "b" ){
                    int sy = startY;
                    for(int sx = startX ; sx <= finalX ; sx++){
                        if(board.getPiece(sx,sy) != null && sx != orgX && sy != orgY){
                            throw new PathwaysException("Pathway Exception: piece at ("+sx+","+sy+")");
                        }
                        sy ++;
                    }
                }else if(chosen.getType() == "q" && difX == difY) {
                    int sy = startY;
                    for (int sx = startX; sx <= finalX; sx++) {
                        if (board.getPiece(sx, sy) != null && sx != orgX && sy != orgY) {
                            throw new PathwaysException("Pathway Exception: piece at (" + sx + "," + sy + ")");
                        }
                        sy++;
                    }
                //horizontal check
                }else if(difY == 0){
                    for (int sx = startX; sx <= finalX; sx++) {
                        if (board.getPiece(sx, orgY) != null && sx != orgX) {
                            throw new PathwaysException("Pathway Exception: piece at (" + sx + "," + orgY + ")");
                        }
                    }
                //vertical check
                }else if(difX == 0){
                    for (int sy = startY; sy <= finalY; sy++){
                        if (board.getPiece(orgX, sy) != null && sy != orgY) {
                            throw new PathwaysException("Pathway Exception: piece at (" + orgX + "," + sy + ")");
                        }
                    }
                }
            }

        //Exception handlers (it changes the move values to the original indexes so the pieces dont move)
        } catch (OutOfBoardException e) {
            System.out.println(e.getMessage());
            x = orgX;
            y = orgY;
        } catch (IllegalChessMoveException e){
            System.out.println(e.getMessage());
            x = orgX;
            y = orgY;
        } catch (PathwaysException e){
            System.out.println(e.getMessage());
            x = orgX;
            y = orgY;
        } finally { //moves the pieces
            board.move(orgX,orgY,x,y);
        }

    }
}