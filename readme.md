## Specific to MySQL 8.0

After MySQL 8.0, MySQL support is a separate dependency for Flyway and will need to be added to your Java project to access these features.
So you need to add the following maven dependency in the POM. 

Maven
Community

```
<dependency>
<groupId>org.flywaydb</groupId>
<artifactId>flyway-mysql</artifactId>
</dependency>
````

Teams
````
<dependency>
<groupId>org.flywaydb.enterprise</groupId>
<artifactId>flyway-mysql</artifactId>
</dependency>
````
Gradle Community
````
dependencies {
compile "org.flywaydb:flyway-mysql"
}
````
Teams
````
dependencies {
compile "org.flywaydb.enterprise:flyway-mysql"
}
````

## For MySQL:

>Driver: com.mysql.cj.jdbc.Driver
>
>URL : jdbc:mysql://localhost:3306/test

## Config flyway 
### For a real database
It needs to turn hibernate auto-generate DDL off.

````
spring.jpa.hibernate.ddl-auto=none
````

### Default flyway folder

By default, it is located at src:resources folder, with a default folder name: db/migration

#### Create migration SQL file

Create a new file with the following naming convention:

>Prefix: Defaults to V.
>Version: Dots or underscores separated in as many parts as one likes.
>Separator: Defaults to __ (two underscores) and separates the version from the description.
>Description: A text with words separated by underscores or spaces.
>Suffix: Defaults to .sql.
 
### Install flyway maven plugin in POM plugins 
run maven command to migrate ddl to the database

````
 mvn compile flyway:migrate
````