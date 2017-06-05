package leetcode_171;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.titleToNumber("AAB");
		System.out.println(ret);
		
	}

}
class Solution {
    
    public int titleToNumber(String s) {
        int colNum = 0;
        for(int i=0;i<s.length();i++){
            colNum += Math.pow(26,s.length()-i-1)*(s.charAt(i)-'A'+1); 
        }
        return colNum;
    }
}