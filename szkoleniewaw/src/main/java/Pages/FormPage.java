package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class FormPage extends BasePage{

    @FindBy(id = "inputFirstName3")
    private WebElement firstName;

    @FindBy(id = "inputLastName3")
    private WebElement lastName;

    @FindBy(id = "inputEmail3")
    private WebElement email;

    @FindBy(id = "inputAge3")
    private WebElement age;

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> sexRbts;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> experienceRbts;

    @FindBy(id = "gridCheckManulTester")
    private WebElement manualTesterProffesion;

    @FindBy(id = "selectContinents")
    private WebElement continents;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumCommands;

    @FindBy(css = "button[type='submit']")
    private WebElement submit;

    @FindBy(id = "validator-message")
    private WebElement resultMessage;

    @FindBy(id = "chooseFile")
    private WebElement chooseFile;

    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public FormPage setPersonDetails(String name, String lastName, String age) {
        firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        this.age.sendKeys(age);
        return this;
    }

    public FormPage setEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public FormPage selectRandomSex() {
        getRandomElement(sexRbts).click();
        return this;
    }


    public FormPage selectRandomExperience() {
        getRandomElement(experienceRbts).click();
        return this;
    }

    public FormPage selectRandomContinent() {
        Select continentsSelect = new Select(continents);
        continentsSelect.selectByIndex(getRndNumber(continentsSelect.getOptions().size()));
        return this;
    }

    public FormPage selectRandomCommand() {
        Select seleniumCommandsSelect = new Select(seleniumCommands);
        seleniumCommandsSelect.selectByIndex(getRndNumber(seleniumCommandsSelect.getOptions().size()));
        return this;

    }

    public FormPage setFile(String path) {
        chooseFile.sendKeys(path);
        return this;
    }

    public FormPage submit() {
        submit.click();
        return this;
    }

    public FormPage selectManualTester() {
        manualTesterProffesion.click();
        return this;
    }

    public String getResultMsg() {
        return resultMessage.getText();
    }

    private WebElement getRandomElement(List<WebElement> elements) {
        Random rand = new Random();
        return elements.get(rand.nextInt(elements.size() - 1));
    }

    private int getRndNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max - 1);
    }
}
