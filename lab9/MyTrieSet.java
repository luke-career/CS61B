import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTrieSet implements TrieSet61B{

    class Node{
        private boolean isKey;
        private HashMap<Character,Node> map;
        public Node(boolean isKey){
            this.isKey = isKey;
            this.map = new HashMap<>();
        }
    }

    private Node root;

    public MyTrieSet(){
        root = new Node(false);
    }

    @Override
    public void clear() {
        root = null;
    }

    public Node find(String key){
        if(key == null || key.length() < 1) {
            throw new IllegalArgumentException();
        }
        Node current = root;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            if(current.map.containsKey(c)){
                current = current.map.get(c);
            }else{
                return null;
            }
        }
        return current;
    }

    @Override
    public boolean contains(String key) {


        return find(key).isKey;
    }

    @Override
    public void add(String key) {
        if(key == null || key.length() < 1) return;
        Node current = root;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            if(!current.map.containsKey(c)){
                current.map.put(c,new Node(false));
            }
            current = current.map.get(c);
        }
        current.isKey = true;
    }

    @Override
    public List<String> keysWithPrefix(String prefix) {
        ArrayList list = new ArrayList<String>();
        Node n = find(prefix);
        collect(prefix,list,n);
        return list;

    }


    private void collect(String s,List<String> list,Node n){
         if(n == null) return;

         if(n.isKey == true){
             list.add(s);
         }
         for(char c : n.map.keySet()){
             collect(s + c, list, n.map.get(c));
         }
    }


    @Override
    public String longestPrefixOf(String key) {
        throw new UnsupportedOperationException();
    }
}
