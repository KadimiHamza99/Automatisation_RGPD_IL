#Automatisation_RGPD_IL
Automatisation de la prise en compte de la RGPD dans le développement logiciel – avec une approche microservices

## L'architecture microservices est realisé en Springboot, Elle contient un serveur de configuration pour les microservices springboot et un service d'enregistrement Eureka pour enregistrer les microservices de l'application et un serveur proxy qui joue le role d'un gateway pour intercepter toutes les requétes envoyer par l'application Front-end

## Ce projet contient aussi des microservices qui sont codé avec d'autres languages (ExpressJS-TypeScript/Flask-Python) et qui sont liés à l'architecture Springboot comme étant des clients Eureka

## Ce projet contient aussi une application frontend qui consomme les endpoints réalisé développer en Angular

### Pour faire executer cette application il faut executer d'abord le serveur de configuration ensuite le serveur Eureka ensuite le Proxy ensuite les autres microservices et à la fin l'application Springboot

### il vous faut aussi creer les bases de données suivantes : GPDR,GPRD_MICROSERVICE_PROCESSINGS,GDPR_MICROSERVICE_CONSENTS, et aussi configurer les credentials de votre base de données dans le fichier cloud-conf\*

- Il vous faut alors créer un repository git dans le dossier users de votre machine que vous allez appeler cloud-conf et la vous allez mettre vos configuration pour les microservices springboot vous trouverez notre cloud-conf dans ce repo mais vous devez le déplacer sur 'C:/utilisateurs/USERNAME/' à savoir que notre exemple cloud conf n'est pas un repo donc il faut aprés l'ajout executer les commandes suivantes
  -- git init
  -- git add .
  et chaque fois vous ajouter une modification il faut forcement re executer la commande git add . et aussi relancer le serveur de configuration
