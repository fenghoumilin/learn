package javaSourceTest;

public class Dog extends Animal{


    public Dog(String na){
        name = na;
    }

    public static void main(String[] args) {
        Dog dog = new Dog("wangwang");
        System.out.println(dog.name);
    }

}
