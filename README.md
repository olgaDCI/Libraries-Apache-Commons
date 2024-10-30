# Apache Commons IO

## Description

In this exercise, we'll learn how to work with 3rd party libraries and explore some commonly used features of the commons-io library

## Tasks

### Download and import the commons-io library
In the first step we'll download the commons-io library and include it in our project. 

> Download-Link: [https://mvnrepository.com/artifact/commons-io/commons-io/2.11.0](https://mvnrepository.com/artifact/commons-io/commons-io/2.11.0)
> Import IntelliJ: [Import a library](https://www.jetbrains.com/help/idea/library.html)
> Import Eclipse: [How to import a jar in Eclipse](https://stackoverflow.com/questions/3280353/how-to-import-a-jar-in-eclipse)

If you imported the library correctly, the Exercise.java file should not run successfully and show the following output:

````
Successfully imported the Apache Commons IO library
````

### Working with streams
The Commons IO library provides multiple API classes that allow us to work with Streams. Take a look at the IOUtils class and try to complete the method readWebPage.
The goal of the method is to read a given URL and transform the whole HTML code to a String.


### Working with Files
The FileUtils class provides an API for the interaction with files. 

Use the FileUtils class to:
* Read the contents of the LoremIpsum.txt file in this project (src/main/resources/LoremIpsum.txt)
* Copy the LoremIpsum file to your local tmp-directory.
* Delete the copy after a short delay.

### Search for files
Use the FileUtils.listFiles() method to search for all files with the ".java" extension in a given project.s