### Flow
1. Load data into Postgres (table: pan_details) from data.sql on startup.
2. Trigger the batch from api: /migrate
   - Reads data from Postgres 
   - Call Crypto API to encrypt the pan_number
   - Write data into MySql (table: pan_details) 