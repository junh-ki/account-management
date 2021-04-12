# MySQL Docker Container with the intended schema

1. Dump your MySQL schema to a file (You need to create your preferred schema prior to this.)

~~~
$ mysqldump -h ${MYSQL_HOST} -u ${USER_NAME} -p --no-data ${DATABASE_NAME} > ${RESULT_DUMPED_SQL_NAME}
~~~

~~~
$ mysqldump -h 127.0.0.1 -u root -p --no-data account > account_schema.sql
~~~

2. In `Dockerfile`, use the `ADD` command to add your schema file to the `/docker-entrypoint-initdb.d` directory in the Docker container. The `docker-entrypoint.sh` file will run any files in this directory ending with `.sql` against the MySQL database.
For more details, see `Dockerfile`.

3. Following commands need to be executed:

~~~
$ docker login --username=${DOCKER_HUB_USERNAME} --password=${DOCKER_HUB_PASSWORD}
~~~
~~~
$ docker build -t ${DOCKER_HUB_USERNAME}/mysql-account-management .
~~~
~~~
$ docker push ${DOCKER_HUB_USERNAME}/mysql-account-management
~~~
