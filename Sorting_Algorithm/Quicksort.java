package Sorting_Algorithm;

public class Quicksort {
    public static void main(String[] args) {
        
    }
    static void sort(int[] arr, int low, int hi){
        if(low >= hi){
            return;
        }
        int s = low;
        int e = hi;
        int m = s + (e-s)/2;
        int pivot = arr[m];

        while(s <= e){
            //also a reason if why it is also sorted it will not swap
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }

        }
        sort(arr, low, e);
        sort(arr, s, hi);
    }
}
