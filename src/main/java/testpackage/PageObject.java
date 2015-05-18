package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import static testpackage.HomePageObjectRepository.*;


/**
 * Created by DimaN on 18.05.2015.
 */
public class PageObject {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void open (){

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
}

    public static void close(){

        driver.quit();
    }

    public static WebElement getElement (String xpath){

        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    }

    public static void openURL (String url){

        driver.get(url);
    }

    public static void click (String xpath){

        getElement(xpath).click();
    }

    public static boolean verifyPresent (String xpath){

        if (driver.findElements(By.xpath(xpath)).size() > 0) return true;
        return false;

    }

    public static void setField(String field, String value){

        getElement(field).sendKeys(value);

    }

    public static String getField(String field){

        WebElement element = getElement(field);
        if(element.getTagName().equals("span")) return element.getText();
            else return element.getAttribute("value");
    }

    public static boolean isLoginSuccessful() {

        if (driver.findElements(By.xpath(userInfoFromHeader)).size() > 0) return true;
            else return false;

    }

    public static boolean verifyMessageAppears (String message){

        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(message)));
        }catch (org.openqa.selenium.TimeoutException e){
            System.out.println(message + " message was not shown!");
            return false;
        }
        return true;
    }

    public static String getBackgroundColour (String xpath){

        return getElement(xpath).getCssValue("background-color");
    }

}
