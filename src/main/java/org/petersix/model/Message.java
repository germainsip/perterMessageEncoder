package org.petersix.model;

import org.petersix.tools.GenKey;
import org.petersix.tools.TransCoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Message {
    private Boolean encoded;
    private List<String> msgClear;
    private List<String> msgEncodded;
    private Path msgClearPath;
    private Path msgEncodedPath;
    private Path keyPath;
    private GenKey key;
    private TransCoder transCoder;


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


    public void read() {
        if (encoded) {
            try {
                this.msgEncodded = Files.readAllLines(msgEncodedPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(String ligne : msgEncodded){
                //System.out.println(ligne);
                String ligneDecoded = transCoder.decode(ligne);
                try {
                    Files.writeString(msgClearPath, ligneDecoded + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                this.msgClear = Files.readAllLines(msgClearPath);
            } catch (IOException e) {
                e.printStackTrace();
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
        }
    }
}
