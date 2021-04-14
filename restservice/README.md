# REST Service Application

This application, `restservice`, is to support its client applications (`cashdeposit` and `cashtransaction`) with REST APIs while interacting directly with the datasource, `mysql`. This runs on port `8080`.

## Supported REST APIs

### 1. UserRestController ([Implementation](https://github.com/junh-ki/account-management/blob/main/restservice/src/main/java/com/jun/restservice/controllers/UserRestController.java))

- **[GET]** *http://localhost:8080/restservice/users/{email}*

> Finds a registered User by User ID (email) / Returns a User JSON dictionary

```Java
@GetMapping("/users/{email}")
public User findUser(@PathVariable("email") String email)
```

- **[POST]** *http://localhost:8080/restservice/users*

> Adds a new User with the passed User JSON dictionary / Returns the saved User JSON dictionary

```Java
@PostMapping("/users")
public User saveUser(@RequestBody User user)
```

### 2. AccountRestController ([Implementation](https://github.com/junh-ki/account-management/blob/main/restservice/src/main/java/com/jun/restservice/controllers/AccountRestController.java))

- **[GET]** *http://localhost:8080/restservice/accounts/{id}*

> Finds a registered Account by Account ID number / Returns an Account JSON dictionary

```Java
@GetMapping("/accounts/{id}")
public Account findAccountById(@PathVariable("id") Long id)
```

- **[GET]** *http://localhost:8080/restservice/accounts*

> Gets all registered Accounts / Returns a list of Account JSON dictionaries

```Java
@GetMapping("/accounts")
public List<Account> getAllAccounts()
```

- **[POST]** *http://localhost:8080/restservice/accounts*

> Updates an Account information (account.balance) with the passed AccountUpdateRequest JSON dictionary / Returns the updated Account JSON dictionary

```Java
@PostMapping("/accounts")
public Account updateAccount(@RequestBody AccountUpdateRequest request)
```

- **[POST]** *http://localhost:8080/restservice/accounts/save*

> Adds a new Account with the passed Account JSON dictionary / Returns the saved Account JSON dictionary

```Java
@PostMapping("/accounts/save")
public Account saveAccount(@RequestBody Account account)
```

### 3. DepositRestController ([Implementation](https://github.com/junh-ki/account-management/blob/main/restservice/src/main/java/com/jun/restservice/controllers/DepositRestController.java))

- **[POST]** *http://localhost:8080/restservice/deposits*

> Adds a new Deposit with the passed Deposit JSON dictionary / Returns the saved Deposit JSON dictionary

```Java
@PostMapping("/deposits")
public Deposit saveDeposit(@RequestBody Deposit deposit)
```

### 4. TransactionRestController ([Implementation](https://github.com/junh-ki/account-management/blob/main/restservice/src/main/java/com/jun/restservice/controllers/TransactionRestController.java))

- **[GET]** *http://localhost:8080/restservice/transactions/{id}*

> Finds a registered Transaction by Transaction ID number / Returns a Transaction JSON dictionary

```Java
@GetMapping("/transactions/{id}")
public Transaction findTransactionById(@PathVariable("id") Long id)
```

- **[GET]** *http://localhost:8080/restservice/transactions*

> Gets all registered Transactions / Returns a list of Transaction JSON dictionaries

```Java
@GetMapping("/transactions")
public List<Transaction> getAllTransactions()
```

- **[POST]** *http://localhost:8080/restservice/transactions*

> Adds a new Transaction with the passed Transaction JSON dictionary / Returns the saved Transaction JSON dictionary

```Java
@PostMapping("/transactions")
public Transaction saveTransaction(@RequestBody Transaction transaction)
```

## Prerequisites

* Java (openjdk:11)
* Maven (maven:3.8.1-jdk-11)
* Docker Hub Account

## Step 1: Login

Login to Docker Hub on your local host.

~~~
$ docker login --username=${DOCKER_HUB_USERNAME} --password=${DOCKER_HUB_PASSWORD}
~~~

## Step 2: Create Docker Image

To build the app and create a Docker image, navigate to `account-management/restservice/` and run:

~~~
$ docker build -t ${DOCKER_HUB_USERNAME}/restservice-account-management .
~~~

## Step 3: Push Docker Image

To push the created Docker image to your Docker Hub registry, run:

~~~
$ docker push ${DOCKER_HUB_USERNAME}/restservice-account-management
~~~

## Deployment

Since it has a dependency on the MySQL micro-service, it should be deployed along with it. In order to deploy the whole package of micro-services for running the account management system, please click [here](https://github.com/junh-ki/account-management/tree/main/docker-compose) to refer to the Docker Compose deployment.
