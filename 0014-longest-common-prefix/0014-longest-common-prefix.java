class Solution {
    class Trie{
        Trie [] children;
        boolean end;
        int numKids;
        
        Trie(){
            children = new Trie[26];
            end=false;
            numKids=0;
        }
        
        void addWord(String word){
            Trie r = this;
            for(char c : word.toCharArray())
            {
                if(r.children[c-'a']==null)
                {
                    r.children[c-'a']=new Trie();
                    r.numKids++;
                }
                r=r.children[c-'a'];
            }
            r.end=true;
        }
        String commonPrefix(StringBuilder res){
            // only traverse if the num of child nodes is exactly 1 
            if(this.numKids==1)
            {
            for(char c='a';c<='z';c++)
                if(this.children[c-'a']!=null)
                {
				    // this is crucial, if we reach the end of a word, then this word must be the longest common prefix
                    if(this.children[c-'a'].end==true)
                        return res.append(c+"").toString();
					// move on to the next level
                    else
                        return this.children[c-'a'].commonPrefix(res.append(c+""));
                }
            }
            return res.toString();
        }
    }
    
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
         return "";  
        if (strs.length == 1)
         return strs[0];
        Trie root = new Trie();
        for(String s : strs)
        {
            if(s.isBlank())
                return s;
            root.addWord(s);
        }
        return root.commonPrefix(new StringBuilder());
    }
}