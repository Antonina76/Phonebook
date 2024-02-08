package com.phonebook.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {
    //log in
    @BeforeMethod
    public void precondition() {
        if(!isLoginLinkPresent()){
            clickOnSignOutButton();
        }

        clickOnLoginLink();

        fillLoginRegisterForm(new User().setEmail("mail@ap-d.com").setPassword("Manuel1234$"));
        //click on Registration button
        clickOnLoginButton();
    }

    @Test
    public void addNewContactPositiveTest() {
        //click Add link

        clickOnAddLink();
        //Enter name
        fillContactForm("Karl", "Adam", "1234567890", "adam@gm.com", "Berlin", "goalkeeper");
        clickOnSaveButton();
        //assert contact is added by text
        Assert.assertTrue(isContactCreated("Karl"));
    }

    @AfterMethod
    public void postCondition(){
        removeContact();
    }

}
