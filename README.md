# Automatisation_RGPD_IL

## Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Usage](#usage)

## About <a name = "about"></a>

\_ Le but de notre projet est l’assistance à l’ingénierie du logiciel pour garantir la protection de la vie privée. L’idée principale de ces travaux est de proposer une méthode qui assiste les ingénieurs du logiciel, lors du développement de nouvelles applications ou lors de la maintenance d’applications existantes, dans la gestion des données personnelles des utilisateurs et la garantie du respect des réglementations en vigueur sur le sujet.

\_ Ce projet contient des microservices développer par différents technologies (ExpressJS, SpringBoot, Flask, Angular), donc pour les éxecuter il faut suivre les étapes suivantes en ordre.

\_ Notre architecture microservices est développer en SpringBoot qui contients un service d'enregistrement Eureka, un serveur de configuration des services springboot en spring cloud config pour centraliser les configurations et aussi un service proxy Zuul pour intercepter les requétes qui viennent depuis l'application front-end.

\_ Alors il faut tout d'abord executer le service de configuration et aprés d'enregistrement et aprés le proxy et à la fin le reste des microservices peu importe leurs ordres.

## Getting Started <a name = "getting_started"></a>

### Configuration file

_Tout d'abord il faut couper le répertoire cloud-conf et le mettre dans n'importe quel emplacement vous voulez en local et puis ce positionner dans ce répertoire et éxecuter les commandes suivantes :
_ git init
_ git add .
_Et aprés il faut changer le chemin dans le fichier de configuartion du service de configuration (service-configuration) il faut suivre les étapes suivantes :
_ Ouvrir le fichier ./service-configuration/src/main/resources/application.properties
_ Mettre le chemin du repertoire cloud-conf que vous avez choisi dans la propriété suivante spring.cloud.config.server.git.uri="./your/path" (par exemple file://${user.home}/cloud-conf)

### Run configuration service

_ Il faut ce positioner sur le dossier target du projet 'service-configuration' et éxecuter la commande : \
 \* java -jar service-configuration-0.0.1-SNAPSHOT

### Run registry service

_ Il faut ce positioner sur le dossier target du projet 'service-register' et éxecuter la commande : \
 \* java -jar service-register-0.0.1-SNAPSHOT

### Run proxy service

_ Il faut ce positioner sur le dossier target du projet 'service-proxy' et éxecuter la commande : \
 \* java -jar service-proxy-0.0.1-SNAPSHOT

### Run processing service

_ Il faut ce positioner sur le dossier target du projet 'service-processing' et éxecuter la commande : \
 \* java -jar service-company-0.0.1-SNAPSHOT

### Run consent service

_ Il faut ce positioner sur le dossier target du projet 'Consent-service' il faut modifier d'abord dans le fichier bdd.py les configurations de la base de données et éxecuter les commandes suivantes :
_ pip install py-eureka-client
_ pip install mysql-connector-python
_ py ./bdd.py
_ py ./app.py

### Run Data & DataSubject service

    * Create a mysql database
    * Fill the .env file in GDPR_HELPER/API/
    `DATABASE_URL="mysql://username:password@host:port/DatabaseName"` corresponding to the authentication URL to the database.
    * `ADMIN_API_KEY` is the key that will be used by external clients to access GDPRMS
    * `API_ENDPOINT_PROCESS_DATA_REQUEST_ANSWERS="http://localhost:2000/processAnswers"` Is the address to the endpoint of the Provider Application api that is used by the server to notify the Provider server that new data request answers need to be processed.

    * Run `cd .\GDPR_HELPER\API\`
    * Run `npm install`
    * Run  `npx prisma db push`
    * Run `npm run start`

### Prerequisites

_Vous aurez besoin de : 
1. Install Node JS 
2. Install Maven 
3. Install Java 11+ 
4. Install Python 
5. Install pip 
6. Install Eclipse (Optional to run springboot microservices)

## Usage <a name = "usage"></a>

Pour vérifier que tous les services de l'architecture sont éxécutés sans problème, il faut vérifier qu'ils sont détectables par le service d'enregistrement Eureka (Eureka Clients) on peut vérifier ça en navigant l'URL : `http://localhost:8760`
