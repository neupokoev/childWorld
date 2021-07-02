# Автотесты на страницу https://job.detmir.ru/vacancies/

## Используемые технологии и инструменты

<a href="https://www.jetbrains.com/idea/">
    <img src="https://starchenkov.pro/qa-guru/img/skills/Intelij_IDEA.svg" width="40" height="40"  alt="IDEA"/>
</a>
<a href="https://www.jetbrains.com/idea/">
    <img src="https://starchenkov.pro/qa-guru/img/skills/Java.svg" width="40" height="40"  alt="Java"/>
</a>
<a href="https://www.jetbrains.com/idea/">
    <img src="https://starchenkov.pro/qa-guru/img/skills/Selenide.svg" width="40" height="40"  alt="Seleide"/>
</a>
<a href="https://www.jetbrains.com/idea/">
    <img src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg" width="40" height="40"  alt="Selenoid"/>
</a>
<a href="https://www.jetbrains.com/idea/">
    <img src="https://starchenkov.pro/qa-guru/img/skills/Gradle.svg" width="40" height="40"  alt="Gradle"/>
</a>
<a href="https://www.jetbrains.com/idea/">
    <img src="https://starchenkov.pro/qa-guru/img/skills/JUnit5.svg" width="40" height="40"  alt="JUnit 5"/>
</a>
<a href="https://www.jetbrains.com/idea/">
    <img src="https://starchenkov.pro/qa-guru/img/skills/Allure_Report.svg" width="40" height="40"  alt="Allure SE"/>
</a>
<a href="https://www.jetbrains.com/idea/">
    <img src="https://starchenkov.pro/qa-guru/img/skills/Allure_EE.svg" width="40" height="40"  alt="Allure EE"/>
</a>
<a href="https://www.jetbrains.com/idea/">
    <img src="https://starchenkov.pro/qa-guru/img/skills/Github.svg" width="40" height="40"  alt="Github"/>
</a>
<a href="https://www.jetbrains.com/idea/">
    <img src="https://starchenkov.pro/qa-guru/img/skills/Jenkins.svg" width="40" height="40"  alt="Jenkins"/>
</a>
<a href="https://www.jetbrains.com/idea/">
    <img src="https://starchenkov.pro/qa-guru/img/skills/Rest-Assured.svg" width="40" height="40"  alt="ResrAssured"/>
</a>
<a href="https://www.jetbrains.com/idea/">
    <img src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg" width="40" height="40"  alt="Telegram"/>
</a>
<a href="https://www.jetbrains.com/idea/">
    <img src="https://starchenkov.pro/qa-guru/img/skills/Jira.svg" width="40" height="40"  alt="Jira"/>
</a>

IntelliJ IDEA, Java, Selenide, Selenoid, Gradle, JUnit5, Allure SE, Allure TestOps, Github, Jenkins, Telegram (notification).

## Список тестов (для примера) - хранение и анализ в Allure TestOps

##screen

## Используемые параметры по умолчанию для запуска через Jenkins <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Jenkins.svg" width="30" height="30"  alt="Jenkins"/></a>

* BROWSER (default chrome)
* BROWSER_VERSION (default 89.0)
* BROWSER_SIZE (default 1920x1080)
* REMOTE_DRIVER_URL (url address from selenoid or grid)
* THREADS (number of threads to run)
* ALLURE_NOTIFICATIONS_VERSION

Run tests with filled remote.properties:
```bash
gradle clean test
```

Run tests with not filled remote.properties:
```bash
gradle clean -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

Serve report:
```bash
allure serve build/allure-results
```

![alt "Запуск через Jenkins"](./src/test/resources/images/jenkinsRun.png "Запуск через Jenkins")

## Оповещение о результатах прохождения тестов через бот в телеграмме <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg" width="30" height="30"  alt="Telegram"/></a>

![alt "бот в телеграмме"](./src/test/resources/images/bot.png "бот в телеграмме")

## Анализ результатов в Jenkins через Allure Reports
![alt "Allure Reports"](./src/test/resources/images/jenkinsResult.png "Allure Reports")
## Анализ результатов в Allure TestOps <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Allure_EE.svg" width="40" height="40"  alt="Allure EE"/></a>
![alt "Allure TestOps"](./src/test/resources/images/allureTO1.png "Allure TestOps")
![alt "Allure TestOps"](./src/test/resources/images/allureTO2.png "Allure TestOps")
## Видео прохождения тестов, взятое из среды выполнения (из Selenoid) <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg" width="40" height="40"  alt="Selenoid"/></a>

![alt "Video from Selenoid"](./src/test/resources/images/Video.gif "Video from Selenoid")