import java.util.Iterator;
import java.util.Set;


public class MyHashMap<K,V> implements Map61B<K,V>{

    private class Entry<K,V>{
        private K key;
        private V value;
        private Entry<K,V> next;

        private boolean deleted;

        public Entry(K key, V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
            deleted = false;
        }

        public Entry(K key, V value, Entry<K,V> next, boolean deleted){
            this.key = key;
            this.value = value;
            this.next = next;
            this.deleted = deleted;
        }
    }


    double loadFactor = 0.75;
    private int size;
    private int capacity = 16;
    private int threshold =(int)(capacity * loadFactor);
    private Entry<K,V>[] table;




    public MyHashMap(){
        table = (Entry<K, V>[]) new Object[capacity];
    }


    public MyHashMap(int initialSize){
        capacity = initialSize;
        table = (Entry<K, V>[]) new Object[capacity];
    }

    public MyHashMap(int initialSize,double LoadFactor){
        capacity = initialSize;
        threshold = (int)(initialSize * LoadFactor);
        table = (Entry<K, V>[]) new Object[capacity];

    }

    @Override
    public void clear() {
        size = 0;
        threshold = capacity * threshold;
        table = (Entry<K, V>[]) new Object[capacity];
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        int num = hash(key.hashCode()) % capacity;
        if(table[num] == null ) return null;
        for(Entry<K,V> e = table[num]; e !=null ; e = e.next ){
            if(e.key == key && !e.deleted)  return e.value;
         }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        if(key == null) throw new IllegalArgumentException("First argument to put() is null");

        int hs = hash(key.hashCode());
        int index =hs % capacity;
        for(Entry<K,V> e = table[index]; e !=null; e = e.next){
                if(e.key == key){
                    e.value = value;
                }
                return;
        }
        table[index] = new Entry<>(key,value,table[index]);
        size++;
        if(size > threshold){
            resize();
        }
    }

    private void resize(){
        int oldCapacity = capacity;
        capacity =  2 * oldCapacity + 1;
        Entry<K,V>[] oldTable = table;
        for(int i = 0; i < capacity; i++){
            for(Entry<K,V> e = oldTable[i] ; e!= null; e = e.next){
                    if(e.deleted != true){
                         continue;
                    }
                    int index = hash(e.key.hashCode()) % capacity;
                    table[index] = new Entry<>(e.key,e.value,table[index]);
                    size++;
            }
        }
    }

    @Override
    public Set<K> keySet() {
        return Set.of();
    }

    @Override
    public V remove(K key) {
        int num = hash(key.hashCode()) % capacity;
        Entry<K,V> f = table[num];
        if(f == null){
            return null;
        }
        for(Entry<K,V> e = table[num]; e != null; e = e.next){
            if(e.key == key && !e.deleted){
                e.deleted = true;
            }
            size--;
            return e.value;
        }
        return null;

    }

    @Override
    public V remove(K key, V value) {
        int num = hash(key.hashCode()) % capacity;

        Entry<K,V> f = table[num];

        if(f == null) return null;

        for(Entry<K,V> e = table[num] ; e != null; e = e.next){
            if(e.key == key && e.value == value && e.deleted == true){
                    e.deleted = true;
                    size--;
                    return e.value;
            }
        }

        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }


    private int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}
