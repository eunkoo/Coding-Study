package leetcode_459;

public class RepeatSubstringPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		boolean ret = s.repeatedSubstringPattern("abaaba");
		System.out.println(ret);
	}

}
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len<=1) return false;
        if(len==2 && s.charAt(0)==s.charAt(1)) return true;
        int f=1,e=len-1;
        String tar =s;
        while(f<=e){
            if(len%f==0){ 
                String left = s.substring(0,f);
                String right = s.substring(e,len);
                if(left.equals(right)){
                    tar = s.replace(left,"");
                    if(tar.length()==0) return true;
                }
            }
           f++;
           e--;
        }
        return false;
    }
}