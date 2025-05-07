package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    //paraméterbe jöhet a browserType
    //logika jöhet ide, oprendszer stb

    public static WebDriver get() {
        String os = System.getProperty("os.name").toLowerCase();  //ki tudjuk szedni az oprendszert

        if (os.contains("win")) {
            return new ChromeDriver(); // Ensure chromedriver.exe is on PATH
        } else if (os.contains("mac")) {
            return new SafariDriver(); // SafariDriver is preinstalled on macOS
        } else {
            throw new UnsupportedOperationException("Not supported Operating System");
        }
    }

//    public static WebDriver get(BrowserType browserType){
//  return  switch (browserType)
//    }

}
