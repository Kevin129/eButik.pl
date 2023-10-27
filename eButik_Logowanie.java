package eButik;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class eButik_Logowanie {

    @Test
    public void logowanie () {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ebutik.pl/");
        driver.manage().window().maximize();

        //Kliknij zaloguj
        driver.findElement(By.className("fixtop-hidden")).click();

        //Wpisz login
        driver.findElement(By.id("user_login")).sendKeys("Jan700460@gmai.com");

        //Wpisz Hasło
        driver.findElement(By.id("user_pass")).sendKeys("Hasło1234");

        //Kliknij zagloguj
        driver.findElement(By.className("signin_button")).click();

        Assert.assertTrue(driver.findElement(By.className("return_label"))
                .getText().equals("Podany login lub hasło nie jest poprawne."));

    }
}
