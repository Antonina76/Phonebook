package com.phonebook.tests;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {
    //log in
    @BeforeMethod
    public void precondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(new User().setEmail("mail@ap-d.com").setPassword("Manuel1234$"));
        //click on Registration button
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addNewContactPositiveTest() {
        //click Add link

        app.getContact().clickOnAddLink();
        //Enter name
        app.getContact().fillContactForm(new Contact().setName("Karl")
                .setLastName("Adam")
                .setPhone("1234567890")
                .setEmail("adam@gm.com")
                .setAdress("Berlin")
                .setDeskription("goalkeeper"));
        app.getContact().clickOnSaveButton();
        //assert contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }

}
