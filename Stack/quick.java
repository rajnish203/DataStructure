import java.util.*;

class Node{
    int data;
    Node left, right;
    Node(int data ){
        this.data=data;
    }
}
public class quick {
    public static void main(String[] args) {
       int n=5;
       
        for (char ch = 'A'; ch < 'A' + n; ch++) {
            for (char c = 'A'; c <= ch; c++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        
        for (char ch = (char) ('A' + n - 2); ch >= 'A'; ch--) {
            for (char c = 'A'; c <= ch; c++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
