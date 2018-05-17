package test;

import annotations.TestName;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class test extends BaseTest {

    @Test
    @TestName(name="lol")

    public void test(){

        open("http://google.com");
        $(By.name("q")).shouldNotBe(Condition.visible);
        $(By.name("q")).setValue("selenide").pressEnter();

    }
}
