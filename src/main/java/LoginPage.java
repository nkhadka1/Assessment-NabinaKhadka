import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage{
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement Email() {
        return driver.findElement(By.id("input-email"));
    }

    private WebElement Password() {
        return driver.findElement(By.id("input-password"));
    }

    private WebElement Login() {
        return driver.findElement(By.cssSelector("input.btn"));
    }

    public void performLogin(String email, String password){
        Email().clear();
        Email().sendKeys(email);
        Password().clear();
        Password().sendKeys(password);
        Login().click();
    }

    public String getErrorMessage() {
        return driver.findElement(By.cssSelector("#account-login div.alert")).getText();
    }

}
