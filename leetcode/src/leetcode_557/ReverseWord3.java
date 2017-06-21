package leetcode_557;

public class ReverseWord3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String ret = s.reverseWords("hello world!");
		System.out.println(ret);
	}

}
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            for(int j=word.length()-1;j>=0;j--){
                sb.append(word.charAt(j)+"");
            }
            if(i!=words.length-1)sb.append(" ");
        }
        return sb.toString();
    }
}