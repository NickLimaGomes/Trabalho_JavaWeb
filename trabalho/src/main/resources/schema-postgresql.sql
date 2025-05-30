CREATE TABLE IF NOT EXISTS livros (
    id serial PRIMARY KEY,
    titulo varchar(50),
    autor varchar(30),
    ano_publicacao smallint,
    genero varchar(30)
);