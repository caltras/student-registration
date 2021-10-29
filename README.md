# School registration

## How setup the project

To run the project on local environment you will nedd to install
 * JDK 17 - Helper (https://sdkman.io/install)
 * Docker && docker-compose
 * IDE (VScode, Intelij) or terminal


## Build the project

To build the project, you have to run the command `./gradlew build`.

## Test the project

you can run the test isolated (after build), running the command `./gradlew test`.
It will run the functional tests and unit tests.

The reports are available under the folder `build/reports`


## Run the project

You can run the project using the command `./gradlew bootRun` or through docker-compose

`docker-compose up`.
The endpoints will be expose on port `8080`

## Endpoints

Local server  = http://localhost:8080

### Student

GET `/student/{id}` - Returns a student based on id param

    - return a `Student` object

DELETE `/student/{id}` - Delete a student based on id param

    - return `Boolean`

POST `/student/` - Create a new Student

    - payload (json): 
        `name`: Student's name
        `dateOfBirthday`: Student's birthday (format: yyyy-MM-dd)

    - return a `Student` object


PUT `/student/` - Update an existent student

    - payload (json): 
        `id`: Student's id
        `name`: Student's name
        `dateOfBirthday`: Student's birthday (format: yyyy-MM-dd)

    - return a `Student` object

### Course

GET `/course/{id}` - Returns a course based on id param

    - return a `Course` object

DELETE `/course/{id}` - Delete a course based on id param

    - return `Boolean`

POST `/course/` - Create a new course

    - payload (json): 
        `name`: course's name
    - return a `Course` object


PUT `/course/` - Update an existent course

    - payload (json): 
        `id`: course's id
        `name`: course's name

    - return a `Course` object

### Registration

GET `/course/{courseId}/student/{studentId}`

    - returns a String with the result of registration.
        Examples:
        `Student xxxx has enrolled to the course yyyy` - Success to register

        `Student xxxx has already enrolled to the course yyyy` - Duplicated register, dont' save

        `Student reached the limit of 5 courses` - Don't save

        `Course reached the limit of 50 students.` - Don't save


### Report

GET `/admin/registrations/course/{courseId}` - Returns list of students in the course
    
     return List<Student>

GET `/admin/registrations/student/{studentId}` - Returns list of courses that the students is enrolled
    
    - return List<Course>

GET `/admin/registrations/empty-courses` - Returns list of courses with no students enrolled
    
    - return List<Course>

GET `/admin/registrations/no-enrolled-students` - Returns list of students registered in none course
    
    - return List<Student>
    





