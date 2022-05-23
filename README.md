# qa_guru_5_24_final_project
# Автотесты на http://github.com :woman_technologist:

![Intelij_IDEA](src/test/resources/files/icons/Intelij_IDEA.png)![Java](src/test/resources/files/icons/Java.png)![Selenide](src/test/resources/files/icons/Selenide.png)![Selenoid](src/test/resources/files/icons/Selenoid.png)![Gradle](src/test/resources/files/icons/Gradle.png)![JUnit5](src/test/resources/files/icons/JUnit5.png)![Allure Report](src/test/resources/files/icons/Allure_Report.png)![AllureTestOps](src/test/resources/files/icons/AllureTestOps.png)![Github](src/test/resources/files/icons/Github.png)![Jenkins](src/test/resources/files/icons/Jenkins.png)![Rest-Assured](src/test/resources/files/icons/Rest-Assured.png)![Telegram](src/test/resources/files/icons/Telegram.png)![Jira](src/test/resources/files/icons/Jira.png)

IntelliJ IDEA, Java, Selenide, Selenoid, Gradle, JUnit5, Allure Report, Allure TestOps, Github, Jenkins, Rest-Assured,
Telegram (reports), Jira.

## Реализованы проверки:
В реализации использованы разные подходы проектирования, позволяющие достичь разного представления в отчетах
### UI
- [X] - Авторизация пользователя с неверным паролем
- [X] - Поиск репозитория через поисковую строку
- [X] - Поиск раздела Issue в репозитории
- [X] - Открытие вкладки team
- [X] - Открытие страницы shop
### API
- [X] - Создание репозитория
- [X] - Изменение названия репозитория
- [X] - Удаление репозитория
- [X] - Поиск репозитория до и после создания
- [X] - Создание Issue
- [X] - Редактирование Issue
- [X] - Блокировка Issue

### Команда для запуска из терминала
Локально должны быть заданы параметры в local.properies, app.properties
```
gradle clean
```
Для запуска в несколько потоков
```
gradle clean -Dthreads=5
```
### Видео о прохождении тестов
![Selenoid](src/test/resources/files/Selenoid.gif)

### Запуск в Jenkins
Статистика по запускам
![Jenkins](src/test/resources/files/Jenkins_1.png)
Указание параметров для запуска
![Jenkins](src/test/resources/files/Jenkins_2.png)

### Отчёт в Allure Report
![Allure](src/test/resources/files/AllureReport.png)

### Хранение тест-кейсов в Allure TestOps
Ручные и автотесты
![Allure](src/test/resources/files/AllureTestOps_3.png)
Дашборд
![Allure](src/test/resources/files/AllureTestOps_4.png)
Ланчи
![Allure](src/test/resources/files/AllureTestOps_5.png)
Результат запуска ланча
![Allure](src/test/resources/files/AllureTestOps_1.png)

### Интерграция с Jira
Отображение тест-кейсов и ланча
![Jira](src/test/resources/files/Jira.png)

### Уведомления в Telegram
![Telegram](src/test/resources/files/Telegram.png)