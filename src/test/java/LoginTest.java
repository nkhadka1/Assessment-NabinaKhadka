import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.testng.AssertJUnit.assertEquals;


public class LoginTest extends SetupTest {

    //Send data for testing
    @DataProvider
    public Iterator<Object[]> getLoginData() {
        List<Object[]> LoginData = new ArrayList<>();
        LoginData.add(new Object[]{"standard_user", "Adn12", false});      //Valid Username and Invalid Password
        LoginData.add(new Object[]{"abcdefg", "secret_sauce", false});    //Invalid Username and Valid Password
        LoginData.add(new Object[]{"", "", false});                             //Empty fields
        LoginData.add(new Object[]{"standard_user", "secret_sauce", true});    //Valid Username and Password
        return LoginData.iterator();
    }

    @Test(dataProvider = "getLoginData")
    public void TestLogin (String username, String password,boolean isValidUser){

        // access the LambdaTest Login Page
        
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(username, password);

        if (!isValidUser) {
            assertEquals(loginPage.getErrorMessage(), "Invalid Login. Please check for the credentials.");
        } else {
            HomePage home = new HomePage(driver);
            assertEquals(home.getPageTitle(), "Swag Labs");
        }
    }
}