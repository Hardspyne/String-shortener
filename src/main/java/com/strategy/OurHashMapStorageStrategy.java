package com.strategy;

import java.util.Objects;

public class OurHashMapStorageStrategy implements StorageStrategy {

    class Entry  {
        int hash;
        Long key;
        String value;
        Entry next;

        Entry(int hash, Long key, String value, Entry next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Long getKey() {
            return key;
        }

        String getValue() {
            return value;
        }

        public String toString() {
            return key + "=" + value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return Objects.equals(key, entry.key) &&
                    Objects.equals(value, entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);

    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];

    private int size;

    private int hash(Long k) {
        return k.hashCode();
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    private Entry getEntry(Long key) {
        if (size == 0) {
            return null;
        }
        int hash = (key == null) ? 0 : hash((long) key.hashCode());
        for (Entry e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {
            if (e.hash == hash && Objects.equals(e.key, key))
                return e;
        }
        return null;
    }

    private void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == (1 << 30)) {
            threshold = Integer.MAX_VALUE;
            return;
        }
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int) Math.min(newCapacity * DEFAULT_LOAD_FACTOR, (1 << 30) + 1);
    }

    private void transfer(Entry[] newTable) {
        int newCapacity = newTable.length;
        for (Entry e : table) {
            while (null != e) {
                Entry next = e.next;
                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
    }


    private void addEntry(int hash, Long key, String value, int bucketIndex) {
        if ((size >= threshold) && (null != table[bucketIndex])) {
            resize(2 * table.length);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }

    private void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        size++;
    }


    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null)
            return false;

        Entry[] tab = table;
        for (Entry entry : tab)
            for (Entry e = entry; e != null; e = e.next)
                if (value.equals(e.value))
                    return true;
        return false;
    }

    @Override
    public void put(Long key, String value) {
        addEntry(hash(key), key, value, indexFor(hash(key), table.length));
    }

    @Override
    public Long getKey(String value) {
        if (value == null)
            return 0L;
        for (Entry aTable : table) {
            for (Entry e = aTable; e != null; e = e.next)
                if (value.equals(e.value))
                    return aTable.getKey();
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return null == getEntry(key) ? null : getEntry(key).getValue();
    }
}
