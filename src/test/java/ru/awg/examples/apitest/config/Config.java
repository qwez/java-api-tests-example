package ru.awg.examples.apitest.config;

import ru.awg.examples.apitest.util.PropertiesReader;

import java.io.IOException;
import java.util.Properties;

public class Config {

    public static final Properties properties;

    static {
        try {
            properties = PropertiesReader.read("config.properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
