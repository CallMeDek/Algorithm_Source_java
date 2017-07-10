public class Maze{
	private static int N=8;
	private static int [][] maze = {
		{0, 0, 0, 0, 0, 0, 0, 1},
		{0, 1, 1, 0, 1, 1, 0, 1},
		{0, 0, 0, 1, 0, 0, 0, 1},
		{0, 1, 0, 0, 1, 1, 0, 0},
		{0, 1, 1, 1, 0, 0, 1, 1},
		{0, 1, 0, 0, 0, 1, 0, 1},
		{0, 0, 0, 1, 0, 0, 0, 1},
		{0, 1, 1, 1, 0, 1, 0, 0}
	};
	
	private static final int PATHWAY_COLOR = 0;
	private static final int WALL_COLOR = 1;
	private static final int BLOCKED_COLOR = 2;
	private static final int PATH_COLOR = 3;
	
	public static boolean findMazePath(int x, int y){
		if(x < 0 || y <0 || x >= N || y >= N) return false;
		else if (maze[x][y] != PATHWAY_COLOR) return false;
		else if (x == N-1 && y == N-1 ){
			maze[x][y] = PATH_COLOR;
			return true;
		}
		else{
			maze[x][y] = PATH_COLOR;
			if(findMazePath(x-1, y) || findMazePath(x, y+1) || 
				findMazePath(x+1, y) || findMazePath(x, y-1)){
				return true;
			}
			maze[x][y] = BLOCKED_COLOR;
			return false;
		}
	}
	
	public static void printMaze(){
		for(int i=0; i < N; i++)
		{
			for(int j=0; j < N; j++)
				System.out.print(maze[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String [] args){
		printMaze();
		findMazePath(0, 0);
		printMaze();
	}
}