# Java: TestNG + Appium for mobile web testing

Project presents example in using libraries to perform web tests.

## Required software

- Java JDK 11+
- Maven installed and in your classpath
- Android Studio installed
- Android SDK installed and in your path environment
- NodeJS 12+

## Setup

### Appium

Install the lastest version with the command below:

```sh
npm i -g appium@latest
```

Now you need to start the Appium Server. Use the command below:

```sh
appium --port 4723
```

### Android

1. Download [Android Studio](https://developer.android.com/studio) latest version
2. Setup a [new AVD](https://developer.android.com/studio/run/managing-avds#createavd)
3. Start the AVD
   1. From [AVD Manager](https://developer.android.com/studio/run/managing-avds#emulator)
   2. From CLI
  ```sh
  # list AVDs configured
  emulator -list-avds
  # start the AVD
  emulator -avd DEVICE -netdelay none -netspeed full
  ```
  >  Remember to add ANDROID variables to path environment: `ANDROID_HOME`,  `ANDROID_HOME/platform-tools` and `ANDROID_HOME/tools`.

### iOS

TBD

### Execution types

There are two execution types: **android** and **ios**.
The `TargetFactory` class will resolve the target execution based on the `target` property value located on `general.properties` file.
Its usage is placed on the `BaseWeb` class before each test execution.

#### Execution

This execution type uses [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) class to instantiate the web browsers.
When the `target` is `android` the `createDriver()` method is used from the `BrowserFactory` class to return the browser instance.

The browser used in the test is placed on the `browser` property in the `local.properties` file. 

Eg: executing the test suite

```sh
mvn test -Dsuite=android
```

## Generating the test report

This project uses Allure Report to automatically generate the test report. There are some configuration to make it happen:

- aspectj configuration on `pom.xml` file
- `allure.properties` file on `src/test/resources`

You can use the command line to generate it in two ways:

- `mvn allure:serve`: will open the HTML report into the browser
- `mvn allure:report`: will generate the HTML port at target/site/allure-maven-plugin folder

## About the project

## src/main/java

### test

Tests used in the example of using Selenium + TestNG libraries

### config

The Configuration class is the connections and authentication data between the `general.properties` and `grid.properties` properties file located in `src/test/resources/`.


## src/test/resources

It has a `schemas` folder with the JSON Schemas to enable Contract Testing using Rest-Assured. Also, the properties file to easily configure the API URI.

## Errors

### No ChromeDriver

```log
[debug] [BaseDriver] Event 'newSessionStarted' logged at 1623703622279 (22:47:02 GMT+0200 (Central European Summer Time))
[debug] [W3C] Encountered internal error running command: Error: No Chromedriver found that can automate Chrome '83.0.4103'. You could also try to enable automated chromedrivers download server feature. See https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md for more details
```

How to fix:

- Acces the [ChromeDriver Storage](https://chromedriver.storage.googleapis.com) and search for ChromeDriver versions
- Update the `driver.version` in [android.properties](src/test/resources/android.properties)

## Libraries

* [Java 11](https://openjdk.java.net/projects/jdk/11/) as the programming language
* [TestNG](https://testng.org/doc/) as the UnitTest framework to support the test creation
* [Appium](https://github.com/appium/appium) as the mobile browser automation framework using the Java binding
* [Allure Report](https://docs.qameta.io/allure/) as the testing report strategy
* [Log4J2](https://logging.apache.org/log4j/2.x/) as the logging management strategy
* [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) as the Selenium binaries management
* [Owner](http://owner.aeonbits.org/) to minimize the code to handle the properties file

## Future improvements

- Validate support for IOS browser
- Improve test scenarios, they have many lines generating a lot of maintenance over time
- Clone the project and start cucumber support. This change will generate benefits when developing scripts for ATDD