package leetcode_515;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class FindLargestValueinEachRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<Integer>();
        HashMap<TreeNode,Integer> mapTreeOfDepth = new HashMap<>();
        Queue<TreeNode> quTree = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        quTree.add(root);
        mapTreeOfDepth.put(root,0);
        while(!quTree.isEmpty()){
            
            TreeNode tTree = quTree.poll();   
            int curDep = mapTreeOfDepth.get(tTree);
            if(ret.size() < curDep){
                ret.add(max);
                max = Integer.MIN_VALUE;
            }
            max = Math.max(max,tTree.val);
            
            if(tTree.left!=null) {
                quTree.add(tTree.left);
                mapTreeOfDepth.put(tTree.left,curDep+1 );
            }
            if(tTree.right!=null) {
                quTree.add(tTree.right);
                mapTreeOfDepth.put(tTree.right,curDep+1 );
            }
            
        }
        ret.add(max);
        return ret;
    }
}