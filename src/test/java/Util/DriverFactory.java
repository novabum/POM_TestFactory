package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    //paraméterbe jöhet a browserType
    public static WebDriver get(){
//        var system = System.getProperty("os"); // valahogy ki tudjuk szedni az oprendszert
//        //logika jöhet ide, oprendszer stb
//        if ("windows".equals(system))
//            return new ChromeDriver();
//        if ("mac".equals(system))
//            return new SafariDriver();
        return new ChromeDriver();
    }

//    public static WebDriver get(BrowserType browserType){
//  return  switch (browserType)
//    }

}
