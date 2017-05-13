## MonolithicApplication
Monolithic Application developed to be used on paper which compare THIS monolithic application with a same application but with developed with microservices architecture.

#### How it works
This application works simple way.
After build and run the application, you can perform a GET, PUT, POST and DELETE to http://localhost:3000/api/perform-a-get?stepsReceived=1234 .
Each number passed by argument `stepsReceived` is a service which will be called from the service that was called. The return will be a list of service called and your respectively HTTP code status.

List of services and your respective number associated:

```
'1' = GET SERVICE
'2' = POST SERVICE
'3' = DELETE SERVICE
'4' = PUT SERVICE
```

List of all resource available on this application:

 ```
 GET    = /api//perform-a-get
 POST   = /api/perform-a-post
 DELETE = /api/perform-a-delete
 PUT    = /api/perform-a-put
 ```

#### Example:

You perform a GET passing `stepsReceived=23415` as argument like this: `http://localhost:3000/api/perform-a-get?stepsReceived=23415` the application will receive this request into `GetService` class which will call the `RouterService` to manipulate all steps passed by argument. The `RouterService` will add into a list all result passed as response by services called. `23415` represents that `RouterService` will call in this sequence: `POST, DELETE, PUT and GET` services. The last number (`5`) is a `UNKNOWN_METHOD` so the `RouterService` will add into the list a `BAD_REQUEST` response.

Below the response of this request:

```
[
  {
    "methodCalled": "POST_METHOD",
    "httpStatus": "OK"
  },
  {
    "methodCalled": "DELETE_METHOD",
    "httpStatus": "OK"
  },
  {
    "methodCalled": "PUT_METHOD",
    "httpStatus": "OK"
  },
  {
    "methodCalled": "GET_METHOD",
    "httpStatus": "OK"
  },
  {
    "methodCalled": "UNKNOWN_METHOD",
    "httpStatus": "BAD_REQUEST"
  }
]
```

PS: All response is sent in `Json` format
