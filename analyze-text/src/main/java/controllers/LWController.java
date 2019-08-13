package controllers;

import exceptions.DuplicateFoundException;
import models.*;
import services.LWService;
import views.LWView;

import java.util.List;
import java.util.Set;

public class LWController {

    private InputSentence inputSentence;
    private UniqueLetters uniqueLetters;
    private UniqueWords uniqueWords;
    private LWRegistry registry;
    private LWView view;

    public LWController() {
        this.inputSentence = new InputSentence();
        this.uniqueLetters = new UniqueLetters();
        this.uniqueWords = new UniqueWords();
        this.registry = new LWRegistry();
        this.view = new LWView();
    }

    private String getInputSentence() {
        return inputSentence.getSentence();
    }

    public void setSentence(String userText) {
        inputSentence.setSentence(userText);
    }

    private Set<String> getUniqueLetters() {
        return uniqueLetters.getUniqueLetters();
    }

    public void setUniqueLetters() {
        uniqueLetters.setUniqueLetters(LWService.findUniqueLetters(getInputSentence()));
    }

    private Set<String> getUniqueWords() {
        return uniqueWords.getUniqueWords();
    }

    public void setUniqueWords() {
        uniqueWords.setUniqueWords(LWService.findUniqueWords(getInputSentence()));
    }

    private void addSelectedLetterAndWordsToRegistry(String letter) {
        LetterAndWords letterAndWords = new LetterAndWords(letter, getWordsContainingTheLetter(letter));
        try {
            LWRegistry.getInstance().addLetterAndWords(letterAndWords);
        } catch (DuplicateFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> getWordsContainingTheLetter(String letter){
        return LWService.findWordsContainingTheLetter(letter, getUniqueWords());
    }

    public void addAllLetterAndWordsToRegistry() {
        for (String letter : getUniqueLetters()) {
            addSelectedLetterAndWordsToRegistry(letter);
        }
    }

    public void deleteAllLetterAndWordsFromRegistry(){
        LWRegistry.getInstance().deleteAllLettersAndWords();
    }

    public void displayInit(){
        view.printHR('=');
        view.printUserPrompt();
        view.printHR('=');
    }

    public void displayResult() {
        view.printUserSentence(getInputSentence());
        view.printHR('-');
        view.printWordsAssignedToLetters();
    }

}
