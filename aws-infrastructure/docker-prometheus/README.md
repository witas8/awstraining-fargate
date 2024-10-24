# Push image to ECR
Run below commands to push our custom Prometheus image to ECR.
```
aws ecr get-login-password --region eu-central-1 --profile backend-test | docker login --username AWS --password-stdin 084828574290.dkr.ecr.eu-central-1.amazonaws.com
```

```
docker build -t prometheus-custom .
```

```
docker tag prometheus-custom 084828574290.dkr.ecr.eu-central-1.amazonaws.com/monitoring:prometheus
```

```
docker push 084828574290.dkr.ecr.eu-central-1.amazonaws.com/monitoring:prometheus
```