package views;

import models.LWRegistry;
import models.LetterAndWords;

import java.util.Arrays;
import java.util.List;

public class LWView {

    private int lineWidth = 80;

    public void printUserPrompt() {
        String prompt = "Wpisz własne zdanie lub wybierz przykładowy tekst do analizy:";
        String prompt1 = "1-Kot";
        String prompt2 = "2-Żółw";
        String prompt3 = "3-Telegram";
        String prompt4 = "4-Inwokacja";
        String prompt0 = "0-Wyjście";
        System.out.printf("|        %s         |%n", prompt);
        System.out.printf("|        %s,  %s,  %s,  %s,         %s          |%n",
                prompt1, prompt2, prompt3, prompt4, prompt0);
    }

    public void printUserSentence(String sentence) {
        if (registryIsNotEmpty()) {
            System.out.printf("%s%n", sentence);
        } else {
            printNoTextMessage();
        }
    }

    public void printWordsAssignedToLetters() {
        List<LetterAndWords> allLetterAndWords = LWRegistry.getInstance().getAllLetterAndWords();
        if (allLetterAndWords.size() > 0) {
            for (LetterAndWords law : allLetterAndWords) {
                System.out.println(law.toString());
            }
        }
    }

    public void printHR(char pattern) {
        char[] hr = new char[lineWidth];
        Arrays.fill(hr, pattern);
        System.out.printf("%s%n", new String(hr));

    }

    private void printNoTextMessage() {
        String NoTxtMessage = "Nie wybrano/wprowadzono tekstu do analizy\n";
        System.err.printf("                   %s%n", NoTxtMessage);
    }

    private boolean registryIsNotEmpty() {
        return LWRegistry.getInstance().getAllLetterAndWords().size() > 0;
    }

}
