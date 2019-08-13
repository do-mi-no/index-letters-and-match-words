package models;

import java.util.List;

public class LetterAndWords {
    private String selectedLetter;
    private List<String> selectedWords;

    public LetterAndWords(String selectedLetter, List<String> selectedWords) {
        this.selectedLetter = selectedLetter;
        this.selectedWords = selectedWords;
    }

    public String getSelectedLetter() {
        return selectedLetter;
    }

    public void setSelectedLetter(String selectedLetter) {
        this.selectedLetter = selectedLetter;
    }

    public List<String> getSelectedWords() {
        return selectedWords;
    }

    public void setSelectedWords(List<String> selectedWords) {
        this.selectedWords = selectedWords;
    }

    @Override
    public String toString() {
        String words = selectedWords.toString()
                .replaceAll("[\\[\\]]", "")
                .trim();
        return String.format(" %s: %s", selectedLetter, words);
    }
}
