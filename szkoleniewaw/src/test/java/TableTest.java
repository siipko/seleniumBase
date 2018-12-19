import Base.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Execution(ExecutionMode.CONCURRENT)
public class TableTest extends BaseTest {
    @Test
    public void tableTest() {
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            WebElement col = row.findElement(By.cssSelector("td:nth-of-type(4)"));
            if (Integer.parseInt(col.getText()) > 4000) {
                System.out.println(row.getText());
            }
        }
    }
}
