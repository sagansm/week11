package me.ssagan.task1._main;

public class _Main {
    public static void main(String[] args) {
        //Напишите программу, которая создает два потока, каждый из которых выводит на экран числа от 1 до 10.
        // Но при этом первый поток должен выводить только четные числа, а второй - только нечетные.
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 1) {
                    System.out.println("     " + i);
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
