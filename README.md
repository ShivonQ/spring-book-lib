# spring-book-lib
A Rudimentary CRUD &amp; REST api in spring &amp; Docker


##In order to get the DB up and running you need to Have Docker installed locally.

##Then a 'docker-compose up' command into your terminal/command line. (This should start up the database.)

##Thereafter you should be able to run the spring application itself.  Currently tyhe HTML pages do not work, so any in/out data you may want has to be done with Postman or Curl.

###In postman you would want to POST to 'localhost:8080/api/owners/' with the Body set to 'form-data' {firstName:whatever , lastName:whatever, email:whatever, phone:whatever}
