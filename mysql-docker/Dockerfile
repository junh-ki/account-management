FROM mysql:5.7.33

MAINTAINER junh-ki kijoonh91@gmail.com

ENV MYSQL_DATABASE=account \
    MYSQL_ROOT_PASSWORD=admin123

ADD account_schema.sql /docker-entrypoint-initdb.d

EXPOSE 3306
