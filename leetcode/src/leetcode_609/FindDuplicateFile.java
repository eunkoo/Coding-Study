package leetcode_609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FindDuplicateFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		List<List<String>> ret = s.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"});
		for(List<String> paths : ret){
			for(String path : paths)
				System.out.print(path+" ");
			System.out.println();
		}
	}

}
class Solution {
	   public List<List<String>> findDuplicate(String[] paths) {
	        HashMap<String,List<String>> mapContentOfPaths = new HashMap<>();
	        for(String line : paths){
	            String[] fis = line.split(" ");
	            for(int i=1;i<fis.length;i++){
	                String content = fis[i].substring(fis[i].indexOf("(")+1,fis[i].indexOf(")"));
	                if(mapContentOfPaths.containsKey(content)==false){
	                	mapContentOfPaths.put(content,new ArrayList<String>() );
	                }
	                mapContentOfPaths.get(content).add(fis[0]+"/"+fis[i].substring(0,fis[i].indexOf("(")));
	            }
	        }
	        List<List<String>> ret = new ArrayList<List<String>>();
	        Iterator<List<String>> iter = mapContentOfPaths.values().iterator();
	        while(iter.hasNext()){
	            List<String> p = iter.next();
	            if(p.size()>1) ret.add(p);
	        }
	        return ret;
	        
	    }
	}