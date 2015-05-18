import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static testpackage.PageObject.*;
import static testpackage.LoginPageObjectRepository.*;
import static testpackage.HomePageObjectRepository.*;

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

        close();
    }

    @Test

    public void verifyPageElements() {

        openURL(loginURL);
        Assert.assertTrue(verifyPresent(logo));
        Assert.assertTrue(verifyPresent(loginLabel));
        Assert.assertTrue(verifyPresent(registerButton));
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

            public void badInput(){

        openURL(loginURL);
        click(loginButton);
        Assert.assertTrue(verifyMessageAppears(enterValidEmailMessage));
        Assert.assertEquals("rgba(246, 217, 219, 1)", getBackgroundColour(emailField));
        Assert.assertEquals("rgba(246, 217, 219, 1)", getBackgroundColour(passwordField));


        //Assert.assertTrue(isLoginSuccessful());

    }


}





