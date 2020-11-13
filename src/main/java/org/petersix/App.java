package org.petersix;

/*
*MMMMMMMMWXkoc:;,'''''''''',,;:lxKWMMMMMM
MMMMMMNkc;',:cllooooooooool::;'',:xNMMMM
MMMMNx;';cloooooooooooooolcoKKxl:,';kWMM
MMW0:';looooolccolc:::clocl00kKKkl:''oNM
MWk,'coooooolc::,,;ccc:,'c0Oc:lxKXx:,.oN
MO,'coooooolcdXx:xNWNNNxckkccll::l:,'..x
K:.coooooolcdXXXOxxlcoOkOx,',;;;::cclod0
d.;oooooolcdXk;oKd:oxolkkdkO0KXNNWWMMMMM
;.cooooolcdXO,.oXNXWMNXXd:clodOXWMMMMMMM
.,loooolcdXK:.;KMMMMMMMMXl,;;,,;cxKWMMMM
.;oooolcdNXo':0MMMMMMMMMMXoclolc;',oKMMM
.:ooolcdNXd;l0WNNWMMMMWNNWXocloool:',xNM
.:oolcdNNd;c0WMWWWMMMMWWWMMXoclooool,.oN
.:oocl0Xd;c0WMMMMMMMMMMMMMMMXdclooool,.d
.:oolcll:c0WMMMMMMMMMMMMMMMMMXoclooool',
.;ooolloclKMMMMMMMMMMMMMMMMMMNd:looooo;.
''looooolcoKMMMNOxxxxxxONMMMNxcloooooo:.
:.coooooolcoXMMWO:....;kNMMNxclooooooo:.
k',loooooolcoXMMW0c'':OWMMNdcloooooooo;.
Nl.:oooooolc:oXMMWkc:kWMMXd;:loooooooc.;
MKc.:ooooo:...lK0kkkxkk0Kl...:ooooool,'k
MMXc.;looo:.  ..'lOOOOo,'.  .:oooooc''xW
MMMNx,':lo:...,:c:,..,:c:,...:oool;';OWM
MMMMMKo;';;;:loooolccloooolc:ll:,';xXMMM
MMMMMMMXkl:,,,;;::cccccc::;;,,,:oONMMMMM
MMMMMMMMMWXOd:,............':oONWMMMMMMM
 */

import org.petersix.tools.GenKey;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class App {
    public static void main(String[] args) {
        /*GenKey chaineCode = new GenKey("germain");
        System.out.printf("Génération de la clé pour %s%n",chaineCode.getPrenom());
        System.out.println("Clé en clair: ");
        System.out.println(chaineCode.getGeneratedKey());
        System.out.println("=================================");
        System.out.println("Clé cryptée: ");
        System.out.println(chaineCode.getGeneratedCryptedKey());*/


       /* String home = System.getProperty("user.dir");
        System.out.println(home);
        Path path = Paths.get(home, "test.txt");
        System.out.println(Files.notExists(path));
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
                System.out.println("fichier et dossier créé");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            String str = "This is write file Example";
            byte[] bs = str.getBytes();
            Files.write(path, bs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String str = "\nThis is write file Example";
            byte[] bs = str.getBytes();
            Files.write(path, bs, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        System.out.println("╔════════════════════════════════════════╗\n" +
                           "║                  Encodeur              ║ \n" +
                           "╠════════════════════════════════════════╣ \n" +
                           "║       1) Décoder un message            ║ \n" +
                           "║       2) Encode un message             ║ \n" +
                           "║       3) Quitter                       ║ \n" +
                           "╚════════════════════════════════════════╝");

        String test = "uVakB sQ:YUEHqxlRvIc,.wNtCpfMFmod!'hrWgKeLXGSZPnJbyDAzjiTO";
        System.out.println(test.length());

    }
}
