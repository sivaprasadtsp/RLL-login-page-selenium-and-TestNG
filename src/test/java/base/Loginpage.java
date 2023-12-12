package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Loginpage {
	
	
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//li[@id='Registration Desk']")
	WebElement inpatient;
	
	@FindBy(xpath="//input[@type = 'submit']")
	WebElement loginbtn;
	
	
	
	
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void user_login(String u,String p)
	{
		
		username.sendKeys(u);
		password.sendKeys(p);
		inpatient.click();
		loginbtn.click();
	}
	
	
	

	
}
