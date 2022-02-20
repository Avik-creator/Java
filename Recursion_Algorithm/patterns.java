package Recursion_Algorithm;

public class patterns {
    public static void main(String[] args) {
        pattern31(4);
    }

    // How to Approach
    // 1. No of lines = No of rows = No of times outer loop will run
    // 2. Identify every row Number, How may cols are there
    // 3. Type of element we need to print.

    static void pattern1(int n){
        for (int row = 1; row <=n ; row++) {
            // for every row, run the col
            for (int col = 1; col <= row ; col++) {
                System.out.print("* ");
            }
            // we need to print new line.
            System.out.println();
        }
    }

    static void pattern2(int n){
        for (int row = 1; row <= n ; row++) {
            for (int col = 1; col <= n-row+1 ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for (int row = 1; row <= n ; row++) {
            for (int col = 1; col <= row ; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
    static void pattern4(int n){
        for (int row = 1; row <= (2*n)-1 ; row++){
            int TotalNumberofColsinRows = row > n ? 2*n - row : row;
            for (int col = 0; col < TotalNumberofColsinRows; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern28(int n){
        for (int row = 0; row < 2*n; row++) {
            int TotalNumberofColsinRows = row > n ? 2*n - row : row;
            int spaces = n - TotalNumberofColsinRows;
            for (int s = 0; s < spaces; s++) {
                System.out.print(" ");
            }
            for (int col = 0; col < TotalNumberofColsinRows; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern30(int n){
        for (int row = 1; row < n ; row++) {

            for (int space = 0; space < n-row ; space++) {
                System.out.print(" ");
            }

            for (int col = row; col >= 1  ; col--) {
                System.out.print(col+" ");
            }
            for (int col = 2; col <= row ; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    static void pattern17(int n){
        for (int row = 1; row <= 2*n ; row++) {

            int c = row > n ? 2*n - row : row;
            for (int space = 0; space < n-c ; space++) {
                System.out.print(" ");
            }

            for (int col = c; col >= 1  ; col--) {
                System.out.print(col+" ");
            }
            for (int col = 2; col <= c ; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    static void pattern31(int n){
        int originalN = n;
        n = 2*n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n;col++){
                int atEveryIndex = originalN-Math.min(Math.min(row, col),Math.min(n-row, n-col));
                System.out.print(atEveryIndex);
            }
            System.out.println();
        }
    }



}
