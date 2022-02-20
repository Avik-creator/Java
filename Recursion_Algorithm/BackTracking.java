package Recursion_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

import javax.lang.model.element.Element;

public class BackTracking {
    public static void main(String[] args) {
        int[] a = {3,5,9};
        int[] b = {3,5,11};
        System.out.println(p(a, b));
    }
    static int count(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }
        int left = count(r-1, c);
        int right = count(r, c-1);
        return left + right;
    }
    static ArrayList<String> path(String p , int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r > 1){
            ans.addAll(path(p + 'D', r-1, c));
        }
        if(c > 1){
            ans.addAll(path(p + 'R', r, c-1));
        }
        return ans;
    }
    static ArrayList<String> pathdia(String p , int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r > 1 && c > 1){
            ans.addAll(pathdia(p + 'D', r-1, c-1));
        }
        if(r > 1){
            ans.addAll(pathdia(p + 'V', r-1, c));
        }
        if(c > 1){
            ans.addAll(pathdia(p + 'H', r, c-1));
        }
        return ans;
    }
    static boolean p(int[] target, int[] arr){
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
             if(target[i] != arr[i]){
                    return false;
            }
        }
        return true;
    }
    //Maze with Obstacle
    static void pathresriction(String p, boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r < maze.length - 1){
            pathresriction(p + 'D', maze, r+1, c);
        }
        if(c < maze[0].length - 1){
            pathresriction(p, maze, r, c + 1);
        }
    }


        static void allpath(String p, boolean[][] maze, int r, int c){
            if(r == maze.length - 1 && c == maze[0].length - 1){
                System.out.println(p);
                return;
            }
            if(!maze[r][c]){
                return;
            }
            if(r < maze.length - 1){
                allpath(p, maze, r + 1, c);
            }
            if(c < maze[0].length - 1){
                allpath(p, maze, r, c + 1);
            }
            if(r > 0){
                allpath(p + 'U', maze, r-1, c);
            }
            if(c > 0){
                allpath(p + 'L', maze, r, c-1);
            }
            //it will recursion error.
        }


        static void allpathcor(String p, boolean[][] maze, int r, int c){
            if(r == maze.length - 1 && c == maze[0].length - 1){
                System.out.println(p);
                return;
            }
            if(!maze[r][c]){
                return;
            }


            // I am considering this block in my path
            maze[r][c] = false;

            if(r < maze.length - 1){
                allpath(p, maze, r + 1, c);
            }
            if(c < maze[0].length - 1){
                allpath(p, maze, r, c + 1);
            }
            if(r > 0){
                allpath(p + 'U', maze, r-1, c);
            }
            if(c > 0){
                allpath(p + 'L', maze, r, c-1);
            }
            // This line is where the function will be over.
            //So before the function gets removed, also remove the changes that were made by that function.
            maze[r][c] = true;
        }

        static void allpathprint(String p, boolean[][] maze, int r, int c, int[][] path, int step){
            if(r == maze.length - 1 && c == maze[0].length - 1){
                for(int[] arr : path){
                    System.out.println(Arrays.toString(arr));
                }
                return;
            }
            if(!maze[r][c]){
                return;
            }


            // I am considering this block in my path
            maze[r][c] = false;
            path[r][c] = step;

            if(r < maze.length - 1){
                allpathprint(p, maze, r+1, c,path,step+1);
            }
            if(c < maze[0].length - 1){
                allpathprint(p, maze, r, c+1,path,step+1);
            }
            if(r > 0){
                allpathprint(p + 'U', maze, r-1, c,path,step+1);
            }
            if(c > 0){
                allpathprint(p + 'L', maze, r, c-1,path,step+1);
            }
            // This line is where the function will be over.
            //So before the function gets removed, also remove the changes that were made by that function.
            maze[r][c] = true;
            path[r][c] = 0;
        }
        // N-Queens Question.
        static int queens(boolean[][] board,int row){
            if(row == board.length){
                display(board);
                return 1;
            }
            // Placing the queen and checking every column and row
            int count = 0;
            for(int col = 0; col < board.length;col++){
                // place the queen if it is safe
                if(isSafe(board, row, col)){
                    board[row][col] = true;
                    count = count + queens(board, row+1);
                    board[row][col] = false;
                }
            }
            return count;
        }
        private static boolean isSafe(boolean[][] board, int row, int col) {
            // Vertical Columns
            for(int i = 0; i < row; i++){
                if(board[i][col]){
                    return false;
                }

            }

            // diagonal left
            int leftmax = Math.min(row, board.length - col - 1);
            for(int i = 1; i <= leftmax; i++){
                if(board[row-i][col-i]){
                    return false;
                }
            }
            //diagonal right
            int maxright = Math.min(row, col);
            for(int i = 1; i <= maxright; i++){
                if(board[row-i][col+i]){
                    return false;
                }
            }


            return true;

        }
        private static void display(boolean[][] board) {
            for(boolean[] row : board){
                for(boolean element : row){
                    if(element){
                        System.out.println("Q");
                    }else{
                        System.out.println("x");
                    }
                }
            }
            System.out.println();
        }

        // N-Knights Problem.
        static void knights(boolean [][] board, int row, int col, int knights){
            if(knights == 0){
                displayk(board);
                System.out.println();
                return;
            }

            if(col == board.length - 1 && col == board.length){
                return;
            }



            if(col == board.length){
                knights(board,row+1,0, knights);
            }
            if(issafe(board, row, col)){
                board[row][col] = true;
                knights(board, row, col+1, knights - 1);
                board[row][col] = false;
            }

            knights(board, row, col+1, knights);

        }


        private static boolean issafe(boolean[][] board, int row, int col) {
            if(isValid(board, row - 2, col - 1)){
                if(board[row - 2][col - 1]){
                    return false;
                }
            }
            if(isValid(board, row - 1, col - 2)){
                if(board[row - 1][col - 2]){
                    return false;
                }
            }
            if(isValid(board, row - 2, col + 1)){
                if(board[row - 2][col - 1]){
                    return false;
                }
            }
            if(isValid(board, row - 1, col + 2)){
                if(board[row - 1][col + 2]){
                    return false;
                }
            }
            return true;
        }

        static boolean isValid(boolean[][] board, int row, int col){
            if(row >= 0 && row < board.length && col >= 0 && col < board.length){
                return true;
            } 
            return false;
        }

        private static void displayk(boolean[][] board) {
            for(boolean[] row : board){
                for(boolean element : row){
                    if(element){
                        System.out.println("K");
                    }else{
                        System.out.println("x");
                    }
                }
            }
            System.out.println();
        }



        //              Sudoku Solver
        static boolean solve(int[][] board){
            int n = board.length;
            int row = -1;
            int col = -1;
            boolean emptyleft = true;
            for(int i = 0; i < n; i++){
                for (int j = 0; j < n; j++) {
                    if(board[i][j] == 0){
                        row = i;
                        col = j;
                        emptyleft = false;
                        break;
                    }
                }
                //if you found some empty element in row, then break
                if(emptyleft == false){
                    break;
                }

            }
            if(emptyleft == true){
                return true;
            }


            for (int number = 1; number <= 9; number++) {
                if(issafesudoku(board, row, col, number)){
                    board[row][col] = number;
                    if(solve(board)){
                        displaysudoku(board);
                        return true;
                    }else{
                        board[row][col] = 0;
                    }
                }
            }
            return false;

        }



        private static void displaysudoku(int[][] board) {
            for(int[] row : board){
                for(int num :row){
                    System.out.println(num + " ");
                }
                System.out.println();
            }
        }
        static boolean issafesudoku(int[][] board, int row, int col, int num){
            //check the row
            for (int i = 0; i < board.length; i++) {
                // check if the number is already in the row or not
                if(board[row][col] == num){
                    return false;
                }

            }
            // check the col
            for (int[] nums : board) {
                if(nums[col] == num){
                    return false;
                }
            }


            int sqrt = (int)(Math.sqrt(board.length));
            int rowstart = row - row % sqrt;
            int colstart = col - col % sqrt;

            for (int r = rowstart; r < rowstart + sqrt; r++) {
                for (int c = colstart; c < colstart + sqrt ; c++) {
                    if(board[r][c] == num){
                        return false;
                    }
                }
            }
            return true;
        }



}
