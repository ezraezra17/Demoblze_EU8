package com.demoblaze.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    /*Creating a private constructor so we are closing access to the object of this class outside the class*/

    private Driver() {
    }
/*
  we make WebDriver private, because we want to close access from outside the class
  We make it static because we will use  in a static mode.
* */

    //private static WebDriver driver;// value is null by default
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    // create a re-usable method which will return same driver instance when we call it
    public static WebDriver getDriver() {

        if (driverPool.get() == null) { // if the driver is null it will create a driver within the brackets or not null it will get to retun and execute the driver
          /*
          we read our browserType from configuration.properties.
          This way, we can control which browser is open from outside code, from configuration properties
          */

            String browserType = com.demoblaze.utilities.ConfigurationReader.getProperty("browser");
            /*
             * Depending on the browserType that will be return from configuration.properties file
             * switch statement  will determine the case , and open the matching browser
             * */
            switch (browserType) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.setAcceptInsecureCerts(true);//if the website block you to enter the homepage you can create this object of the chromeoptions class
                    //  options.addArguments("Incognito");
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }
        return driverPool.get();
    }

    //This method will make sure our driver value is always null after using quit() method
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();//this line will terminate the existing session ,value will not even be null
            driverPool.remove();

        }

    }

}
