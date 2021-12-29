package com.hermes.sinfo.crawler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Crawler {

    private WebDriver driver;
    private WebElement element;

    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static Path path = FileSystems.getDefault().getPath("");
    public static String directoryName = path.toAbsolutePath().toString();
    public static String WEB_DRIVER_PATH = directoryName + "/chromedriver";

    private String base_url;

    public Crawler() {

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formatedNow = now.format(formatter);
        base_url = "http://data.krx.co.kr/contents/MDC/MDI/mdiLoader/index.cmd?menuId=MDC0201020303";

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver(options);

        driver.get(base_url);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cal-area")));

        element = driver.findElement(By.name("endDd"));
        element.clear();
        element.sendKeys(formatedNow);
        element = driver.findElement(By.name("strtDd"));
        element.clear();
        element.sendKeys(formatedNow);

    }

    public void SetMarket(){
        element = driver.findElement(By.cssSelector("#MDCSTAT024_FORM > div.search_tb > div > table > tbody > tr:nth-child(1) > td > label:nth-child("+ Market.values() +")"));
        element.click();
    }
}
