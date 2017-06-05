package stringReformatting;

public class stringReformatting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String ret =s.stringReformatting("2-4a0r7-4k", 4);
		System.out.println(ret);
	}

}
class Solution{
	String stringReformatting(String s, int k) {
	    if(s.length() == 0) return "";
	    String outOfDash = s.replace("-","");
	    String res = "";
	    int len = outOfDash.length();
	    int dashcount = 0;
	    for(int i =len-1;i>=0;i--){
	        int e = res.length() - dashcount;
	        if((len-i)%k == 0 || i == 0)
	            if(e == 0)
	                res = outOfDash.substring(i,len-e);
	            else{
	               res = outOfDash.substring(i,len-e)+"-"+res; 
	                dashcount++;
	            }
	        
	    }
	    System.out.println(res);
	   
	    return res;
	}

}