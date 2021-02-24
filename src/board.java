import java.util.Scanner;

public class Board {
    private char[][] board = new char[3][3];

    public static void main(String[] args) {
        Board testBoard = new Board();
        System.out.println("Welcome! This is your board");
        testBoard.displayBoard();
        boolean playerXTurn = true;
        Scanner userInput = new Scanner(System.in);
        while(!testBoard.win()){
            if(playerXTurn){
                System.out.println("Player X, what is your move");
                String playersMove = userInput.nextLine();
                String[] move = playersMove.split(" "); 
                int m1;
                int m2;
                try {
                    m1 = Integer.parseInt(move[0]);
                    m2 = Integer.parseInt(move[1]);
                    if(testBoard.move(m1,m2, 'X')){
                        playerXTurn = false;
                    }
                } catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
                    System.out.println("Bad input");
                }
            }else {
                System.out.println("Player O, what is your move");
                String playersMove = userInput.nextLine();
                String[] move = playersMove.split(" "); 
                int m1;
                int m2;
                try {
                    m1 = Integer.parseInt(move[0]);
                    m2 = Integer.parseInt(move[1]);
                    if(testBoard.move(m1,m2, 'O')){
                        playerXTurn = true;
                    }
                } catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
                    System.out.println("Bad input");
                }
            }
            userInput.close();
        }

    }
    public Board(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = '-';
            }
        }
    }

    public char[][] getBoard(){
        return board;
    }

    public void displayBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " ");
                if(j == 2){
                    System.out.println("");
                }
            }
        }
    }

    public boolean move(int px, int py, char player){
        //player is expecting our 0,0 to be 1,1
        int x = px - 1;
        int y = py - 1;
        if((x < 3) && (y < 3) && 
                (x >= 0) && (y >= 0) && 
                board[x][y] == '-'){
            board[x][y] = player;
            displayBoard();
        } else {
            System.out.println("Invalid move");
            return false;
        }
        return true;
    }

    public boolean rowWin(){
        for(int i = 0; i < 3; i++){
            char curr = '-';
            for(int j = 0; j < 3; j++){
                if(board[i][j] == '-'){
                    break;
                }
                if(j == 0){
                    curr = board[i][j];
                } else if(board[i][j] != curr){
                    break;
                } else if(j == 2){
                    System.out.println(curr + " is the winner");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean colWin(){
        for(int j = 0; j < 3; j++){
            char curr = '-';
            for(int i = 0; i < 3; i++){
                if(board[i][j] == '-'){
                    break;
                }
                if(i == 0){
                    curr = board[i][j];
                } else if(board[i][j] != curr){
                    break;
                } else if(i == 2){
                    System.out.println(curr + " is the winner");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean diagWin(){
        char curr = '-';
        for(int i = 0; i < 3; i++){
            if(board[i][i] == '-'){
                break;
            }
            if(i == 0){
                curr = board[i][i];
            } else if (board[i][i] != curr){
                break;
            } else if(i == 2) {
                System.out.println(curr + " is the winner");
                return true;
            }
        }
        return false;
    }

    public boolean diagWin2(){
        char curr = '-';
        for(int j = 0; j < 3; j++){
            int i = 2 - j;
            if(board[i][j] == '-'){
                break;
            }
            if(j == 0){
                curr = board[i][j];
            } else if (board[i][j] != curr){
                break;
            } else if(j == 2) {
                System.out.println(curr + " is the winner");
                return true;
            }
            
        }
        return false;
    }
    public boolean win(){
        return rowWin() || colWin() || diagWin() || diagWin2();
    }
}
