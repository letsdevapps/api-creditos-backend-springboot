#!/bin/bash
until netcat -z -v -w30 mariadb 3306
do
  echo "Esperando MariaDB ficar disponível..."
  sleep 15
done
echo "MariaDB está disponível!"
