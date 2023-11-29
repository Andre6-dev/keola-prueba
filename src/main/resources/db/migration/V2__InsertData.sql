INSERT INTO roles (nombre_rol) VALUES ('ROLE_USER');
INSERT INTO roles (nombre_rol) VALUES ('ROLE_ADMIN');

INSERT INTO users (id, creado_en, modificado_en, nombre_usuario, apellido_usuario, username, correo, contrasena)
VALUES
    ('1fbb539d-bf79-4e7a-a156-52b979a4e34d', '2023-11-29 10:00:00', '2023-11-29 10:00:00', 'John', 'Doe', 'johndoe', 'john@example.com', 'hashedpassword123');
INSERT INTO users (id, creado_en, modificado_en, nombre_usuario, apellido_usuario, username, correo, contrasena)
VALUES
    ('2c6f3e22-8fc6-45a9-a722-9687b5e0a9b4', '2023-11-29 11:00:00', '2023-11-29 11:00:00', 'Jane', 'Smith', 'janesmith', 'jane@example.com', 'hashedpassword456');

INSERT INTO products (id, creado_en, modificado_en, name, price, stock, usuario_id)
VALUES
    ('6a315657-0b8d-4e87-9d63-4fa2177a128f', '2023-11-29 12:00:00', '2023-11-29 12:00:00', 'Product 1', 19.99, 100, '1fbb539d-bf79-4e7a-a156-52b979a4e34d');
INSERT INTO products (id, creado_en, modificado_en, name, price, stock, usuario_id)
VALUES
    ('8e0f9781-df2e-4f29-a30d-3b6d1875b6a2', '2023-11-29 13:00:00', '2023-11-29 13:00:00', 'Product 2', 29.99, 50, '2c6f3e22-8fc6-45a9-a722-9687b5e0a9b4');
