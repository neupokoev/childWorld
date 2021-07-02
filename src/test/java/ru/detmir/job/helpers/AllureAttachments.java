package ru.detmir.job.helpers;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static com.codeborne.selenide.Selenide.sleep;
import static ru.detmir.job.helpers.Logging.LOGGER;

public class AllureAttachments {

    @Attachment(value = "{attachName}", type = "text/plain")
    private static String addMessage(String attachName, String text) {
        return text;
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static void addBrowserConsoleLogs() {
        addMessage("Browser console logs", DriverUtils.getConsoleLogs());
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] addScreenshotAs(String attachName) {
        return DriverUtils.getScreenshotAsBytes();
    }

    @Attachment(value = "Page source", type = "text/html")
    public static byte[] addPageSource() {
        return DriverUtils.getPageSourceAsBytes();
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static void addVideo(String sessionId) {
        URL videoUrl = DriverUtils.getVideoUrl(sessionId);
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
                    LOGGER.warn("[ALLURE VIDEO ATTACHMENT ERROR] Cant attach allure video, {}", videoUrl);
                    e.printStackTrace();
                }
            }
            Allure.addAttachment("Video", "video/mp4", videoInputStream, "mp4");
        }
    }
}
