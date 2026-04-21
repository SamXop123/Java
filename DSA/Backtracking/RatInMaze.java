import java.util.ArrayList;

/*
  notes:

    this solves the "rat in a maze" problem using backtracking.

    problem idea:
    a rat starts from the top-left cell (0,0) of the maze
    and wants to reach the bottom-right cell (n-1,n-1).

    the maze contains:
    1 = open path (rat can move there)
    0 = blocked cell (rat cannot move there)

    allowed moves:
    D = down
    L = left
    R = right
    U = up

    goal:
    find all possible valid paths from start to destination
    and store them as strings like:
    "DRDDRR"

    approach:
    from each cell, try moving in all 4 directions.
    before moving, check if the next cell is safe:
    1) it must be inside the maze
    2) it must be open (value 1)
    3) it must not already be visited in the current path

    why visited array is needed:
    because rat can move in 4 directions, it may come back
    to the same cell again and again and cause infinite loops.
    visited[][] prevents that.

    backtracking idea:
    - mark current cell as visited
    - try all 4 directions
    - after exploring all directions, unmark it
      so that other possible paths can use this cell later

    base case:
    when rat reaches (n-1,n-1), it means one full valid path is found,
    so add the current path string to the result list.

    mental flow:
    try move -> go deeper -> if path works, save it
    -> come back -> unvisit -> try next direction
*/

public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        int n = maze.length;
        ArrayList<String> paths = findPath(maze, n);
        System.out.println(paths);
    }
  

    static ArrayList<String> findPath(int[][] maze, int n) {
        ArrayList<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        // if starting cell itself is blocked, no path is possible
        if (maze[0][0] == 1) {
            solve(0, 0, maze, n, result, "", visited);
        }

        return result;
    }
  

    static void solve(int i, int j, int[][] maze, int n,
                      ArrayList<String> result, String path, boolean[][] visited) {

        // base case:
        // if rat reaches destination cell, store the path
        if (i == n-1 && j == n-1) {
            result.add(path);
            return;
        }

        // mark current cell as visited
        visited[i][j] = true;

        // move Down
        if (isSafe(i+1, j, maze, n, visited)) {
            solve(i+1, j, maze, n, result, path + "D", visited);
        }

        // move Left
        if (isSafe(i, j-1, maze, n, visited)) {
            solve(i, j-1, maze, n, result, path + "L", visited);
        }

        // move Right
        if (isSafe(i, j+1, maze, n, visited)) {
            solve(i, j+1, maze, n, result, path + "R", visited);
        }

        // move Up
        if (isSafe(i-1, j, maze, n, visited)) {
            solve(i-1, j, maze, n, result, path + "U", visited);
        }

        // backtracking:
        // remove visited mark before returning,
        // so this cell can be used in another possible path
        visited[i][j] = false;
    }
  

    static boolean isSafe(int i, int j, int[][] maze, int n, boolean[][] visited) {
        return ( 
                i >= 0 && j >= 0 
                && i < n && j < n
                && maze[i][j] == 1
                && !visited[i][j] 
               );
    }
  
}
