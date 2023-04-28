public class revstring {
    public static String revSersseSTring(String str){
        String s="";
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            s=c+s;
        }
        return s;

    }
    public static void main(String[] args) {
        String s="rajnish";
        System.out.print(revSersseSTring(s));
    }
}
