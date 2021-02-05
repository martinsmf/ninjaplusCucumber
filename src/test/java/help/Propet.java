package help;

import java.io.InputStream;
import java.util.Properties;

public class Propet {

   private Properties prop = new Properties();
   private InputStream inputFile = getClass().getClassLoader().getResourceAsStream("movies.properties");

    public String propertis(String key, String value){
        try {
            prop.load(inputFile);
        } catch (Exception ex) {
            System.out.println("Erro ao carregar arquivo properties => " + ex.getMessage());
        }
        return prop.getProperty(key + value);
    }
}
