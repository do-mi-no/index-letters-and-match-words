package models;

import exceptions.DuplicateFoundException;
import exceptions.LetterNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class LWRegistry {

    private static models.LWRegistry instance = null;

    public static models.LWRegistry getInstance() {
        if (instance == null) {
            instance = new LWRegistry();
        }
        return instance;
    }

    private List<LetterAndWords> LWRegistry = new ArrayList<>();

    public void addLetterAndWords(LetterAndWords letterAndWords) throws DuplicateFoundException {
        for (LetterAndWords law : LWRegistry) {
            if (law.getSelectedLetter().contains(letterAndWords.getSelectedLetter())) {
                throw new DuplicateFoundException();
            }
        }
        LWRegistry.add(letterAndWords);
    }

    public LetterAndWords getLetterAndWordsByLetter(String letter) throws LetterNotFoundException {
        for (LetterAndWords law : LWRegistry) {
            if (law.getSelectedLetter().contains(letter)) {
                return law;
            }
        }
        throw new LetterNotFoundException();
    }

    public List<LetterAndWords> getAllLetterAndWords() {
        return LWRegistry;
    }

    public void deleteAllLettersAndWords(){
        LWRegistry.clear();
    }


}
