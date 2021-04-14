FROM mysql:5.7.33

MAINTAINER junh-ki kijoonh91@gmail.com

ENV MYSQL_DATABASE=account \
    MYSQL_ROOT_PASSWORD=admin123

ADD account_schema.sql /docker-entrypoint-initdb.d

EXPOSE 3306

# ----- Docker Command Examples -----

# docker login --username=${DOCKER_HUB_USERNAME} --password=${DOCKER_HUB_PASSWORD}
# docker build -t ${DOCKER_HUB_USERNAME}/mysql-account-management .
# docker push ${DOCKER_HUB_USERNAME}/mysql-account-management
# docker pull ${DOCKER_HUB_USERNAME}/mysql-account-management
# docker run -p 3306:3306 -d -t ${DOCKER_HUB_USERNAME}/mysql-account-management

# You need to empty port 3306 to do this.
