package org.petersix.tools;

import org.germain.tool.ManaBox;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.petersix.utils.Constants.ALPHABET;

public class GenKey {
    private String prenom;
    private String generatedKey;
    private final String generatedCryptedKey;

    public String getGeneratedCryptedKey() {
        return generatedCryptedKey;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getGeneratedKey() {
        return generatedKey;
    }

    public GenKey(String prenom) {
        this.prenom = prenom;
        this.generatedKey = randomKey();
        this.generatedCryptedKey = ManaBox.encrypt(this.generatedKey);
    }

    private String randomKey() {

        List<Character> charList = Arrays.asList(ALPHABET);

        Collections.shuffle(charList);

        //charList.toArray(code);

        //System.out.println(Arrays.toString(code));

        StringBuilder chaineCode = new StringBuilder();
        for( Character car : charList){ chaineCode.append(car); }

        return String.valueOf(chaineCode);
    }
}
