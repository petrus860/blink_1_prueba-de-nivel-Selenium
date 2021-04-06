package stepImplementations;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.*;

public class BDDLoginTest {

    WebDriver driver;
    WebElement putLoginEmail, putLoginPass, waitBlinkElement;



    @Given("el usuario abre el browser")
    public void elUsuarioAbreElBrowser() {
        System.out.println("User is on the login page");
    //        open driver
        driver = utilities.DriverFactory.open("firefox");
//        driver = utilities.DriverFactory.open("chrome");
        driver.get("https://www.blinklearning.com/login");
    }


    @When("el usuario ingresa el correo electronico {string}")
    public void elUsuarioIngresaElCorreoElectronico(String emailId) {
        System.out.println("Testing" + emailId);
        putLoginEmail = new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
        putLoginEmail.sendKeys(emailId);
    }

    @And("el usuario ingresa la contrasena {string}")
    public void elUsuarioIngresaLaContrasena(String password) {
        putLoginPass = new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@name,'contrasena')]")));
        putLoginPass.sendKeys(password);

    }

    @And("click at the login boton")
    public void clickAtTheLoginBoton() {
//    driver.findElement(By.xpath("//button[contains('Iniciar sesión')]")).click();
    }

    @Then("obtenemos la confirmacion de que se ha logueado")
    public void obtenemosLaConfirmacionDeQueSeHaLogueado() {
                System.out.println("User gets confirmation");
//                Como no tengo usuario real, no puedo hacer los asserts --> confirmacion
        waitBlinkElement = new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(By.xpath
                        ("//div[@class='v-toolbar__title'][contains(.,'Blink')]")));
        Assert.assertTrue(waitBlinkElement.getText().contains("Blink"));

    }

    @And("cerrar el browser el terminar las prueba")
    public void cerrarElBrowser() {
        driver.close();
    }
}
