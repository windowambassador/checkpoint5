package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Задача 1 ===");
        Task1.solve(new String[]{"3"});
        System.out.println();

        System.out.println("=== Задача 2 ===");
        Task2.solve(new String[]{
                "7",
                "ADD apple",
                "ADD application",
                "COUNT app",
                "ADD ban",
                "COUNT ba",
                "REMOVE apple",
                "COUNT app"
        });
        System.out.println();

        System.out.println("=== Задача 3 ===");
        Task3.solve(new String[]{
                "8",
                "1 2 3 2 4 5 1 3"
        });
        System.out.println();

        System.out.println("=== Задача 4 ===");
        Task4.solve(new String[]{
                "4 2",
                "1 2",
                "3 4"
        });
        System.out.println();

        System.out.println("=== Задача 5 ===");
        Task5.solve(new String[]{
                "6",
                "ADD apple",
                "ADD application",
                "ADD ban",
                "KTH app 2",
                "KTH ap 1",
                "KTH zz 1"
        });
        System.out.println();

        System.out.println("=== Задача 6 ===");
        Task6.solve(new String[]{
                "5",
                "1 2 3 4 5"
        });
    }
}