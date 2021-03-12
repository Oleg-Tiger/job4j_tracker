package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Head first java", 877);
        Book second = new Book("Clean Code", 655);
        Book third = new Book("Java: The Complete Reference", 789);
        Book fourth = new Book("Thinking in Java", 800);
        Book[] array = new Book[4];
        array[0] = first;
        array[1] = second;
        array[2] = third;
        array[3] = fourth;
        System.out.println("Выводим содержимое массива на консоль:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName() + ": " + array[i].getPagesCount() + " pages");
        }
        Book temp = array[0];
        array[0] = array[3];
        array[3] = temp;
        System.out.println("Выводим содержимое на консоль после перестановки элементов 0 и 3:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName() + ": " + array[i].getPagesCount() + " pages");
        }
        System.out.println("Выводим на консоль книгу с именем Clean Code:");
        for (int i = 0; i < array.length; i++) {
            if (array[i].getName().equals("Clean Code")) {
                System.out.println(array[i].getName() + ": " + array[i].getPagesCount() + " pages");
            }
        }
    }
}