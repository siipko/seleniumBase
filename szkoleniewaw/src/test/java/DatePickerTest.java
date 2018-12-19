import Base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

@Execution(ExecutionMode.CONCURRENT)
public class DatePickerTest extends BaseTest {

    @Test
    public void datePickerTest() {
        driver.get("http://automation-practice.emilos.pl/datepicker.php");
        moveTo(LocalDate.now());
        moveTo(LocalDate.of(2018, Month.NOVEMBER, 30));
        moveTo(LocalDate.of(2017, Month.OCTOBER, 05));
        moveTo(LocalDate.of(2017, Month.NOVEMBER, 05));
        moveTo(LocalDate.of(2017, Month.NOVEMBER, 05));
        moveTo(LocalDate.of(2018, Month.JANUARY, 01));
    }

    public void moveTo(LocalDate date) {
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.click();
        LocalDate desiredYearAndMonth = LocalDate.of(date.getYear(), date.getMonth(), 1);
        LocalDate currentYearAndMonth = getCurrentYearAndMonth();

        while (!desiredYearAndMonth.equals(currentYearAndMonth)) {
            if (desiredYearAndMonth.isAfter(currentYearAndMonth)) {
                goNext();
            } else if (desiredYearAndMonth.isBefore(currentYearAndMonth)) {
                goPrev();
            }
            currentYearAndMonth = getCurrentYearAndMonth();
        }
        int day = date.getDayOfMonth();
        int month = date.getMonthValue() - 1;
        WebElement dayToSelect = driver.findElement(
                By.xpath("//td[@data-month='" + month + "']//a[text()='" + day + "']"));
        dayToSelect.click();
        sleep();
        Assertions.assertEquals(date, getDateFromDatePickerInput());
    }


    public LocalDate getDateFromDatePickerInput() {
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        return LocalDate.parse(datePicker.getAttribute("value"),
                DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

    public void goNext() {
        sleep();
        driver.findElement(By.cssSelector("span[class$='triangle-e']")).click();
    }

    public void goPrev() {
        sleep();
        driver.findElement(By.cssSelector("span[class$='triangle-w']")).click();
    }

    private LocalDate getCurrentYearAndMonth() {
        Month currentMonth = Month.valueOf(driver.findElement(By.cssSelector("div .ui-datepicker-month"))
                .getText().toUpperCase());
        int currentYear = Integer.valueOf(driver.findElement(By.cssSelector("div .ui-datepicker-year")).getText());
        return LocalDate.of(currentYear, currentMonth, 1);
    }

    public void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
