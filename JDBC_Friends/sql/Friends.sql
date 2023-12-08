CREATE TABLE FRIENDS (
       FRIEND_NO NUMBER(4)PRIMARY KEY,
       FRIEND_NAME VARCHAR2(15) NOT NULL,
       MOBILE VARCHAR2(13) UNIQUE,
       ADDR VARCHAR2(50)
);


INSERT INTO FRIENDS
VALUES (1, '둘리', '010-1234-1234', '쌍문동');

INSERT INTO FRIENDS
VALUES (2, '희동', '010-2345-1234', '쌍문동');

INSERT INTO FRIENDS
VALUES (3, '또치', '010-4567-1234', '쌍문동');

commit;

SELECT * FROM FRIENDS;
