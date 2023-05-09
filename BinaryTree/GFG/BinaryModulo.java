

public class BinaryModulo {
    public static int BinaryMod(String s, int m){
        int k = Integer.parseInt(s, 2);
        return k%m;
        
    }
    public static void main(String[] args) {
      String s="1000"  ; int m=4;
      System.out.print(BinaryMod(s, m));
    }
}
