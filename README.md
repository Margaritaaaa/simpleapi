[![Build Status](https://travis-ci.org/Margaritaaaa/simpleapi.svg?branch=master)](https://travis-ci.org/github/Margaritaaaa/simpleapi)
# Лабораторная работа №1: создание микросервиса на Spring Boot с базой данных

# Савостьянова М.С. МБД2031
Лабораторная работа по дисциплине: Технологии разработки программного обеспечения

Целью лабораторной работы является знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов).

Первоначально необходимо склонировать текущую репозиторию. Клонирование можно осуществить тремя разными способами: 

![clone](https://github.com/Margaritaaaa/simpleapi/blob/master/clone2.png)

Наиболеее удобный способ получения копии существующего Git-репозитория это командой git clone <url>



Для работы запуска приложения под docker:



1. Для сборки приложения в Maven в среде для разработки IntelliJ IDEA

Сборку можно осуществить двумя различными вариантами: через интерфейс или через консоль.

Через интерфейс: зайти во вкладку maven: simpleApi -> Lifecycle -> package

Через консоль: находясь в директории проекта необходимо выполнить команду (с пропуском тестирования)    
        
    mvn package -Dmaven.test.skip=true

Результатом будет файл с расширением .jar

    simpleapi-1.0.jar

Файл будет располагаться в новой папке target
  
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
      curl -X GET http://localhost:8080/api/v1/computers
    Получить конкретный компьютер по id
      curl -X GET http://localhost:8080/api/v1/computers/2
    Для возрата hostName
      curl -X GET http://localhost:8080/api/v1/status
    
Метод: POST

    Сохранить новый товар
    Curl 
      curl -X POST http://localhost:8080/api/v1/computers -d ‘{ "type": "Laptop", "cpu": "Intel Core i9", ""name": "Dell XPS 13", "employee": "Levin"}’ -H «Content-Type:application/json» 
    
Ответом на данный curl будет статус "200 ОК".       

Метод: DELETE
  
    Удалить конкретный товар по id
      curl -X DELETE http://localhost:8080/api/v1/computers/{id}
      
В качестве {id} необходимо подставить выбранный id товара, который нужно удалить из таблицы. Ответом на данный curl будет статуc "204 No Content".
      
# Лабораторная работа №3: CI/CD и деплой приложения в Heroku
Лабораторная работа по дисциплине: Технологии разработки программного обеспечения

Целью лабораторной работы является знакомство с CI/CD и его реализацией на примере Travis CI и Heroku.

Приложение развернуто на Heroku: https://simpleapii.herokuapp.com/api/v1/computers


