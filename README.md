# Rating-System

Assumptions i have made are:
1.Rating out of 5 will be given to the user(user can be driver or passenger)

Approach:
I am using two table one is user and other is user_rating.User will be differentiated on the basis of user type(DRIVER,PASSENGER).So user table will contain some basic fields and user type.User rating table will have rating and user(reference) as main fields so that rating relative to user can be added in the table.Coming to business logic i have written two apis one to find user average rating on the basis of user id and to rate user (can be driver or passenger) i have created createUserRating method which will take rating and user id and add the rating to corrosponding user.Following are the descriptions for the apis.

1.Api to find average rating for user (work for both driver or passenger as i am taking user type in user)
URL:http://localhost:8080/ratingsystem/api/aggregatedRating/
Method Type:GET
Request Params:userId
EX.http://localhost:8080/ratingsystem/api/aggregatedRating/?userId=3


1.Api to rate user (work for both driver or passenger as i am taking user type in user)
URL:http://localhost:8080/ratingsystem/api/createUserRatingRecord/
Method Type:POST
Request Params:rating and userId
EX. http://localhost:8080/ratingsystem/api/createUserRatingRecord/?rating=2&userId=3

DB inital set up data:
I have added the seed_data you just need to create the schema ratingsystem and just run the some sql statements which you can find in src/main/java/resources/seed_data and also change the datasource setting as per your db in application properties file.

Steps to run the application:
1.Just import the project in spring boot (version above 2.0)
2.I assume maven installed on your computer so just run command:
mvn clean spring-boot:run 
3.To test apis just use the postman 
