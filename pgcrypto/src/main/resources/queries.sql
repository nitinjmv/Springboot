CASE-1: Flexible way
--------------------------------------
CREATE TABLE IF NOT EXISTS ACCT_TABLE
(
   ACCOUNT_ID BIGINT NOT NULL,
   ACCOUNT_NUMBER CHARACTER VARYING (255) NOT NULL,
   ACCOUNT_TYPE CHARACTER VARYING (255) NOT NULL,
   CREATED_DATE TIMESTAMP NOT NULL,
   STS CHARACTER VARYING (64) NOT NULL
)
WITH(
    OIDS=FALSE
);
# There is no encryption at table/col level
# so any plain text can be inserted and retrieved
INSERT INTO ACCT_TABLE (ACCOUNT_ID, ACCOUNT_NUMBER, ACCOUNT_TYPE, CREATED_DATE, STS) 
VALUES (nextval('ACCOUNT_SEQUENCE'), 9999, 'current', current_timestamp, 'A');

SELECT * FROM ACCT_TABLE;


# Encryption is achieved with pgcrypto extension.
# So table remains same and accepts both encrypted and plain-text
INSERT INTO ACCT_TABLE (ACCOUNT_ID, ACCOUNT_NUMBER, ACCOUNT_TYPE, CREATED_DATE, STS) 
VALUES (nextval('ACCOUNT_SEQUENCE'), pgp_sym_encrypt('555', 'mysecret'), 'current', current_timestamp, 'A');

SELECT PGP_SYM_DECRYPT(account_number::bytea, 'mysecret' ) from ACCT_TABLE;

DELETE FROM ACCT_TABLE;


CASE-2: Strict way
---------------------------------------
CREATE TABLE IF NOT EXISTS ACCT_TABLE1
(
   ACCOUNT_ID bigint NOT NULL,
   ACCOUNT_NUMBER bytea NOT NULL,
   ACCOUNT_TYPE CHARACTER VARYING (255) NOT NULL,
   CREATED_DATE TIMESTAMP NOT NULL,
   STS CHARACTER VARYING (64) NOT NULL
)
WITH(
    OIDS=FALSE
);

# byeta will save account_id as binanry_data
# No issue, data will get inserted without key
INSERT INTO ACCT_TABLE1 (ACCOUNT_ID, ACCOUNT_NUMBER, ACCOUNT_TYPE, CREATED_DATE, STS) 
VALUES (nextval('ACCOUNT_SEQUENCE'), '0000000', 'current', current_timestamp, 'A');

SELECT * FROM ACCT_TABLE1;

# to insert data with key
INSERT INTO ACCT_TABLE1 (ACCOUNT_ID, ACCOUNT_NUMBER, ACCOUNT_TYPE, CREATED_DATE, STS) 
VALUES (nextval('ACCOUNT_SEQUENCE'), pgp_sym_encrypt('555', 'mysecret'), 'current', current_timestamp, 'A');

SELECT PGP_SYM_DECRYPT(account_number::bytea, 'mysecret' ) from ACCT_TABLE1;

DELETE FROM ACCT_TABLE1;

