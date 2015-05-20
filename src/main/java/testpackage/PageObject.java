package testpackage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.Iterator;
import java.util.Set;

import static testpackage.ObjectRepository.*;


/**
 * Created by DimaN on 18.05.2015.
 */
public class PageObject {

    public static WebDriver driver;
    public static final String string_255 = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111" +
                                            "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
    public static final String string_96 = "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
    public static final String paidUserEmail = "dmitriy.naydenov@gmail.com";
    public static final String paidUserPassword = "MyPassword123";
    public static final String newValidPassword = "MyNewPassword123";
    public static final String facebookEmail = "dimonaz@ukr.net";
    public static final String facebookPassword = "MyPassword123";
    public static final String googleEmail = "dmitriy.naydenov@gmail.com";
    public static final String googlePassword = "Bishop123";
    public static final String validRegisterEmail = "dmitriy.naydenov+automation1@gmail.com"; //CHANGE THIS FOR EVERY NEW TEST RUN!
    public static final String denyGoogleAccessButton = "//button[@id='submit_deny_access']";
    public static final String approveGoogleAccessButton = "//button[@id='submit_approve_access']";
    public static final String validforgotPasswordEmail = "dmitriy.naydenov+forgot@gmail.com";

    public static void open (){

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
}

    public static void close(){

        driver.quit();
    }

    public static WebElement getElement (String xpath) {

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

    public static void clear (String field){

        getElement(field).clear();
    }

    public static boolean isLoginSuccessful() {

        if (waitIsVisible(userPicHeader)) return true;
            else return false;
    }

    public static boolean verifyMessageAppears (String message){

        try {
            waitIsVisible(message);
        }catch (org.openqa.selenium.TimeoutException e){
            System.out.println(message + " message was not shown!");
            return false;
        }
        waitIsInvisible(enterValidEmailMessage);
        return true;
    }

    public static String getBackgroundColour (String xpath){

        return getElement(xpath).getCssValue("background-color");
    }

    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public static String getClipboardData() {
        String clipboardText;
        Transferable trans = Toolkit.getDefaultToolkit().getSystemClipboard()
                .getContents(null);

        try {
            if (trans != null && trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                clipboardText = (String) trans.getTransferData(DataFlavor.stringFlavor);
                return clipboardText;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean verifyMaxLength(String field, int length){

        WebElement inputField = getElement(field);
        String inputString = "";

        switch (length){
            case 255: inputString = string_255;
                break;
            case 96: inputString = string_96;
                break;
            default:
                System.out.println("Length not supported!");
                break;
        }

        setClipboardData(inputString);
        inputField.sendKeys(getClipboardData());
        inputField.sendKeys("2");
        if (getField(field).length() > inputString.length()){
            System.out.println("Field " + field + " accepts more than " + length + " characters");
            return false;
        }
        return true;
    }

    public static void logout(){

        click(userPicHeader);
        waitIsVisible(logoutButton);
        click(logoutButton);
    }

    public static void loginWithFacebook (){

        click(loginWithFacebookButton);
        String parentWindow = driver.getWindowHandle();

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();

        while (itr.hasNext()){

            String popupHandle = itr.next();
            if (!popupHandle.equals(parentWindow)){
                driver.switchTo().window(popupHandle);
                getElement("//input[@id='email']").sendKeys(facebookEmail);
                getElement("//input[@id='pass']").sendKeys(facebookPassword);
                click("//input[@value='Log In']");
                driver.switchTo().window(parentWindow);
            }
        }

        waitIsVisible(userPicHeader);
    }

    public static void loginWithGoogle (){

        click(loginWithGoogleButton);
        waitIsVisible("//h2[contains(text(),'Sign in')]");
        getElement("//input[@id='Email']").sendKeys(googleEmail);
        getElement("//input[@id='Passwd']").sendKeys(googlePassword);
        click("//input[@id='signIn']");
        waitIsClickable(denyGoogleAccessButton);
        click(denyGoogleAccessButton);
        waitIsClickable(loginWithGoogleButton);
        click(loginWithGoogleButton);
        waitIsClickable(approveGoogleAccessButton);
        click(approveGoogleAccessButton);
        waitIsVisible(userPicHeader);
    }

    public static void register(){

        openURL(loginURL);
        click(registerSectionButton);
        setField(registerEmailField, validRegisterEmail);
        setField(registerPasswordField, paidUserPassword);
        click(registerButton);
        waitIsVisible(userPicHeader);

    }

    public static void waitIsClickable (String xpath){

        try{
            new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        }catch (TimeoutException e){
            System.out.println("Element still not clickable after 10 seconds!");
        }
    }

    public static boolean waitIsVisible (String xpath){

        try{
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        }catch (TimeoutException e){
            System.out.println("Element still not visible after 10 seconds!");
            return false;
        }
        return true;
    }

    public static void waitIsInvisible (String xpath){

        try{
            new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
        }catch (TimeoutException e){
            System.out.println("Element still visible after 10 seconds!");
        }
    }

    public static void openResetEmail (){

        driver.get("http://mail.google.com");
        waitIsVisible("//input[@id='Email']");
        getElement("//input[@id='Email']").sendKeys(paidUserEmail);
        click("//input[@id='next']");
        waitIsVisible("//input[@id='Passwd']");
        getElement("//input[@id='Passwd']").sendKeys(googlePassword);
        click("//input[@id='signIn']");
        String subj = "//*[1][text()='[PDFfiller] Password reset.']";
        waitIsClickable(subj);
        click(subj);
        String resetLink = "//a[contains(text(),'link')]";
        waitIsVisible(resetLink);
        String parentHandle = driver.getWindowHandle();
        click(resetLink);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();

        while (itr.hasNext()){

            String otherHandle = itr.next();
            if (!otherHandle.equals(parentHandle)){
                driver.switchTo().window(otherHandle);
                waitIsVisible("//div[text()='Password Reset']");
            }
        }
    }

    public static void login (String username, String password){

        openURL(loginURL);
        waitIsVisible(emailField);
        setField(emailField, username);
        setField(passwordField, password);
        click(loginButton);
        Assert.assertTrue(isLoginSuccessful());
    }

    public static boolean verifySelected (String xpath){

        if(getElement(xpath).isSelected()) return true;
        return false;
    }

    public static boolean verifyDisplayed (String xpath){

        if(getElement(xpath).isDisplayed()) return true;
        return false;
    }

}
