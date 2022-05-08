package com.lebedev.helper;

import java.util.Objects;

public class Pair<T, S> {
    private final T valueT;
    private final S valueS;

    private Pair(T valueT, S valueS) {
        this.valueT = valueT;
        this.valueS = valueS;
    }

    public static <T, S> Pair<T, S> of(T valueT1, S valueS1) {
        return new Pair<>(valueT1, valueS1);
    }

    public T getFirst() {
        return valueT;
    }

    public S getSecond() {
        return valueS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(valueT, pair.valueT) && Objects.equals(valueS, pair.valueS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueT, valueS);
    }

}

