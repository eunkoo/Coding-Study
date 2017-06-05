package PushingButton;

import java.util.ArrayList;
import java.util.List;

public class PushingButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[] ret = s.pressingButtons("42");
		for(String str : ret)
			System.out.println(str);
	}

}
class Solution{
	String[] pressingButtons(String buttons) {
	    if(buttons == null || buttons.length() == 0) return new String[0];
	    String[] dials = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	    List<String> lst = new ArrayList<>(); 
	    List<String> tmp = new ArrayList<>(); 
	    for(int i=buttons.length()-1;i>=0;i--){
	        int idx = buttons.charAt(i)-48;
	        if(idx <2 || 9< idx) return new String[0];
	        String poss = dials[idx];
	        for(int j=0;j<poss.length();j++){
	           if(i==buttons.length()-1){
	                lst.add(""+poss.charAt(j));
	            }else{
	                for(String str : tmp){
	                    lst.add(poss.charAt(j)+str);
	                }
	            }
	        }
	        tmp.clear();
	        tmp.addAll(lst);
	        lst.clear();
	    }
	    return tmp.toArray(new String[0]);
	}
}