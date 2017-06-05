package leetcode_501;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FindModeinBST {

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
	public int[] findMode(TreeNode root) {
		if(root == null) return new int[0];
		HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		int max =0, mCount=0;
		qu.offer(root);
		while(qu.peek() != null){
			TreeNode t =  qu.poll();

			Integer v = hash.containsKey(t.val) ? hash.get(t.val) : 0;
			hash.put(t.val, v+1);
			max = max < v+1 ? v+1 : max;
			if(t.left != null)
				qu.offer(t.left);
			if(t.right != null)
				qu.offer(t.right);
		}

		int count =0;
		Integer[] values = hash.values().toArray(new Integer[0]);

		for(Integer i : values)
			if(i == max) mCount++;
		int[] result = new int[mCount];
		Iterator<Integer> keys = hash.keySet().iterator();
		while(keys.hasNext()){
			Integer k = keys.next();
			if(max == hash.get(k)) result[count++] = k;
		}

		// for(int i =0;i<lstVal.size();i++){
		//     Set<Integer,Integer> s = lstVal
		//     if(max == lstVal[i]) result[count++] = i ;
		// }
		return result;
	}
}