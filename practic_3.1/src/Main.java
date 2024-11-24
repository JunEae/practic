public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        while (true) {
            try {
                String userInput = inputHandler.getInput("Введите строку для анализа (или 'выход' для выхода): ");

                if (userInput.equalsIgnoreCase("выход")) {
                    System.out.println("Выход из программы.");
                    break;
                }

                TextAnalyzer analyzer = new TextAnalyzer(userInput);

                System.out.println("Результаты анализа:");
                System.out.println("Кол-во слов: " + analyzer.countWords());
                System.out.println("Кол-во букв: " + analyzer.countLetters());
                System.out.println("Кол-во гласных: " + analyzer.countVowels());
                System.out.println("Кол-во согласных: " + analyzer.countConsonants());
                System.out.println("Кол-во знаков препинания: " + analyzer.countPunctuationMarks());
                System.out.println("Кол-во пробелов: " + analyzer.countSpaces());
                System.out.println();

            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }
    }
}