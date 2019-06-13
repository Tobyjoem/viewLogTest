# ViewLogTest
ViewLogTest is a Java program that calculates the Unique Time Viewed (UTV) by a user on a video learning platform. 

## Motivation

ViewTestLog was created as a coding challenge for gomo Learning.

## Installation

Start by downloading and setting up Java. A easy to follow tutorial can be found [here](https://www.tutorialspoint.com/java/java_environment_setup.htm).

Then download and set up Maven, a software project management tool used through the build. [This tutorial](https://www.tutorialspoint.com/maven/maven_environment_setup.htm) should help you out.

Clone the repo. 

## Usage

There should be a .jar file available to you in the cloned repo. If it does not work for you following the commands below, you can generate a new one by navigating to /ViewLogTest/ViewLogTest and typing
```java
mvn clean package
```
. This process may take a while. This should generate the .jar file in the parent directory.

If you would like to see the program in action, navigate to the topmost viewLogTest directory. In this directory, type 
```java
java -jar viewlog.jar [startTime,endTime]
```
and replace the start and end times with appropriate values. For example, if the hypothetical user watched from 2000 millisecondds until 7000 milliseconds, type in 
```java
java -jar viewlog.jar 2000,7000
```

You may enter as many as many times as you would like, but they must be in the format [startTime,endTime]. For instance, you could type 
```java
java -jar viewlog.jar 100,5000 2000,8654 4877,10000 
```
to indicate that the user had watched the video on 3 seperate occasions, starting and ending the sessions at the indicated times. Make sure that startTime and endTime are serpated by a comma, and pairs of startTime and endTime are sperated by a space.

ViewLogTest contains 10 unit tests to make sure that the individual views are properly logged and recorded. To view these tests, make sure that you have Maven installed as described above. In the command line, type 
```java
mvn clean test
```
This will compile the program and run the tests. If everything goes well, you should see that 10 tests were run and 10 tests pass.

## Contribute

As of now, this entire project has been written by me, Tobias Mullen. I bellieve that it is stable enough that I would feel comfortable with another developer working on it. If you have somehow stumbled across this project, please feel free to play around with it.

## Credits

This project was inspired by Emma Lefavor at gomo Learning. Thank you for giving the oportunity for me to show what I can do.
