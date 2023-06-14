CREATE TABLE IF NOT EXISTS conference(
    id SERIAL,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    assistants INT NOT NULL,
    PRIMARY KEY (id)
    );
CREATE TABLE IF NOT EXISTS assistant(
    id SERIAL,
    conference_id INT NOT NULL,
    fullname VARCHAR (100) NOT NULL,
    roles VARCHAR (100) NOT NULL,
    age INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (conference_id) REFERENCES conference(id)
    );