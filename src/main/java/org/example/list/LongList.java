package org.example.list;

import java.util.Iterator;

public interface LongList {
    long get(int index);
    void set(int index, long element);

    int size();
    boolean isEmpty();

    void add(long element);
    void add(int index, long element);
    long remove(int index);

    boolean contains(long element);

    Iterator<Long> iterator();
}
