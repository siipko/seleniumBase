package Slider;

import Base.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

@Execution(ExecutionMode.CONCURRENT)
public class SliderTests extends BaseTest {

    @Test
    public void moveSliderTest() {
        driver.get("http://automation-practice.emilos.pl/slider.php");
        moveTo(50);
        moveTo(20);
        moveTo(20);
        moveTo(80);
    }

    public void moveTo(int moveTo) {
        WebElement sliderHandle = driver.findElement(By.id("custom-handle"));
        int sliderValue = Integer.parseInt(sliderHandle.getText());
        if (sliderValue > moveTo) {
            sendArrow(sliderHandle, Keys.ARROW_LEFT, Math.abs(sliderValue - moveTo));
        } else if (sliderValue < moveTo) {
            sendArrow(sliderHandle, Keys.ARROW_RIGHT, Math.abs(sliderValue - moveTo));
        }
    }

    public void sendArrow(WebElement sliderHandle, Keys key, int n) {
        for (int i = 0; i < n; i++) {
            sliderHandle.sendKeys(key);
        }
    }
}
