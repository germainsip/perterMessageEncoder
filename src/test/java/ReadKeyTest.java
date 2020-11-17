import org.germain.tool.ManaBox;
import org.junit.Assert;
import org.junit.Test;

public class ReadKeyTest {
    @Test
    public void readKeyTest() {
        String keyCrypted = "6lUjKOzUj4e/Gelw9c6sDLqHniwulClN6XSayZ+HRF/kbZx+CMf95jxrhm4YFSY26OnxVlsrzGkO00IMeAFs3g==";
        String keyDecrypted = "uVakB sQ:YUEHqxlRvIc,.wNtCpfMFmod!'hrWgKeLXGSZPnJbyDAzjiTO";

        Assert.assertEquals("La librairie de décryptage est mal installée",keyDecrypted,ManaBox.decrypt(keyCrypted));

    }
}
