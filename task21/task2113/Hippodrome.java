package com.javarush.task.task21.task2113;                                                                                                                                                      
                                                                                                                                                      
import java.util.*;
public class Hippodrome {
    static Hippodrome game;
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    private List<Horse> horses;

    public List<Horse> getHorses(){
        return horses;
}
    void run(){
        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    void move(){
        for (Horse hs: horses) {
            hs.move();
        }
    };
    void print(){
        for (Horse hs: horses) {
            hs.print();
        }
        for (int i = 0; i<10; i++){
            System.out.println();
        }
    };

    public Horse getWinner(){
        double maxDist = 0;
        Horse winner =new Horse("0", 0,0);
        for (Horse hs: horses) {
            if (hs.distance >= maxDist){
                maxDist = hs.distance;
                winner = hs;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is "+ getWinner().name + "!");

    }
    public static void main(String[] args) {
        List<Horse> hs = new ArrayList<>();
        hs.add(new Horse("1", 3, 0));
        hs.add(new Horse("2", 3, 0));
        hs.add(new Horse("3", 3, 0));
        game = new Hippodrome(hs);
        game.run();
        game.printWinner();
    }                                                                                                                                                      
}