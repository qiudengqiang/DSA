package com.alphabethub.test;


import com.alphabethub.tool.Times;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static {
        System.out.println("Static initialization of Main");

    }

    {
        System.out.println("Instance initialization of Main");
    }

    public Main() {
        System.out.println("Constructor of Main");
    }

    public static void main(String[] args) {
        new Class3();
    }

}

class Class1 {
    static {
        System.out.println("Static initialization of Class1");
    }

    {
        System.out.println("Instance initialization of Class1");
    }

    Class1() {
        System.out.println("Constructor of Class1");
    }
}

class Class2 extends Class1 {
    static {
        System.out.println("Static initialization of Class2");
    }

    {
        System.out.println("Instance initialization of Class2");
    }

    Class2() {
        System.out.println("Constructor of Class2");
    }
}

class Class3 extends Class2 {
    static {
        System.out.println("Static initialization of Class3");
    }

    {
        System.out.println("Instance initialization of Class3");
    }

    Class3() {
        System.out.println("Constructor of Class3");
    }
}