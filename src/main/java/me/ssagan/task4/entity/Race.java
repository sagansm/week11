package me.ssagan.task4.entity;

public class Race {
    private int distance = 100;

    public void begin() throws InterruptedException {
        Car car1 = new Car("Car1", distance, (int) (Math.random() * 5) + 1);
        Car car2 = new Car("Car2", distance, (int) (Math.random() * 5) + 1);
        Thread thread1 = new Thread(car1);
        Thread thread2 = new Thread(car2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        if (car1.isWinner()) {
            System.out.println("The winner is " + car1);
        } else if (car2.isWinner()) {
            System.out.println("The winner is " + car2);
        }
    }
}
