package test;

import annotations.TestName;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PageHeader;
import utils.BaseTest;

import static com.codeborne.selenide.Selenide.getJavascriptErrors;
import static com.codeborne.selenide.Selenide.refresh;

public class test2 extends BaseTest {

    @Test
    @TestName(name="lol")

    public void test(){

        HomePage home = HomePage.Instance;

        home.open();
        PageHeader.openSilverMatress();
        System.out.println("!!!!!!!" + getJavascriptErrors());

    }
}
