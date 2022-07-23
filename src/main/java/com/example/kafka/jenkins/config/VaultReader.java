package com.example.kafka.jenkins.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class VaultReader {

    String filePath = "asdASD";

    public String getCacheSize1() {
        FileReader reader= null;
        Properties p=new Properties();
        try {
            reader = new FileReader(filePath);
            p.load(reader);
            reader.close();
        } catch (Exception e) {
            System.out.println("Error while Reading Properties file!!!");
            e.printStackTrace();
            return "4";
        }
        return p.getProperty("tc.cache.size");
    }
}
