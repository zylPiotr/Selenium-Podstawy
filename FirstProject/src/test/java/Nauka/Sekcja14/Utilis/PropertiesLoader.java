package Nauka.Sekcja14.Utilis;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class PropertiesLoader {

    public static String loadProperty(String propertyName) throws IOException {

        InputStream inputStream = new FileInputStream("src/test/resources/config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        return properties.getProperty(propertyName);
    }
}
