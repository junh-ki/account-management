# MySQL with the ERM schema

This Dockerfile is to build a MySQL Docker image with the Entity-Relationship Model (ERM) schema to run the database for the account management system. 
This runs on port `3306`.

## Supported Entities

### 1. user

* SQL

```sql
CREATE TABLE user (
  id BIGINT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(20),
  last_name VARCHAR(20),
  email VARCHAR(50),
  password VARCHAR(50), 
  PRIMARY KEY (id),
  UNIQUE KEY (email)
);
```

* Dictionary

~~~
"user": {
    {
        "id": "---",
        "first_name": "---",
        "last_name": "---",
        "email": "---",
        "password": "---"
    },
    {
        ...
    },
    ...
}
~~~

### 2. account

* SQL

```sql
CREATE TABLE account (
  id BIGINT NOT NULL AUTO_INCREMENT,
  currency VARCHAR(10),
  balance FLOAT(14, 2),
  holder_id BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (holder_id) REFERENCES user(id)
);
```

* Dictionary

~~~
"account": {
    {
        "id": "---",
        "currency": "---",
        "balance": "---",
        "holder_id": "---"
    },
    {
        ...
    },
    ...
}
~~~

### 3. deposit

* SQL

```sql
CREATE TABLE deposit (
  id BIGINT NOT NULL AUTO_INCREMENT,
  amount FLOAT(14, 2),
  account_id BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (account_id) REFERENCES account(id)
);
```

* Dictionary

~~~
"deposit": {
    {
        "id": "---",
        "amount": "---",
        "account_id": "---"
    },
    {
        ...
    },
    ...
}
~~~

### 4. transaction

* SQL

```sql
CREATE TABLE transaction (
  id BIGINT NOT NULL AUTO_INCREMENT,
  send_amount FLOAT(14, 2),
  receive_amount FLOAT(14, 2),
  send_currency VARCHAR(10),
  receive_currency VARCHAR(10),
  PRIMARY KEY (id),
  sender_account_id BIGINT,
  recipient_account_id BIGINT,
  FOREIGN KEY (sender_account_id) REFERENCES account(id),
  FOREIGN KEY (recipient_account_id) REFERENCES account(id)
);
```

* Dictionary

~~~
"transaction": {
    {
        "id": "---",
        "send_amount": "---",
        "receive_amount": "---",
        "send_currency": "---",
        "receive_currency": "---",
        "sender_account_id": "---",
        "recipient_account_id": "---" 
    },
    {
        ...
    },
    ...
}
~~~

## Prerequisites

* Docker
* Docker Hub Account

## Step 1: Create the dumped MySQL schema

Dump your MySQL schema to a file. (You need to create your preferred SQL schema prior to this.)
The dumped file is intended to be fed into the Docker image.

~~~
$ mysqldump -h ${MYSQL_HOST} -u ${USER_NAME} -p --no-data ${DATABASE_NAME} > ${RESULT_DUMPED_SQL_NAME}
~~~

Ex)

~~~
$ mysqldump -h 127.0.0.1 -u root -p --no-data account > account_schema.sql
~~~

In `Dockerfile`, use the `ADD` command to add your schema file to the `/docker-entrypoint-initdb.d` directory in the Docker container. The `docker-entrypoint.sh` file will run any files in this directory ending with `.sql` against the MySQL database.
For more details, see `Dockerfile`.

## Step 2: Login

Login to Docker Hub on your local host.

~~~
$ docker login --username=${DOCKER_HUB_USERNAME} --password=${DOCKER_HUB_PASSWORD}
~~~

## Step 2: Create Docker Image

To build the app and create a Docker image, navigate to `account-management/mysql-docker/` and run:

~~~
$ docker build -t ${DOCKER_HUB_USERNAME}/mysql-account-management .
~~~

## Step 3: Push Docker Image

To push the created Docker image to your Docker Hub registry, run:

~~~
$ docker push ${DOCKER_HUB_USERNAME}/mysql-account-management
~~~

## Deployment

It is recommended to deploy the whole package of micro-services for running the account management system.
For this, please click [here](https://github.com/junh-ki/account-management/tree/main/docker-compose) to refer to the Docker Compose deployment.

Or you can deploy this independently on your local host by commanding:

~~~
$ docker run -p 3306:3306 -d -t ${DOCKER_HUB_USERNAME}/mysql-account-management
~~~
