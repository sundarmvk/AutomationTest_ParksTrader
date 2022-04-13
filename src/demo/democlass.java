package demo;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class democlass {

public static void main(String[] args) throws InterruptedException {
 
  //WebDriverManager.chromedriver().setup();
  System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe"); 
  WebDriver driver=new ChromeDriver();
  String URL="http://automationpractice.com/index.php";
  
  // Open URL and Maximize browser window
  driver.get(URL);
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

  //Click on Sign in
  driver.findElement(By.linkText("Sign in")).click();
  //Login
  driver.findElement(By.id("email")).sendKeys("sundartest@test.com");
  driver.findElement(By.id("passwd")).sendKeys("@yDzYPA4XzkAeTP");
  driver.findElement(By.id("SubmitLogin")).click();
  
  //Search and Select the Cheapest Printed Summer Dress
  WebElement searchbox = driver.findElement(By.id("search_query_top"));
  searchbox.sendKeys("Printed Summer Dress");
  searchbox.submit();
  
//Check if Printed Summer Dress results are available
  String results = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/h1/span[2]")).getText();
  if (results.length() != 0) {
	  
	  System.out.println("Passed."+results+ "for Printed Summer Dress");
  } 
  else {
	  System.out.println("Failed."+results+ "for Printed Summer Dress");
	 driver.quit();
  }
  // Select Cheapest Price from drop down
  Select cheapestprice=new Select(driver.findElement(By.id ("selectProductSort")));
  cheapestprice.selectByVisibleText("Price: Lowest first");
  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img")).click(); 
 
  //Change quantity by 2
  driver.findElement(By.id("quantity_wanted")).clear();
  driver.findElement(By.id("quantity_wanted")).sendKeys("2");

  //Select size as M
  WebElement Sizedrpdwn=driver.findElement(By.xpath("//*[@id='group_1']"));
  Select oSelect=new Select(Sizedrpdwn);
  oSelect.selectByVisibleText("M");

  //Search and Select for Color Green
   String colourname =driver.findElement(By.xpath("/html/body/div/div[2]/div/div[4]/div/div/div/div[4]/form/div/div[2]/div/fieldset[2]/div/ul/li[1]/a")).getAttribute("title");
   if (colourname.equals("Green")) {
		  System.out.println("Passed for "+colourname+ " Colour");
	  } 
   else {
		  System.out.println("Failed. Green Colour Not Found");
		  driver.quit();
	  }
   driver.findElement(By.id("color_15")).click();
  
  //Click on add to cart
  driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
  
  //Click on proceed
  driver.findElement(By.xpath("/html//div[@id='layer_cart']//a[@title='Proceed to checkout']/span")).click();

   //Checkout page Proceed
  String totalprice = driver.findElement(By.id("total_price")).getText();
  String pricecompare ="$34.80";
 
    if (totalprice.equals(pricecompare)) {
	  System.out.println("Price Validation Successful.Total Price at Check Out is "+totalprice);
  } else {
	  System.out.println("Price Validation failed.Total Price at Check Out is "+totalprice);
  }
   
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();
  //Agree terms&Conditions
  driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")).click();

  //Click on Payby Check
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();
  
  //Confirm the order
  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();

  //Get Text
  String ConfirmationText=driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();
  
  // Verify that Product is ordered
  if(ConfirmationText.contains("complete")) {
	  
   System.out.println("Order Completed: Test Case Passed");
  }
  else {
	  
   System.out.println("Order Not Successfull: Test Case Failed");
  }
 
 }

private static void assertequals(java.lang.String testtotalprice, java.lang.String testprice) {
	// TODO Auto-generated method stub
	
}

private static void assertEquals(java.lang.String string2, WebElement price1, java.lang.String totalprice) {
	// TODO Auto-generated method stub
	
}
}
