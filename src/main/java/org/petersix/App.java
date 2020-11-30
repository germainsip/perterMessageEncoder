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

import org.petersix.GUI.Menu;
import org.petersix.model.Message;
import org.petersix.tools.GenKey;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.Map;
import java.util.regex.Pattern;

public class App{
    public static void main(String[] args) throws IOException, URISyntaxException {


        // Le menu s'initialise
        Menu menu = new Menu();
        // On récupère l'entré de l'utilisateur
        String test = menu.init();
        String home = System.getProperty("user.dir");




        if (!test.equals("quit")){
            Path msgClearPath;
            Path msgEncodedPath;
            Path msgKeyPath;
            Message message;
            Map<String,String> choix = menu.pathChooser(test);

            switch (test){
                case "decode":
                    //Path msgClearPath = Paths.get(home,"decoded.txt");
                    msgClearPath = Paths.get(home,"decoded.txt");
                    msgEncodedPath = Paths.get(home,choix.get("encodedFile")+".txt");
                    msgKeyPath = Paths.get(home,choix.get("keyFile")+".txt");
                    message = new Message(true,msgClearPath,msgEncodedPath,msgKeyPath);
                    message.read();
                    break;
                case "encode":
                    msgClearPath = Paths.get(home, choix.get("clearFile")+".txt");
                    msgEncodedPath = Paths.get(home,"encoded.txt");
                    msgKeyPath = Paths.get(home,choix.get("keyFile")+".txt");
                    message = new Message(false,msgClearPath,msgEncodedPath,msgKeyPath);
                    message.read();
                    break;
            }
        }








    }}

