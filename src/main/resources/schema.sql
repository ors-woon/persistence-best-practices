
DROP TABLE IF EXISTS Author;
DROP TABLE IF EXISTS Book;

CREATE TABLE Author
(
    id     IDENTITY PRIMARY KEY,
    age    int NOT NULL,
    genre  VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NOT NULL
);

CREATE TABLE Book
(
    id        IDENTITY PRIMARY KEY,
    isbn      VARCHAR(255) NOT NULL,
    title     VARCHAR(255) NOT NULL,
    author_id int          NOT NULL,
    FOREIGN KEY (author_id) references Author
);
