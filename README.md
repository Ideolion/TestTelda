# TestTelda

Тестовое задание для программистов Java: Создать приложение используя Spring Boot реализующее справочник регионов
(свойства: идентификатор, наименование, сокращённое наименование), предоставляющее REST-API на чтение и изменение
справочника, справочник должен храниться в БД в качестве ORM необходимо использовать MyBatis. Преимуществом будет
использование Spring Cache. Использовать встроенные БД и сервер приложений.<br>

Проект выполнен на spring Boot, сборщик Maven, c использованием базы даннных h2database и MyBatis.

Для запуска проекта необходимо:
- в папке проекта выполнить команду mvn clean install, затем mvn spring-boot:run
- с помощью Postman или другим удобным способом отправить запросы по адресу http://localhost:8080/catalog/regions
следующего вида:
- Для создания элемента справочника POST запрос на http://localhost:8080/catalog/regions вида:<br>
 {<br>
"id":1,<br>
"regionfullname": "Ленинградская область",<br>
"regionshortname":"LED"<br>
}<br>
- Для получения всех регионов из справочника - GET запрос на http://localhost:8080/catalog/regions
- Для получения региона по номеру id - GET запрос на http://localhost:8080/catalog/regions/{id}, где id - идентификатор региона (ранее присвоенный номер);
- Для изменения данных региона отправить PUT запрос на  http://localhost:8080/catalog/regions/{id}, где id - идентификатор региона (ранее присвоенный номер), вид запроса:<br>
{<br>
"regionfullname": "Санкт-Петербург",<br>
"regionshortname":"СПб"<br>
}<br>
- для удаления региона из справочника необходимо отправить DELETE запрос на http://localhost:8080/catalog/regions/{id}, где id - идентификатор региона (ранее присвоенный номер).<br>
В папке проекта имеется Json- файл с запросами Postman -  TeldaTest.postman_collection.json
