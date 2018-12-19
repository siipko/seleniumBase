package Slider;

import Base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class SliderWithAction extends BaseTest {

    @Test
    public void moveSliderWithActionsTest() {
        driver.get("http://automation-practice.emilos.pl/slider.php");
        WebElement handle = driver.findElement(By.id("custom-handle"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(handle);
        for (int i = 0; i < 10; i++) {
            actions.sendKeys(Keys.ARROW_RIGHT);
        }
        actions.release()
                .perform();
        Assertions.assertEquals(Integer.parseInt(handle.getText()), 10);

    }

    @Test
    public void moveSliderByPixelsTest() {
        driver.get("http://automation-practice.emilos.pl/slider.php");
        WebElement handle = driver.findElement(By.id("custom-handle"));
        int moveTo = 50;

        Actions actions = new Actions(driver);
        actions.clickAndHold(handle)
                .moveByOffset(calculateOffset(moveTo), 0)
                .release()
                .perform();
        Assertions.assertEquals(Integer.parseInt(handle.getText()), moveTo);
    }

    public int calculateOffset(int moveTo) {
        int sliderWidth = driver.findElement(By.id("slider")).getSize().width;
        return sliderWidth * moveTo / 100 - sliderWidth / 100;
    }


}
