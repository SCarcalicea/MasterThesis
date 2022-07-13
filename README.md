# IMPLEMENTATION OF CLOUD ARCHITECTURED APPLICATIONS USING NOSQL DATABASES FOR SMART CITIES

Cloud agnostic and platform independent application. 
Display Timisoara public transportation vehicles in real time on a Google Map. 

Technologies:
- Java 11;
- Spring Framework;
- Lombok;
- PrimeFaces (UI);
- Mongo DB;
- Maven;
- Docker.

Links to academic papers and resources:
- https://www.sciencedirect.com/science/article/abs/pii/S026322411931084X
- https://ec.europa.eu/info/eu-regional-and-urban-development/topics/cities-and-urban-development/city-initiatives/smart-cities_en
- https://www.sciencedirect.com/science/article/pii/S2352146521005366
- https://www.sciencedirect.com/science/article/pii/S2352146521005366
- https://www.manning.com/books/spring-in-action-sixth-edition?query=spring%20in%20action
- https://www.elefant.ro/introducing-maven-a-build-tool-for-today-s-java-developers-paperback_910e7c07-e1dc-49f3-929a-c43cd4fbc23b?gclid=CjwKCAiA866PBhAYEiwANkIneJGAigsYvQh45r-HsRBQkgLQRRub4ixapGEAN-nG_x7gIySY8V_3LBoC3zcQAvD_BwE
- https://www.enbook.ro/catalog/product/view/id/2599795?gclid=CjwKCAiA866PBhAYEiwANkIneAgLSVU1cWBhapKjpnNQseLtBhBMIuKro9-71X1H8TKnGExoPhyblRoCAkwQAvD_BwE
- https://www.redhat.com/en/topics/devops/what-is-ci-cd
- https://git-scm.com/about

To run the application you just need run these commands from the terminal:
- mvn clean install; (compile the code into a jar file)
- docker-compose build; (build the application)
- docker-compose up. (deploy the application)

Or run this Run Config from IntelliJ:
- "Deploy to Docker";

You just need a Docker and MongoDB installed and if you choose to run it from IntelliJ:
- then run "Main" from IntelliJ run configs.
