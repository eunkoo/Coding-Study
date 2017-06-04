package leetcode_287;

import java.util.Arrays;

public class FindDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.findDuplicate(new int[]{4,32,2,43,4,2,6});
		System.out.print(ret);

	}

}
class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
         for(int i=1;i<nums.length;i++){
             for(int j =0;j<i;j++){
                 if(nums[i] == nums[j]){
                     return nums[i];
                 }
             }
         }
         return 0;
    }
    // class TreeNode{
    //     int val;
    //     TreeNode left;
    //     TreeNode right;
    //     public TreeNode(int v){
    //         val = v;
    //     }
    // }
    // public int findDuplicate(int[] nums) {
    //     if(nums == null || nums.length == 0) return 0;
    //     TreeNode root = new TreeNode(nums[0]);
    //     for(int i=1;i<nums.length;i++){
    //         if(insertTree(root,nums[i]) == false)   
    //             return nums[i];
    //     }
    //     return 0;
    // }
    // boolean insertTree(TreeNode root, int val){
    //     boolean r = true;
    //     if(root.val < val){
    //         if(root.right == null)  root.right = new TreeNode(val);
    //         else    r = insertTree(root.right, val);
    //     }else if(root.val > val){
    //         if(root.left == null)  root.left = new TreeNode(val);
    //         else    r = insertTree(root.left, val);
    //     }else{
    //         return false;
    //     }
    //     return r;
    // }
}