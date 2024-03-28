README
------

Download the code.

Go to folder where pom.xml is present througn command prompt

To build the application
> mvn clean install

To run the application
>mvn spring-boot:run

The store endpoint is 
URL: http://localhost:8080/api/employee/store
Method: post
Body
{
    "employeeid": "employeeId",
    "FirstName": "firstName",
    "LastName": "lastName",
    "Email": "abc@gmail.com",
    "DOJ": "2023-11-20",
    "Salary": 100000
}


The list endpoint is
URL: http://localhost:8080/api/employee/tax
METHOD: GET