package projectakhir;
import java.util.Scanner;

public class MazeRunner {

    public int counter = 0;
    private final static int MAX_VALUE = 1000;
    int best_solution = MAX_VALUE;
    public char[][] maze;    
    public char[][] output_maze = null;    
    public int start_x, start_y;    
    Scanner input = new Scanner(System.in);
    
    public void inputMaze(){
        System.out.print("Input n : ");
        int n = input.nextInt();
        System.out.print("Input m : ");
        int m = input.nextInt();
        
        System.out.println();
        
        this.maze = new char[n][m];
        
        System.out.println("Input maze : ");
        for (int i = 0; i < this.maze.length; i++) {
            for (int j = 0; j < this.maze[i].length; j++) {
                this.maze[i][j] = input.next().charAt(0);
            }
        }
        System.out.println();
        
        System.out.println("Input start coordinat : ");
        int goal_y = input.nextInt();
        int goal_x = input.nextInt();
        this.maze[goal_x][goal_y] = 'S';
        
        System.out.println("Input goal coordinat : ");
        this.start_y = input.nextInt();
        this.start_x = input.nextInt();
        this.maze[this.start_x][this.start_y] = 'G';
        
        System.out.println();
    }
    
    // Membuat salinan maze
    private void cloneMaze() {
        this.output_maze = new char[maze.length][maze[0].length];
        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[x].length; y++) {
                this.output_maze[x][y] = this.maze[x][y];
            }
        }
    }

    // Mulai dari lokasi (x,y), kemudian mencari solusi
    public void solve() {
        this.best_solution = MAX_VALUE;
        if (step(this.start_x, this.start_y, 0) != MAX_VALUE) {
            this.output_maze[this.start_x][this.start_y] = 'G';
        }
    }

    // Metode Backtraking untuk maze
    public int step(int x, int y, int count) {

        counter++;
        
        //mencetak setiap langkah
	//System.out.println(this.toString());
        
        // Langkah invalid - menembus dinding luar
        if (x == -1 || x == this.maze.length || y == -1 || y == this.maze.length) {
            return MAX_VALUE;
        }

        
        //Langkah valid - menemukan tempat goal 
        if (this.maze[x][y] == 'S') {
            this.best_solution = count;
            this.cloneMaze();
            return count;
        }

        // Langkah invalid - menembus dinding dalam
        if (this.maze[x][y] == '#' || this.maze[x][y] == '+') {
            return MAX_VALUE;
        }
        
        // Langkah invalid - sudah menemukan solusi terbaik
        if (count == this.best_solution) {
            return MAX_VALUE;
        }

        // Metode Backtracking
        
        // Tandai lokasi karena merupakan lintasan menuju goal
        this.maze[x][y] = '+';
        int result = MAX_VALUE;
        int new_result = MAX_VALUE;

        // Coba ke Utara
        new_result = step(x - 1, y, count + 1);
        if (new_result < result) {
            result = new_result;
        }
        
        // Coba ke Timur
        new_result = step(x, y + 1, count + 1);
        if (new_result < result) {
            result = new_result;
        }
        
        // Coba ke Selatan
        new_result = step(x + 1, y, count + 1);
        if (new_result < result) {
            result = new_result;
        }
        
        // Coba ke Barat
        new_result = step(x, y - 1, count + 1);
        if (new_result < result) {
            result = new_result;
        }

        // Tandai lintasan yang sudah dilintasi tapi buka lintasan menuju goal
        maze[x][y] = 'x';

        if (result < MAX_VALUE) {
            return result;
        }

        //Deadend - Lokasi bukan bagian dari solusi untuk mencapai goal
        // Kembali
        return MAX_VALUE;
    }

    @Override
    public String toString() {
        String output = "";
        for (int x = 0; x < this.maze.length; x++) {
            for (int y = 0; y < this.maze[x].length; y++) {
                output += this.maze[x][y] + " ";
            }
            output += "\n";
        }
        return output;
    }

    public String toStringSolution() {
        if (this.output_maze == null) {
            return "No Solution!";
        }
        
        String output = "";
        for (int x = 0; x < output_maze.length; x++) {
            for (int y = 0; y < output_maze[x].length; y++) {
                output += this.output_maze[x][y] + " ";
            }
            output += "\n";
        }
        return output;
    }

    public static void main(String[] args) {
        MazeRunner maze = new MazeRunner();
        
        maze.inputMaze();
        
        System.out.println("Maze with start and goal position :");
        System.out.println(maze);
        
        maze.solve();
        
        System.out.println("Result path :");
        System.out.println(maze.toStringSolution());
    }
}