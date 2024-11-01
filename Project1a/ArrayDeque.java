public class ArrayDeque<T>{
    private T[] items;
    private int size;
    private int nextLast ;
    private int nextFirst;
    private static final int REACTOR = 2;

    public ArrayDeque(){
        size = 0;
        items =(T[]) new Object[8];
        nextLast = 5;
        nextFirst = 4;
    }

    public ArrayDeque(ArrayDeque other){}

    private void resize(int capacity){
        T[] newItems = (T[]) new Object[capacity];
        int current = plusOne(nextFirst);
        for(int i =0 ; i < size; i++){
            newItems[i] = items[current];
            current = plusOne(current);
        }
        items = newItems;
        nextLast = size;
        nextFirst = capacity -1;
    }

    private int minOne(int i){
        return ((i - 1) + items.length) % items.length;
    }

    private int plusOne(int i){
        return (i + 1 ) % items.length;
    }

    public void addFirst(T item){
        if(size ==  items.length){
            resize(size * 2 );
        }
        items[nextFirst] = item;
        nextFirst = minOne(nextFirst);
        size += 1;
    }

    public void addLast(T item){
        if(size ==  items.length){
            resize(size * 2 );
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;

  }
    public int size(){
        return size;
    }
    public void printDeque() {
        int start = plusOne(nextFirst);;
        while (start != nextLast) {
            System.out.print(items[start] + " ");
            start = plusOne(start);
        }
    }

    public T removeLast(){
        int last =  minOne(nextLast);
        T removeLastItem = items[last];
        items[last] = null;
        size -= 1;
        nextLast = last;
        if(items.length > 16 && size < items.length * 0.25){
            resize(size / 2);
        }
        return removeLastItem;
    }

    public T removeFirst(){
        int first = plusOne(nextFirst);
        T removeFirstItem = items[first];
        items[first] = null;
        size -= 1;
        nextFirst = first;
        if(items.length > 16 && size < items.length * 0.25){
            resize(size / 2);
        }
        return removeFirstItem;
    }
    public T get(int index){
        int start = plusOne(nextFirst);
        while(index > 0){
            start = plusOne(start);
            index--;
        }
        return items[start];
    }

}
