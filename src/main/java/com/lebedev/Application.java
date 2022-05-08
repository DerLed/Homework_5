package com.lebedev;

import com.lebedev.exception.MyDataBaseNotFoundException;
import com.lebedev.helper.MyRepository;

public class Application {
    public static void main(String[] args) {
        MyRepository<String> myRepository = new MyRepository<>();
        myRepository.save("Вася");
        myRepository.save("Петя");
        myRepository.save("Маша");



            System.out.println(myRepository.findOne(1));
            System.out.println(myRepository.findOne(8));
            System.out.println(myRepository.findOne(0));


        myRepository.update(0, "Коля");
        myRepository.update(35, "Коля");


            System.out.println(myRepository.findOne(1));
            System.out.println(myRepository.exist(2));
            System.out.println(myRepository.findOne(0));


    }
}
