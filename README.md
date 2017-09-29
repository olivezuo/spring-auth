# spring-auth

## Design and implementation
This is a standalone Authentication/Authorization server implementation. To make it work in 
the microservice architecture, we divide the functions into to 2 parts:

### 1. Authentication/Authorization for Microservice
1. For any Microservice that provide public API, we will create API users in the auth 
   server.
2. Assign a role to the API user.
3. API permission is setup in the Microservice.

### 2. Authorization for a gateway layer of a web application which using all the microservice as backend.
1. User Authentication is taken care in the web app layer, which can be any authentication 
   provider. (Siteminder, LDAP, etc)
2. An user will be assigned to one or more groups
3. ACL is setup in the DB 
4. API gateway layer will setup the permission of the API exposed to web layer. 

## Future work
1. We can create different ACL module in the server for different Authorization purpose.
2. Can be extended to be a authentication server for web app layer.

