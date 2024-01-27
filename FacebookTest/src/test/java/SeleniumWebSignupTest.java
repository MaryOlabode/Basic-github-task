import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {

//import the selenium WebDriver
    private WebDriver driver;

@BeforeTest
public void start () throws InterruptedException {
//locate where the chromedriver is
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver-win64/chromedriver-win64/chromedriver.exe");
    //1. Open your chrome browser
    driver = new ChromeDriver();
    //2. Input your Selenium Demo Page URL (https://selenium.blog.herokuapp.com)
    driver.get("https://selenium.blog.herokuapp.com");
    // Test1. Verify the user input the right url and his on the right webpage
    if(driver.getCurrentUrl().contains("https://selenium.blog.herokuapp.com"))
        //Pass
        System.out.println("Correct Webpage");
    else
        //fall
    System.out.println("Wrong Webpage");
    Thread.sleep(5000);
    //3. Maximise the browser
    driver.manage().window().maximize();
    //4. Click on Signup button to open the Signup page
    driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
    Thread.sleep(5000);
}

    @Test (priority = 0)
    public void positiveSignup() throws InterruptedException {
        // Test7. Verify that user is successfully signed up when valid details are inputted
        //5. Input your username on the username field
        // driver.findElement(By.id("user_username")).sendKeys("mary05");
        //6. Input your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("mary05@mailinator.com");
        //7. Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("testify");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
     public void clickUser1item() throws InterruptedException {
        //9. Click on user1 item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        // Test2. Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct Webpage");
        else
            //fall
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void verifyitem() throws InterruptedException {
        //10. Search for an item (Using python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        //Test9. Verify that the item searched for on the User1 page is present
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct User1page");
        else
            //fall
            System.out.println("Wrong User1page");
        Thread.sleep(5000);
    }

    @Test (priority = 3)
     public void logoutSuccessfully() {
        //11. Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test10. Verify that when user logout he or she is directed back to the homepage
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedTitle))
            //Pass
            System.out.println("Correct Webpage");
        else
            //fall
            System.out.println("Wrong Webpage");
    }

    @Test (priority = 4)
    public void negativeSignup() throws InterruptedException {
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        // Test3. Verify that user cannot signup with username less than 3 characters
        //5. Input your username on the username field
        // driver.findElement(By.id("user_username")).sendKeys("ma");
        //6. Input your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("mary04@mailinator.com");
        //7. Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("testify");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

   @AfterTest
   public void closeBrowser(){
       //Quit the browser
       driver.quit();
   }


}
