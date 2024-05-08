package tz_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tz_2_program {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла с расширением: ");
        String file_name = scanner.nextLine();
        scanner.close();
        long startTime = System.currentTimeMillis();
        try {
            File file = new File(file_name);
            Scanner scanner_1 = new Scanner(file);
            String line = scanner_1.nextLine();
            String[] numbersAsString = line.split(" ");
            int[] numbers = new int[numbersAsString.length];
            for (int i = 0; i < numbersAsString.length; i++) {
                numbers[i] = Integer.parseInt(numbersAsString[i]);
            }
            System.out.println("Минимум: " + _min(numbers));
            System.out.println("Максимум: " + _max(numbers));
            System.out.println("Сумма: " + _sum(numbers));
            System.out.println("Произведение: " + _mult(numbers));
            scanner_1.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }
        long endTime = System.currentTimeMillis();
        long Time = endTime - startTime;
        System.out.println("Программа выполнилась за: " + Time + " миллисекунд");
    }
    
    public static int _min(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }
    
    public static int _max(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
    
    public static long _sum(int[] numbers) {
        long sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (long) sum;
    }
    
    public static String _mult(int[] numbers) {
        long mult = 1;
        int flag = 0;
        for (int num : numbers) {
        	if (num == 0) {
        		flag = 1;
        	}
            mult *= num;
        }
        if (flag == 0 && mult == 0) {
        	return "произведение вышло за пределы диапазона значений long";
        }
        return String.valueOf(mult);
    }
}
