import org.apache.log4j.LogManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final String PROPERTIES_FILE_NAME = "src\\main\\resources\\file.properties";
    private static Properties property = new Properties();
    private static InputStream inputStream;

    public static String getPropertyValue(String propertyName) {
        loadProperties(propertyName);
        String propertyValue = null;
        propertyValue = property.getProperty(propertyName);
        return propertyValue;
    }

    private static void loadProperties(String propertyName) {
        try {
            inputStream = new FileInputStream(PROPERTIES_FILE_NAME);
            property.load(inputStream);
        } catch (IOException e) {
            LogManager.getLogger(PropertiesReader.class).error(e.getMessage());
        }
    }
}

