package UI;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    String url = "https://www.hepsiburada.com/";
    static WebDriver driver;

    @BeforeScenario
    public void senaryoOncesi() throws InterruptedException {
        System.out.println("============ Senaryo başlangıcı ============");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("============ ChromeDriver Çalıştı ============");
    }

    @AfterScenario
    public void senaryoSonrasi() {
        driver.quit();
        System.out.println("============ Senaryo sonu ============");
    }
}
