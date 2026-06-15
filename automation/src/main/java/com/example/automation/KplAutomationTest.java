package com.example.automation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class KplAutomationTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // Tulis nama device/emulator Anda (bebas, bawaan default biasanya Android Emulator)
        options.setDeviceName("Android Emulator");

        // SESUAIKAN: Ganti dengan jalur absolut tempat Anda menyimpan file APK hasil build tadi!
        options.setApp("D:/Muadz/Kuliah/Semester 6/PBM/UasKplApp/app/build/outputs/apk/debug/app-debug.apk");

        // options.setAppWaitForLaunchDelay(Duration.ofSeconds(10));

        // Menghubungkan ke Appium Server lokal
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void testLoginKosong() {
        WebElement btnLogin = driver.findElement(AppiumBy.id("com.example.uaskplapp:id/btnLogin"));
        btnLogin.click();

        WebElement tvError = driver.findElement(AppiumBy.id("com.example.uaskplapp:id/tvErrorMessage"));
        Assert.assertEquals(tvError.getText(), "Username dan Password wajib diisi!");
    }

    @Test(priority = 2)
    public void testLoginGagal() {
        WebElement etUsername = driver.findElement(AppiumBy.id("com.example.uaskplapp:id/etUsername"));
        WebElement etPassword = driver.findElement(AppiumBy.id("com.example.uaskplapp:id/etPassword"));
        WebElement btnLogin = driver.findElement(AppiumBy.id("com.example.uaskplapp:id/btnLogin"));

        etUsername.sendKeys("salah_user");
        etPassword.sendKeys("12345");
        btnLogin.click();

        WebElement tvError = driver.findElement(AppiumBy.id("com.example.uaskplapp:id/tvErrorMessage"));
        Assert.assertEquals(tvError.getText(), "Username atau Password salah!");
    }

    @Test(priority = 3)
    public void testLoginSukses() {
        WebElement etUsername = driver.findElement(AppiumBy.id("com.example.uaskplapp:id/etUsername"));
        WebElement etPassword = driver.findElement(AppiumBy.id("com.example.uaskplapp:id/etPassword"));
        WebElement btnLogin = driver.findElement(AppiumBy.id("com.example.uaskplapp:id/btnLogin"));

        etUsername.clear();
        etUsername.sendKeys("admin");
        etPassword.clear();
        etPassword.sendKeys("admin123");
        btnLogin.click();

        // Verifikasi apakah berhasil masuk ke halaman DashboardActivity
        WebElement tvWelcome = driver.findElement(AppiumBy.id("com.example.uaskplapp:id/tvWelcomeUser"));
        Assert.assertTrue(tvWelcome.getText().contains("Halo, admin!"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}