import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Created by Peeta on 4/20/2016.
 */
public class HardTest {

    private WebDriver driver = new FirefoxDriver();
    private final String SITE_URL = "C:\\Users\\Peter\\Downloads\\automation_challenge_1.html";

    @Test
    // Finds the URL, finds the body of the image, forces a save, then checks last modified file in downloads folder.
    public void firstHardTest() throws AWTException {
        String fileName = "d47e4394374f3434e84e167bcd2d409d";
        String downloadPath = "C:\\Users\\Peter\\Downloads";
        driver.get(SITE_URL);
        driver.findElement(By.xpath(".//*[@id='Hard']/p[1]/a")).click();
        driver.findElement(By.xpath("xhtml:html/xhtml:body/xhtml:img")).sendKeys(Keys.CONTROL, "s");
        //Robots are useful for navigating the OS.
        Robot object = new Robot();
        // Uncomment the last four Robot commands if you already have this file downloaded.
        object.keyPress(KeyEvent.VK_ENTER);
        object.keyRelease(KeyEvent.VK_ENTER);
        // object.keyPress(KeyEvent.VK_LEFT);
        // object.keyRelease(KeyEvent.VK_LEFT);
        // object.keyPress(KeyEvent.VK_ENTER);
        // object.keyRelease(KeyEvent.VK_ENTER);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted!");
        }
        File getLatestFile = getLatestFilefromDir(downloadPath);
        String downloadedFileName = getLatestFile.getName();
        System.out.println(downloadedFileName + " = " + getLatestFile.getName());
        Assert.assertTrue("Last modified file is not the one you want!", (getLatestFile.getName()).equals(downloadedFileName));
    }

    /** Gets document name based on last action performed in the specified folder.
     * Code from http://www.seleniumeasy.com/selenium-tutorials/verify-file-after-downloading-using-webdriver-java
     *
     * @param dirPath the folder you specify
     * @return a File object that represents the last modified file
     */
    private File getLatestFilefromDir(String dirPath){
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    @Test
    public void secondHardTest() {
        driver.get(SITE_URL);
        driver.findElement(By.xpath(".//*[@id='Hard']/p[2]/input")).click();
        driver.switchTo().alert().accept();

        // This is something I tried that did not work, for posterity.
        /*try {
            driver.findElement(By.cssSelector("Body")).sendKeys(Keys.ESCAPE);
        } catch (UnhandledAlertException e) {
            driver.switchTo().alert().accept();
        }*/
    }

    @Test
    public void thirdHardTest() {
        driver.get(SITE_URL);
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath(".//*[@id='Hard']/ul/li/a"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath(".//*[@id='Hard']/ul/li/ul/li[2]/a"))).click();

    }
}
