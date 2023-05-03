import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class Q2215 {
    public static ArrayList<ArrayList<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>();
        for(int i:nums1){
            s1.add(i);
        }
        for(int i:nums2){
            s2.add(i);
        }
        Set<Integer> d1=new HashSet<>(s1);
        d1.removeAll(s2);
        Set<Integer> d2=new HashSet<>(s2);
        d2.removeAll(s1);
        ArrayList<Integer>l1=new ArrayList<>();
        ArrayList<Integer>l2=new ArrayList<>();
        l1.addAll(d1);
        l2.addAll(d2);
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        list.add(l1);
        list.add(l2);
        return list;


   }
    public static void main(String[] args) {
        int num1[]={1,2,3};
        int num2[]={2,4,6};
        ArrayList<ArrayList<Integer>>list=findDifference(num1, num2);
        System.out.print(list);
    }
    
}
