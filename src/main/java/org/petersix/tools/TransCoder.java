package org.petersix.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.stripAccents;

public class TransCoder {
    private Map<Character, String> encode = new HashMap<Character, String>();
    private Map<String, Character> decode = new HashMap<String, Character>();

    /**
     *
     * @param key
     */
    public TransCoder(GenKey key){
        System.out.println(key.getGeneratedKey());
        char[] code = key.getGeneratedKey().toCharArray();
        Character first = 'A';
        Character second = 'A';
        for(char letter : code){
            //System.out.println(first.toString()+second.toString());
            this.encode.put(letter,first.toString()+second.toString());
            this.decode.put(first.toString()+second.toString(),letter);
            if (second != 'Z'){
                second++;
            } else {
                first++;
                second = 'A';
            }


        }
        System.out.println(this.decode.toString());
    }

    /**
     *
     * @return
     */
    public Map<Character, String> getEncode() {
        return encode;
    }

    /**
     *
     * @return
     */
    public Map<String, Character> getDecode() {
        return decode;
    }

    /**
     *
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
     *
     * @param msgTest
     * @return
     */
    public String encode(String msgTest) {
        msgTest = stripAccents(msgTest);
        //System.out.println(msgTest);
        char[] mesgTab = msgTest.toCharArray();
        StringBuilder msgRetour = new StringBuilder();
        for(Character letter : mesgTab){
            msgRetour.append(encode.get(letter));
        }
        return msgRetour.toString();
    }

    /**
     *
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
            msgRetour.append(decode.get(couple));
        }

        return msgRetour.toString();
    }


}
