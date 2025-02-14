package com.OrangeHrmAutomation.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties properties;
    String path = "src/main/resources/Config/config.properties";
    public ReadConfig() throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(path);
        properties.load(fis);
    }

    public String UrlMain(){
       String url =  properties.getProperty("BaseUrl");
       if (url!=null)
           return url;
       else throw new RuntimeException("Url is the specified in the config properties file");
    }

    public String BrowserMain(){
        String browser =properties.getProperty("BaseBrowser");
        if (browser!=null)
            return browser;
        else throw new RuntimeException("Browser is not specified in the config properties file");
    }
}
