package collections.introduction

fun Shop.getSetOfCustomers(): Set<Customer> = this.customers.toSet()

// Return the set of cities the customers are from
fun Shop.getCitiesCustomersAreFrom(): Set<City> = this.customers.map { customer -> customer.city }.toSet()

// Return a list of the customers who live in the given city
fun Shop.getCustomersFrom(city: City): List<Customer> = this.customers.filter { customer -> customer.city == city }

// Return true if all customers are from the given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean = this.customers.all { customer -> customer.city == city }

// Return true if there is at least one customer from the given city
fun Shop.hasCustomerFrom(city: City): Boolean = this.customers.any { customer -> customer.city == city }

// Return the number of customers from the given city
fun Shop.countCustomersFrom(city: City): Int = this.customers.count { customer -> customer.city == city }

// Return a customer who lives in the given city, or null if there is none
fun Shop.findAnyCustomerFrom(city: City): Customer? = this.customers.find { customer -> customer.city == city }

// Return all products this customer has ordered
val Customer.orderedProducts: Set<Product>
    get() {
        return this.orders.flatMap { order -> order.products }.toSet()
    }

// Return all products that were ordered by at least one customer
val Shop.allOrderedProducts: Set<Product>
    get() {
        return this.customers.flatMap { customer ->
            customer.orders.flatMap { order -> order.products }
        }.toSet()
    }

// Return a customer whose order count is the highest among all customers
fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? =
    this.customers.maxBy { customer -> customer.orders.count() }

// Return the most expensive product which has been ordered
fun Customer.getMostExpensiveOrderedProduct(): Product? =
    this.orders.flatMap { order -> order.products }.maxBy { product -> product.price }

// Return a list of customers, sorted by the ascending number of orders they made
fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer>
    = this.customers.sortedBy { customer -> customer.orders.count() }

// Return the sum of prices of all products that a customer has ordered.
// Note: the customer may order the same product for several times.
fun Customer.getTotalOrderPrice(): Double
    = this.orders.flatMap { order -> order.products }.sumByDouble { product -> product.price }

// Return a map of the customers living in each city
fun Shop.groupCustomersByCity(): Map<City, List<Customer>>
    = this.customers.groupBy { customer -> customer.city }

fun main(args: Array<String>) {
    println(shop.groupCustomersByCity())
}