CREATE TABLE organizations (
   id SERIAL PRIMARY KEY,
   name TEXT NOT NULL,
   email TEXT UNIQUE,
   phone_number TEXT UNIQUE,
   cnpj TEXT UNIQUE,
   image_url TEXT
);