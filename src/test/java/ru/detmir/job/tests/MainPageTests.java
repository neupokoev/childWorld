package ru.detmir.job.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.detmir.job.helpers.DriverUtils;

import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTests extends BaseTest {
    @Test
    @DisplayName("Проверка свойства title главной страницы")
    void titleTest() {
        step("Open url 'https://job.detmir.ru/'", () ->
                Selenide.open("https://job.detmir.ru/"));

        step("Свойство title главной страницы сайта job должно быть равно 'Работа в детском мире -'", () -> {
            String expectedTitle = "Работа в детском мире -";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Console log на главной странице не должна содержать ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://job.detmir.ru/'", () ->
                Selenide.open("https://job.detmir.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}