import Base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTests extends BaseTest {

    @Test
    public void fillFormTest() {
        driver.get("http://automation-practice.emilos.pl/form.php");

        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Jan");

        WebElement lastName = driver.findElement(By.id("inputLastName3"));
        lastName.sendKeys("Kowalski");

        WebElement email = driver.findElement(By.id("inputEmail3"));
        email.sendKeys("jan.kowalski@wp.pl");

        WebElement age = driver.findElement(By.id("inputAge3"));
        age.sendKeys("22");

        List<WebElement> sex = driver.findElements(By.cssSelector("input[name='gridRadiosSex']"));
        getRandomElement(sex).click();

        List<WebElement> yearsOfExperience = driver.findElements(By.cssSelector("input[name='gridRadiosExperience']"));
        getRandomElement(yearsOfExperience).click();

        WebElement file = driver.findElement(By.id("chooseFile"));

        File photo = new File("src\\main\\resources\\image.png");
        file.sendKeys(photo.getAbsolutePath());

        WebElement manualTester = driver.findElement(By.id("gridCheckManulTester"));
        manualTester.click();

        WebElement continents = driver.findElement(By.id("selectContinents"));
        Select continentsSelect = new Select(continents);
        continentsSelect.selectByIndex(getRndNumber(continentsSelect.getOptions().size()));

        WebElement seleniumCommands = driver.findElement(By.id("selectSeleniumCommands"));
        Select seleniumCommandsSelect = new Select(seleniumCommands);
        seleniumCommandsSelect.selectByIndex(getRndNumber(seleniumCommandsSelect.getOptions().size()));

        WebElement signIn = driver.findElement(By.cssSelector("button[type='submit']"));
        signIn.click();

        WebElement resultMsg = driver.findElement(By.id("validator-message"));
        Assertions.assertEquals("Form send with success", resultMsg.getText());
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        Random rand = new Random();
        return elements.get(rand.nextInt(elements.size() - 1));
    }

    public int getRndNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max - 1);
    }
}
