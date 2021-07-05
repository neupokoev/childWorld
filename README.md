# Автотесты на страницу https://job.detmir.ru/vacancies/
___
## Используемые технологии и инструменты
| GitHub | IntelliJ IDEA | Java | Gradle | Junit5 | Selenide |
|:------:|:----:|:----:|:------:|:------:|:--------:|
| <img src="images/GitHub.svg" width="40" height="40"> | <img src="images/IDEA.svg" width="40" height="40"> | <img src="images/JAVA.svg" width="40" height="40"> | <img src="images/Gradle.svg" width="40" height="40"> | <img src="images/Junit5.svg" width="40" height="40"> | <img src="images/Selenide.svg" width="40" height="40"> |

| Jenkins | Selenoid | Allure Report | Allure TestOps | Telegram |
|:--------:|:-------------:|:---------:|:-------:|:--------:|
| <img src="images/Jenkins.svg" width="40" height="40"> | <img src="images/Selenoid.svg" width="40" height="40"> | <img src="images/Allure Report.svg" width="40" height="40"> | <img src="images/Allure TestOps.svg" width="40" height="40"> | <img src="images/Telegram.svg" width="40" height="40"> |
___

## Список тестов (для примера) - хранение и анализ в Allure TestOps
![alt "Allure TestOps"](./images/allureTO1.png "Allure TestOps")

## 5 из 6 тестов ПАДАЮТ на данный момент из-за ошибок на сайте



## Используемые параметры по умолчанию для запуска через Jenkins <a href="https://www.jetbrains.com/idea/"><img src="./images/Jenkins.svg" width="30" height="30"  alt="Jenkins"/></a>

* BROWSER (default chrome)
* BROWSER_VERSION (default 89.0)
* BROWSER_SIZE (default 1920x1080)
* REMOTE_DRIVER_URL (url address from selenoid or grid)
* THREADS (number of threads to run)
* ALLURE_NOTIFICATIONS_VERSION

![alt "Запуск через Jenkins"](./images/jenkinsRun.png)

### Run tests with filled local.properties:

```bash
gradle clean test
```

### Run tests with not filled local.properties:

```bash
gradle clean -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

### Serve allure report:

```bash
allure serve build/allure-results
```

## Оповещение о результатах прохождения тестов через бот в телеграмме <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg" width="30" height="30"  alt="Telegram"/></a>

![alt "бот в телеграмме"](./images/bot.png "бот в телеграмме")

## Анализ результатов в Jenkins через Allure Reports
![alt "Allure Reports"](./images/jenkinsResult.png "Allure Reports")
## Анализ результатов в Allure TestOps <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Allure_EE.svg" width="40" height="40"  alt="Allure EE"/></a>

![alt "Allure TestOps"](./images/allureTO2.png "Allure TestOps")
## Видео прохождения тестов, взятое из среды выполнения (из Selenoid) <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg" width="40" height="40"  alt="Selenoid"/></a>

![alt "Video from Selenoid"](./images/Video.gif "Video from Selenoid")