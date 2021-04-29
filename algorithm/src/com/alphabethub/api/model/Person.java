package com.alphabethub.api.model;

public class Person implements Comparable<Person> {
    private String name;
    private Integer boneBreak;

    public Person(String name, Integer boneBreak) {
        this.name = name;
        this.boneBreak = boneBreak;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", boneBreak=" + boneBreak +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.boneBreak - o.boneBreak;
    }
}
