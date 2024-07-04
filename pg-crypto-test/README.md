### Bulk Upload Account
curl --location 'localhost:8081/accounts/bulk?type=current&status=active' \
--header 'Content-Type: application/json' \
--data '{
"accounts": [
"1221221","1212121","33333333333"
]
}'

Other account attributes are hardcoded.

### Add one Account
curl --location 'localhost:8081/accounts' \
--header 'Content-Type: application/json' \
--data '{
"number":"0000000000",
"type": "savings",
"createUserId": "user1",
"status": "active"
}'


### Get all accounts
curl --location 'localhost:8081/accounts'