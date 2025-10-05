#!/bin/bash

/usr/local/bin/wait-for-it.sh mariadb:3306 -- echo "MariaDB está disponível!"

exec java -jar /usr/local/lib/backend-springboot.jar

