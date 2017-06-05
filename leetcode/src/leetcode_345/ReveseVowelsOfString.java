package leetcode_345;

public class ReveseVowelsOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String ret = s.reverseVowels("hello");
		System.out.println(ret);
	}

}
 class Solution {
    
    public String reverseVowels(String s) {
        String vowls = "aeouiAEOUI";
        char[] ch = s.toCharArray();
        
        int l=0,r=s.length()-1;
        
        while(l < r){
            while(l<r && !vowls.contains(s.charAt(l)+""))
                l++;
                
            while(l<r && !vowls.contains(s.charAt(r)+""))
                r--;
                
            //System.out.println("l:"+l+", r="+r);
            
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;
            l++;
            r--;
        }
        return String.valueOf(ch);
        
        
        
    }

}