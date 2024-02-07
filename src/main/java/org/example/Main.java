package org.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            MyMath mathService = (MyMath) registry.lookup("MyMathService");0


            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();

            int[] numbers = new int[size];

            System.out.println("Введите элементы массива:");
            for (int i = 0; i < size; i++) {
                System.out.print("Элемент " + (i + 1) + ": ");
                numbers[i] = getIntFromUser(scanner);
            }
            int choice=0;
            System.out.println("Выберете что хотите вывести:");
            System.out.println("1-факториалы членов массива\n 2-корни членов массива");

            choice=getIntFromUser(scanner);
            switch (choice)
            {
                case 1:
                {   int[] factorials = mathService.Factorials(numbers);


                    System.out.println("Факториалы чисел:");
                    for (int i = 0; i < factorials.length; i++) {
                        System.out.println(numbers[i] + "! = " + factorials[i]);
                    }
                    break;
                }

                case 2: {
                    double[] squareRoots = mathService.SqureRoots(numbers);


                    System.out.println("Квадратные корни чисел:");
                    for (int i = 0; i < squareRoots.length; i++) {
                        System.out.println("√" + numbers[i] + " = " + squareRoots[i]);
                    }
                    break;
                }
            }





        } catch (Exception e) {
            System.err.println("Ошибка при вызове RMI сервиса: " + e.getMessage());
        }
    }
    private static int getIntFromUser(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введите целое число.");
                scanner.nextLine(); // Очистка буфера сканера после ошибочного ввода
            }
        }
    }
}