Retention service
-
Two ways to trigger the process
1. Endpoint `/trigger`
2. Scheduler

Process calls endpoint 

```mermaid
sequenceDiagram
    retention-service ->> downstream-service: GET: /eligible?cutOffDate
    downstream-service ->> database: select records by cutoffdate
    database ->> downstream-service: returns the records <br/> from multiple tables
    downstream-service ->> retention-service: EligibleRecordDto

    retention-service ->> downstream-service: POST: /remove <br/> RemovableDto
    downstream-service ->> database: update the records <br/> by request payload
    database ->> downstream-service: returns the number of records <br/> from multiple tables
    downstream-service ->> retention-service: Map<String, Integer>
    
```

Downstream service
-

Deletion of records
Two ways to trigger the process
1. Endpoint `/trigger`
2. Scheduler

```mermaid
sequenceDiagram
    downstream-service ->> downstream-service: GET: /removable?cutOffDate
    
```
