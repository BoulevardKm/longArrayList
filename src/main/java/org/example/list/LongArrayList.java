package org.example.list;

import java.util.Iterator;

public class LongArrayList implements LongList {
    private long[] values;
    private int capacity;
    private int size;

    LongArrayList() {
        capacity = 1;
        values = new long[capacity];
        size = 0;
    }

    @Override
    public long get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return values[index];
    }

    @Override
    public void set(int index, long element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
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
    }

    @Override
    public void add(int index, long element) {
        if (size + 1 > capacity) {
            updateCapacity(capacity * 2);
        }
    }

    @Override
    public long remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        long removedValue = values[index];

        for (int i = index; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
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

    public static class ArrayRealization {
        LongArrayList longList = new LongArrayList();
        public void arrayAddElements() {

            longList.add(0, 10);
            longList.add(1, 20);
            longList.add(2, 30);
            longList.add(3, 40);
            longList.add(4, 50);
            longList.add(60);
        }

        public void arrayGetElement() {

            longList.get(2);
        }

        public void arraySetElement() {

            longList.set(2, 31);
        }

        public void arrayGetSize() {

            longList.size();
        }

        public void arrayIsEmpty() {

            longList.isEmpty();
        }

        public void arrayRemove() {

            longList.remove(3);
        }

        public void arrayContains() {

            longList.contains(60);
        }

    }
}