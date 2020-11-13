import org.junit.Assert;
import org.junit.Test;
import org.petersix.tools.GenKey;
import org.petersix.tools.TransCoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;

public class TranscoderTest {
 public static GenKey testGermain;
 public final String msgTest = "Les test sont là pour essayer !!!";
    @Test
    public void createMapTest() {
        testGermain = new GenKey("Germain");
        TransCoder transcodeTest = new TransCoder(testGermain);
        Assert.assertNotNull(transcodeTest.getEncode());
        System.out.println(transcodeTest.getEncode().toString());
        Assert.assertNotNull(transcodeTest.getDecode());
        System.out.println(transcodeTest.getDecode().toString());
    }

    @Test
    public void encodeTest() {
        TransCoder transCoderTest = new TransCoder(testGermain);
        String msgEncodedTest = transCoderTest.encode(msgTest);
        Assert.assertNotEquals("", msgTest);
        System.out.println(msgTest);
    }

    @Test
    public void decodeTest() {
        TransCoder transCoderTest = new TransCoder(testGermain);
        String msgEncodedTest = transCoderTest.encode(msgTest);
        String msgDecodedTest = transCoderTest.decode(msgEncodedTest);
        Assert.assertNotEquals("", msgDecodedTest);
        System.out.println(msgTest);
    }

    @Test
    public void writeEncodeTest() throws IOException {
        TransCoder transcodeTest = new TransCoder(testGermain);
        String home = System.getProperty("user.dir");
        System.out.println(home);
        Path path = Paths.get(home, "testEncode.txt");
        System.out.println("Le fichier n'existe pas: " + Files.notExists(path));
        TransCoder transCoderTest = new TransCoder(testGermain);
        String msgEncodedTest = transCoderTest.encode(msgTest);
        transcodeTest.writeIntoFile(path, msgEncodedTest);
        System.out.println("Le fichier n'existe pas: " + Files.notExists(path));
        //Files.delete(path);
        System.out.println("Le fichier n'existe pas: " + Files.notExists(path));

    }

    @Test
    public void writeDecodedTest() throws IOException {
        TransCoder transcodeTest = new TransCoder(testGermain);
        String home = System.getProperty("user.dir");
        System.out.println(home);
        Path path = Paths.get(home, "testDecode.txt");
        System.out.println("Le fichier n'existe pas: " + Files.notExists(path));
        TransCoder transCoderTest = new TransCoder(testGermain);
        System.out.println(msgTest);
        String msgEncodedTest = transCoderTest.encode(msgTest);
        String msgDecoded = transCoderTest.decode(msgEncodedTest);
        System.out.println(msgDecoded);
        transcodeTest.writeIntoFile(path, msgDecoded);
        System.out.println("Le fichier n'existe pas: " + Files.notExists(path));
        //Files.delete(path);
        System.out.println("Le fichier n'existe pas: " + Files.notExists(path));
    }
}
