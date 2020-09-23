# zoetic-assigment
This application is developed by Ahmet Semsettin Ozdemirden. Java Spring Boot, MongoDB, GitlabCI, Docker and Kubernetes is used. Hosted on Google Cloud Platform. Spring Profile env name is `SPRING_PROFILES_ACTIVE`.

## Tests
Controllers and services are 100% unit tested. There are e2e test in the mobile side. I would also write web service tests with [karate](https://github.com/intuit/karate) and [testcontainers](https://www.testcontainers.org) but unfortunately I don't have that much time :(. For the contract between mobile and server [pact](https://docs.pact.io/) can be used.

## Live Environments
- https://zoetic.ozdemirden.com

## MongoDB
MongoDB Atlas is primary choice since firstly It's free to use shared instances, secondly It's well managed and backed by MongoDB itself.

## Docker
It works on not only my machine, It works on everywhere! You will find two different docker files, `Base.dockerfile` is here for caching maven dependencies.

## CI/CD
This project includes full continues delivery pipeline, which means your code will be compiled, tested, containerized, pushed and deployed to production.

## Kubernetes
To serve thousands of users your infrastructure needs to scale easily. You can find kubernetes configurations ready to scale in `k8s` folder. Kubernetes also enables that your infrastructure is written as code. 

### [The Twelve-Factor App](https://12factor.net/)
This project follows [The Twelve-Factor App](https://12factor.net/) principles, such as 'secrets as environment variables'.

#### Generate tls secret
```
kubectl create secret tls tls-secret --key="private.key" --cert="certificate.crt"
```

#### Generate mongo secret 
```
kubectl create secret generic mongo-secret --from-literal='username=<username>' --from-literal='password=<password>'
```

## Folder Structure
```
|-- k8s
`-- src
    |-- main
    `-- test
    |-- main
    |   |-- java
    |   |   `-- com
    |   |       `-- zoetic
    |   |           `-- ahmetsemsettinozdemidenassigment
    |   |               |-- config
    |   |               |-- controller
    |   |               |-- dto
    |   |               |-- model
    |   |               |-- repository
    |   |               |-- service
    |   |               `-- util
    |   `-- resources
    `-- test
        `-- java
            `-- com
                `-- zoetic
                    `-- ahmetsemsettinozdemidenassigment
                        |-- controller
                        `-- service
```