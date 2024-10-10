package com.cib.icarus.core.dto;

import java.util.Objects;

/**
 * 键值对
 */
public class KvPair<K, V> {

    private K key;

    private V value;

    public KvPair() {
    }

    public KvPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KvPair<?, ?> kvPair = (KvPair<?, ?>) o;
        return Objects.equals(key, kvPair.key) && Objects.equals(value, kvPair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "KvPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

}
