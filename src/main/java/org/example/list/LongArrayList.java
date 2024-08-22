package org.example.list;

import java.util.Iterator;

public class LongArrayList implements LongList {
    private long[] values;
    private int capacity;
    private int size;

    public LongArrayList() {
        capacity = 1;
        values = new long[capacity];
        size = 0;
    }

    @Override
    public long get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " вне допустимого диапазона: 0 до " + (size - 1));
        }
        return values[index];
    }

    @Override
    public void set(int index, long element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " вне допустимого диапазона: 0 до " + (size - 1));
        }
        values[index] = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(long element) {
        if (size + 1 > capacity) {
            updateCapacity(capacity * 2);
        }
        values[size] = element;
        size++;
    }

    @Override
    public void add(int index, long element) {
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

    @Override
    public long remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " вне допустимого диапазона: 0 до " + (size - 1));
        }
        long removedValue = values[index];

        for (int i = index; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        values[size - 1] = Long.parseLong(null);
        size--;

        return removedValue;
    }


    @Override
    public boolean contains(long element) {
        for (int i = 0; i < size; i++) {
            if (values[i] == element) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Iterator<Long> iterator() {
        throw new UnsupportedOperationException();
    }

    private void updateCapacity(int newCapacity) {
        long[] valuesArray = new long[newCapacity];
        for (int i = 0; i < size; i++) {
            valuesArray[i] = values[i];
        }
        values = valuesArray;
        capacity = newCapacity;
    }
}