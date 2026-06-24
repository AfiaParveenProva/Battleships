import java.util.ArrayList;
import java.util.List;

public class Battleships {
	static char[][] board = {{'.','.','.','.','.','.','.','.','.','.'},
			  {'.','.','.','.','.','.','.','.','.','.'},
			  {'.','.','.','.','.','.','.','.','.','.'},
			  {'.','.','.','.','.','.','.','.','.','.'},
			  {'.','.','.','.','.','.','.','.','.','.'},
			  {'.','.','.','.','.','.','.','.','.','.'},
			  {'.','.','.','.','.','.','.','.','.','.'},
			  {'.','.','.','.','.','.','.','.','.','.'},
			  {'.','.','.','.','.','.','.','.','.','.'},
			  {'.','.','.','.','.','.','.','.','.','.'}};
	public static void main(String[] args) {	
	}	
	public static boolean ValidBoardSquare(char state) {      //method 1.1
		if (state == '.' || state == 'S' || state == '*'){   //'S' is case sensitive meaning s cannot be lower case
			return true;
		}
		else return false;
	}
	public static int ValidBoard(char[][] board) {        	//method 1.2
		if(board == null) {        //the board is null
			return 0;
		}
		if(board.length != 10 || board[0].length != 10) {   //board is the wrong size
			return 1;
		}	 
		for(int i=0;i<10;i++) {     //correct size & at least one invalid square
			for(int j=0;j<10;j++) {
				if(board[i][j] != '.' && board[i][j] != 'S' && board[i][j] != '*')
			return 2;
			}
		}
		    return 3;    //valid means board is correct size, not null, each square contains a valid character
	}
	public static int NumberSunk(char[][] board) {   	//method 1.3
		//if(ValidBoard(board)!=3) return -1;	assuming the board is valid
				int total= 0;  //if there are no ships on the board 
						for(int i=0;i<10;i++) {
							for (int j=0;j<10;j++) {
								if(board[i][j] == 'S' || board[i][j] == '*') {
									total++;
								}
							}
						}
				if(total == 0) 
					return 4;
		int sunk=0;     //return number of sunk ships; 
		for(int i=0;i<10;i++){
			boolean flag = false;	
			for(int j=0;j<9;j++){
				if(board[i][j]=='.' && board[i][j+1]=='*'){
					flag = true;
				}
				if(flag && board[i][j]=='*' && board[i][j+1]=='.'){  
					sunk++;
					flag = false;
				}
			}
		}
		    return sunk;    //'*' horizontally without gap means sunk				
	}   //flag NOT ; flag = true
	public static int Hit(int row, char column, char[][] board) {	//method 1.4   //1A = (0,0)
		if (row > 10 || row < 1) {  //the row number is invalid
			return 5;
		}
		if (column != 'A' && column != 'B' && column != 'C' && column != 'D' && column != 'E' && column != 'F' && column != 'G' && column != 'H' && column != 'I' && column != 'J') {  //the column is invalid  
			return 6;
		}
		if (board[row-1][(int)(column-'A')] == 'S') {   //hit (square contains a ‘S’)
			return 7;
		}
		if (board[row-1][column-'A'] == '.') {   //miss (square contains a ‘.’)
			return 8;
		}
		//if (board[row-1][column-'A'] == '*') {   //repeated hit (square contains a ‘*’)
			return 9;    //assuming the input board is valid
	} //unmappable character for encoding ascii for line 72 and 75
	public static int CountShips(char[][] board1, String shipType, String damageType) {	//method 1.5	    
		//ss....ss. 
		//star
		//star == ship length => sunk
		//star = 0 => undamaged
		//damaged
		int count = 0;
		int sunk = 0,undamaged = 0,damaged = 0;
		for(int i=0;i<10;i++) {
			int star = 0,ship=0;
			boolean flag = false;
			for(int j=0;j<10;j++)
			{
				if(board1[i][j]=='S' || board1[i][j]=='*')
				{
					flag = true;
					ship++;
				}
				if(board1[i][j]=='*')star++;
				if(flag && (board1[i][j]=='.' || j==9))
				{
					flag = false;
					if(star==ship)
					{
						sunk++;
						if(damageType.equals("sunk")){
							count++;
						}
					}
					else if(star==0) undamaged++;
					if(damageType.equals("undamaged")){
						count++;
					}
					else damaged++;
					if(damageType.equals("damaged")){
						count++;
					}
					star = 0;
					ship = 0;
					if(shipType.equals("1")||shipType.equals("Carrier")){
						count++;
					}
					if(shipType.equals("2")||shipType.equals("Battleship")){
						count++;
					}
					if(shipType.equals("3")||shipType.equals("Cruiser")){
						count++;
					}
					if(shipType.equals("4")||shipType.equals("Destroyer")){
						count++;
					}
				}
			}
			return count; //returns the number (count) of ships that match the parameters
		}  
		if(shipType!="1" && shipType!="2" && shipType!="3" && shipType!="4" && shipType!="Carrier" && shipType!="Battleship" && shipType!="Cruiser" && shipType!="Destroyer") {   //ship type parameter is invalid
			return 10;
		}
		if(damageType!="undamaged" && damageType!="damaged" && damageType!="sunk") {   //damage type parameter is invalid
			return 11;
		}  
		boolean flag2= false;
		for(int i1=0;i1<10;i1++) {
			for(int j1=0;j1<10;j1++) {
				if (board[i1][j1]!=board1[i1][j1])
				{
					flag2 = true; //ships on the board
					break;
				}
			}
		}
		if (flag2==false) 
			return 12;  //If there are no ships on the board 
		    return -1;
			}
	
	for(int i=0;i<10;i++) {
		for(int j=0;j<10;j++){
			if(board[i][j]!='S' && board[i][j]!='*'){
		return -3;  //If there are no ships on the board 
		}
	  }
	}
		
		/*int totalS = 0;  //no ships on the board (this is still a valid board)
			for(int i=0;i<10;i++) {
				for (int j=0;j<10;j++) {
					if(board[i][j] == 'S') {
						totalS++;
					}
				}
			}
			if(totalS == 0)*/			
	public static ArrayList<Double> Bonus(char[][] board1) {		//method BONUS
		ArrayList<Double> arr = new ArrayList<>();
		int sunk = 0,undamaged = 0,damaged = 0;
		arr.set(1, null);
		arr.set(2, null);
		arr.set(3, null);
		arr.set(4, null);
		arr.set(5, null);
		arr.set(6, null);
		arr.set(7, null);
		arr.set(8, null);
		arr.set(9, null);
		arr.set(10, null);
		arr.set(11, null);
		arr.set(12, null);
		arr.set(13, null);
		arr.set(14, null);
		arr.set(15, null);
		arr.set(16, null);
		arr.set(17, null);
		arr.set(18, null);
		arr.set(19, null);
		arr.set(20, null);
		arr.set(21, null);
		arr.set(22, null);
		arr.set(23, null);
		arr.set(24, null);
		arr.set(25, null);
		arr.set(26, null);
		arr.set(27, null);
		arr.set(28, null);
		arr.set(29, null);
		arr.set(30, null);
		arr.set(31, null);
		arr.set(32, null);
		arr.set(33, null);
		arr.set(34, null);
		arr.set(35, null);
		arr.set(36, null);
		arr.set(37, null);
		arr.set(38, null);
		arr.set(39, null);
		arr.set(40, null);
		arr.set(41, null);
		arr.set(42, null);
		arr.set(43, null);
		arr.set(44, null);
		arr.set(45, null);
		arr.set(46, null);
		arr.set(47, null);
		arr.set(48, null);
		arr.set(49, null);
		arr.set(50, null);
		arr.set(51, null);
		arr.set(52, null);
		arr.set(53, null);
		arr.set(54, null);
		arr.set(55, null);
		arr.set(56, null);
		arr.set(57, null);
		arr.set(58, null);
		arr.set(59, null);
		arr.set(60, null);
		arr.set(61, null);
		arr.set(62, null);
		arr.set(63, null);
		arr.set(64, null);
		arr.set(65, null);
		arr.set(66, null);
		arr.set(67, null);
		arr.set(68, null);
		arr.set(69, null);
		arr.set(70, null);
		arr.set(71, null);
		arr.set(72, null);
		arr.set(73, null);
		arr.set(74, null);
		arr.set(75, null);
		arr.set(76, null);
		arr.set(77, null);
		arr.set(78, null);
		arr.set(79, null);
		arr.set(80, null);
		arr.set(81, null);
		arr.set(82, null);
		arr.set(83, null);
		arr.set(84, null);
		arr.set(85, null);
		arr.set(86, null);
		arr.set(87, null);
		arr.set(88, null);
		arr.set(89, null);
		arr.set(90, null);
		arr.set(91, null);
		arr.set(92, null);
		arr.set(93, null);
		arr.set(94, null);
		arr.set(95, null);
		arr.set(96, null);
		arr.set(97, null);
		arr.set(98, null);
		arr.set(99, null);
		arr.set(100, null);
		//arr..arr..arr
		
		for(int i=0;i<10;i++) {
			int star = 0,ship=0;
			boolean flag = false;
			for(int j=0;j<10;j++)
			{
				if(board1[i][j]=='S' || board1[i][j]=='*')
				{
					flag = true;
					ship++;
				}
				if(board1[i][j]=='*')star++;
				if(flag && (board1[i][j]=='.' || j==9))
				{
					flag = false;
					Double perc = (100.0*star)/ship;
					if(ship==4)
					{
						arr.set(1,perc);
					}
					//if
					//if
					
					star = 0;
					ship = 0;
				}
			}
		}
		return arr;
		
		//star count,ship length
		//star = 0 (star*100)/length = percenttage
		//ship length->id
		//arr[id] -> damage percentage ta push kortesi
		
/*returns a damage report for a given board. Each type of ship should be identified within the board and the percentage of damage calculated 
(the average damage per ship within each class/type of ship). The return value will be an array/list type structure where the first position represents 
the damage report for ship ID 1, etc… If there are no ships of a given type then the corresponding array position (return value) should contain an error value (specified on the day of the examination). 
The board might not be valid and hence there will be return values for error conditions needed.*/
	}
}

/*
import java.util.ArrayList;
import java.util.Arrays;
public class BattleshipBoard {
    private static final int BOARD_SIZE = 10;
    private static final char SHIP_PART = 'S';
    private static final char DAMAGED_SHIP_PART = '*';
    private static final char WATER = '.';
    private static final int CARRIER_SIZE = 5;
    private static final int BATTLESHIP_SIZE = 4;
    private static final int CRUISER_SIZE = 3;
    private static final int DESTROYER_SIZE = 2;
    private static final int ERROR_NO_SHIP = -1;
    private static final int ERROR_INVALID_BOARD = -2;

    public static int[] getDamageReport(char[][] board) {
        if (!isValidBoard(board)) {
            return new int[] {ERROR_INVALID_BOARD, ERROR_INVALID_BOARD, ERROR_INVALID_BOARD, ERROR_INVALID_BOARD};
        }

        int[] shipCounts = new int[4];
        int[] damageCounts = new int[4];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == SHIP_PART || board[i][j] == DAMAGED_SHIP_PART) {
                    int shipSize = 0;
                    int damageCount = 0;
                    int startJ = j;

                    while (j < BOARD_SIZE && (board[i][j] == SHIP_PART || board[i][j] == DAMAGED_SHIP_PART)) {
                        if (board[i][j] == DAMAGED_SHIP_PART) {
                            damageCount++;
                        }
                        shipSize++;
                        j++;
                    }

                    int shipType = getShipType(shipSize);
                    if (shipType != -1) {
                        shipCounts[shipType]++;
                        damageCounts[shipType] += damageCount;
                    }

                    // Mark the identified ship as processed
                    for (int k = startJ; k < j; k++) {
                        board[i][k] = WATER;
                    }
                }
            }
        }

        int[] damageReport = new int[4];
        for (int i = 0; i < 4; i++) {
            if (shipCounts[i] == 0) {
                damageReport[i] = ERROR_NO_SHIP;
            } else {
                damageReport[i] = (damageCounts[i] * 100) / (shipCounts[i] * getShipSize(i));
            }
        }

        return damageReport;
    }

    private static boolean isValidBoard(char[][] board) {
        if (board.length != BOARD_SIZE) {
            return false;
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i].length != BOARD_SIZE) {
                return false;
            }
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] != WATER && board[i][j] != SHIP_PART && board[i][j] != DAMAGED_SHIP_PART) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int getShipType(int size) {
        switch (size) {
            case CARRIER_SIZE:
                return 0; // Carrier
            case BATTLESHIP_SIZE:
                return 1; // Battleship
            case CRUISER_SIZE:
                return 2; // Cruiser
            case DESTROYER_SIZE:
                return 3; // Destroyer
            default:
                return -1; // Invalid ship size
        }
    }

    private static int getShipSize(int type) {
        switch (type) {
            case 0:
                return CARRIER_SIZE;
            case 1:
                return BATTLESHIP_SIZE;
            case 2:
                return CRUISER_SIZE;
            case 3:
                return DESTROYER_SIZE;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', 'S', 'S', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '*', '*', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'S', 'S', 'S', 'S', '*', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
        };

        int[] report = getDamageReport(board);
        System.out.println("Damage Report: " + Arrays.toString(report));
    }
}
*/


For example, if a board contained only four battleships as follows:

"SSS*", "****", "SSSS", "S***"

The damage report for the battleship is: 8/16, and thus the ArrayList to be returned is: [-1, 0.5, -3, -4] 



Use the following function prototype when writing the method:

public static ArrayList<Double> QB_DamageReport(char board[][]) {

}



The following return conditions should be implemented:

Test 1: If the board is invalid then null should be returned. [1 mark]


Test 2: If the board is valid then the damage percentage as defined should be returned. If there are no ships of a given type on the board then -(ship ID), e.g. -1 for ship ID 1, should be in the corresponding position in the ArrayList. [4 marks]
