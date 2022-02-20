package Sorting_Algorithm;

public class insertionswap {
    public static void main(String[] args) {
        
    }
    static void insertion(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j > 0 ; j--) {
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j-1);
                }else{
                    break;
                }
            }
        }
    }
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
