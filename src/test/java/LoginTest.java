import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.WebDriver;

public class LoginTest extends SetupTest {

    //Send data for testing
    @DataProvider
    public Iterator<Object[]> getLoginData() {
        List<Object[]> LoginData = new ArrayList<>();
        LoginData.add(new Object[]{"john.doe@gmail.com", "Adn12", false});      //Valid Email and Invalid Password
        LoginData.add(new Object[]{"abcdefg@gmail.com", "Admin123", false});    //Invalid Email and Valid Password
        LoginData.add(new Object[]{"", "", false});                             //Empty fields
        LoginData.add(new Object[]{"john.doe@gmail.com", "Admin123", true});    //Valid Email and Password
        return LoginData.iterator();
    }

    @Test(dataProvider = "getLoginData")
    public void TestLogin (String email, String password,boolean isValidUser){

        // access the LambdaTest Login Page
        driver.navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.performLogin(email, password);

        if (!isValidUser) {
            assertEquals(loginPage.getErrorMessage(), "Invalid Login. Please check for the credentials.");
        } else {
            HomePage home = new HomePage(this.driver);
            assertEquals(HomePage.getPageTitle(), "My Account");
        }
    }
}