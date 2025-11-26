package com.example;

public class Container<T> {
    private Object[] data; //внутренний массив
    private int size;      //текущее количество элементов
    
    public Container(){
        data = new Object[10]; // емкость по умолчанию
        size = 0;
    }

    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i<size-1; i++){
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
    }

    public int size() {
        return size;
    }

    public void clear() { //TODO:
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
            Object[] newArray = new Object[data.length  * 2];
            System.arraycopy(data, 0, newArray, 0, data.length);
            data = newArray;
        }
    }
}