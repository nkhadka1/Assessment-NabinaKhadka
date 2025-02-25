import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage{
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement Username() {
        return driver.findElement(By.id("user-name"));
    }

    private WebElement Password() {
        return driver.findElement(By.id("password"));
    }

    private WebElement Login() {
        return driver.findElement(By.id("login-button"));
    }

    public void performLogin(String username, String password){
        Username().clear();
        Username().sendKeys(username);
        Password().clear();
        Password().sendKeys(password);
        Login().click();
    }

    public String getErrorMessage() {
        return driver.findElement(By.id("data-test")).getText();
    }

}
