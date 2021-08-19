package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NavigationMenu extends AbstractUIObject {

    @FindBy(xpath="//div[@id= 'nav-xshop']/a[contains(text(), 'Deals')]")
    public ExtendedWebElement dealsBtn;

    @FindBy(xpath="//div[@id= 'nav-xshop']/a[contains(text(), 'Service')]")
    public ExtendedWebElement customerServiceBtn;

    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    public void openDealsPage(){
        WebElement element = driver.findElement(By.xpath("//div[@id= 'nav-xshop']/a[contains(text(), 'Deals')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click();
        dealsBtn.click();
    }

    public void openCustomerServicePage(){
        customerServiceBtn.click();
    }
}
