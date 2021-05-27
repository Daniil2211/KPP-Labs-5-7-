package com.example.demo.query;

import java.util.Objects;

public class Query {

    private final int number;
    private final boolean MoreOrLess;

    public Query(int number, boolean MoreOrLess){
        this.number = number;
        this.MoreOrLess = MoreOrLess;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Query query = (Query) o;
        return number == query.number && MoreOrLess == query.MoreOrLess;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, MoreOrLess);
    }

    public int getNumber() {
        return number;
    }

    public boolean isMoreOrLess() {
        return MoreOrLess;
    }

}
