package me.ssagan.task4._main;

import me.ssagan.task4.entity.Race;

public class _Main {
    //Создайте программу, которая будет имитировать гонки на машине.
    // У вас есть две машины, каждая из которых может двигаться со случайной скоростью в диапазоне от 1 до 5 метров в секунду.
    // Заезд должен начинаться одновременно для обеих машин, и победитель определяется той машиной,
    // которая пройдет заранее заданное расстояние.
    public static void main(String[] args) throws InterruptedException {
        Race race = new Race();
        race.begin();
    }
}
