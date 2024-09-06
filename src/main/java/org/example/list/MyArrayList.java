package org.example.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyArrayList<T> implements Iterable<T> {
    private Object[] values;
    private int capacity;
    private int size;

    public MyArrayList() {
        capacity = 1;
        values = new Object[capacity];
        size = 0;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " вне допустимого диапазона: 0 до " + (size - 1));
        }
        return (T) values[index];
    }


    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " вне допустимого диапазона: 0 до " + (size - 1));
        }
        values[index] = element;
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public void add(T element) {
        if (size + 1 > capacity) {
            updateCapacity(capacity * 2);
        }
        values[size] = element;
        size++;
    }


    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " вне допустимого диапазона: 0 до " + (size - 1));
        }

        if (size + 1 > capacity) {
            updateCapacity(capacity * 2);
        }

        for (int i = size; i > index; i--) {
            values[i] = values[i - 1];
        }

        values[index] = element;
        size++;
    }


    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " вне допустимого диапазона: 0 до " + (size - 1));
        }
        T removedValue = (T) values[index];

        for (int i = index; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        values[size - 1] = null;
        size--;

        return removedValue;
    }




    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, values[i])) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) values[currentIndex++];
            }
        };
    }

    private void updateCapacity(int newCapacity) {
        Object[] valuesArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            valuesArray[i] = values[i];
        }
        values = valuesArray;
        capacity = newCapacity;
    }
}
