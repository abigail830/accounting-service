
CREATE TABLE INTERNAL_ACCT_TBL (
  ID VARCHAR(32) NOT NULL,
  CCY VARCHAR(3) NOT NULL,
  BALANCE DECIMAL NOT NULL,
  STATUS varchar(20) NOT NULL,
  LAST_UPDATE_AT TIMESTAMP NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE INTERNAL_ACCT_AUDIT_TRAIL_TBL
(
  ID           VARCHAR(32) NOT NULL,
  JSON_CONTENT JSON        NOT NULL,
  INTERNAL_ACCT_ID       VARCHAR(32) GENERATED ALWAYS AS (JSON_CONTENT ->> '$.internalAcctId') VIRTUAL,
  PRIMARY KEY (ID)
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

