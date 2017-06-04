package leetcode_134;

public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.canCompleteCircuit(new int[]{4},new int[]{5});
		System.out.println(ret);
	}

}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
	int res = -1;
		if(gas == null || gas.length == 0 ||cost == null || cost.length==0) return res;
		int len = gas.length, remainGas=0,curGas=0;
		int[] p = new int[len];
		if(len==1 && (gas[0]>=cost[0])) res = 0;
		for(int i=0;i<len;i++){
			remainGas += gas[i] - cost[i];
			curGas += gas[i] - cost[i];
			if(curGas>=0 ){
				if(res == -1)	res = i;
			}else{
				curGas=0;
				res = -1;
			}
		}
		if(remainGas<0) res = -1;
		return res;
    }
}