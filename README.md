# Автотесты API на http://github.com 🚀👨‍💻🚀

## Содержание:

1. [Технологии и инструменты](#технологии)
2. [Реализованные проверки](#описание)
3. [Запуск тестов](#запуск_тестов)
4. [Сборка в Jenkins](#дженкинс)
5. [Отчёт в Allure Report](#аллюр)
6. [Главный экран отчета Allure TestOps](#аллюр_тестопс)
7. [Интерграция с Jira](#джира)
8. [Уведомления в Telegram](#телеграм)

<a name="технологии"></a>
## Технологии и инструменты

![Intelij_IDEA](src/test/resources/files/icons/Intelij_IDEA.png)![Java](src/test/resources/files/icons/Java.png)![Selenide](src/test/resources/files/icons/Selenide.png)![Selenoid](src/test/resources/files/icons/Selenoid.png)![Gradle](src/test/resources/files/icons/Gradle.png)![JUnit5](src/test/resources/files/icons/JUnit5.png)![Allure Report](src/test/resources/files/icons/Allure_Report.png)![AllureTestOps](src/test/resources/files/icons/AllureTestOps.png)![Github](src/test/resources/files/icons/Github.png)![Jenkins](src/test/resources/files/icons/Jenkins.png)![Rest-Assured](src/test/resources/files/icons/Rest-Assured.png)![Telegram](src/test/resources/files/icons/Telegram.png)![Jira](src/test/resources/files/icons/Jira.png)

IntelliJ IDEA, Java, Selenide, Selenoid, Gradle, JUnit5, Allure Report, Allure TestOps, Github, Jenkins, Rest-Assured,
Telegram (reports), Jira.

```mermaid        
    stateDiagram-v2
        State1: Начало
        State2: Java & IntelliJ IDEA & Rest-Assured
        State3: Selenide & JUnit5
        State4: Gradle
        State5: GitHub
        State6: Jenkins
        State7: Selenoid & Docker
        State8: Allure Report & Allure TestOps
        State9: Telegram report
        State10: Конец
        State1 --> State2
        State2 --> State3
        State3 --> State4
        State4 --> State5
        State5 --> State6
        State6 --> State7
        State7 --> State8
        State8 --> State9
        State9 --> State10
```

<a name="описание"></a>
## Реализованы проверки:
- [X] - Создание репозитория
- [X] - Изменение названия репозитория
- [X] - Удаление репозитория
- [X] - Поиск репозитория до и после создания
- [X] - Создание Issue
- [X] - Редактирование Issue
- [X] - Блокировка Issue

<a name="запуск_тестов"></a>
### Команда для запуска из терминала
Локально должны быть заданы параметры в local.properies, app.properties
```
gradle clean test
```
Удаленный запуск:
```
clean
test
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView="${BROWSER_MOBILE}"
-DremoteDriverUrl=https://${USER}:${PASSWORD}@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/
-Dthreads=${THREADS}
```
<a name="дженкинс"></a>
### Запуск в Jenkins
Статистика по запускам
https://jenkins.autotests.cloud/job/011-Alex-11-13-Github_API/
![Jenkins](src/test/resources/files/Jenkins_1.png)

<a name="аллюр"></a>
### Отчёт в Allure Report
![Allure](src/test/resources/files/AllureReport.png)

<a name="аллюр_тестопс"></a>
### Главный экран отчета Allure TestOps
![Allure](src/test/resources/files/AllureTestOps_3.png)

<a name="джирас"></a>
### Интерграция с Jira
Отображение тест-кейсов и ланча
![Jira](src/test/resources/files/Jira.png)

<a name="телеграм"></a>
### Уведомления в Telegram
![Telegram](src/test/resources/files/Telegram.png)
