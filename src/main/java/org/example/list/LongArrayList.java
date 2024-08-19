package org.example.list;

import java.util.Iterator;

class LongArrayList implements LongList {
    private long[] values;
    private int capacity;
    private int size;

    LongArrayList() {
        capacity = 1;
        values = new long[capacity];
        size = 0;
    }

    @Override
    public void get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(int index, long element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(long element) {
        if (size + 1 > capacity) {
            updateCapacity(capacity * 2);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, long element) {
        if (size + 1 > capacity) {
            updateCapacity(capacity * 2);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void contains(long element) {
        throw new UnsupportedOperationException();
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