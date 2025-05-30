package com.example.demo;

import org.springframework.stereotype.Component;

@Component
class Subclass{
    public String say(){
        return "hello , this is from the subclass" ;
    }
}