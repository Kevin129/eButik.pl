package eButik;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Test
public class eButik_Rejestracja {

    public void rejestracja() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ebutik.pl/");
        driver.manage().window().maximize();

        //Kliknij załóż konto
        driver.findElement(By.linkText("załóż konto")).click();

        //Kliknij zarejestruj
        driver.findElement(By.xpath("//*[@id='signin-form_box_right']/div/div[1]/a")).click();

        String firstName = "Jan";
        String lastName = "Kowalski";

        //Zmienny email
        int randomNumber = (int) (Math.random() * 1000);
        String email = "Jan" + randomNumber + "@gmail.com";

        //Wypełnienie formularza
        driver.findElement(By.id("client_firstname")).sendKeys(firstName);
        driver.findElement(By.id("client_lastname")).sendKeys(lastName);
        driver.findElement(By.id("client_street")).sendKeys("Śliczna 20/30");
        driver.findElement(By.id("client_zipcode")).sendKeys("50-235");
        driver.findElement(By.id("client_city")).sendKeys("Warszawa");
        driver.findElement(By.id("client_phone")).sendKeys(generateRandomPhoneNumber());
        driver.findElement(By.id("client_email")).sendKeys(email);

        //Zaznaczenie Checkboxa
        driver.findElement(By.id("terms_agree")).click();

        //Kliknij przejdź dalej
        driver.findElement(By.id("submit_clientnew_form")).click();

        //Przejdź na swoje konto
        driver.findElement(By.className("fixtop-hidden")).click();

        // Pobierz tekst z nagłówka
        WebElement heading = driver.findElement(By.xpath("//*[@id='login_welcome']/h1"));
        String headingText = heading.getText();

        // Sprawdź, czy tekst zawiera imię i nazwisko
        Assert.assertTrue(headingText.contains(firstName));
        Assert.assertTrue(headingText.contains(lastName));


    }
    //Losowy nr telefonu
    public static String generateRandomPhoneNumber() {
        long min = 100_000_000; // Najmniejsza możliwa wartość
        long max = 999_999_999; // Największa możliwa wartość

        long randomPhone = min + (long) (Math.random() * (max - min + 1));
        return Long.toString(randomPhone);

    }
}
