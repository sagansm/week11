package me.ssagan.task4.entity;

public class Car implements Runnable {
    private String name;
    private int totalDistance;
    private int speed;
    private int currentDistance;
    private boolean isWinner = false;
    private volatile static boolean isRacing = true;

    public Car(String name, int totalDistance, int speed) {
        this.name = name;
        this.totalDistance = totalDistance;
        this.speed = speed;
        System.out.println(this);
    }

    public boolean isWinner() {
        return isWinner;
    }

    private void move() {
        while (isRacing) {
            if (currentDistance >= totalDistance) {
                isWinner = true;
                isRacing = false;
                break;
            } else {
                currentDistance = currentDistance + speed;
                System.out.println(this + ": расстояние " + currentDistance);
            }
        }
    }

    @Override
    public void run() {
        move();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("name='").append(name).append('\'');
        sb.append(", speed=").append(speed);
        sb.append('}');
        return sb.toString();
    }
}
