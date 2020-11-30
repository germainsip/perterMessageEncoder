package org.petersix.model;

import org.petersix.tools.GenKey;
import org.petersix.tools.TransCoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Classe Message
 *
 */
public class Message {
    private Boolean encoded;
    private List<String> msgClear;
    private List<String> msgEncodded;
    private Path msgClearPath;
    private Path msgEncodedPath;
    private Path keyPath;
    private GenKey key;
    private TransCoder transCoder;

    /**
     * Constructeur de Message
     * @param encoded
     * @param msgClearPath
     * @param msgEncodedPath
     * @param keyPath
     * @throws IOException
     */
    public Message(Boolean encoded, Path msgClearPath, Path msgEncodedPath, Path keyPath) throws IOException {
        this.encoded = encoded;
        this.msgClearPath = msgClearPath;
        this.msgEncodedPath = msgEncodedPath;
        this.keyPath = keyPath;
        if (Files.exists(keyPath)){
            this.key = new GenKey("",Files.readString(keyPath));
            System.out.println("la clé a été enregistrée");
        } else {
            this.key = new GenKey("");
            Files.writeString(keyPath,this.key.getGeneratedCryptedKey());
            System.out.println("une clé a été crée à: " + keyPath.toString());
        }
        this.transCoder = new TransCoder(key);
    }

    //TODO: gérer le cas où le fichier n'existe pas !

    /**
     * Méthode de lecture des fichier à encoder ou décoder
     * écrit le résultat dans un fichier dont le nom est précisé à la création de l'objet message
     *
     */
    public void read() {
        if (encoded) {
            try {
                this.msgEncodded = Files.readAllLines(msgEncodedPath);
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("Le fichier spécifié n'existe pas le programme s'est arrêté");
            }
            System.out.println("====== Décodage =====");
            for(String ligne : msgEncodded){
                //System.out.println(ligne);
                String ligneDecoded = transCoder.decode(ligne);
                System.out.println(ligneDecoded);
                try {
                    Files.writeString(msgClearPath, ligneDecoded + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Le message décodé se trouve: " + msgClearPath.toString());
        } else {
            try {
                this.msgClear = Files.readAllLines(msgClearPath);
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("Le fichier spécifié n'existe pas le programme s'est arrêté");

            }
            for (String ligne : msgClear) {
                //System.out.println(ligne);
                String ligneEncoded = transCoder.encode(ligne);
                try {
                    Files.writeString(msgEncodedPath, (ligneEncoded + System.lineSeparator()), StandardOpenOption.CREATE,StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Le message encodé se trouve: " + msgEncodedPath.toString());

        }
    }
}
