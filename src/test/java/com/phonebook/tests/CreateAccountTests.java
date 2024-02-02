package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewAccountPositiveTest() {
        //click on Login Link
        driver.findElement(By.cssSelector("[href='/login']")).click();

        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("mail@ap-d.com");
        // enter password
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Manuel1234$");
        driver.findElement(By.name("registration")).click();
               //click on Registration button
        Assert.assertTrue(isElementPresent(By.cssSelector("button")));
    }



// assert Sign Out button is present


}
