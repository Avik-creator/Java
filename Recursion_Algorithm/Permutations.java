package Recursion_Algorithm;
import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 */
public class Permutations {
    public static void main(String[] args) {
        //System.out.println(permutations("", "abc"));
        //System.out.println(permutationscount("", "abc"));
        //System.out.println(pad("", "12"));
        dice("", 4);
    }
    static ArrayList<String> permutations(String p, String up ){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            ans.addAll(permutations(f + ch + s, up.substring(1)));
        }
        return ans;
    }
    static int permutationscount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            count = count + permutationscount(f + ch + s, up.substring(1));

        }
        return count;
    }
    static ArrayList<String> pad(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<>();
        for (int i = (digit-1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(pad(p + ch, up.substring(1)));
        }
        return ans; 
    }
    static void dice(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <=target ; i++) {
            dice(p + i, target-i);
        }
    }
}