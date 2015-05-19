import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static testpackage.PageObject.*;
import static testpackage.ObjectRepository.*;

/**
 * Created by DimaN on 18.05.2015.
 */

public class LoginTest {

    @Before

    public void initialize(){

        open();

    }

    @After

    public void finish(){

        //close();
    }

   @Test

    public void verifyLoginPageElements() {

        openURL(loginURL);
        Assert.assertTrue(verifyPresent(logo));
        Assert.assertTrue(verifyPresent(loginLabel));
        Assert.assertTrue(verifyPresent(registerSectionButton));
        Assert.assertTrue(verifyPresent(emailField));
        Assert.assertTrue(verifyPresent(passwordField));
        Assert.assertTrue(verifyPresent(forgotPasswordLink));
        Assert.assertTrue(verifyPresent(remeberMeCheckbox));
        Assert.assertTrue(verifyPresent(loginButton));
        Assert.assertTrue(verifyPresent(loginWithPhoneButton));
        Assert.assertTrue(verifyPresent(loginWithFacebookButton));
        Assert.assertTrue(verifyPresent(loginWithGoogleButton));
        Assert.assertTrue(verifyPresent(noSpam));
    }

    @Test

        public void badLoginInput(){

        openURL(loginURL);
        click(loginButton);
        Assert.assertTrue(verifyMessageAppears(enterValidEmailMessage));
        Assert.assertEquals("rgba(246, 217, 219, 1)", getBackgroundColour(emailField));
        Assert.assertEquals("rgba(246, 217, 219, 1)", getBackgroundColour(passwordField));
        setField(emailField, "invalid");
        click(loginButton);
        Assert.assertTrue(verifyMessageAppears(enterValidEmailMessage));
        clear(emailField);
        setField(passwordField, validPassword);
        click(loginButton);
        Assert.assertTrue(verifyMessageAppears(enterValidEmailMessage));
        setField(emailField, validEmail);
        setField(passwordField, "invalid");
        click(loginButton);
        Assert.assertTrue(verifyMessageAppears(loginFailedMessage));

    }

    @Test

        public void fieldMaxLength (){

        openURL(loginURL);
        Assert.assertTrue(verifyMaxLength(emailField, 255));
        Assert.assertTrue(verifyMaxLength(passwordField, 255));
    }

    @Test

        public void ignoreEmailSpaces (){

        openURL(loginURL);
        setField(emailField, " " + validEmail + " ");
        setField(passwordField, validPassword);
        click(loginButton);
        Assert.assertTrue(isLoginSuccessful());
        logout();
    }

    @Test

        public void loginWithFacebookTest(){

        openURL(loginURL);
        loginWithFacebook();
        Assert.assertTrue(isLoginSuccessful());
    }

    @Test

    public void loginWithGoogleTest(){

        openURL(loginURL);
        loginWithGoogle();
        Assert.assertTrue(isLoginSuccessful());
        logout();
    }

    @Test
    public void verifyRegisterPageElements() {

        openURL(loginURL);
        click(registerSectionButton);
        Assert.assertTrue(verifyPresent(logo));
        Assert.assertTrue(verifyPresent(registerLabel));
        Assert.assertTrue(verifyPresent(loginSectionButton));
        Assert.assertTrue(verifyPresent(registerEmailField));
        Assert.assertTrue(verifyPresent(registerPasswordField));
        Assert.assertTrue(verifyPresent(registerButton));
        Assert.assertTrue(verifyPresent(registerWithFacebookButton));
        Assert.assertTrue(verifyPresent(registerWithGoogleButton));
        Assert.assertTrue(verifyPresent(noSpam));
    }

    @Test

    public void badRegisterInput(){

        openURL(loginURL);
        click(registerSectionButton);
        click(registerButton);
        Assert.assertTrue(verifyMessageAppears(enterValidEmailMessage));
        Assert.assertEquals("rgba(246, 217, 219, 1)", getBackgroundColour(registerEmailField));
        Assert.assertEquals("rgba(246, 217, 219, 1)", getBackgroundColour(registerPasswordField));
        setField(registerEmailField, "invalid");
        waitIsClickable(registerButton);
        click(registerButton);
        Assert.assertTrue(verifyMessageAppears(enterValidEmailMessage));
        clear(registerEmailField);
        setField(registerPasswordField, validPassword);
        click(registerButton);
        Assert.assertTrue(verifyMessageAppears(enterValidEmailMessage));
        setField(registerEmailField, validRegisterEmail);
        setField(registerPasswordField, "invalid");
        waitIsClickable(registerButton);
        click(registerButton);
        Assert.assertTrue(verifyMessageAppears(userExistsMessage));

    }

    @Test

    public void registerTest(){

        register();
        Assert.assertTrue(isLoginSuccessful());
        logout();
    }

    @Test

    public void forgotPassword(){

        openURL(loginURL);
        click(forgotPasswordLink);
        waitIsVisible(forgotPasswordEmail);
        click(cancelForgotPassword);
        click(forgotPasswordLink);
        waitIsVisible(forgotPasswordEmail);
        click(closeForgotPassword);
        click(forgotPasswordLink);
        waitIsVisible(forgotPasswordEmail);
        setField(forgotPasswordEmail, "invalid");
        click(sendForgotPassword);
        Assert.assertEquals("rgba(246, 217, 219, 1)", getBackgroundColour(forgotPasswordEmail));
        clear(forgotPasswordEmail);
        setField(forgotPasswordEmail, "notregistered@mail.com");
        click(sendForgotPassword);
        waitIsVisible(notRegisteredPopupOK);
        click(notRegisteredPopupOK);
        clear(forgotPasswordEmail);
        setField(forgotPasswordEmail, validforgotPasswordEmail);
        click(sendForgotPassword);
        waitIsClickable(forgotPassConfirmOK);
        click(forgotPassConfirmOK);
    }

    @Test

    public void resetPassword(){

        openResetEmail();
        click(submitNewPassButton);
        setField(newPasswordField, newValidPassword);
        click(submitNewPassButton);
        Assert.assertTrue(verifyPresent(fieldRequiredError));
        clear(newPasswordField);
        setField(confirmPasswordField, newValidPassword);
        click(submitNewPassButton);
        Assert.assertTrue(verifyPresent(fieldRequiredError));
        setField(newPasswordField, "notmatching");
        click(submitNewPassButton);
        Assert.assertTrue(verifyPresent(notMatchingPassError));
        clear(newPasswordField);
        setField(newPasswordField, newValidPassword);
        click(submitNewPassButton);
        Assert.assertTrue(isLoginSuccessful());
    }



}





