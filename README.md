# Spring Security Demo

Example Authentication and Authorization using Spring Framework and JPA

Sits on Postgres, using Spring Security.

## Deployment

You'll need to config some env vars for `application.properties` to know about things.

    DATASOURCE_URL=[your_database_url]
    DATASOURCE_USERNAME=[your_database_username]
    DATASOURCE_PASSWORD=[your_database_password]

Note: `DATASOURCE_URL` is a JDBC thing that should look something like:

    jdbc:postgresql://localhost:5432/my_database_name

### Notes:

Get BCrypt passwords from bash:

`htpasswd -nbBC 10 USER [your_password]`

### TODO:
1. **DONE** ~~Store b-crypt passwords with salt~~
2. Relational records with JPA + Hibernate
3. OAuth login
4. Hal-Browser for API browsing UI
5. Account Registration
6. Field and Method level Authorization ROLE filters.
7. **DONE** ~~Move Spring-Data API to /api~~
8. **DONE** ~~Deploy to Heroku~~
9. Figure out file-uploads and configs to GCP buckets.
10. Use JSP Pages for pages
