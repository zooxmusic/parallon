### Parallon Coding Challenge

##### To avoid taking longer than I already have I am aware that I DID NOT
* Write unit tests
* Write integration tests of which I would use JBehave/Sonar
* Write a checkstyle / lint
* I chose NOT to use lombok for ease of running
* I did use the gradle wrapper for ease of use (i.e. ./gradlew)
* I would create        custom login, error and 404 pages
* I am would have currently used more of an Event Sourced methodology but felt this was my best bet given the time I lost due to computer issues as well as other personal issues

> Username: user

> Password: password

> ROLE: USER

#### Swagger URL's
`http://localhost:8080/swagger-resources` - Base URL
`http://localhost:8080/swagger-ui.html` - HTML UI to run endpoints
`http://localhost:8080/v2/api-docs` - JSON formatted docs

#### Direct URL Endpoints
`http://localhost:8080/api/customers` - GET - All customers
`http://localhost:8080/api/customer/{id}` - GET a customer by id
`http://localhost:8080/api/customer` - POST - Create a customer passing in the JSON representation
`http://localhost:8080/api/customer` - PUT - Update a customer passing in the JSON representation
`http://localhost:8080/api/customer` - DELETE - Remove a customer passing in the JSON representation
`http://localhost:8080/api/customer/{customerId}/accounts` - GET All accounts for a given customer
`http://localhost:8080/api/customer/{customerId}/account{id}` - GET - Get an account for a given customer
`http://localhost:8080/api/customer/{customerId}/account` - PUT - Update an account for a given customer passing in the JSON representation
`http://localhost:8080/api/customer/{customerId}/account/{id}/deposit/{amount}` - PUT - Deposit an amount for a given account for a given customer
`http://localhost:8080/api/customer/{customerId}/account/{id}/withdraw/{amount}` - PUT - Withdraw an amount for a given account for a given customer
`http://localhost:8080/api/customer/{customerId}/account/transfer/{fromAccountId}/{toAccountId}/{amount}` - PUT - Transfer an amount from a given account to another for a given customer
`http://localhost:8080/api/customer/{customerId}/account` - DELETE - Remove an account for a given customers passing in the JSON representation


to run WITHOUT docker

`./gradlew bootRun`

