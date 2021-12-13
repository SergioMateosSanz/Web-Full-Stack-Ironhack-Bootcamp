Set up

For these labs, you will need to create two database tables and seed them with some sample data. The database data represents mock clients for a multi-city hospital.

employee_id	department	name			status
356712		cardiology	Alonso Flores	ON_CALL
564134		immunology	Sam Ortega		ON
761527		cardiology	German Ruiz		OFF
166552		pulmonary	Maria Lin		ON
156545		orthopaedic	Paolo Rodriguez	ON_CALL
172456		psychiatric	John Paul Armes	OFF

Note that admitted_by is a foreign key to the employee table.

patient_id	name			date_of_birth	admitted_by
1		Jaime Jordan		1984-03-02	    564134
2		Marian Garcia		1972-01-12	    564134
3		Julia Dusterdieck	1954-06-11	    356712
4		Steve McDuck		1931-11-10	    761527
5		Marian Garcia		1999-02-15	    172456


Specifications

Create the routes below as efficiently as possible using validation where appropriate.

1. Create a route to add a new patient.
2. Create a route to add a new doctor.
3. Create a route to change a doctor’s status.
4. Create a route to update a doctor’s department.
5. Create a route to update patient’s information (the user should be able to update any patient information through this route).
In your README.md write a short answer to the following questions:
* Did you use the same type of route to update patient information and to update an employee department?
  No. There are different resources.
* Why did you choose the strategy that you chose?
  Follow REST API design.
* What are the pros and cons of the strategies you chose for creating these routes?
  Build standard APIs. It is a documented interface and easy to use. On the other hand, learning curve is high.
* What are the tradeoffs between PUT and PATCH?
  PUT replace all information in database, and PATCH only modify some information.
