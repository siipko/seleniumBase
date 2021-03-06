import Base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Execution(ExecutionMode.CONCURRENT)
public class AlertTests extends BaseTest {

    @BeforeEach
    public void openAlertPage(){
        driver.get("http://automation-practice.emilos.pl/alerts.php");
    }

//    @Test
//    public void simpleAlertTest(){
//        WebElement simpleAlertButton = driver.findElement(By.id("simple-alert"));
//        simpleAlertButton.click();
//        driver.switchTo().alert().accept();
//    }
//
//    @Test
//    public void promptAlertTest(){
//        WebElement simpleAlertButton = driver.findElement(By.id("prompt-alert"));
//        simpleAlertButton.click();
//        org.openqa.selenium.Alert alert = driver.switchTo().alert();
//        alert.sendKeys("Jan Kowalski");
//        alert.accept();
//    }

    @Test
    public void confirmAlertTest(){
        WebElement simpleAlertButton = driver.findElement(By.id("confirm-alert"));
        simpleAlertButton.click();
        driver.switchTo().alert().dismiss();
    }
}
