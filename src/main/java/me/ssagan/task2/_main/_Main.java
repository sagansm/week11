package me.ssagan.task2._main;

public class _Main {
    //Напишите программу, которая создает два потока и выводит на экран числа от 1 до 10,
    // сначала из первого потока, затем из второго потока.
    // Каждое число должно быть выведено в формате "Поток X: число Y", где X - номер потока (1 или 2), а Y - число от 1 до 10.
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.format("Поток %s: число %s \n", "1", i);
            }
        });
        thread1.start();
        thread1.join();
        for (int i = 1; i <= 10; i++) {
            System.out.format("     Поток %s: число %s \n", "2", i);
        }
    }
}