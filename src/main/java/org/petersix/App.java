package org.petersix;

import org.petersix.tools.GenKey;

public class App {
    public static void main(String[] args) {
        GenKey chaineCode = new GenKey("germain");
        System.out.printf("Génération de la clé pour %s%n",chaineCode.getPrenom());
        System.out.println("Clé en clair: ");
        System.out.println(chaineCode.getGeneratedKey());
        System.out.println("=================================");
        System.out.println("Clé cryptée: ");
        System.out.println(chaineCode.getGeneratedCryptedKey());

    }
}
