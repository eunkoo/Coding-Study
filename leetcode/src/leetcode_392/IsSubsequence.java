package leetcode_392;

public class IsSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		boolean ret = s.isSubsequence("abc", "ahbgdc");
		System.out.println(ret);
	}

}
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null )    return false;
        if(s.length()==0 ) return true;
        int i=0,j=0;
        while(i<s.length() && j<t.length()){
            char cs = s.charAt(i);
            char ct = t.charAt(j);
            if(cs == ct){
                i++;
            }
            j++;
            if(i == s.length()) return true;
        }
        return false;
    }
}