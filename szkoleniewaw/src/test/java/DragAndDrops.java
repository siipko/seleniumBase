import Base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class DragAndDrops extends BaseTest {

    @Test
    public void dragAndDropTest() {
        driver.get("http://automation-practice.emilos.pl/droppable.php");
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop)
                .perform();
        Assertions.assertEquals("Dropped!", drop.getText());
    }

    @Test
    public void holdAndDropTest() {
        driver.get("http://automation-practice.emilos.pl/droppable.php");
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag)
                .release(drop)
                .perform();
        Assertions.assertEquals("Dropped!", drop.getText());
    }

    @Test
    public void holdMoveAndDropTest() {
        driver.get("http://automation-practice.emilos.pl/droppable.php");
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .perform();
        Assertions.assertEquals("Dropped!", drop.getText());
    }

}
