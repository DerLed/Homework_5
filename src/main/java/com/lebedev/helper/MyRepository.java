package com.lebedev.helper;

import com.lebedev.exception.MyDataBaseNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyRepository <T>{
    List<Pair<Long,T>> data;
    private long id = 0;

    public MyRepository() {
        data = new ArrayList<>();
    }

    public void save(List<T> list){
        data.addAll(list.stream().map(p -> Pair.of(id++, p)).collect(Collectors.toList()));
    }

    public void save(T entity){
        data.add(Pair.of(id++, entity));
    }

    public List<T> findAll(){
        return data.stream().map(Pair::getSecond).collect(Collectors.toList());
    }

    public T findOne(long id) {
        Pair<Long,T> one = data.stream().filter(p -> p.getFirst() == id).findFirst().orElse(null);
        if(one == null){
            throw new MyDataBaseNotFoundException(id);
        }
        return one.getSecond();
    }

    public void update(long id, T entity){
        Pair<Long,T> one = data.stream().filter(p -> p.getFirst() == id).findFirst().orElse(null);
        int index = data.lastIndexOf(one);
        try {
            data.set(index, Pair.of(one.getFirst(), entity));
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    public boolean exist(long id){
        return data.stream().anyMatch(p -> p.getFirst() == id);
    }

}
