package com.cib.icarus.core.dto;

import java.util.Objects;

/**
 * 键值对
 */
public class KvPair<T> {

    private String key;

    private T value;

    public KvPair() {
    }

    public KvPair(String key, T value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KvPair<?> kvPair = (KvPair<?>) o;
        return Objects.equals(key, kvPair.key) && Objects.equals(value, kvPair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "KvPair{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
