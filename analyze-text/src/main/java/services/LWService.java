package services;

import java.text.Collator;
import java.util.*;

public class LWService {

    private static Comparator<String> localeComparator = LWService::compare;

    public static Set<String> findUniqueLetters(String text) {
        Set<String> uniqueLetters = new TreeSet<>(localeComparator);
        char[] chars = text.replaceAll("[\\P{L}]", "").toLowerCase().toCharArray();
        for (char chr : chars) {
            uniqueLetters.add(String.valueOf(chr));
        }
        return uniqueLetters;
    }

    public static Set<String> findUniqueWords(String text) {
        String[] split = text.toLowerCase().replaceAll("\\d","").split("\\P{L}+");
        Set<String> uniqueWords = new TreeSet<>(localeComparator);
        uniqueWords.addAll(Arrays.asList(split));
        return uniqueWords;
    }

    public static List<String> findWordsContainingTheLetter(String letter, Set<String> words) {
        List<String> wordsContainingTheLetter = new ArrayList<>();
        for (String word : words) {
            if (word.contains(letter)) {
                wordsContainingTheLetter.add(word);
            }
        }
        return wordsContainingTheLetter;
    }

    private static int compare(String o1, String o2) {
//        Collator collator = Collator.getInstance(Locale.getDefault());
        Collator collator = Collator.getInstance(new Locale("pl","PL"));
        return collator.compare(o1, o2);
    }

}
