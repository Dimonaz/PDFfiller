/**
 * Created by Dimonaz on 20.05.2015.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static testpackage.ObjectRepository.*;
import static testpackage.PageObject.*;


public class pMailTest {

    @Before

    public void initialize(){

        open();

    }

    @After

    public void finish(){

        //close();
    }

    @Test

    public void Test1() {

        login(paidUserEmail, paidUserPassword);
        click(myAccountLink);
        waitIsVisible(manageAccLabel);
        click(AccInfoTab);
        waitIsVisible(pMailRadio);
        Assert.assertTrue(verifySelected(pMailRadio));
        click(myFormsLink);
        waitIsInvisible(loadingSign);
        Assert.assertTrue(verifyDisplayed(pMailBtn));
        click(pMailBtn);
        waitIsVisible(pMailLabel);

    }
}
