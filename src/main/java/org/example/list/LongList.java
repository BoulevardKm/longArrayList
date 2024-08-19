package org.example.list;

import java.util.Iterator;

public interface LongList {
    void get(int index);
    void set(int index, long element);

    int size();
    boolean isEmpty();

    void add(long element);
    void add(int index, long element);
    void remove(int index);

    void contains(long element);

    Iterator<Long> iterator();
}
