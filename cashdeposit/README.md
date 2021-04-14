# Cash Deposit Application

This application, `cashdeposit`, is a REST client application that interacts with users for: User Registration, Account(s) Creation, Account(s) Overview, and Cash Deposit.
This runs on port `7070`.

## Supported REST Clients

### 1. UserRestClient ([Implementation](https://github.com/junh-ki/account-management/blob/main/cashdeposit/src/main/java/com/jun/cashdeposit/integration/UserRestClientImpl.java))

- **[GET]** *http://restservice:8080/restservice/users/{email}*

> Finds a registered User by User ID (email) / Returns a User instance

```Java
public User findUser(String email) {
    ...
    User user = restTemplate.getForObject(USER_REST_URL + email, User.class);
```

- **[POST]** *http://restservice:8080/restservice/users/*

> Adds a new User with the passed User instance / Returns the saved User instance

```Java
public User saveUser(User user)
    ...
    User savedUser = restTemplate.postForObject(USER_REST_URL, user, User.class);
```

### 2. AccountRestClient ([Implementation](https://github.com/junh-ki/account-management/blob/main/cashdeposit/src/main/java/com/jun/cashdeposit/integration/AccountRestClientImpl.java))

- **[GET]** *http://restservice:8080/restservice/accounts/{id}*

> Finds a registered Account by Account ID number / Returns an Account instance

```Java
public Account findAccountById(Long id)
```

- **[GET]** *http://restservice:8080/restservice/accounts*

> Finds a target Account among the retrieved Account instances by User(Holder) ID number / Returns an Account instance

```Java
public List<Account> findAccountsByHolderId(Long id) {
    ...
    ResponseEntity<Account[]> response = restTemplate.getForEntity(ACCOUNT_REST_URL, Account[].class);
        Account[] accountArray = response.getBody();
        List<Account> accounts = new ArrayList<Account>();
        for (int i = 0; i < accountArray.length; i++) {
            Account account = accountArray[i];
            if (account.getHolderId().equals(id)) {
                accounts.add(account);
            }
        }
        return accounts;
```

- **[POST]** *http://restservice:8080/restservice/accounts*

> Updates an Account information (account.balance) with the passed AccountUpdateRequest instance / Returns the updated Account instance

```Java
public Account updateAccount(AccountUpdateRequest request) {
    ...
    Account account = restTemplate.postForObject(ACCOUNT_REST_URL, request, Account.class);
```

- **[POST]** *http://restservice:8080/restservice/accounts/save*

> Adds a new Account with the passed Account instance / Returns the saved Account instance

```Java
public Account saveAccount(Account account) {
    ...
    Account savedAccount = restTemplate.postForObject(ACCOUNT_REST_URL + "save", account, Account.class);
```

### 3. DepositRestClient ([Implementation](https://github.com/junh-ki/account-management/blob/main/cashdeposit/src/main/java/com/jun/cashdeposit/integration/DepositRestClientImpl.java))

- **[POST]** *http://restservice:8080/restservice/deposits*

> Adds a new Deposit with the passed Deposit instance / Returns the saved Deposit instance

```Java
public Deposit saveDeposit(Deposit deposit) {
    ...
    Deposit savedDeposit = restTemplate.postForObject(DEPOSIT_REST_URL, deposit, Deposit.class);
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
$ docker build -t ${DOCKER_HUB_USERNAME}/cashdeposit-account-management .
~~~

## Step 3: Push Docker Image

To push the created Docker image to your Docker Hub registry, run:

~~~
$ docker push ${DOCKER_HUB_USERNAME}/cashdeposit-account-management
~~~

## Deployment

Since it has a dependency on the `restservice` micro-service, it should be deployed along with it. In order to deploy the whole package of micro-services for running the account management system, please click [here](https://github.com/junh-ki/account-management/tree/main/docker-compose) to refer to the Docker Compose deployment.
