package testpackage;

/**
 * Created by DimaN on 18.05.2015.
 */

public class LoginPageObjectRepository {

    public static final String loginLabel = "//h1[text()='LOG IN']";
    public static final String registerButton = "//a[@class='btn-gray btns1' and text()='Register']";
    public static final String emailField = "//input[@id='username2']";
    public static final String passwordField = "//input[@id='password2']";
    public static final String forgotPasswordLink = "//a[text()='Forgot your password?']";
    public static final String remeberMeCheckbox = "//label[text()='Remember Me']/preceding-sibling::*[@type='checkbox']";
    public static final String loginButton = "//div[@id='login_btn_site']";
    public static final String loginWithPhoneButton = "//div[@class='phone-login-btn']";
    public static final String loginWithFacebookButton = "//span[text()='Login with Facebook']";
    public static final String loginWithGoogleButton = "//div[text()='Login with Google']";
    public static final String noSpam = "//div[@id='no-spam']";
    public static final String enterValidEmailMessage = "//div[text()='Please enter a valid email address!']";

}
