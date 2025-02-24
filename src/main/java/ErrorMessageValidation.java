import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErrorMessageValidation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //redirect to demo website called SauceDemo
        driver.navigate().to("https://www.saucedemo.com/");

        // Webelement to find webelements and send data into it
        WebElement UserName = driver.findElement(By.id("user-name"));
       // UserName.sendKeys("standard_user"); //Valid Username
      UserName.sendKeys("randomname"); //InValid Username
        
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("secret_sauce"); //Valid Password
//   Password.sendKeys("random"); //InValid Password

        WebElement Login = driver.findElement(By.id("login-button"));
        Login.click();

        //Check for login
        if(driver.getCurrentUrl().contains("inventory.html")){
            System.out.println("Login successful. The Current URL is " + driver.getCurrentUrl());
        }
        else {
            System.out.println("Login failed. The Current URL is " + driver.getCurrentUrl());
            WebElement ErrorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
            String DisplayedErrorMessage = ErrorMessage.getText();

            String ExpectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";


            if(DisplayedErrorMessage.equals(ExpectedErrorMessage)) {
                System.out.println("Error Message is Validated");
            }
            else{
                System.out.println("Error Message Validation Failed");
            }
        }

    }


}
