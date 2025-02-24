import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public  WebDriver driver;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(By.cssSelector("#content h2")).getText();
    }
}

