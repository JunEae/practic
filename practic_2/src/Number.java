public class Number {
    public static boolean isSimpleOrComplex(int n){
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void getNumberInformation(double num){
        String plusOrMinus = (num > 0) ? "Положительное" : (num < 0) ? "Отрицательное" : "Ноль";
        String evenOrOdd = (num % 2 == 0) ? "Четное" : "Нечетное";

        String simpleOrComplex;
        if (num <= 1 || num != Math.floor(num)) {
            simpleOrComplex = "Отрицательные числа, 0 и 1 не могут быть простыми или составными.";
        }else {
            simpleOrComplex = isSimpleOrComplex((int) num) ? "Простое" : "Составное";
        }

        String fractionalOrInteger = (num != Math.floor(num)) ? "Дробное" : "Целое";
        double square = num * num;
        String squareRoot = (num >= 0) ? String.valueOf(Math.sqrt(num)) : "Квадратный корень из отрицательных чисел не существует.";

        System.out.println("Информация о числе " + num + ":");
        System.out.println("Положительное/отрицательное: " + plusOrMinus);
        System.out.println("Четность: " + evenOrOdd);
        System.out.println("Простое/Составное: " + simpleOrComplex);
        System.out.println("Дробное/Целое: " + fractionalOrInteger);
        System.out.println("Квадрат: " + square);
        System.out.println("Квадратный корень: " + squareRoot);
    }
}
