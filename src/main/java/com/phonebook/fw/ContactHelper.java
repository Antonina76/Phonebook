package com.phonebook.fw;

import com.phonebook.fw.ApplicationManager;
import com.phonebook.fw.BaseHelper;
import com.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button "));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("input:nth-child(1)"), contact.getName());
        //Enter lastname
        type(By.cssSelector("input:nth-child(2)"), contact.getLastName());
        //Enter phone
        type(By.cssSelector("input:nth-child(3)"), contact.getPhone());
        //Enter email
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        //Enter address
        type(By.cssSelector("input:nth-child(5)"), contact.getAdress());
        //Enter description
        type(By.cssSelector("input:nth-child(6)"), contact.getDeskription());

    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = ApplicationManager.driver.findElements(By.cssSelector("h2"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text))
                return true;
            }
            return false;


        }

    public void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public int sizeOfContacts(){
    if(isElementPresent(By.cssSelector(" .contact-item_card__2SOIM"))){
        return  ApplicationManager.driver.findElements(By.cssSelector(" .contact-item_card__2SOIM")).size();
    }
    return 0;
}
}
