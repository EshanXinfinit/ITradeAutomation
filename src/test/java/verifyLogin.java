import base.baseSetup;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.landingPage;
import pageObjects.loggedInPage;

import java.awt.*;

public class verifyLogin extends baseSetup {
    baseSetup base= new baseSetup();
    landingPage land;
    loggedInPage loggedin;
    @BeforeTest
    public void initDriver(){
        base.setup();

    }
    @Test(priority = 0)
    public void verifyLanding(){
        land= new landingPage();
        Assert.assertEquals(land.navToItrade(),"mycharts - Home");
    }
    @Test(priority = 1,dependsOnMethods = {"verifyLanding"})
    public void verifyNavLogin(){
        Assert.assertEquals(land.clickLogin(),"Log in to mycharts");
    }
    @Test(priority = 2,dependsOnMethods = {"verifyLanding"})
    public void verifyLogin() throws InterruptedException {
        Assert.assertTrue(land.login().contains("Watch List"));
    }
    @Test(priority = 3, dependsOnMethods = {"verifyLogin"})
    public void verifyname() throws InterruptedException {
        loggedin = new loggedInPage();
        Assert.assertEquals(loggedin.setName(), "ESHAN2");
    }
    @Test(priority=4)
    public void setPic() throws InterruptedException, AWTException {
        loggedInPage loggedin = new loggedInPage();
        loggedin.setPic();
    }

    @AfterClass
    public void closeDriver(){
        base.tearDown();
    }
}
