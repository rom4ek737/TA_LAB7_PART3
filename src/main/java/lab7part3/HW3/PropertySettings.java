package lab7part3.HW3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertySettings {
    static Properties prop = new Properties();

    static public String openProperyFile(String str) {
        try {
            prop.load(new FileInputStream(PropertySettings.class.getClassLoader().getResource("config.properties").getFile()));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop.getProperty(str);
    }
}
