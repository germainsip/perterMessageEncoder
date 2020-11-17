package org.petersix.service;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MsgService {
    private Path keyPath;
    private Path msgPath;
    private final String home = System.getProperty("user.dir");

    public MsgService(String keyTestPath, String msgTestPath) {
        this.keyPath = Paths.get(home, keyTestPath + ".txt");
        this.msgPath = Paths.get(home, msgTestPath + ".txt");
    }
}
