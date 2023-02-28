# Guide

### Information about the app

- The app used JaxB after comparison with other libraries.
- I used docker to run Postgres, and docker compose to run both
- I used the global exception handle advice controller to handle different exceptions (Without try catches)
- I couldn't add more test because of inifinite errors
- I used profiles, working with dev profile when running the application

### Instruction to run the app

1-  first run a maven profile : clean install (could also add -DskipTests) to skip tests
2- run docker-compose up on terminal, both containers will run after pulling image and building container.
3- then use either postman or curl to run queries.