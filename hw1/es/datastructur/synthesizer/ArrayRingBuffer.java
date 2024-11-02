package es.datastructur.synthesizer;
import java.util.Iterator;


public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;


    public ArrayRingBuffer(int capacity) {

        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }


    @Override
    public void enqueue(T x) {

        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        rb[last] = x;
        fillCount += 1;
        last = (last + 1) % capacity();
    }

    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

   public boolean equals(Object o ){

        if( o instanceof ArrayRingBuffer<?>) {
            return false;
        }
        ArrayRingBuffer<T> other = (ArrayRingBuffer<T>) o;
        if(this == other ) {
            return true;
        }
        if(other == null) {
            return false;
        }

        Iterator thisIter = this.iterator();
        Iterator otherIter = other.iterator();
        while(thisIter.hasNext() && otherIter.hasNext()){
            if(thisIter.next() != otherIter.next()){
                return false;
            }
        }
       return true;
   }


    @Override
    public T dequeue() {

        T item = rb[first];
        rb[first] = null;
        first = (first + 1) % capacity();
        fillCount -= 1;
        return item;
    }


    @Override
    public T peek() {

        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T item = rb[first];
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {


        int current = first;
        int count = 0;

        @Override
        public boolean hasNext() {
            if(count < fillCount) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object next() {
            count++;
            T item = rb[current];
            current = (current + 1) % capacity();
            return item;
        }


    }
}