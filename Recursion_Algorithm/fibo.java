package Recursion_Algorithm;

public class fibo {
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(fiboformula(i));   
        }
    }
    static double fiboformula(int n){
        return (double) Math.pow((1 + Math.sqrt(5))/2, n) /Math.sqrt(5);
    }
}
