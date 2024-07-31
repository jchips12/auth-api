INSERT INTO members (id, username, password) VALUES
    (1,'john','$2a$12$.DNBDk4w3VlG6Fn3sNmUOeCw6VXuVa7O3oDCfvRrfMucwMn5VthQK'),
    (2,'sam','$2a$12$FujPv5E0QKVRVt1zIIu3GuTMxkvLs9dEgTQOx0z8WYfyjYJAZF0Zm');

INSERT INTO roles VALUES (1,'USER'),(2,'ADMIN');

INSERT INTO members_roles VALUES (1,1),(2,2);