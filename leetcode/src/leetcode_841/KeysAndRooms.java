package leetcode_841;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size()==0) return false;
        int visited_count = 1;
        int[] checked_room = new int[rooms.size()];
        Queue<List<Integer>> visited = new LinkedList<>();
        visited.add(rooms.get(0));
        checked_room[0] = 1;
        
        while(visited.isEmpty()==false){
            List<Integer> keys = visited.poll();
            for(int k : keys)  {
                if(checked_room[k]>0) continue;
                visited.add(rooms.get(k));
                checked_room[k] = 1;
                visited_count++;
            } 
        }

        return rooms.size() == visited_count;
    }
}
