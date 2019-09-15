package automationTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {
	/*By ProductName=By.xpath("//*[@class='_3wU53n']");
	By ProductName2=By.xpath("//*[@class='_2cLu-l']");
	public static void main(String[] args) throws InterruptedException {
		new Flipkart().main();
	}*/

	public static void main(String args[]) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//System.setProperty("webdriver.chrome.driver", "F:\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		WebDriver driver =new ChromeDriver(options);

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File file = new File("Login.properties");
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("URL ::" + prop.getProperty("URL"));
		System.out.println("User name::" +prop.getProperty("username"));
	    System.out.println("Password::" +prop.getProperty("password"));
		driver.get("https://www.flipkart.com/");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//body/div[2]/div/div/button")).click();
		List<WebElement>li=driver.findElements(By.xpath("//li/span"));
		
		//li/ul/li/a
		for(WebElement l:li)
		{
			System.out.println(l.getText());
		}
		WebElement element = driver.findElement(By.xpath("//li/span"));
		 
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        String xpath="(//ul/li/a)";
		List<WebElement>l1=driver.findElements(By.xpath("(//ul/li/a)"));
		int i=0;
		for(WebElement l:l1)
		{i++;
		
 
        action.moveToElement(element).build().perform();
			try {
				driver.findElement(By.xpath(xpath+"["+i+"]"+"/span"));
				System.err.println(driver.findElement(By.xpath(xpath+"["+i+"]")).getAttribute("textContent"));
			}catch(Exception e) {
				System.out.println(i+"---"+driver.findElement(By.xpath(xpath+"["+i+"]")).getAttribute("textContent"));
			}
			
			
			//System.out.println(i+++"---xpath---"+l.toString());
		}
		/*List<WebElement>l2=driver.findElements(By.xpath("//li/ul/li/ul/li/ul/li/a/span"));
		int j=0;
		for(WebElement l:l2)
		{
			System.out.println(j+++"---"+l.getText());
		}*/
		//li/ul/li/ul/li/ul/li/a[1]
		
		//(//ul/li/a)[]/span
		int j=0;
		for(WebElement l:l1)
		{
			j++;
			action.moveToElement(element).build().perform();
			try {
				driver.manage().window().maximize();
				driver.findElement(By.xpath(xpath+"["+j+"]"+"/span"));
				Thread.sleep(3000);
				System.err.println(driver.findElement(By.xpath(xpath+"["+j+"]")).getAttribute("textContent"));
			}catch(Exception e) {
				Thread.sleep(5000);
				driver.findElement(By.xpath(xpath+"["+j+"]")).click();
				Thread.sleep(3000);
				
				
				int p=1;
				int page=1;
				boolean b = false;
				while(!b)
				{
					//List<WebElement> n = driver.findElements(By.xpath("//div[3]/div[2]/div/div/div[2]/div"));
					List<WebElement> n = driver.findElements(ProductName);
					//String url1="(//div[3]/div[2]/div/div/div[2]/div)";
					//String url2="//div[3]/div/div";
				if(n.size()==0)
				{
					n=driver.findElements(ProductName2);
				}
				for(WebElement el:n)
				{
					
					
					
					//body/div/div/div[3]/div[2]/div/div/div[2]/div
					try {
					//System.out.println(driver.findElement(By.xpath(url1+"["+m+"]"+url2)).getAttribute("textContent"));
					String s=el.getAttribute("textContent");
						System.out.println(s);
					try(FileWriter fw = new FileWriter("result.txt", true);
						    BufferedWriter bw = new BufferedWriter(fw);
						    PrintWriter out = new PrintWriter(bw))
						{
						    out.println(s);
						    //more code
						   // out.println("more text");
						    //more code
						} catch (IOException e3) {
						    //exception handling left as an exercise for the reader
						}
						System.out.println(p);
					p++;
					}
					catch(Exception c) 
					{
						//List<WebElement> n1 = driver.findElement(By.xpath(url1+"["+m+"]"+"/div/div/nav/a/span"));
						 //div/div/nav/a
						
					//body/div/div/div[3]/div[2]/div/div/div[2]/div)[26]//div/div/nav/a/span
						/*for(int a=1;a<=n1.size();a++) 
						{
							driver.findElement(By.xpath(url1+"["+a+"]"+"/div/div/nav/a/span")).click();
							if(a==n1.size())
							{
								b=!b;
							}
						}*/
						/*JavascriptExecutor js = (JavascriptExecutor) driver;  
						js.executeScript("window.scrollTo(0,document.body.scrollHeight)");*/
						
						System.out.println("ERROR");
						
					    //p++;
						/*catch (Exception v)
						{
							System.out.println("COMPLETED");
							b=!b;
							break;
						}*/
						
					}
					
				}
				try
				{
				driver.findElement(By.xpath("//a/span[contains(text(),'Next')]")).click();
				System.err.println("Page "+(++page)+" is clicked");
				Thread.sleep(3000);
				}
				catch(Exception e2)
				{
					System.out.println("completed");
					b=!b;
				}
				}
				
				//break;
				
				//nav/a
				
			}
			
			
			
		}
		driver.quit();

	}

}
