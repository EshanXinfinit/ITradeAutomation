package pageObjects;

import base.baseSetup;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

public class loggedInPage {
    WebDriver driver = baseSetup.driver;

    public String setName() throws InterruptedException {
        driver.findElement(By.xpath("(//div[@class='c-dropdown'])[1]")).click();
        driver.findElement(By.xpath("//i[@class='icom icom-pencil']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(260));
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("ESHAN2");
        driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Submit')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='c-dropdown'])[1]")).click();
        String nName = driver.findElement(By.xpath("//p[@class='has-ellipsis']")).getText();
        return nName;
    }

    public void setPic() throws InterruptedException, AWTException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//button[@data-toggle='dropdown'])[2]")).click();
        Thread.sleep(2500);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[@ng-click='vm.onclickCamera()']/i")));

        //StringSelection filepath = new StringSelection("/Users/upload.png");
        File file = new File("/Users/upload.png");
        StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
        //Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = new Robot();

// Cmd + Tab is needed since it launches a Java app and the browser looses focus

        robot.keyPress(KeyEvent.VK_META);

        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyRelease(KeyEvent.VK_META);

        robot.keyRelease(KeyEvent.VK_TAB);

        robot.delay(500);

//Open Goto window

        robot.keyPress(KeyEvent.VK_META);

        robot.keyPress(KeyEvent.VK_SHIFT);

        robot.keyPress(KeyEvent.VK_G);

        robot.keyRelease(KeyEvent.VK_META);

        robot.keyRelease(KeyEvent.VK_SHIFT);

        robot.keyRelease(KeyEvent.VK_G);

//Paste the clipboard value

        robot.keyPress(KeyEvent.VK_META);

        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_META);

        robot.keyRelease(KeyEvent.VK_V);

//Press Enter key to close the Goto window and Upload window

        robot.keyPress(KeyEvent.VK_ENTER);

        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(500);

        robot.keyPress(KeyEvent.VK_ENTER);

        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
//Test comment
