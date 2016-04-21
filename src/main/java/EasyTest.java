import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Peeta on 4/20/2016.
 */

public class EasyTest {

    private WebDriver driver = new FirefoxDriver();
    private final String SITE_URL = "C:\\Users\\Peter\\Downloads\\automation_challenge_1.html";

    @Test
    public void firstTest() {
        driver.get(SITE_URL);
        Assert.assertTrue("Text not found!", driver.getPageSource().contains("pongify"));
        driver.close();
    }

    @Test
    public void secondTest() {
        driver.get(SITE_URL);
        Select select = new Select(driver.findElement(By.xpath(".//*[@id='dropdown']")));
        select.selectByVisibleText("Artiferous");
        WebElement option = select.getFirstSelectedOption();
        Assert.assertTrue("Incorrect selection!", option.getText().equals("Artiferous"));
        driver.close();
    }

    @Test
    public void thirdTest() {
        driver.get(SITE_URL);
        driver.findElement(By.xpath(".//*[@id='button-click']/input")).click();
        driver.close();
    }

    @Test
    public void fourthTest() {
        driver.get(SITE_URL);
        driver.findElement(By.xpath(".//*[@id='input-entry']/input")).sendKeys("fuck you");
        driver.close();
    }

}
