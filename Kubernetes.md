# JavaSimpleApi
Технологии разработки программного обеспечения

Лабораторная работа №2: создание кластера Kubernetes и деплой приложения

Савостьянова М.С. МБД2031

Целью лабораторной работы является знакомство с кластерной архитектурой на примере Kubernetes, а также деплоем приложения в кластер.


Манифест deployment.yaml

	apiVersion: apps/v1
	kind: Deployment
	metadata:
	  name: my-deployment
	spec:
	  replicas: 10
	  selector:
	    matchLabels:
	      app: my-app
	  strategy:
	    rollingUpdate:
	      maxSurge: 1
	      maxUnavailable: 1
	    type: RollingUpdate
	  template:
	    metadata:
	      labels:
	        app: my-app
	    spec:
	      containers:
	        - image: myapi:latest
	          imagePullPolicy: Never 
	          name: myapi
	          ports:
	            - containerPort: 8080
	      hostAliases:
	      - ip: "192.168.49.1" # The IP of your VM
	        hostnames:
	        - postgres.local
			
Манифест service.yaml 

	apiVersion: v1
	kind: Service
	metadata:
	  name: my-service
	spec:
	  type: NodePort
	  ports:
	    - nodePort: 31317
	      port: 8080
	      protocol: TCP
	      targetPort: 8080
	  selector:
	    app: my-app

Увеличение числа подов до десяти:

![10 po](https://github.com/Margaritaaaa/JavaSimpleApi/blob/main/10-podes.png)

Балансировщик распределяет запросы на разные поды:

![po1](https://github.com/Margaritaaaa/JavaSimpleApi/blob/main/po1.png)
![po2](https://github.com/Margaritaaaa/JavaSimpleApi/blob/main/po2.png)

Для удобства есть графический интерфейс dashboard:
![dashboard](https://github.com/Margaritaaaa/JavaSimpleApi/blob/main/dashboard.png)

Перейдем в my-deploment, чтобы проверить работу подов:
![10-dashboard](https://github.com/Margaritaaaa/JavaSimpleApi/blob/main/10_dashboard.png)
Все 10 подов запущены и работают без сбоев.

Обзор работы кластера: 
[Обзор кластера](https://drive.google.com/file/d/13z-bY7Rr_FkfOFUhyotcgyHH_fwteiin/view?usp=sharing)
