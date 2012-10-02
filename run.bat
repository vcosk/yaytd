@echo off
IF DEFINED JAVA_HOME (java -jar yaytd.jar) ELSE (ECHO JAVA_HOME is NOT defined)