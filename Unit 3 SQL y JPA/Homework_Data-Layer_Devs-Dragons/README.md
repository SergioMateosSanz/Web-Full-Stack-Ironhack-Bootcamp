# CRM - Data Layer

### 📌 ABOUT

This project adds the Data Layer to the CRM developed for the previous Homework. **CRM**s are a tool that almost every
sales team uses to track prospective and existing customers through the sales process.

**IMPORTANT :**
When reading the assignment we got the idea to implement a login feature with different users, since it would not make
sense for Sales Rep to be able to access reporting features. Therefore, we created a system based on Users with different
UserTypes. We did not create a SalesRep class because we thought it would make more sense this way, but the feature still exists.

If you have any questions about the way we developed the project, feel free to ask!

## :computer: Technology Stack

### Pre-requisites

The programming language of this repository is **Java 11.0.10**, therefore must have Java 11 installed.
To check your version of the software, run the following function on your local machine:

```
java -version
```

Other tools used in the development of the project:

* [Diagrams.io ] - To draw the general structure of the project
* [Maven] - Dependencies handler
* [SpringBoot v2.5.4]
* [MySQL]
* [JUnit]

### Installation

In order to import the project to your local repository and start application, you should write the following
commands in your IDE terminal:

```
git init
git pull https://github.com/ES-IH-WDPT-JUN21/homework-3-Devs-Dragons master
```

You can also clone the project from GitHub or download it as a zip file and open 
it on IntelliJ as you would any other project.

The Application runs on the **HomeworkDataLayerDevsDragonsApplication.java** archive. Before
running the program you will need to create the databases in your local MySQL Workbench. We have
included a script in the [resources folder](/src/main/resources).

You don't need to create an user to access the application once it is running. Two users will be
created automatically for testing purposes: *DIRECTOR* and *SALES*. The password for both will be *123456*.

## :exclamation:Project Pipeline

### Use Case Diagram
![image](src/main/resources/CRM%20-%20Use%20Case%20Diagram.jpg)

### Class Case Diagram
![image](src/main/resources/CRM%20-%20Class%20Diagram.jpg)

***If for some reason the links to the images are broken, you can access them in 
the [resources folder](/src/main/resources).***

## :star: Authors

* **Sergio Mateos Sanz**  - [SergioMateosSanz](https://github.com/SergioMateosSanz)
* **David de Ingunza de Caso** - [Deingun](https://github.com/Deingun)
* **Miryam Toro** - [miryam-tp](https://github.com/miryam-tp)
* **Pilar María Carranza Astrada** - [pilicarranza](https://github.com/pilicarranza)
* **Lucia MdA Mielgo** - [mxvements](https://github.com/mxvements)

## ♥️ Thanks

Big thanks to TAs and teachers for the help and support in the development of this course:

* **Victor Cardozo** - [GazzD](https://github.com/GazzD)
* **Adrià López** - [AdriaLopez-Ironhack](https://github.com/AdriaLopez-Ironhack)
* **Iván Trujillo** - [IvanTrujillo-Ironhack](https://github.com/IvanTrujillo-Ironhack)

### IH ES WDPT - JUN21 - BECAS SANTANDER TECH

