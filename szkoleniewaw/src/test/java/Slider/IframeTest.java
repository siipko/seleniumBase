package Slider;

import Base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IframeTest extends BaseTest {

    @Test
    public void verifyIframes(){
        driver.get("http://automation-practice.emilos.pl/iframes.php");

        WebElement shortFormIframe = driver.findElement(By.name("iframe1"));
        driver.switchTo().frame(shortFormIframe);
        driver.findElement(By.id("inputFirstName3")).sendKeys("test");

        driver.switchTo().parentFrame();
        WebElement extendFormIframe = driver.findElement(By.name("iframe2"));
        driver.switchTo().frame(extendFormIframe);
        driver.findElement(By.id("inputLogin")).sendKeys("test");
    }
}
