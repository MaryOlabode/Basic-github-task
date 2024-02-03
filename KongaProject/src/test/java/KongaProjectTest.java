import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaProjectTest {

    //import the Konga webDriver
    private WebDriver driver;

@BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions() ;
        options.addArguments("--remote-allow-origins=*");
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your Chrome browser
        driver = new ChromeDriver(options);
    }
@Test(priority = 0)
    public void userSuccessfullyvisitKongaURL() throws InterruptedException {
        //Visit the Konga URL
        driver.get("https://www.konga.com/");
        // Test1. Verify that the user input the right url and it on the right page
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //pass
            System.out.println("Correct Konga Webpage URL");
        else
            //fail
            System.out.println("Wrong Konga Webpage URL");
        Thread.sleep(3000);
        //Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

@Test(priority = 1)
    public void userSuccessfullyLogin() throws InterruptedException {
        //Click on login button to open the login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        //Input your username on the username field
        driver.findElement(By.id("username")).sendKeys("");
        //Input your password on the password field
        driver.findElement(By.id("password")).sendKeys("");
        //Click on the login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);
        //Test2. Verify that when user click on the login button user is directed to the login page.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.konga.com";
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct login Url");
        else
            //faIl
            System.out.println("Wrong login Url");
        Thread.sleep(3000);
    }

@Test(priority = 2)
    public void computerAndAccessoriesIsPresent() throws InterruptedException {
        //From the Categories, click on the “Computers and Accessories”
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(3000);
        //Test3. Verify that "computers and accessories" is present on the category list
        String actualPageUrl = driver.getCurrentUrl();
        String expectedPageUrl = "https://www.konga.com/category/accessories-computing-5227";
        if (actualPageUrl.equals(expectedPageUrl))
            //pass
            System.out.println("Correct Page Url");
        else
            //fail
            System.out.println("Wrong Page Url");
        Thread.sleep(3000);

    }
@Test(priority = 3)
    public void LaptopSubCategoryispresent() throws InterruptedException {
        //From Computers and Accessories, "click on the Laptop SubCategory"
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(3000);
        //Test4. Verify that "laptop" is present on the subcategory list
        String actualPageUrl = driver.getCurrentUrl();
        String expectedPageUrl = "https://www.konga.com/category/accessories-computing-5227";
        if (actualPageUrl.equals(expectedPageUrl))
            //pass
            System.out.println("Correct Page Url");
        else
            //fail
            System.out.println("Wrong Page Url");
        Thread.sleep(3000);
    }
@Test(priority = 4)
        public void AppleMacBooksispresent() throws InterruptedException {
            //Click on the Apple MacBooks
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span")).click();
            Thread.sleep(3000);
            //Test 5 verify that "Apple MacBook is present"
            String actualPageUrl = driver.getCurrentUrl();
            String expectedPageUrl = "https://www.konga.com/category/accessories-computing-5227";
            if (actualPageUrl.equals(expectedPageUrl))
                //pass
                System.out.println("Correct Page Url");
            else
                //fail
                System.out.println("Wrong Page Url");
            Thread.sleep(3000);
        }

@Test(priority = 5)
    public void userSuccessfullyAddToCart() throws InterruptedException {
        //Get current cart size
        int cartSizeBeforeItemIsAdded = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[2]")).getText());
        //Add an item to the cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(3000);
        //Get Cart size after adding an item to cart
        int cartSizeAfterItemIsAdded = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[2]")).getText());
        Thread.sleep(3000);
        //Test6. Verify that on adding new product to the cart the count increases
        if (cartSizeAfterItemIsAdded > cartSizeBeforeItemIsAdded)
            //pass
            System.out.println("New Item added to cart");
        else
            //fail
            System.out.println("No Item added to cart");
        Thread.sleep(3000);
    }
@Test(priority = 6)
    public void usersuccessfullyselectaddress() throws InterruptedException {
        //Fill out correct address details for delivery
    driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section")).click();
    Thread.sleep(3000);
      //Test 7 Verify that user can successfully select an address
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.konga.com/checkout/complete-order"))
            System.out.println("address successfully added");
        else
            System.out.println("address unsuccessfully added");
    Thread.sleep(3000);

    }

@Test(priority = 7)
    public void userSuccessfullyEnterPayOutPage() throws InterruptedException {
        //Click "Pay Now" to enable “Continue to Payment” button - the user must have preselected pick up method
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(3000);
        //Test 8 Verify that user successfully enter payout page
        //click on continue to payment button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(3000);
        if (driver.getCurrentUrl().equals("https://www.konga.com/checkout/complete-order"))
            //pass
            System.out.println("User successfully enter payout page");
        else
            //fail
            System.out.println("User not successfully enter payout page");
        Thread.sleep(3000);
    }

@Test(priority = 8)
    public void userInputCardDetails() throws InterruptedException {
        //Select the “CARD” payment method
        WebElement checkOutFrame = driver.findElement(By.xpath("//*[@id='kpg-frame-component']"));
        driver.switchTo().frame(checkOutFrame);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button")).click();
        Thread.sleep(3000);
        //Input a wrong card number
        driver.findElement(By.id("card-number")).sendKeys("567398720003");
        //input a wrong date
        driver.findElement(By.id("expiry")).sendKeys("07/04");
        //input a wrong CVV
        driver.findElement(By.id("cvv")).sendKeys("234");
        //Click on the Field for entering card pin
        driver.findElement(By.id("card-pin-new")).sendKeys("2341665478903345");
        //Enter pin randomly
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[1]")).click();
        Thread.sleep(3000);
        //click second pin
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[1]")).click();
        //click third pin
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[3]")).click();
        //Click fourth pin
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[3]")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 9)
    public void userClickPayNow() throws InterruptedException {
        //click on pay now
        driver.findElement(By.id("validateCardForm")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 10)
    public void userPaymentUnsuccessfulWithWrongCardDetail() throws InterruptedException {
        //Test10. User cannot make successful payment with wrong card details and cannot move to next page
        //get current url after user click on Pay now
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.konga.com/checkout/complete-order"))
            System.out.println("Unsuccessful transaction");
        else
            System.out.println("Successful transaction");
        //Print out the error message for the card number field.
        System.out.println(driver.findElement(By.xpath("//*[@id='card-number_unhappy']")).getText());
        Thread.sleep(3000);
    }

    @Test(priority = 11)
    public void printOutInvalidCardNumber() throws InterruptedException {
        //Print out the error message for the card number field.
        String invalidCardErrorMessage = driver.findElement(By.xpath("//*[@id='card-number_unhappy']")).getText();
        //Test11. Card error message is correctly captured and printed on console
        if (invalidCardErrorMessage.equals("Invalid card number"))
            System.out.println("Card error message successfully captured");
        else
            System.out.println("Card error message not successfully captured");
        Thread.sleep(3000);
    }

    @Test(priority = 12)
    public void cardIframeClosedSuccessfully() throws InterruptedException {
        //Close the iFrame that displays the input card Modal
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void quitBrowser() {
        //Quit the browser.
        driver.quit();
    }



    }































































































