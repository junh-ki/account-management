# Cash Transaction Application

This application, `cashtransaction`, is a REST client application that interacts with users for: Account(s) Overview and Cash Transaction using a third-party API for getting currency exchange rate. 
This runs on port `9090`.
* After deployment, you can use this app via '*http://localhost:9090/cashtransaction/*'.

## Supported REST Clients

### 1. UserRestClient ([Implementation](https://github.com/junh-ki/account-management/blob/main/cashtransaction/src/main/java/com/jun/cashtransaction/integration/UserRestClientImpl.java))

- **[GET]** *http://restservice:8080/restservice/users/{email}*

> Finds a registered User by User ID (email) / Returns a User instance

```Java
public User findUser(String email) {
    ...
    User user = restTemplate.getForObject(USER_REST_URL + email, User.class);
```

### 2. AccountRestClient ([Implementation](https://github.com/junh-ki/account-management/blob/main/cashtransaction/src/main/java/com/jun/cashtransaction/integration/AccountRestClientImpl.java))

- **[GET]** *http://restservice:8080/restservice/accounts/{id}*

> Finds a registered Account by Account ID number / Returns an Account instance

```Java
public Account findAccountById(Long id)
```

- **[GET]** *http://restservice:8080/restservice/accounts*

> Finds Account(s) that belong(s) to a User among the retrieved Account instances by User(Holder) ID number / Returns the List of Account instances

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

### 3. TransactionRestClient ([Implementation](https://github.com/junh-ki/account-management/blob/main/cashtransaction/src/main/java/com/jun/cashtransaction/integration/TransactionRestClientImpl.java))

- **[POST]** *http://restservice:8080/restservice/transactions*

> Adds a new Transaction with the passed Transaction instance / Returns the saved Transaction instance

```Java
public Transaction saveTransaction(Transaction transaction) {
    ...
    Transaction savedTransaction = restTemplate.postForObject(TRANSACTION_REST_URL, transaction, Transaction.class);
```

### 4. ExchangeRateRestClientImpl ([Implementation](https://github.com/junh-ki/account-management/blob/main/cashtransaction/src/main/java/com/jun/cashtransaction/integration/ExchangeRateRestClientImpl.java))

- **[GET]** *http://api.exchangeratesapi.io/v1/latest?access_key=35bbcdd96e0d471a96ab0a75f554cbf9*

> Gets a Euro-based currency exchange rate JSON dictionary via **a thrid-party API** for Cash Transaction / This API url can be dynamically allocated using the `.env` file

```Java
public JSONObject getEuroBasedExchangeRates() {
    ...
    String exchangeRates = restTemplate.getForObject(restServiceUrl.getExchangeApiUrl(), String.class);
```

Because the access key, `35bbcdd96e0d471a96ab0a75f554cbf9`, is a free-plan access key, the exchange rate gets updated not in real-time but on a daily basis. 
You can change this url with a new access key once the plan is upgraded.

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

To build the app and create a Docker image, navigate to `account-management/cashtransaction/` and run:

~~~
$ docker build -t ${DOCKER_HUB_USERNAME}/cashtransaction-account-management .
~~~

## Step 3: Push Docker Image

To push the created Docker image to your Docker Hub registry, run:

~~~
$ docker push ${DOCKER_HUB_USERNAME}/cashtransaction-account-management
~~~

## Deployment

Since it has a dependency on the `restservice` micro-service, it should be deployed along with it. In order to deploy the whole package of micro-services for running the account management system, please click [here](https://github.com/junh-ki/account-management/tree/main/docker-compose) to refer to the Docker Compose deployment.
