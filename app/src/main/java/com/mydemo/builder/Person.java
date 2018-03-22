package com.mydemo.builder;

/**
 * Created by Administrator on 2018/3/22.
 */

public class Person {

    private String name;
    private int age;

    public Person(Builder builder) {
        this.age=builder.age;
        this.name=builder.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    class Builder{
        private String name;
        private int age;

        public Builder name(String name){
          this.name=name;
            return this;
        };
        public Builder age(int age){
            this.age=age;
            return this;
        };

        public Person build(){
            return new Person(this);
        }
    }
}
