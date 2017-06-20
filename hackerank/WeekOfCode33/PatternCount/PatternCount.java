package PatternCount;

import java.util.Scanner;

public class PatternCount {


    static int patternCount(String s){
        // Complete this function
        boolean start = false;
        int i=1,count=0;
        while(i<s.length()){
            if(start ){
                if(s.charAt(i) == '1'){
                    count++;
                    start = false;
                }else if( s.charAt(i) != '0'){
                    start = false;
                }
            }else if(s.charAt(i-1)=='1' && s.charAt(i)=='0'){
                start = true; 
            } 
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = Integer.parseInt(in.next());
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = patternCount(s);
            System.out.println(result);
        }
    }

}
