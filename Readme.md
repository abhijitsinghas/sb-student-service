# Spring Boot Restful Service Demo

## Maven Commands
### Launch Spring Boot Application
```console
mvn spring-boot:run
```

### Terminate Application
Press `Ctrl + c`

## Rest Requests
### POST - Create student
```console
curl -v -X POST -d '{"firstName":"Varun","lastName":"Dube","age":18,"gender":"MALE","standard":10}' -H 'Content-Type: application/json' http://localhost:8080/student
```

### GET - Get student
```console
curl -v -X GET -H 'Accept: application/json' http://localhost:8080/student/{uuid}
```

### PATCH - Update student
```console
curl -v -X PATCH -d '{"firstName":"Varun","lastName":"Dube","age":40,"gender":"MALE","standard":12}' -H 'Content-Type: application/json' http://localhost:8080/student/{uuid}
```

### DELETE - Delete Student
```console
curl -v -X DELETE -H 'Content-Type: application/json' http://localhost:8080/student/{uuid}
```