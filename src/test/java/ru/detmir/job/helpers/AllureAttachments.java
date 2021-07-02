package ru.detmir.job.helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;
import static ru.detmir.job.helpers.DriverUtils.getVideoUrl;

public class AllureAttachments {
    @Attachment(value = "{attachName} Text", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "{attachName} Screen", type = "image/png")
    public static byte[] addScreenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{attachName} Log", type = "text/plain")
    public static void addBrowserConsoleLogs() {
        attachAsText(
                "Browser console logs",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] addPageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    //    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
//    public static String addVideo(String sessionId) {
//        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
//                + getVideoUrl(sessionId)
//                + "' type='video/mp4'></video></body></html>";
//    }
//
    //@Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static void addVideo(String sessionId) {
        URL videoUrl = getVideoUrl(sessionId);
        if (videoUrl != null) {
            InputStream videoInputStream = null;
            sleep(1000);

            for (int i = 0; i < 10; i++) {
                try {
                    videoInputStream = videoUrl.openStream();
                    break;
                } catch (FileNotFoundException e) {
                    sleep(1000);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Allure.addAttachment("Video", "video/mp4", videoInputStream, "mp4");
        }
    }
}
