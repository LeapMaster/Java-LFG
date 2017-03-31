# Java Class Design

## Controller

### IndexServlet
- Loads initial home page with query of latest posts. Will move NewPost and RunSearch to once they work.

### NewPost 
- Takes parameters from form and uses LFGPostDAO to insert a new post.

### RunSearch
- Takes parameters from form and runs a filtered search.

## Entity

### LFGPost 
- Object to store data for LFG ticker posts.

### User
- Object to store data for Users

## Persistence

### LFGPostDAO
- Hibernate DAO to run queries on the lfg_post table

### UserDAO
- Hibernate DAO to run queries on the users table

### SessionFactoryProvider
- Boilerplate Hibernate class for building sessions
