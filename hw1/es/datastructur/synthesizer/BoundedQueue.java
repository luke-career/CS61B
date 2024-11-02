package es.datastructur.synthesizer;

public interface BoundedQueue<T> extends Iterable<T> {

    default boolean isEmpty(){
        return fillCount() == 0;
    }
    default boolean isFull(){
        return  capacity() == fillCount();
    }
    int capacity();
    int fillCount();
    void enqueue(T x);
    T dequeue();
    T peek();

}
