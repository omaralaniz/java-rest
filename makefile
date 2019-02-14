WITH_JAR=-cp ".:./jars/gson.jar"

clean: 
	rm -rf *.class

get: clean GetTest.java Get.java
	javac ${WITH_JAR} GetTest.java;java ${WITH_JAR} GetTest

put: clean PutTest.java Put.java
	javac ${WITH_JAR} PutTest.java;java ${WITH_JAR} PutTest
