package ru.detmir.job.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VacanciesPageTests extends BaseTest {

    @Test
    @DisplayName("Тест на проверку кнопки показа всех вакансий")
    void checkMoreVacanciesButton() {
        step("Open https://job.detmir.ru/", () -> {
            Selenide.open("https://job.detmir.ru/");
        });

        step("Перейти через левое меню в вакансии", () -> {
            $$("ul li a").findBy(text("Вакансии")).click();
        });

        step("Выбрать категорию вакансий 'Информационные технологии'", () -> {
            $$(".vacancies-link").findBy(text("Информационные технологии")).click();
        });

        step("Больше вакансий - нажать на кнопку 'показать еще'", () ->
                $("div .vacancies-more__show-more").scrollIntoView(true).click());

        step("Проверить, что доступно более 11 вакансий на странице", () ->
                assertTrue($$(".vacancies-more-item__head").size() > 11,
                        "После кнопки 'Показать еще' отображается менее 11 вакансий на странице!"));
    }

    @Test
    @DisplayName("Тест фильтра по станции метро")
    void checkVacanciesPageMetroStationFilter() {
        step("Открыть страницу вакансий на сайте https://job.detmir.ru", () ->
                Selenide.open("https://job.detmir.ru/vacancies/"));

        step("Выбрать метро - Окружная (МЦК)", () -> {
            $("#subway").$(".subway__input").val("Окружная");
            $(byText("Окружная (МЦК)")).click();
            $("#subway").$(".subway__input").shouldHave(value("Окружная (МЦК)"));
        });

        step("Проверить, что есть хотя бы одна вакансия после выбора метро", () ->
                assertTrue($$(".vacancies-more-item__head").size() > 1,
                        "После фильтрации по метро отображается меньше 1 вакансии на странице!"));
    }

    @Test
    @DisplayName("Тест вакансии ведущего тестировщика по автоматизации")
    void checkAutomationQAVacancy() {
        step("Открыть страницу вакансий на сайте https://job.detmir.ru", () ->
                Selenide.open("https://job.detmir.ru/vacancies/"));

        step("Выбрать категорию ИТ", () ->
                $$(".vacancies-link").findBy(text("Информационные технологии")).click());

        step("Выбрать 3 страницу вакансий", () ->
                $(".vacancies-more-pagination__link", 2).click());

        step("Найти вакансию ведущего тестировщика по автоматизации", () ->
                $$(".vacancies-more-item__name").findBy(text("Automation QA")).click());

        step("Проверить, что в требованиях есть Selenide", () ->
                $(withText("Наш стек: Java 16, Selenide, Rest Assured")).shouldBe(visible));

        step("Проверить, что зарплата = 350т", () ->
                $(".vacancy-detail__price").shouldHave(text("до 350000 ₽ до вычета налогов")));
    }
}