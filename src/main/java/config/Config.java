package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;

public class Config {
    public String url;
    public String username;
    public String password;

    public static Config load(String path){
        ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
        try{
            Config config=objectMapper.readValue(Config.class.getResource(path),Config.class);
            return config;
        } catch (IOException e) {
           e.printStackTrace();
           return null;
        }
    }
}
