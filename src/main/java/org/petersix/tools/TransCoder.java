package org.petersix.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.stripAccents;

public class TransCoder {
    private Map<Character, String> encodeMap = new HashMap<Character, String>();
    private Map<String, Character> decodeMap = new HashMap<String, Character>();

    /**
     * Constructeur de Transcoder
     * @param key clé du type Genkey
     */
    public TransCoder(GenKey key){
        System.out.println(key.getGeneratedKey());
        char[] code = key.getGeneratedKey().toCharArray();
        Character first = 'A';
        Character second = 'A';
        for(char letter : code){
            //System.out.println(first.toString()+second.toString());
            this.encodeMap.put(letter,first.toString()+second.toString());
            this.decodeMap.put(first.toString()+second.toString(),letter);
            if (second != 'Z'){
                second++;
            } else {
                first++;
                second = 'A';
            }


        }
        System.out.println(this.decodeMap.toString());
    }

    /**
     *
     * @return
     */
    public Map<Character, String> getEncodeMap() {
        return encodeMap;
    }

    /**
     *
     * @return
     */
    public Map<String, Character> getDecodeMap() {
        return decodeMap;
    }

    /**
     * Méthode d'écriture du fichier
     * @param path
     * @param msg
     */
    public void writeIntoFile(Path path, String msg) {
        byte[] bs = msg.getBytes();
        try {
            Files.write(path, bs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode d'encodage
     * @param msgTest
     * @return
     */
    public String encode(String msgTest) {
        msgTest = stripAccents(msgTest);
        //System.out.println(msgTest);
        char[] mesgTab = msgTest.toCharArray();
        StringBuilder msgRetour = new StringBuilder();
        for(Character letter : mesgTab){
            msgRetour.append(encodeMap.get(letter));
        }
        return msgRetour.toString();
    }

    /**
     * Méthode de décodage
     * @param msgTest
     * @return
     */
    public String decode(String msgTest) {
        StringBuilder msgRetour = new StringBuilder();
        String[] mesgTab = new String[ msgTest.length()/2];
        int j = 0;
        //System.out.println("msgTest to tab");
        for (int i = 0 ; i < msgTest.length()-1 ; i++){
            //System.out.println(msgTest.substring(i,i+2));
            mesgTab[j] = msgTest.substring(i,i+2);
            j++;
            i++;
        }
        // System.out.println("=========================");
        //System.out.println("encodage");
        for (String couple : mesgTab){
            //System.out.println(couple);
            msgRetour.append(decodeMap.get(couple));
        }

        return msgRetour.toString();
    }


}
