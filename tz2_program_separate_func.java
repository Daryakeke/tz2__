import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tz2_program_separate_func {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file_name = scanner.nextLine();
        try {
            File file = new File(file_name);
            Scanner scanner_1 = new Scanner(file);
            String line = scanner_1.nextLine();
            String[] numbersAsString = line.split(" ");
            int[] numbers = new int[numbersAsString.length];
            for (int i = 0; i < numbersAsString.length; i++) {
                numbers[i] = Integer.parseInt(numbersAsString[i]);
            }
            int choice;
            do {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Минимум: " + _min(numbers));
                        break;
                    case 2:
                        System.out.println("Максимум: " + _max(numbers));
                        break;
                    case 3:
                        System.out.println("Сумма: " + _sum(numbers));
                        break;
                    case 4:
                        System.out.println("Произведение: " + _mult(numbers));
                        break;
                    case 0:
                        System.out.println("Программа завершена.");
                        break;
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } while (choice != 0);
            scanner_1.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден!");
        }
        scanner.close();
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
