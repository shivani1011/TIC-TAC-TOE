public class Board {
    private static char[][] board;
    private static int boardSize = 3;
    private char p1Symbol1,p2Symbol2;
    private int count;
    public final static int PLAYER_1_WINS = 1;
    public final static int PLAYER_2_WINS = 2;
    public final static int DRAW = 3;
    public final static int INCOMPLETE = 4;
    public final static int INVALID = 5;


    public Board(char p1Symbol1,char p2Symbol2) {
        board = new char[boardSize][boardSize];
        for(int i=0;i<boardSize;i++)
            for(int j=0;j<boardSize;j++)
                board[i][j] = ' ';

        this.p1Symbol1 = p1Symbol1;
        this.p2Symbol2 = p2Symbol2;
    }
    public static void print() {
        System.out.println("-------------------------------------------------");
        for(int i=0;i<boardSize;i++) {
            for(int j=0;j<boardSize;j++) {
                System.out.print("| "+board[i][j]+" |");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("-------------------------------------------------");

    }
    public int move(char symbol,int x,int y)
    {
        if(x<0 || x>=boardSize || y<0 || y>=boardSize || board[x][y]!=' ') {
            return INVALID;
        }
        board[x][y] = symbol;
        count++;
        //check row
        if(board[x][0] == board[x][1] && board[x][0] == board[x][2])
        {
            return symbol==p1Symbol1?PLAYER_1_WINS:PLAYER_2_WINS;
        }
        //check col
        if(board[0][y] == board[1][y] && board[0][y] == board[2][y])
        {
            return symbol==p1Symbol1?PLAYER_1_WINS:PLAYER_2_WINS;
        }
        //check first  diag
        if(board[0][0]!=' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2])
        {
            return symbol==p1Symbol1?PLAYER_1_WINS:PLAYER_2_WINS;
        }
        //check second  diag
        if(board[0][2]!=' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0])
        {
            return symbol==p1Symbol1?PLAYER_1_WINS:PLAYER_2_WINS;
        }
        if(count==boardSize*boardSize)
            return DRAW;

        return INCOMPLETE;
    }
}