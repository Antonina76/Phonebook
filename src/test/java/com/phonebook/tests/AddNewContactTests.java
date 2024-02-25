package com.phonebook.tests;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.utils.ContactData;
import com.utils.DataProviders;
import com.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;


public class AddNewContactTests extends TestBase {
    //log in
    @BeforeMethod
    public void precondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        //click on Registration button
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addNewContactPositiveTest() {
        //click Add link

        app.getContact().clickOnAddLink();
        //Enter name
        app.getContact().fillContactForm(new Contact().setName(ContactData.NAME)
                .setLastName(ContactData.LASTNAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAdress(ContactData.ADDRESS)
                .setDeskription(ContactData.DESC));
        app.getContact().clickOnSaveButton();
        //assert contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated(ContactData.NAME));
    }

    @Test(dataProvider = "addNewContact",dataProviderClass = DataProviders.class)
    public void addNewContactPositiveTestDataProvider(String name, String lastName, String phone, String adress,String desc,String email ) {

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastName(ContactData.LASTNAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAdress(ContactData.ADDRESS)
                .setDeskription(ContactData.DESC));
        app.getContact().clickOnSaveButton();
        //assert contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated(ContactData.NAME));
    }

    @Test(dataProvider = "addNewContactFromCSV",dataProviderClass = DataProviders.class )
    public void addNewContactPositiveTestDataProviderWithCSV(Contact contact ) {

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
        //assert contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated(contact.getName()));
    }
    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }

}
