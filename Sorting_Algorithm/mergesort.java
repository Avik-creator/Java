package Sorting_Algorithm;

import java.util.Arrays;

public class mergesort {
    public static void main(String[] args) {
        
    }
    static int[] Mergesort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Mergesort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = Mergesort(Arrays.copyOfRange(arr, mid+1, arr.length));

        return merge(left, right);

    }
    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;

        }
        //it may be possible that one of the arrays is not complete
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mix[k] = second[i];
            j++;
            k++;
        }
        return mix;
    }











    static void MergesortInPlace(int[] arr, int s, int e){
        if( e-s == 1){
            return;
        }
        int mid = (s+e) / 2;
        MergesortInPlace(arr, s, mid);
        MergesortInPlace(arr, mid,e);

        mergeinplace(arr,s,mid,e);

    }
    private static void mergeinplace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e-s];

        int i = s;
        int j = m;
        int k = 0;

        while(i < m && j < e){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;

        }
        //it may be possible that one of the arrays is not complete
        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j < e) {
            mix[k] = arr[i];
            j++;
            k++;
        }
        for (int k2 = 0; k2 < mix.length; k2++) {
            arr[s+k2] = mix[i];
        }
    }
}
