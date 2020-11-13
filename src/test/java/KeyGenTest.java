import org.junit.Assert;
import org.junit.Test;
import org.petersix.tools.GenKey;

public class KeyGenTest {

    @Test
    public void testGen() {
        GenKey testGermain = new GenKey("Germain");
        System.out.println(testGermain.getGeneratedKey());
        System.out.println(testGermain.getGeneratedCryptedKey());
        Assert.assertTrue("ça marche pas !!!",testGermain.getGeneratedCryptedKey() != null);
    }
}
