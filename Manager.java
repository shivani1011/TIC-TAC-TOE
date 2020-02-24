import java.util.Scanner;

public class Manager {
    private Player player1, player2;
    private Board board;

    private Player takeInput(int num) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player " + num + " name: ");
        String name = sc.nextLine();
        System.out.println("Enter symbol " + num + " symbol: ");
        char symbol = sc.next().charAt(0);
        Player p = new Player(name, symbol);
        return p;
    }

    public void startGame() {
        //player input, create board, conduct game
        Scanner sc = new Scanner(System.in);
        player1 = takeInput(1);
        player2 = takeInput(2);
        while(player1.getSymbol()==player2.getSymbol())
        {
            System.out.println("Symbol already taken, Pick another symbol");
            player2.setSymbol(sc.next().charAt(0));
        }

        //make board
        board = new Board(player1.getSymbol(), player2.getSymbol());
        int status = Board.INCOMPLETE;
        //conduct game
        boolean player1Turn = true;
        while(status == Board.INCOMPLETE || status == Board.INVALID)
        {
            if(player1Turn)
            {
                System.out.println("Player 1 :" + player1.getName()+"'s turn");
                System.out.println("Enter X: ");
                int x = sc.nextInt();
                System.out.println("Enter Y: ");
                int y = sc.nextInt();
                status = board.move(player1.getSymbol(),x,y);
                //1 - player1 win.. 2- player 2 win.. 3- draw.. 4- incomplete.. 5-invalid
                if(status!=board.INVALID)
                {
                    player1Turn = false;
                    board.print();
                }else
                    System.out.println("Invalid Move, Try again!");
            }

            else {
                System.out.println("Player 2 : " + player2.getName()+"'s turn");
                System.out.println("Enter X coord: ");
                int x = sc.nextInt();
                System.out.println("Enter Y coord: ");
                int y = sc.nextInt();
                status = board.move(player2.getSymbol(),x,y);
                //1 - player1 win.. 2- player 2 win.. 3- draw.. 4- incomplete.. 5-invalid
                if(status!=board.INVALID)
                {
                    player1Turn = true;
                    board.print();
                }else
                    System.out.println("Invalid Move, Try again!");

            }

        }
        if(status==board.PLAYER_1_WINS)
            System.out.println("Player 1 - "+player1.getName()+" wins!!");
        else if(status==board.PLAYER_2_WINS)
            System.out.println("Player 2 - "+player2.getName()+" wins!!");
        else
            System.out.println("Game Draw");

    }
    public static void main(String[] args) {
        Manager m = new Manager();
        m.startGame();
    }
}