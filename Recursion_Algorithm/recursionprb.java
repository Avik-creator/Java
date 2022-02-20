package Recursion_Algorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class recursionprb {
    public static void main(String[] args) {
        
    }
    //Skip a Character.
    /*static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            skip(p, up.substring(1));
        }else{
            skip(p+ch, up.substring(1));
        }
    }*/
    //Input for below program is bcaappleccdah.
    /*static String skipappnotapple(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("app") && !up.startsWith("apple")){
            return skipappnotapple(up.substring(3));
        }
        else{
            return up.charAt(0) + skipappnotapple(up.substring(1));
        }
    }*/
    /*static void subseq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        subseq(p + ch, up.substring(1));
        subseq(p, up.substring(1));
    }*/
   /* static ArrayList<String> subseq(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        ArrayList<String> left=subseq(p + ch, up.substring(1));
        ArrayList<String> right=subseq(p, up.substring(1));
        left.addAll(right);
        return left;
    }*/
   /* static void subseqAscii(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        subseqAscii(p + ch, up.substring(1));
        subseqAscii(p, up.substring(1));
        subseqAscii(p + (ch + 0), up.substring(1));
    }*/
    //              IMPORTANT

    /*static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num : arr){
            int size = outer.size();
            for (int i = 0; i < size; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }



        return outer;
    }*/
    static List<List<Integer>> subsetduplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i = 0; i < arr.length; i++){
            start = 0;
            //if my current and previous element is same then s = e + 1
            if (i>0 && arr[i] == arr[i-1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int size = outer.size();
            for (int j = start; i < size; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }



        return outer;
    }
}
