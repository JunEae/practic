import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Введите число (или 'х' для выхода): ");
                String userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("х")) {
                    System.out.println("Выход из программы.");
                    break;
                }

                double number = Double.parseDouble(userInput);
                Number.getNumberInformation(number);

            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введите корректное число.");
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }
        scanner.close();
    }
}



