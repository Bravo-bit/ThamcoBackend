package reader;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.Properties;

public class PropertiesReader {

    private static final Logger LOGGER = Logger.getLogger(PropertiesReader.class.getName());

    public Properties readProperties(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(Objects.requireNonNull(filePath));

            if (!file.exists()) {
                LOGGER.log(Level.SEVERE, "File not found: " + filePath);
                return null;
            }

            return objectMapper.readValue(file, Properties.class);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading properties from file: " + filePath, e);
        }
        return null;
    }
}
