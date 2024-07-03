#### Endpoint: 
- POST /files/upload/blob [accepts any file format]: uploads any file into database as blob.
- POST /files/upload/csv [accepts csv]: parse csv (account_numbers)
- POST /files/upload/json [accepts json]: parse json (account_numbers)
- POST /accounts: creates one or multiple account.
- GET /accounts

#### Schema:
- FILE_UPLOAD

    Long file_upload_id - Auto generated
    
    Instant uploaded_timestamp current_timestamp

- ACCOUNT
    
    Long account_id - Auto generated
    
    file_upload_id - FK
    
    Long account_number


    
