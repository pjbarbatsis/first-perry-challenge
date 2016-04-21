import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Peeta on 4/20/2016.
 */
public class MediumTest {

    private WebDriver driver = new FirefoxDriver();
    private final String SITE_URL = "C:\\Users\\Peter\\Downloads\\automation_challenge_1.html";

    @Test
    public void firstMediumTest() {
        driver.get(SITE_URL);
        System.out.println(driver.findElement(By.xpath(".//*[@id='Medium']/p[2]")).getText());
        driver.close();
    }

    @Test
    public void secondMediumTest() {
        driver.get(SITE_URL);
        driver.findElement(By.xpath(".//*[@id='Medium']/p[3]/input")).click();
        driver.findElement(By.xpath(".//*[@id='Medium']/p[3]")).click();
        driver.close();
    }

    @Test
    public void thirdMediumTest() {
        driver.get(SITE_URL);
        driver.findElement(By.xpath(".//*[@id='Medium']/p[4]/a")).click();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
        driver.close();
    }
}
