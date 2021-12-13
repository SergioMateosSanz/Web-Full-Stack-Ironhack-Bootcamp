Using Feign and Eureka, complete the following:

1. Refactor your lab from the previous set of lab to use OpenFeign instead of RestTemplates

2. Build the following:

* Service with a database that stores product names and prices in USD. With a simple GET by id route.
* A service without a database with a single route that takes in a price in USD and a currency and returns the price in the new currency (you may approximate the exchange rate)
* An edge service with a single GET route that takes in a product id and currency and returns the product name and price in the specified currency.
