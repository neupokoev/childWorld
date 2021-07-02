package ru.detmir.job.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.detmir.job.helpers.DriverUtils;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class ContentTests extends TestBase {
    @Test
    @Description("Content test")
    @DisplayName("Test на проверку кнопки показа всех вакансий")
    void checkVacanciesPageLazyLoad() {
        step("Open https://job.detmir.ru/", () -> {
            Selenide.open("https://job.detmir.ru/");
        });

        step("Перейти через левое меню в вакансии", () -> {
            $$("ul li a").findBy(text("Вакансии")).click();
        });

        step("Выбрать категорию ИТ", () -> {
            $$(".vacancies-link").findBy(text("Информационные технологии")).click();
        });

        step("Больше вакансий - нажать на кнопку \"показать больше\"", () -> {
            $("div .vacancies-more__show-more").scrollIntoView(true).click();
        });

        step("Проверить, что нет ошибок в консоли", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "500 (Internal Server Error)";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }


    @Test
    @Description("Content test")
    @DisplayName("Test фильтра по станции метро")
    void checkVacanciesPageMetroStationFilter() {
        step("Открыть страницу вакансий на сайте https://job.detmir.ru", () -> {
            Selenide.open("https://job.detmir.ru/vacancies/");
        });

        step("Выбрать метро - Окружная", () -> {
            $("#subway").$(".subway__input").val("Окружная");
            $(byText("Окружная (МЦК)")).click();
            $("#subway").$(".subway__input").shouldHave(value("Окружная (МЦК)"));
        });

        step("Проверить, что нет 500 ошибки в консоли", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "500 (Internal Server Error)";

            assertThat(consoleLogs).doesNotContain(errorText);
        });

    }

    @Test
    @Description("Content test")
    @DisplayName("Test вакансии ведущего тестировщика по автоматизации")
    void checkQAVacancy() {
        step("Открыть страницу вакансий на сайте https://job.detmir.ru", () -> {
            Selenide.open("https://job.detmir.ru/vacancies/");
        });

        step("Выбрать категорию ИТ", () -> {
            $$(".vacancies-link").findBy(text("Информационные технологии")).click();
        });

        step("Выбрать 3 страницу вакансий", () -> {
            $(".vacancies-more-pagination__link", 2).click();
        });

        step("Найти вакансию ведущего тестировщика по автоматизации", () -> {
            $$(".vacancies-more-item__name").findBy(text("Automation QA")).click();
        });

        step("Проверить, что в требованиях есть Selenide", () -> {
            $(withText("Наш стек: Java 16, Selenide, Rest Assured")).shouldBe(visible);
        });

        step("Проверить, что зп = 350т", () -> {
            $(".vacancy-detail__price").shouldHave(text("до 350000 ₽ до вычета налогов"));
        });
    }
}