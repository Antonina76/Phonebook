package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    //precondition: log in and add contact
@BeforeMethod
    public void precondition(){
    if(!isLoginLinkPresent()){
        clickOnSignOutButton();
    }
    clickOnLoginLink();
    fillLoginRegisterForm(new User().setEmail("mail@ap-d.com").setPassword("Manuel1234$"));
    //click on Registration button
    clickOnLoginButton();
    clickOnAddLink();
    //Enter name
    fillContactForm("Karl", "Adam", "1234567890", "adam@gm.com", "Berlin", "goalkeeper");
    //click on save button
    clickOnSaveButton();

}
@Test
    public void removeContactTest(){
    int sizeBefore = sizeOfContacts();
    removeContact();
pause(1000);
    int sizeAfter=sizeOfContacts();
    Assert.assertEquals(sizeAfter,sizeBefore-1);
}

}
