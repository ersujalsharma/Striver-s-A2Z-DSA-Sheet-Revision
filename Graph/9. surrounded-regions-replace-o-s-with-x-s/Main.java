/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    public static int rows[] = {-1,0,+1,0};
    public static int cols[] = {0,-1,0,+1};
	public static void main(String[] args) {
	    char board[][] = {
	        {'X','X','X','X'},
	        {'X','O','O','X'},
	        {'X','X','O','X'},
	        {'X','O','X','X'}
	    };
	    /*
		for(int i=1;i<board.length-1;i++){
            for(int j=1;j<board[i].length-1;j++){
                if(board[i][j]=='O'){
                    if(!checkIsItTouchedWithWallOrNot(board,i,j)){
                        System.out.println(i+" "+j);
                        dfs(board,i,j);
                    }
                    else{
                        dfs0(board,i,j);
                    }
                }
            }
        }
        */
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O')
                dfsDot(board,i,0);
            if(board[i][board[0].length-1]=='O')
                dfsDot(board,i,board[0].length-1);
        }
        for(int j=0;j<board[0].length;j++){
            if(board[0][j]=='O')
                dfsDot(board,0,j);
            if(board[board.length-1][j]=='O')
                dfsDot(board,board.length-1,j);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O') board[i][j] = 'X';
                else if(board[i][j] == '.') board[i][j] = 'O';
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void dfsDot(char[][] board,int i,int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '.';
        for(int itr = 0;itr < rows.length ;itr++){
            dfsDot(board,i+rows[itr],j+cols[itr]);
        }
    }
    public void dfs0(char[][] board,int i,int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != '.'){
            return;
        }
        board[i][j] = 'O';
        for(int itr = 0;itr < rows.length ;itr++){
            dfs0(board,i+rows[itr],j+cols[itr]);
        }
    }
    public void dfs(char[][] board,int i,int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != '.'){
            return;
        }
        board[i][j] = 'X';
        for(int itr = 0;itr < rows.length ;itr++){
            dfs(board,i+rows[itr],j+cols[itr]);
        }
    }
    public boolean checkIsItTouchedWithWallOrNot(char[][] board,int i,int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return true;
        }
        if((i==0 || j==0 || i==board.length-1 || j==board[0].length-1) && board[i][j] == 'O' ) return true;
        if(board[i][j] != 'O') return false;
        board[i][j] = '.';
        for(int itr = 0;itr<rows.length;itr++){
            if(checkIsItTouchedWithWallOrNot(board,i+rows[itr],j+cols[itr])){
                return true;
            }
        }
        return false;
	}
}
