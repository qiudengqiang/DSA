package com.alphabethub.test;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if(o instanceof Person){
            Person person = (Person) o;
            return this.age == person.age;
        }
        return false;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(Person.class.toString()+"---finalize");
    }
}
