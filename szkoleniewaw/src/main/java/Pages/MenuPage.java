package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BasePage {
    @FindBy(linkText = "Basic")
    private WebElement basicMenu;

    @FindBy(id = "form-item")
    private WebElement formSubmenu;

    public MenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openForm() {
        driver.get("http://automation-practice.emilos.pl");
        basicMenu.click();
        formSubmenu.click();
    }
}
