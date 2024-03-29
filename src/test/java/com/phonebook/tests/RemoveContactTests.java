package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.utils.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    //precondition: log in and add contact
@BeforeMethod
    public void precondition(){
    if(!app.getUser().isLoginLinkPresent()){
        app.getUser().clickOnSignOutButton();
    }
    app.getUser().clickOnLoginLink();
    app.getUser().logIn();
    app.getUser().clickOnLoginButton();
    app.getContact().clickOnAddLink();

    app.getContact().fillContactForm(new Contact().setName(ContactData.NAME)
            .setLastName(ContactData.LASTNAME)
            .setPhone(ContactData.PHONE)
            .setEmail(ContactData.EMAIL)
            .setAdress(ContactData.ADDRESS)
            .setDeskription(ContactData.DESC));
    //click on save button
    app.getContact().clickOnSaveButton();

}

    @Test
    public void removeContactTest(){
    int sizeBefore = app.getContact().sizeOfContacts();
    app.getContact().removeContact();
app.getContact().pause(1000);
    int sizeAfter= app.getContact().sizeOfContacts();
    Assert.assertEquals(sizeAfter,sizeBefore-1);
}

}
