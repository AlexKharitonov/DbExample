### Start PostgreSql in Docker


```
docker run --name my-postgres \
-e POSTGRES_USER=dbuser \
-e POSTGRES_PASSWORD=dbpassword \
-e POSTGRES_DB=mydb \
-p 5432:5432 \
-d postgres:16
```

### Create User table
```
CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    lastName VARCHAR(150) NOT NULL
);
```