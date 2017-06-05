package leetcode_242;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		boolean ret = s.isAnagram("anagram", "margana");
		System.out.println(ret);
	}

}
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null ||s.length() != t.length())return false;
        int[] hash = new int[26];
        for(char c : s.toCharArray())
            hash[c-'a']++;
         
         for(char c : t.toCharArray()){
             if(hash[c-'a']-- == 0) return false;
         }
        return true;
    }
}