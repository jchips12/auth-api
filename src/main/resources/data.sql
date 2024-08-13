INSERT INTO members (id, first_name, last_name, email, username, password) VALUES
    (1,'Juan','Carlos','john@gmail.com','john','$2a$12$.DNBDk4w3VlG6Fn3sNmUOeCw6VXuVa7O3oDCfvRrfMucwMn5VthQK'),
    (2,'Uncle','Sam','sam@email.com','sam','$2a$12$FujPv5E0QKVRVt1zIIu3GuTMxkvLs9dEgTQOx0z8WYfyjYJAZF0Zm');

INSERT INTO roles VALUES (1,'USER'),(2,'ADMIN'),(3,'SUPERADMIN'),(4,'GUEST'),(5,'ANONYMOUS');

INSERT INTO members_roles(member_id, role_id) VALUES (1,1),(1,4),(2,2);