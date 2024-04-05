/*
1347. Minimum Number of Steps to Make Two Strings Anagram

You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

Example 1:
Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.

Example 2:
Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
Example 3:

Input: s = "anagram", t = "mangaar"
Output: 0
Explanation: "anagram" and "mangaar" are anagrams. 
 

Constraints:

1 <= s.length <= 5 * 104
s.length == t.length
s and t consist of lowercase English letters only. 
 */

import java.util.Scanner;

public class minStepTwoMakeStringAnagram {
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
            if(freq2[i]>freq1[i]){
                ans+=freq2[i]-freq1[i];            }
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
