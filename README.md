# zoetic-assigment

Spring Profile env name is `SPRING_PROFILES_ACTIVE`.

Furthermore, `service-account.json` must be provided. Contact admins to obtain file.

## Live Environments
- https://zoetic.ozdemirden.com

## secret

#### Generate tls secret
```
kubectl create secret tls tls-secret --key="private.key" --cert="certificate.crt"
```

#### Generate mongo secret 
```
kubectl create secret generic mongo-secret --from-literal='username=<username>' --from-literal='password=<password>'
```