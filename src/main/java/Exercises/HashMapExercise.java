package Exercises;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapExercise {
    private static final Scanner scanner = new Scanner(System.in);
    public static void run(){
        HashMap< String, Integer> populationMap = new HashMap<>();

        populationMap.put("Vietnam", 98);
        populationMap.put("USA", 331);
        populationMap.put("China", 1444);
        populationMap.put("India", 1588);

        populationMap.get("USA");
        populationMap.put("Vietnam", 100);
        populationMap.remove("China");
        if (populationMap.containsKey("China")){
            System.out.println("China exist");
        }

        System.out.println("Tong so cap key-value: " + populationMap.size());

        System.out.println("Input: ");
        int N = scanner.nextInt();

        switch(N){
            case 1:
                for (String key: populationMap.keySet()){
                    System.out.println("Tat ca cac Key: " + key);
                    break;
                }
            case 2:
                for (int value: populationMap.values()){
                    System.out.println("Tat ca cac Value: "+ value);
                    break;
                }
        }
    }

}