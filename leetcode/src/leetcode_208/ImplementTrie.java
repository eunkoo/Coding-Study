package leetcode_208;

public class ImplementTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Trie obj = new Trie();
		 String word = "adsfadfadfd";
		 obj.insert(word);
		 obj.insert(word+"ffd");
		 obj.insert(word+"aaaad");
		 boolean param_2 = obj.search(word);
		 System.out.println(param_2);
		 boolean param_3 = obj.startsWith("ads");
		 System.out.println(param_3);
	}

}
class Trie {
    
    class TreeStr{
        TreeStr[] children = new TreeStr[26];
        boolean isWord = false;
        char ch;
        public TreeStr(char c){
            ch = c;
        }
    }

    TreeStr root = null;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeStr(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeStr ts = root;
        for(char c : word.toCharArray()){
            if(ts.children[c-'a'] == null){
                ts.children[c-'a'] = new TreeStr(c);
            }
            ts = ts.children[c-'a'];
        }
        ts.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeStr ts = root;
        for(char c : word.toCharArray()){
            if(ts.children[c-'a'] == null)  return false;
            ts = ts.children[c-'a'];
        }
        return ts.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeStr ts = root;
        for(char c : prefix.toCharArray()){
            if(ts.children[c-'a'] == null)  return false;
            ts = ts.children[c-'a'];
        }
        return true;
    }
}