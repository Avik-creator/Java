package Searching_Algorithm;
import java.util.ArrayList;
import java.util.List;

public class w{
    public static void main(String[] args) {
       int[] arr = {2,3,1,4,4,5};
       
    }
    /*static int count(int n){
        return helper(n,0);
    }
    static int helper(int n, int c){
        if(n == 0){
            return c;
        }
        int rem = n%10;
        if(rem == 0){
            return helper(n/10, c+1);
        }
        return helper(n/10, c);
    }*/
    /* Linear Search Using Recursion.
    static boolean find(int[] arr, int target, int index){
        if(index == arr.length){
            return false;
        }
        return arr[index] == target || find(arr, target, index+1);
    }
    static int findIndex(int[] arr, int target, int index){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        else{
            return findIndex(arr, target, index+1);
        }
    }
    static int findIndexLast(int[] arr, int target, int index){
        if(index == -1){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        else{
            return findIndex(arr, target, index-1);
        }
    }
    static ArrayList<Integer> list = new ArrayList<>();
    static void FindAllIndex(int[] arr, int target, int index ){
        //static void FindAllIndex(int[] arr, int target, int index,ArrayList<Integer> list)
        if (index == arr.length) {
            return;
        }
        if(arr[index] == target){
            list.add(index);
        }
        FindAllIndex(arr, target, index+1);
    }
    static ArrayList<Integer> Find2(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> ansFromlowcalls = Find2 (arr,target,index+1);
        list.addAll(ansFromlowcalls);
        return list;
    }*/
    static int search(int[] arr, int target, int s, int e){
        if(s>e){
            return -1;
        }
        int m = s + (e-s)/2;
        if(arr[m] == target){
            return m;
        }
        if(arr[s] <= arr[m]){
            if(target >= arr[s] && target <=arr[m]){
                return search(arr, target, s, m-1);
            }else{
                return search(arr, target, m+1, e);
            }
        }
        if(target >= arr[m] && target <= arr[e]){
            return search(arr, target, m+1, e);
        }
        return search(arr, target, s, m-1);
    }
}