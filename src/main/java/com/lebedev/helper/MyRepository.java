package com.lebedev.helper;

import com.lebedev.exception.MyDataBaseNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyRepository <T>{
    List<Pair<Long,T>> data;
    private long id = 0;

    public MyRepository() {
        data = new ArrayList<>();
    }

    public T save(T entity){
        data.add(Pair.of(id++, entity));
        return entity;
    }

    public List<T> findAll(){
        return data.stream().map(Pair::getSecond).collect(Collectors.toList());
    }

    public T findOne(long id) {
        return find(id).getSecond();
    }

    public T update(long id, T entity){
        Pair<Long,T> one = find(id);
        int index = data.lastIndexOf(one);
        data.set(index, Pair.of(one.getFirst(), entity));
        return entity;
    }

    public void delete(long id){
        Pair<Long,T> one = find(id);
        int index = data.lastIndexOf(one);
        data.remove(index);
    }

    public boolean exist(long id){
        return data.stream().anyMatch(p -> p.getFirst() == id);
    }

    private Pair<Long, T> find(long id){
        Pair<Long,T> one = data.stream().filter(p -> p.getFirst() == id).findFirst().orElse(null);
        if(one == null){
            throw new MyDataBaseNotFoundException(id);
        }
        return one;
    }
}
