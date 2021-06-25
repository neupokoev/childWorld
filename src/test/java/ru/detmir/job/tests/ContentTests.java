package ru.detmir.job.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ContentTests extends TestBase {
    @Test
    @Description("Content test")
    @DisplayName("Test на проверку кнопки показа всех вакансий")
    void checkVacanciesPageLazyLoad() {
        step("Open https://job.detmir.ru/", () -> {
            Selenide.open("https://job.detmir.ru/");
        });

        step("Перейти через левое меню в вакансии", () -> {
            step("// todo: just add selenium action");
        });

        step("Выбрать категорию ИТ", () -> {
            step("// todo: just add selenium action");
        });

        step("Больше вакансий - нажать на кнопку \"показать больше\"", () -> {
            step("// todo: just add selenium action");
        });

        step("Проверить, что пришёл ответ 200", () -> {
            step("// todo: just add selenium action");
        });
    }


    @Test
    @Description("Content test")
    @DisplayName("Test фильтра по станции метро")
    void checkVacanciesPageMetroStationFilter() {
        step("Открыть страницу вакансий на сайте https://job.detmir.ru", () -> {
            Selenide.open("https://job.detmir.ru/vacancies/");
        });

        step("Выбрать категорию ИТ", () -> {
            step("// todo: just add selenium action");
        });

        step("Выбрать метро - Окружная", () -> {
            step("// todo: just add selenium action");
        });

        step("Проверить, что пришёл ответ 200", () -> {
            step("// todo: just add selenium action");
        });

    }

    @Test
    @Description("Content test")
    @DisplayName("Test вакансии ведущего тестировщика")
    void checkQAVacancy() {
        step("Открыть страницу вакансий на сайте https://job.detmir.ru", () -> {
            Selenide.open("https://job.detmir.ru/vacancies/");
        });

        step("Перейти через левое меню в вакансии", () -> {
            step("// todo: just add selenium action");
        });


        step("Выбрать 3 страницу", () -> {
            step("// todo: just add selenium action");
        });

        step("Найти вакансию ведущего тестировщика", () -> {
            step("// todo: just add selenium action");
        });

        step("Проверить, что в требованиях есть Selenide", () -> {
            step("// todo: just add selenium action");
        });

        step("Проверить, что зп = 350т", () -> {
            step("// todo: just add selenium action");
        });
    }
}