package testpackage;

/**
 * Created by DimaN on 18.05.2015.
 */

public class ObjectRepository {

    //HOME PAGE

    public static final String homePageURL = "http://pdffiller.com";
    public static final String loginURL = "https://www.pdffiller.com/en/login.htm";
    public static final String loginLink = "//a[text()='Log in']";
    public static final String logo = "//img[@class='h-logo__img' and @alt='PDFfiller logo']";
    public static final String userPicHeader = "//img[@id = 'user_logo_thumb_header']";

    //LOGIN PAGE

    public static final String loginLabel = "//h1[text()='LOG IN']";
    public static final String registerLabel = "//h1[text()='REGISTER']";
    public static final String registerEmailField = "//input[@id='username']";
    public static final String registerPasswordField = "//input[@id='password']";
    public static final String registerButton = "//div[@id='register_btn_site']";
    public static final String registerSectionButton = "//a[@class='btn-gray btns1' and text()='Register']";
    public static final String loginSectionButton = "//a[@class='btn-gray btns1' and text()='Login']";
    public static final String emailField = "//input[@id='username2']";
    public static final String passwordField = "//input[@id='password2']";
    public static final String forgotPasswordLink = "//a[text()='Forgot your password?']";
    public static final String remeberMeCheckbox = "//label[text()='Remember Me']/preceding-sibling::*[@type='checkbox']";
    public static final String loginButton = "//div[@id='login_btn_site']";
    public static final String loginWithPhoneButton = "//div[@class='phone-login-btn']";
    public static final String loginWithFacebookButton = "//span[text()='Login with Facebook']";
    public static final String loginWithGoogleButton = "//div[text()='Login with Google']";
    public static final String registerWithFacebookButton = "//span[text()='Register with Facebook']";
    public static final String registerWithGoogleButton = "//div[text()='Register with Google']";
    public static final String logoutButton = "//a[text() = 'Log out']";
    public static final String noSpam = "//div[@id='no-spam']";
    public static final String enterValidEmailMessage = "//div[text()='Please enter a valid email address!']";
    public static final String loginFailedMessage = "//div[@class='ERROR_MESSAGE']//div[contains(text(),'Either the specified PDFfiller account does not exist')]";
    public static final String userExistsMessage = "//div[@class='ERROR_MESSAGE']//div[contains(text(),'Account with this email address already exists')]";
    public static final String forgotPasswordEmail = "//input[@id='fp_email']";
    public static final String cancelForgotPassword = "//span[starts-with(text(),'Password Reset:')]/following::a[@id='btn_close_ui_dialog']";
    public static final String closeForgotPassword = "//span[starts-with(text(),'Password Reset:')]/following::a[@class='ui-dialog-titlebar-close ui-corner-all']";
    public static final String sendForgotPassword = "//span[starts-with(text(),'Password Reset:')]/following::a[@id='btn_popup_ok']";
    public static final String notRegisteredPopupOK = "//p[text()='This username is not registered with PDFfiller']/following::button[text()='OK']";
    public static final String forgotPassConfirmOK = "//p[contains(text(),'Password reset email was sent')]/following::button[text()='OK']";
    public static final String newPasswordField = "//div[@class='block-reset-password']//input[@id='password']";
    public static final String confirmPasswordField = "//div[@class='block-reset-password']//input[@id='confirm']";
    public static final String submitNewPassButton = "//div[@class='block-reset-password']//button[text()='Submit']";
    public static final String fieldRequiredError = "//div[text()='This field is required']";
    public static final String notMatchingPassError = "//div[text()='Passwords entered do not match']";

}
