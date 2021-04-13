# Docker Compose Deployment for the account management system

The script, `docker-compose.yml`, is to deploy all four services required for running the account management system on a local host.
These services include: `mysql`, `restservice`, `cashdeposit`, and `cashtransaction`.

## Prerequisites - docker, docker-compose

* Docker, Compose [How to install Docker on Ubuntu 18.04](https://phoenixnap.com/kb/how-to-install-docker-on-ubuntu-18-04)

## Step 1 

Make sure that ports for `mysql`, `restservice`, `cashdeposit`, and `cashtransaction` are available. This includes: 3306(`mysql`), 8080(`restservice`), 7070(`cashdeposit`), and 9090(`cashtransaction`).

## Step 2

Make sure that the `.env` file contains the same information as follow:

```
MYSQL_USERNAME=root
MYSQL_ROOT_PW=admin123
MYSQL_DB_NAME=account

SPRING_DB_URL=jdbc:mysql://mysql:3306/account?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=CET

REST_SERVICE_URL=http://restservice:8080/restservice/
EXCHANGE_API_URL=http://api.exchangeratesapi.io/v1/latest?access_key=35bbcdd96e0d471a96ab0a75f554cbf9
```

## Step 3

In the `.env` file, `EXCHANGE_API_URL` stands for the API url for retrieving the euro-based currency exchange rate JSON data. Because the access key, `35bbcdd96e0d471a96ab0a75f554cbf9`, is a free-plan access key, the exchange rate gets updated not in real-time but on a daily basis. You can change this url with a new access key once the plan is upgraded.

## Step 4

Navigate to the same directory where this `README.md` file is located and run Docker Compose.

- Option A (Normal Mode)

~~~
$ docker-compose up
~~~

With this normal mode, you can monitor every log on the terminal where you commanded `docker-compose up`.

- Option B (Detached Mode)

~~~
$ docker-compose up -d
~~~

With this detached mode, you can simply close the terminal once you run `docker-compose up -d`.

* The startup can take up to 30 seconds.

## Step 5

Check to see if you can access the following urls:

- `http://localhost:7070/cashdeposit/`
- `http://localhost:9090/cashtransaction/`

## Undeployment

- Option A (To Keep data persist)

Take all the services down but do not terminate volumes.

~~~
$ docker-compose down
~~~

- Option A (Without data persist)

Take all the services down as well as volumes.

~~~
$ docker-compose down --volumes
~~~
