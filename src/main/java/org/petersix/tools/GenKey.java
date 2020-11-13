package org.petersix.tools;

import org.germain.tool.ManaBox;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.petersix.utils.Constants.ALPHABET;

public class GenKey {
    private final String prenom;
    private final String generatedKey;
    private String generatedCryptedKey = null;

    public String getGeneratedCryptedKey() {
        return generatedCryptedKey;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getGeneratedKey() {
        return generatedKey;
    }

    public GenKey(String prenom, String generatedCryptedKey) {
        this.prenom = prenom;
        this.generatedCryptedKey = generatedCryptedKey;
        this.generatedKey = ManaBox.decrypt(this.generatedCryptedKey);
    }

    public GenKey(String prenom) {
        this.prenom = prenom;
        this.generatedKey = randomKey();
        this.generatedCryptedKey = ManaBox.encrypt(this.generatedKey);
    }

    private String randomKey() {

        List<Character> charList = Arrays.asList(ALPHABET);

        Collections.shuffle(charList);

        StringBuilder chaineCode = new StringBuilder();
        for( Character car : charList){ chaineCode.append(car); }

        return String.valueOf(chaineCode);
    }

    public void writeKey(){

    }
}
