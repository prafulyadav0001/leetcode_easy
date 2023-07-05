class Trie {

    public class Node{ 
        // is node mein  character ke corres. mein child hai
        char ch;
        HashMap<Character, Node> child = new HashMap<>();
        boolean isLast = false;
    }

    private Node root;

    public Trie() {
        Node nn = new Node();
        nn.ch = '*';
        this.root = nn; 
    }
    
    public void insert(String word) {
        Node curr=root;
        
        for(int i=0 ; i < word.length() ; i++){
            char ch = word.charAt(i);

            if(curr.child.containsKey(ch)){
                curr=curr.child.get(ch);
            }
            else{
                Node nn = new Node();
                nn.ch=ch;
                curr.child.put(ch,nn);
                curr=nn;
            }   
        }
        
        curr.isLast=true;
    }
    
    public boolean search(String word) {
        Node curr = root;

        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(!curr.child.containsKey(ch))
                return false;
            curr = curr.child.get(ch);
        }

        return curr.isLast;
        
    }
    
    public boolean startsWith(String prefix) {
        Node curr=root;

        for(int i = 0 ; i < prefix.length() ; i++){
            char ch = prefix.charAt(i);
            if(!curr.child.containsKey(ch))
                return false;
            curr = curr.child.get(ch);
        }

        return true;
        
    }
}
