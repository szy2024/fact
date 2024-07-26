CREATE TABLE USER_INFO_TBL
(
    USER_ID                     VARCHAR(8) NOT NULL,
    USER_NAME                   VARCHAR(100),
    PASSWORD                    VARCHAR(8) NOT NULL,
    COMPANY_NAME                VARCHAR(100) NOT NULL,
    CREATE_ID                   VARCHAR(30) NOT NULL,
    CREATE_DATE                 DATE DEFAULT sysdate NOT NULL,
    UPDATE_ID                   VARCHAR(30),
    UPDATE_DATE                 DATE,
    CONSTRAINT USER_INFO_TBL_PK PRIMARY KEY (USER_ID)
);
