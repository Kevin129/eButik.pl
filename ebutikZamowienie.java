package eButik;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ebutikZamowienie {
    @Test
    public void shop() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ebutik.pl/");
        driver.manage().window().maximize();

        WebElement bieliznaLink = driver.findElement(By.linkText("Bielizna"));
        bieliznaLink.click();

        WebElement bieliznaNocnaLink = driver.findElement(By.linkText("Bielizna nocna"));
        bieliznaNocnaLink.click();

        WebElement pizamaNocnaLink = driver.findElement(By.linkText("Czarny wiskozowy komplet nocny z koszulą i majtkami"));
        pizamaNocnaLink.click();

        WebElement rozmiarLink = driver.findElement(By.className("select_button"));
        rozmiarLink.click();

        WebElement button = driver.findElement(By.id("projector_button_basket"));
        button.click();


        WebElement przejdzDoKoszykaButton = driver.findElement(By.xpath("//a[contains(text(), 'Przejdź do koszyka')]"));
        przejdzDoKoszykaButton.click();

        WebElement przejdzDalej = driver.findElement(By.id("basket_go_next"));
        przejdzDalej.click();

        WebElement zamowBezRejestracji = driver.findElement(By.xpath("//a[contains(text(), 'Zamów bez rejestracji')]"));
        zamowBezRejestracji.click();

        WebElement imie = driver.findElement(By.id("client_firstname"));
        imie.sendKeys("Jan");

        WebElement nazwisko = driver.findElement(By.id("client_lastname"));
        nazwisko.sendKeys("Kowalski");

        WebElement adres = driver.findElement(By.id("client_street"));
        adres.sendKeys("Krakowska 129");

        WebElement kodPocztowy = driver.findElement(By.id("client_zipcode"));
        kodPocztowy.sendKeys("50-220");

        WebElement miasto = driver.findElement(By.id("client_city"));
        miasto.sendKeys("Wrocław");

        WebElement telefon = driver.findElement(By.id("client_phone"));
        telefon.sendKeys("123456789");

        WebElement zgoda = driver.findElement(By.id("terms_agree"));
        zgoda.click();

        WebElement email = driver.findElement(By.id("client_email"));
        email.sendKeys("jan700460@gmail.com");

        WebElement przejdz = driver.findElement(By.id("submit_clientnew_form"));
        przejdz.click();

        WebElement przelewZwykly = driver.findElement(By.id("simple_transfer_payment"));
        przelewZwykly.click();

        WebElement przejdzDoPlatnosci = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[5]/div/div/div[3]/div[3]/button"));
        przejdzDoPlatnosci.click();

        WebElement regulamin = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/form/div[5]/div/div/div[4]/div[1]/label/i"));
        regulamin.click();

        WebElement umowa = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/form/div[5]/div/div/div[4]/div[2]/label/i"));
        umowa.click();

        WebElement zamawiam = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/form/div[5]/div/div/div[5]/div/input"));
        zamawiam.click();
    }
}
