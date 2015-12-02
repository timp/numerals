#!/usr/bin/env bash
# See http://skife.org/java/unix/2011/06/20/really_executable_jars.html
mvn clean install 
cp src/main/sh/exec numerals
cat target/numerals-1.0-SNAPSHOT.jar >> numerals
chmod +x numerals
