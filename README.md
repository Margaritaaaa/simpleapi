# JavaSimpleApi
Технологии разработки программного обеспечения

Лабораторная работа №1: создание микросервиса на Spring Boot с базой данных

Савостьянова М.С. МБД2031

Целью лабораторной работы является знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов).

Первоначально необходимо склонировать текущую репозиторию. Клонирование можно осуществить тремя разными способами: 

![clone](https://github.com/Margaritaaaa/JavaSimpleApi/blob/main/clone.png)

Наиболеее удобный способ получения копии существующего Git-репозитория это командой git clone <url>



Для работы запуска приложения под docker:



1. Для сборки приложения в Maven в среде для разработки IntelliJ IDEA

Зайти во вкладку maven: simpleApi -> Lifecycle -> package

![maven](https://github.com/Margaritaaaa/JavaSimpleApi/blob/main/maven.png)
  
2. Прописать Dockerfile, где указать:

//

      FROM maven:3.5.2-jdk-8-alpine
      
    //Поддерживаемые теги и соответствующие ссылки Dockerfile, задает базовый образ для последующих инструкций
      
      COPY /target/simpleapi-1.0.jar myapi.jar 
      
    // simpleapi-1.0.jar - результат работы maven, myapi.jar - alias, придуманный нами
      
      ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/myapi.jar"] 
      
    //определение инструкции Entrypoint

//

3. Для сборки docker-образа из командной строки 

Необходимо ввести команду: 

    docker build . -t myapi:latest
      //myapi:latest - последняя версия нашего проекта

Для проверки можно выполнить в терминате docker images и проверить наличие созданного образа в списке образов

4. Для запуска docker-контейнера из docker-образа с указанием маппинга портов

Необходимо ввести команду в терминале: 

    docker run -p 8080:8080 myapi:latest
  
Curl

Метод: GET
  
    Получить все данные 
      http://localhost:8080/api/v1/computers
    Получить конкретный компьютер по id
      http://localhost:8080/api/v1/computers/2
    Для возрата hostName
      http://localhost:8080/api/v1/status
    
Метод: POST

    Сохранить новый товар
    Curl 
      http://localhost:8080/api/v1/computers
    Пример join 
      {
          "type": "Laptop",
          "cpu": "Intel Core i9",
          "name": "Dell XPS 13",
          "employee": "Levin"
      }
       

Метод: DELETE
  
    Удалить конкретный товар по id
      http://localhost:8080/api/v1/computers/10
