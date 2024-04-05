import java.util.Scanner;

public class firstOccurenceOfString {
    public static int firstOccurenceIndex(String haystack, String needle){
        if (needle.length() == 0) {
            return 0; 
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break; 
                }
            }
            if (j == needle.length()) {
                return i; 
            }
        }
        return -1; 
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String hayastack=scanner.nextLine();
        String needle=scanner.nextLine();
        int ans=firstOccurenceIndex(hayastack, needle);
        scanner.close();
        System.out.print(ans);
    }
}
