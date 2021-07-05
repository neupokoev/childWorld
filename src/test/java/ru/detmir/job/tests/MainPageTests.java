package ru.detmir.job.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.detmir.job.helpers.DriverUtils;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTests extends BaseTest {
    @Test
    @Description("Page title test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://job.detmir.ru/'", () ->
                open("https://job.detmir.ru/"));

        step("Page title should have text 'Работа в детском мире -'", () -> {
            String expectedTitle = "Работа в детском мире -";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Console should not have errors test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://job.detmir.ru/'", () ->
                open("https://job.detmir.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}