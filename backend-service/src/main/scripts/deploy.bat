set m2=%M2_REPO%
set project=%PROJECT%
scp %m2%/edu/episen/si/ing1/pds/backend-service/1.0-SNAPSHOT/backend-service-1.0-SNAPSHOT-jar-with-dependencies.jar tata@172.31.254.99:/home/tata/server/
scp %project%\teck-work\backend-service\src\main\scripts\backend-service.sh tata@172.31.254.99:/home/tata/server/
ssh tata@172.31.254.99 chmod 777 /home/tata/server/backend-service.sh