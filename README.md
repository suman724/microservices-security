# Spring Security using JWT (Json Web Token) in Spring Boot

This Project uses JWT to secure the REST endpoints.

The Following are the REST end points available in the example.
- `/token` - Generates the JWT token based on the JSON sent. Its a POST method which expects the JSON: `{ "username": "name", "id": 123, "role": "admin"}` 
- `/rest/hello` - Requires a JWT Token with Header `key - "Authorisation"` and `value - "Token <JWT_Token>"`

# Create the keystore with something like this.
` keytool -genkey -keyalg RSA -alias jwtkey -keystore keystore.jks -storepass XXXX -validity 360 -keysize 2048`

# Export the certificate from keytool and convert it to DER format
` keytool -list -rfc -keystore keystore.jks -alias jwtkey -storepass xxxx | openssl x509  -outform der -out cert1.der`




