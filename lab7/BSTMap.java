import javax.lang.model.util.Elements;
import java.security.Key;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

public class BSTMap<K extends Comparable<K> ,V > implements Map61B<K,V>{


    private class Node{

        private K key;
        private V val;
        private int size;
        private Node left;
        private Node right;

        public Node(K key, V val){
            this.key = key;
            this.val = val;
            size = 1;
        }
    }

    private Node root;

    @Override
    public void clear() {
        root = null;
    }



    @Override
    public boolean containsKey(K key) {
        return get(key) != null ;
    }

    @Override
    public V get(K key) {
        return get(root,key);
    }


    private V get(Node x, K key){
        if(x == null) return null;
        int comp = key.compareTo(x.key);
        if(comp < 0){
           return get(x.left,key);
        }else if(comp > 0){
           return get(x.right,key);
        }else{
            return x.val;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if(x == null) return 0;
        else{
            return x.size;
        }
    }

    @Override
    public void put( K key, V value) {
       put(root,key,value);
    }


    public Node put (Node n, K key, V value){
        if(n == null) {
            return new Node(key,value);
        }
        int comp = key.compareTo(n.key);
        if(comp < 0){
            n.left = put(n.left,key,value);
        }else{
            n.right = put(n.right,key,value);
        }
        n.size = size(n.left) + size(n.right) + 1;
        return n;
    }

    public void printInorder(){
            printInorder(root);
    }

    public void printInorder(Node x){
        if(x.left == null && x.right == null){
            printValue(x);
        }else if(x.left == null && x.right != null){
            printValue(x);
            printInorder(x.right);
        }else if(x.left != null && x.right == null){
            printInorder(x.left);
            printValue(x);
        }else{
            printInorder(x.left);
            printValue(x);
            printInorder(x.right);
        }
    }


    public void printValue(Node x){
        System.out.println(x.val);
    }



    @Override
    public Set keySet() {
        throw  new UnsupportedOperationException("Unsupport");
    }

    @Override
    public V remove(K key) {
        throw  new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

}
