class TextAnalyzer {
    private String text;

    public TextAnalyzer(String text) {
        this.text = text;
    }

    public int countWords() {
        if (text.trim().isEmpty()) return 0;
        return text.trim().split("\s+").length;
    }

    public int countLetters() {
        return text.replaceAll("[^a-zA-Zа-яА-Я]", "").length();
    }

    public int countVowels() {
        return text.toLowerCase().replaceAll("[^aeiouаеёиоуыэюя]", "").length();
    }

    public int countConsonants() {
        return text.replaceAll("[^a-zA-Zа-яА-Я]", "").length() - countVowels();
    }

    public int countPunctuationMarks() {
        return text.replaceAll("[^\\p{Punct}]", "").length();
    }

    public int countSpaces() {
        return text.length() - text.replace(" ", "").length();
    }
}
