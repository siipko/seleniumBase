import Base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleTest extends BaseTest {

    @Test
    public void googleTest() {
        String nameToFind = "Robert Lewandowski";
        driver.get("https://www.google.com/");
        WebElement searchInput =
                driver.findElement(By.cssSelector("input[title='Szukaj']"));
        searchInput.sendKeys(nameToFind + Keys.ENTER);
        WebElement searchResults = driver.findElement(By.cssSelector(".gsmt > span"));
        Assertions.assertEquals(nameToFind, searchResults.getText());
    }
}
