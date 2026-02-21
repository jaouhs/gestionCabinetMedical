# Gestion d’un Cabinet Médical  
## Projet pédagogique évolutif – Architectures distribuées

Cours assuré par : **Jaouad OUHSSAINE**  
Contact : jaouad.ouhs@gmail.com | jaouad_ouhssaine@um5.ac.ma

---

Ce dépôt GitHub contient un **projet pédagogique évolutif** visant à illustrer **l’évolution progressive des architectures logicielles** dans le cadre du module :

**Systèmes Distribués Basés sur les Microservices**  
Master IPS – Faculté des Sciences de Rabat

Le projet suit une démarche **pas à pas**, en partant d’une **application monolithique** jusqu’à une architecture **orientée événements** et enrichie par des **agents d’intelligence artificielle**.

---

## Objectifs pédagogiques

- Comprendre l’évolution des architectures :
  - Monolithe
  - SOA (Service-Oriented Architecture)
  - Microservices
  - Architecture orientée événements (Event-Driven)
  - Intégration d’agents IA
- Appliquer concrètement :
  - Spring Boot
  - REST
  - Apache Camel (ESB)
  - Kafka
- Concevoir un système :
  - modulaire
  - maintenable
  - extensible
  - scalable

---

## Vision fonctionnelle globale

L’application **Gestion d’un Cabinet Médical** couvre progressivement les fonctionnalités suivantes :

- Gestion des patients
- Gestion des médecins
- Gestion des rendez-vous
- Gestion des consultations
- Facturation
- Notifications
- Intelligence artificielle (priorisation, recommandation, génération de texte)

Ces fonctionnalités sont **introduites progressivement**, selon l’architecture étudiée à chaque TP.

---

## Structure du repository

```text
gestionCabinetMedical/
│
├── cabinetMedicalTp1/        			# TP1 – Application monolithique
│
├── cabinetMedicalTp2SOA/     			# TP2 – Architecture SOA avec ESB
│
├── cabinetMedicalTp3MS/      			# TP3-1 – Mise en oeuvre d’une architecture Microservices (REST)
│
├── cabinetMedicalTp3MS-discovery/     	# TP3-2 – Mise en oeuvre d’une architecture Microservices (REST) avec la mise en place de discovery service
│
├── cabinetMedicalTp4EDA/     			# TP4 – Architecture Event-Driven (EDA) avec Kafka
│
├── cabinetMedicalTp5IA/      			# À venir – Agents IA
│
└── README.md                 			# Documentation globale du projet

