Specifications

1. Using the Spring JPA model the relationships of the below application:

Assume that you are working with Task Management software. Below are the requirements in regards to data storage:

* Tasks have a title, dueDate, and a boolean status
* There are 2 kinds of tasks BillableTask and InternalTask. The BillableTask have an hourlyRate.

2. Using the Spring JPA model the relationships of the below application:

Assume that you are working with a PR company to model their data. Below are the requirements in regards to data storage:

* The database consists of Contacts. Each Contact has a name, title, and company.
* Names are their own object and have a firstName, lastName, middleName, and salutation.
* Names should not be stored in a separate table in the database.

3. List 3 tasks that can be accomplished with native SQL that you cannot do with JPQ.
* Use subqueries outside of WHERE and HAVING clauses. With JPQL, you can use subqueries only in the WHERE and HAVING clauses but not in the SELECT and FROM clause.
* Perform set operations (UNION, INTERSECT and EXCEPT).
* Write recursive queries.
[Source] (https://thorben-janssen.com/query-complex-jpa-hibernate/).
