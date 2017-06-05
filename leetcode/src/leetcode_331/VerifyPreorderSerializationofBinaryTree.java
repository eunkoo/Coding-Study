package leetcode_331;

public class VerifyPreorderSerializationofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		boolean ret = s.isValidSerialization("1,2,3,#,#,#,2,#,#");
		System.out.println(ret);
	}

}
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] ch = preorder.split(",");
        int diff = 1;
        for(String s : ch){
            if(--diff < 0) return false;
            if(s.equals("#")==false) diff += 2;
            //--diff;
        }
        return diff == 0;
    }
}