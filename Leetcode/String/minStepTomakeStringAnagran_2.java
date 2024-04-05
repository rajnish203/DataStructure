
/*
 2186. Minimum Number of Steps to Make Two Strings Anagram II

You are given two strings s and t. In one step, you can append any character to either s or t.

Return the minimum number of steps to make s and t anagrams of each other.

An anagram of a string is a string that contains the same characters with a different (or the same) ordering.

Example 1:

Input: s = "leetcode", t = "coats"
Output: 7
Explanation: 
- In 2 steps, we can append the letters in "as" onto s = "leetcode", forming s = "leetcodeas".
- In 5 steps, we can append the letters in "leede" onto t = "coats", forming t = "coatsleede".
"leetcodeas" and "coatsleede" are now anagrams of each other.
We used a total of 2 + 5 = 7 steps.
It can be shown that there is no way to make them anagrams of each other with less than 7 steps.
Example 2:

Input: s = "night", t = "thing"
Output: 0
Explanation: The given strings are already anagrams of each other. Thus, we do not need any further steps.
 

Constraints:

1 <= s.length, t.length <= 2 * 105
s and t consist of lowercase English letters.

 */
import java.util.Scanner;

public class minStepTomakeStringAnagran_2 {
    public static int minStepTomakeStringAnagram(String s, String t){
        int freq1[]=new int[26];
        int freq2[]=new int[26];

        for(char ch: s.toCharArray()){
            freq1[ch-'a']++;
        }
        for(char ch: t.toCharArray()){
            freq2[ch-'a']++;
        }

        int ans=0;
        for(int i=0;i<26;i++){
            if(freq1[i]<freq2[i]) ans+=freq2[i]-freq1[i];
            else ans+=freq1[i]-freq2[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String t=scanner.nextLine();
        int ans=minStepTomakeStringAnagram(s, t);
        System.out.print(ans);
        scanner.close();
    }
}
