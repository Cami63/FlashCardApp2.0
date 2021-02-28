CREATE DATABASE flash;
USE flash;
CREATE TABLE sets (
    id BIGINT NOT NULL AUTO_INCREMENT,
    setName VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE cards (
    id BIGINT NOT NULL AUTO_INCREMENT,
    cardFront VARCHAR(255) NOT NULL,
    cardBack VARCHAR(255) NOT NULL,
    setId BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT setId_fk FOREIGN KEY (setId) REFERENCES flash.sets (id)
);
CREATE TABLE correct (
    id BIGINT NOT NULL AUTO_INCREMENT,
    dateTime TIMESTAMP NOT NULL,
    cardId BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT cardId_correct_fk FOREIGN KEY (cardId) REFERENCES flash.cards (id)
);
CREATE TABLE wrong (
    id BIGINT NOT NULL AUTO_INCREMENT,
    dateTime TIMESTAMP NOT NULL,
    cardId BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT cardId_wrong_fk FOREIGN KEY (cardId) REFERENCES flash.cards (id)
);

DELIMITER $$
CREATE PROCEDURE flash.addSet (
    setNam VARCHAR(255)
)
BEGIN
    INSERT INTO flash.sets (setName)
        VALUES (setNam);
    SELECT LAST_INSERT_ID();
END$$
CREATE PROCEDURE flash.addCard (
    cardFron VARCHAR(255),
    cardBac VARCHAR(255),
    setI BIGINT
)
BEGIN
    INSERT INTO flash.cards (cardFront, cardBack, setId)
        VALUES (cardFron, cardBac, setI);
END$$
CREATE PROCEDURE flash.addCorrect (
    cardI BIGINT,
    dateTim TIMESTAMP
)
BEGIN
    INSERT INTO flash.correct (dateTime, cardId)
        VALUES (dateTim, cardI);
END$$
CREATE PROCEDURE flash.addWrong (
    cardI BIGINT,
    dateTim TIMESTAMP
)
BEGIN
    INSERT INTO flash.wrong (dateTime, cardId)
        VALUES (dateTim, cardI);
END$$
CREATE PROCEDURE flash.searchDecks (
    keyword VARCHAR(255)
)
BEGIN
    SELECT se.id, se.setName
    FROM sets AS se
    WHERE se.setName LIKE CONCAT('%', keyword, '%');
END$$
CREATE PROCEDURE flash.selectPracticeSet (
    setI BIGINT
)
BEGIN
    WITH cte1 AS
    (
        (SELECT car.id, car.cardFront, car.cardBack, HOUR(TIMEDIFF(NOW(), cor.dateTime)) AS x, 1 AS correct
        FROM correct AS cor
            RIGHT JOIN cards AS car
                ON cor.cardId = car.id AND car.setId = setI)
        UNION
        (SELECT car.id, car.cardFront, car.cardBack, HOUR(TIMEDIFF(NOW(), cor.dateTime)) AS x, -1 AS correct
        FROM wrong AS wr
            RIGHT JOIN cards AS car
                ON wr.cardId = car.id AND car.setId = setI)
    )
    SELECT SUM(correct*(CASE
        WHEN (x < 1) THEN 10
        WHEN (x >= 1 AND x < 24) THEN 9
        WHEN (x >= 24 AND x < 72) THEN 8
        WHEN (x >= 72 AND x < 168) THEN 7
        WHEN (x >= 168 AND x < 672) THEN 6
        WHEN (x >= 672) THEN 1
    END)) AS points, cte1.id
    FROM cte1
    GROUP BY cte1.id
    ORDER BY points ASC
    LIMIT 10;
END$$
DELIMITER ;