# Spring Security using JWT (Json Web Token) in Spring Boot

This Project uses JWT to secure the REST endpoints.

The Following are the REST end points available in the example.
- `/login` - Generates the JWT token based on the JSON sent. Its a POST method which expects the JSON: `{ "username": "name", "id": 123, "role": "admin"}`
- `/rest/hello/user` - Requires a JWT Token with Header `key - "Authorization"` and `value - "Bearer <JWT_Token>"`

# Create the keystore with something like this.
` keytool -genkey -keyalg RSA -alias jwtkey -keystore keystore.jks -storepass XXXX -validity 360 -keysize 2048`

# Export the certificate from keytool and convert it to DER format
` keytool -list -rfc -keystore keystore.jks -alias jwtkey -storepass xxxx | openssl x509  -outform der -out cert1.der`


# Authorizations
- `rest/hello/user` - This REST API is availabe for `ROLE_USER`, `ROLE_POWERUSER`, `ROLE_ADMIN`
- `rest/hello/power` - This REST API is availabe for `ROLE_POWERUSER`, `ROLE_ADMIN`
- `rest/hello/admin` - This REST API is availabe for `ROLE_ADMIN`

