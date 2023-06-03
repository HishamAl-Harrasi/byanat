#!/bin/bash

# Start the application with live code reloading using Spring DevTools
java -javaagent:/spring-boot-devtools.jar \
     -cp /app/app.jar \
     org.springframework.boot.loader.JarLauncher | \
     entr -r -s "pkill -f 'java -javaagent'"
