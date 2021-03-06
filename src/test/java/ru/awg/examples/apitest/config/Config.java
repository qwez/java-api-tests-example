package ru.awg.examples.apitest.config;

import lombok.SneakyThrows;
import ru.awg.examples.apitest.util.PropertiesReader;

import java.util.Properties;

public class Config {
    private static final Properties properties = getProperties();

    @SneakyThrows
    private static Properties getProperties() {
        return PropertiesReader.read("config.properties");
    }

    public static String getValue(String key) {
        return properties.getProperty(key, "");
    }
}
