# zoetic-assigment
This application is developed by Ahmet Semsettin Ozdemirden. Java Spring Boot, MongoDB, GitlabCI, Docker and Kubernetes is used. Hosted on Google Cloud Platform. Spring Profile env name is `SPRING_PROFILES_ACTIVE`.

## Live Environments
- https://zoetic.ozdemirden.com

## Docker
It works on not only my machine, It works on everywhere! You will find two different docker files, `Base.dockerfile` is here for caching maven dependencies.

## CI/CD
This project includes full continues delivery pipeline, which means your code will be compiled, tested, containerized, pushed and deployed to production.

## Kubernetes
To serve thousands of users your infrastructure needs to scale easily. You can find kubernetes configurations ready to scale in `k8s` folder. Kubernetes also enables that your infrastructure written as a code  

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