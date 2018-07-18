package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.reporters.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// CSV
// Properties
// XML

public class FileIO {

    static String TARGET_FOLDER = "target";
    static String DATA_RESOURCES = "src/main/resources/data/";
    static String PROD_DATA_RESOURCES = "src/main/resources/data/production/";
    static String CONFIG_FILE = System.getProperty("config");
    static String PROPERTIES = "src/main/resources/" + (( CONFIG_FILE == null ) ? "default" : CONFIG_FILE) + ".properties";
    static String Report_folder = "Report";

    public static String filename;

    public static String getConfigProperty(String fieldName){
        String fileLocation = PROPERTIES;
        String result   = null;

        try {
            //open file
            File file = new File(fileLocation);
            //open input stream to read file
            FileInputStream fileInput = new FileInputStream(file);
            //create Properties object
            Properties properties = new Properties();
            //load properties from file
            properties.load(fileInput);
            //close file
            fileInput.close();
            //get property by name
            result = properties.getProperty(fieldName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            ReporterManager.Instance.fatalFail("Config was not found");
        } catch (IOException e) {
            e.printStackTrace();
            ReporterManager.Instance.fatalFail("Config was not opened");
        } catch (Exception e){
            e.printStackTrace();
            ReporterManager.Instance.fatalFail("Field was not found: " + fieldName);
        }
        return result;
    }

    public static String takeScreenshot(WebDriver driver){
        return takeScreenshot(driver, String.valueOf(System.currentTimeMillis()));
    }

    public static String takeScreenshot(WebDriver driver, String name){
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        filename = name + "screen.png";
        try {
            Files.copyFile(new FileInputStream(file) , new File(TARGET_FOLDER + File.separator + Report_folder + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }

    public static String getDataFile(String filename){
//        if (FileIO.getConfigProperty("EnvType").equals("PROD"))
//            return PROD_DATA_RESOURCES + filename;
//        else
            return DATA_RESOURCES + filename;
    }

}

