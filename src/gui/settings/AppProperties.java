package gui.settings;

import exceptions.PropertiesFileNotFoundException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class AppProperties extends Properties {

    private static AppProperties uniqueInstance;

    private static final String settingsFileName = "settings.xml";
    private FileInputStream settingsFileInput;
    private FileOutputStream settingsFileOutput;

    private AppProperties() throws PropertiesFileNotFoundException, InvalidPropertiesFormatException{
        try{
            settingsFileInput = new FileInputStream(settingsFileName);
            loadFromXML(settingsFileInput);
            settingsFileInput.close();
        }catch(FileNotFoundException exception){
            throw new PropertiesFileNotFoundException(exception.getMessage());
        }catch(IOException exception){
            throw new PropertiesFileNotFoundException(exception.getMessage());
        }
    }

    public static AppProperties getInstance() throws PropertiesFileNotFoundException, InvalidPropertiesFormatException {
        if(uniqueInstance == null){
            uniqueInstance = new AppProperties();
        }
        return uniqueInstance;
    }

    public void store() throws PropertiesFileNotFoundException{
        try {
            settingsFileOutput = new FileOutputStream(settingsFileName);
            storeToXML(settingsFileOutput, "");
            settingsFileOutput.close();
        }catch(IOException exception){
            throw new PropertiesFileNotFoundException(exception.getMessage());
        }
    }
}
