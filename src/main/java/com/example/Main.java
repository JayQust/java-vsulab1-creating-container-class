package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java работает!");

        Container<String> c = new Container<>();

        c.add("good");
        c.add("work");
        c.add("!");

        System.out.println(c.get(0));
        System.out.println(c.get(1));

        c.remove(1);

        System.out.println("Size: " + c.size());
        System.out.println(c.get(1));
    }
}
