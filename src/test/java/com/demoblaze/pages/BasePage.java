package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


public void getLink (String link){// we need link text
     Driver.getDriver().findElement(By.partialLinkText(link));
     //we choose partial cause some link text has space

}




}
