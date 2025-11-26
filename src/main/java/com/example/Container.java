package com.example;

public class Container<T> {
    private Object[] data; //внутренний массив
    private int size;      //текущее количество элементов
    



    /** hELP */
    private Container() {
        this(DEFAULT_CAPACITY);
    }

    private Container(int initialCapacity) {
        if (initialCapacity<=0) {
            throw new IllegalArgumentException("initialCapacity must be > 0");
        }
        this.data = new Object[initialCapacity];
        this.size = 0;
    }

    public void add(T item) {
        
    }

    public T get(int index) {

    }

    public void remove(int index) {

    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i<size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: "+ size);
        }
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int newCapacity = data.length +}
    }
}