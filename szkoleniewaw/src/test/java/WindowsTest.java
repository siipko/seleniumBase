import Base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class WindowsTest extends BaseTest {

    @Test
    public void windowsTest() {
        driver.get("http://automation-practice.emilos.pl/windows-tabs.php");
        WebElement newBrowserWindow = driver.findElement(By.id("newBrowserWindow"));

        // open window
        newBrowserWindow.click();

        //wait for number of windows to be 2
        new WebDriverWait(driver, 20).until(ExpectedConditions.numberOfWindowsToBe(2));

        //get main window name
        String windowName = driver.getWindowHandle();

        System.out.println(windowName);
        for (String winHandle : driver.getWindowHandles()) {
            if (!windowName.equals(winHandle)) {
                //switch to 2nd window
                driver.switchTo().window(winHandle);
            }
        }

        //find element on 2nd window
        driver.findElement(By.cssSelector("tbody"));
        //close current window (2nd)
        driver.close();

        // switch back to 1st window
        driver.switchTo().window(windowName);

        //find element on 1st window
        driver.findElement(By.id("newMessageWindow"));

    }
}
