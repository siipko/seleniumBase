import Base.BaseTest;
import Pages.FormPage;
import Pages.MenuPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FormTests extends BaseTest {

    @Test
    public void fillFormTest() {
        File photo = new File("src\\main\\resources\\image.png");
        
        MenuPage menuPage = new MenuPage(driver);
        menuPage.openForm();

        FormPage formPage = new FormPage(driver);
        formPage.setPersonDetails("Jan", "Kowalski", "10")
                .setEmail("jan.kowalski@wp.pl")
                .selectRandomSex()
                .selectRandomExperience()
                .selectRandomContinent()
                .selectRandomCommand()
                .selectManualTester()
                .setFile(photo.getAbsolutePath())
                .submit();
        Assertions.assertEquals("Form send with success", formPage.getResultMsg());
    }
}
