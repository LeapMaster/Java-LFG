# Java Class Design

## Controller

### IndexServlet
- Loads initial home page with query of latest posts.
- Processes filtered search of posts
- Processes new post insert

### LoginServlet
- Processes user login and redirects according. Sets session attribute for logged user on success.

### LogoutServlet
- Invalidates session and redirects back home.

### Profile Servlet
- Loads data for logged in user, and allows users to change that data

### PropertiesFileLoader
- Can be instantiated anywhere in project to load the properties file

## RegisterServlet
- Processes registering a new User insert, redirects based on insert success.

## RegistrationSuccess
- Simply redirects to registration success page on successful registration.

## Entity

### LFGPost 
- Object to store data for LFG ticker posts.

### User
- Object to store data for Users and their character data

## Persistence

### LFGPostDAO
- Hibernate DAO to run queries on the lfg_post table

### UserDAO
- Hibernate DAO to run queries on the users table

### SessionFactoryProvider
- Boilerplate Hibernate class for building sessions
