package support;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.representer.Representer;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.HashMap;
import java.util.Map;

public class YamlDataHandler {

    // Method to write (or overwrite) a key-value pair in the specified YAML file
    public static void writeKeyValue(String filename, String key, String value) {
        // Prepare YAML options for pretty output
        DumperOptions options = new DumperOptions();
        options.setPrettyFlow(true);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        // Initialize YAML with options
        Representer representer = new Representer(options);
        representer.getPropertyUtils().setSkipMissingProperties(true);
        Yaml yaml = new Yaml(representer, options);

        String path = System.getProperty("user.dir") + "/src/test/resources/data/" + filename + ".yaml";
        // Load existing data or create a new map if file does not exist
        Map<String, Object> data = new HashMap<>();
        try {
            File file = new File(path);
            if (file.exists()) {
                data = yaml.load(new FileReader(file));
                if (data == null) {
                    data = new HashMap<>();
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading YAML file: " + e.getMessage());
        }

        // Update the value for the specified key
        data.put(key, value);

        // Write the updated data back to YAML file
        try (FileWriter writer = new FileWriter(path)) {
            yaml.dump(data, writer);
        } catch (IOException e) {
            System.err.println("Error writing to YAML file: " + e.getMessage());
        }
    }

    // Method to read a value by key from the specified YAML file
//    public String readValueByKey(String filename, String key) {
//        String path = System.getProperty("user.dir") + "/src/test/resources/data/" + filename + ".yaml";
//        Yaml yaml = new Yaml();
//        try (FileReader reader = new FileReader(path)) {
//            Map<String, Object> data = yaml.load(reader);
//            if (data != null && data.containsKey(key)) {
//                return data.get(key).toString();
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading YAML file: " + e.getMessage());
//        }
//        return null; // Return null if the key doesn't exist or there's an error
//    }


    // Method to read a value by key from the specified YAML file with wait mechanism
    public static String readValueByKey(String filename, String key) {
        String path = System.getProperty("user.dir") + "/src/test/resources/data/" + filename + ".yaml";
        Yaml yaml = new Yaml();
        int maxAttempts = 10;  // Maximum number of attempts
        int delay = 500;       // Delay in milliseconds between attempts

        File file = new File(path);
        FileTime lastModifiedTime = null;

        for (int i = 0; i < maxAttempts; i++) {
            try {
                // Check if the file has been modified since the last check
                BasicFileAttributes attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                FileTime currentModifiedTime = attrs.lastModifiedTime();

                // Refresh the file contents if it was updated
                if (lastModifiedTime == null || !currentModifiedTime.equals(lastModifiedTime)) {
                    lastModifiedTime = currentModifiedTime; // Update last checked modification time
                    try (FileReader reader = new FileReader(path)) {
                        Map<String, Object> data = yaml.load(reader);
                        if (data != null && data.containsKey(key)) {
                            return data.get(key).toString(); // Return the value if key is found
                        }
                    }
                }

                System.out.println("Waiting for key '" + key + "' to be available...");
                Thread.sleep(delay); // Wait before retrying
            } catch (IOException e) {
                System.err.println("Error reading YAML file: " + e.getMessage());
                break; // Exit if there is an error reading the file
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread was interrupted", e);
            }
        }
        throw new RuntimeException("Key '" + key + "' not found in YAML file after waiting");
    }

    public static Map<String, Object> reloadYamlFile(String filename) {
        String path = System.getProperty("user.dir") + "/src/test/resources/data/" + filename + ".yaml";
        Yaml yaml = new Yaml();
        Map<String, Object> data = new HashMap<>();

        try (FileReader reader = new FileReader(new File(path))) {
            data = yaml.load(reader);
            if (data == null) {
                data = new HashMap<>(); // Return an empty map if the file is empty
            }
        } catch (IOException e) {
            System.err.println("Error reading YAML file: " + e.getMessage());
        }

        return data;
    }

}
