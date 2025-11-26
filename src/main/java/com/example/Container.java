package com.example;

/** Простой динамический массив (контейнер) для хранения произвольного количества объектов.
 * Реализация основана на внутреннем массиве типа {@code Object[]}. 
 */
public class Container<T> {
    private Object[] data; //внутренний массив
    private int size;      //текущее количество элементов
    private static final int DEFAULT_CAPACITY = 10; //емкость по умолчанию
    
    /**Создает пустой контейнер с емкостью по умолчанию (10).*/
    public Container(){
        this.data = new Object[DEFAULT_CAPACITY]; // емкость по умолчанию
        this.size = 0;
    }

    /**
     * Создает пустой контейнер с указанной начальной емкостью.
     * @param initialCapacity начальгая емкость.
     */
    public Container(int initialCapacity){
        if (initialCapacity<0){
            throw new IllegalArgumentException("Начальная размарность не может быть отрицательной:" + initialCapacity);
        }
        this.data = new Object[initialCapacity]; // емкость по умолчанию
        this.size = 0;
    }

    /**
     * Добавляет элемент в конец контейнера. Если емкости текущей недостаточно, автоматически удваиваетсяю.
     * @param item Элемент для добавления.
     */
    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    /**
     * Возвращает элемент по указанному индексу.
     * @param index Индекс элемента, который требуется извлечь.
     * @return Значение элемента.
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     * @param index Индекс удаляемого элемента.
     */
    public void remove(int index) {
        checkIndex(index);
        int numMoved = size - index - 1; 
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--size] = null;
    }

    /**
     * Возвращает текущее количество элементов в контейнере.
     * @return Количество элементов.
     */
    public int size() {
        return size;
    }

    /**
     * Очищает контейнер, удаляя все элементы.
     */
    public void clear() {
        for (int i = 0; i<size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * Проверяет, что указанный индекс находится в пределах диапазона контейнера [0, size - 1].
     * @param index Индекс для проверки.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: "+ size);
        }
    }

    /**
     * Увеличивает емкость внутреннего массива, если она недостаточна для добавления следующего элемента.
     */
    private void ensureCapacity() {
        if (size == data.length) {
            // Удвоение емкости, если она еще не 0. Если 0, то устанавливаем в DEFAULT_CAPACITY.
            int newCapacity = data.length == 0 ? DEFAULT_CAPACITY : data.length * 2;
            
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(data, 0, newArray, 0, data.length);
            data = newArray;
        }
    }
}