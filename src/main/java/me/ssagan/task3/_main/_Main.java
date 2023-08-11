package me.ssagan.task3._main;

public class _Main {
    //Создайте программу, которая считает сумму квадратов первых N натуральных чисел, используя многопоточность.
    public static void main(String[] args) throws InterruptedException {
        int number = 100;
        Calculation calculation1 = new Calculation(1, (int) (number / 2));
        Thread thread1 = new Thread(calculation1);
        thread1.start();
        Calculation calculation2 = new Calculation((int) (number / 2) + 1, number);
        Thread thread2 = new Thread(calculation2);
        thread2.start();
        thread1.join();
        thread2.join();
        int sumSquare1 = calculation1.getSumSquare();
        int sumSquare2 = calculation2.getSumSquare();
        int sumSquare = sumSquare1 + sumSquare2;
        System.out.println("Сумма в первом потоке: " + sumSquare1);
        System.out.println("Сумма во вотором потоке: " + sumSquare2);
        System.out.format("Сумма квадратов %s натуральных чисел = %s \n", number, sumSquare);
    }
}

class Calculation implements Runnable {
    private int fromNumber;
    private int toNumber;
    private int sumSquare = 0;

    public Calculation(int fromNumber, int toNumber) {
        this.fromNumber = fromNumber;
        this.toNumber = toNumber;
    }

    private void sumSquare(int fromNumber, int toNumber) {
        for (int i = fromNumber; i <= toNumber; i++) {
            sumSquare = sumSquare + i * i;
            System.out.format("Поток %s: сумма %s \n", Thread.currentThread().getName(), sumSquare);
        }
    }

    @Override
    public void run() {
        sumSquare(fromNumber, toNumber);
    }

    public int getSumSquare() {
        return sumSquare;
    }
}
