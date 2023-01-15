## 🗹Prerequisites

Before you begin, ensure you have met the following requirements:
* <a href="https://www.jetbrains.com/idea/">IntelliJ IDEA</a> / <a href="https://www.eclipse.org/downloads/">Eclipse</a>
* <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">JDK 17</a
##  🛠️Installing the app

To install properly, follow these steps:

Clone this git repository
```
https://github.com/iliyandzh/iliyandzh-s444c3d22-9ba8-11e4-aeB1-p24sac1D0vdm
```

To run :
1. Open IntelliJ 
3. Click `Open`
4. Find the directory where you saved repository and select API that you want to run
5. Select the `pom.xml` file for this API
![Untitled](https://user-images.githubusercontent.com/43420012/212568646-2ad59a10-90ef-4c75-be4c-ce3d6f0197ca.png)


7. Click `Open as Project`
8. Click `Trust Project`
9. Fill `application.properties` file with the proper h2 password and username
10. Run the project

To get Covid-19 data for a Country you desire :
1. Go to 
```
http://localhost:8080/country/{countryCode}
```
2. Replace the `{countryCode}` with the country code of the country you wish to see data for
