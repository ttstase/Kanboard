## UI and API tests for the Kanboard application
### Deployment instruction:
* Java 17, Maven 3.9.2, Docker Desktop are installed
* Copy the docker-compose.yml file
* run the command $ docker compose up on the folder with the file
* make sure that the container with Kanboard app is running
* Token is unique for each localhost --> TBM in upcoming test refactoring
* Login: admin, password: admin
* Navigate to get API token: Settings/API
* Change token value in env.properties

### Run tests commands:
* mvn clean test -Papitests - for running API tests
* mvn clean test -Palltests -Dbrowser=chrome -Dheadless=false - for running all tests in Chrome

* mvn clean test -Puitests -Dbrowser=chrome -Dheadless=false - for running UI tests in Chrome
* mvn clean test -Puitests -Dbrowser=chrome -Dheadless=true - for running UI tests in Chrome headless mode
* mvn clean test -Puitests -Dbrowser=firefox -Dheadless=false - for running UI tests in Firefox
### Run the commands to get Allure report
* allure generate target/allure-results --clean
* allure serve target/allure-results# Kanboard
