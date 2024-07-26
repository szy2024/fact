CREATE TABLE ITEM_AUTH_MANAGEMENT_TBL
(
    SEQ_NO                      VARCHAR(6) NOT NULL,
    SCREEN_ID                   VARCHAR(9),
    SCREEN_ITEM                 VARCHAR(100) DEFAULT 'Å@' NOT NULL,
    VISIBLE_AUTH                VARCHAR(255),
    PROTECT_AUTH                VARCHAR(255),
    CREATE_ID                   VARCHAR(30) NOT NULL,
    CREATE_DATE                 DATE DEFAULT sysdate NOT NULL,
    UPDATE_ID                   VARCHAR(30),
    UPDATE_DATE                 DATE,
    CONSTRAINT SYS_C007000 PRIMARY KEY (SEQ_NO)
);
