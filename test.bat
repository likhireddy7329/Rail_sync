@echo off
if not exist out mkdir out
javac -d out src\*.java tests\AlgorithmSmokeTest.java
if errorlevel 1 exit /b 1
java -cp out AlgorithmSmokeTest
