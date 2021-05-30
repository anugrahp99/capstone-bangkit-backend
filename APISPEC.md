# API Specification - Yubisayu
## Plant API

### Get Plant by Id

+ Endpoint : ``/api/plants/{id}``
+ HTTP Method : `GET`
+ Auth : Required
+ Path Variable :
    + id
+ Response Body (Success) :

```json
{
  "code": 200,
  "status": "OK",
  "data": {
    "id" : "UUID",
    "plantName" : "Siapa",
    "plantClass" : "Magnoliopsida",
    "plantSpecies" : "Oryza sativa L.",
    "plantHumidity" : 10.0,
    "plantLighting" : 10.0,
    "plantFertilizer" : 10.0,
    "plantPrice" : 39000,
    "plantSalesPrice" : 39000,
    "plantMonthHarvest" : "Magnoliopsida",
    "plantPreparation" : "tanaman ini perlu ...",
    "createdAt" : "datetime",
    "updatedAt" : "datetime",
    "deleted" : "0"
  }
}
```

+ Response Body (Fail) :

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```

```json
{
  "code": 404,
  "status": "NOT_FOUND"
}
```
### Get All Plants

+ Endpoint : ``/api/plants``
+ HTTP Method : `GET`
+ Auth : Required
+ Path Variable : -
+ Response Body (Success) :

```json
{
  "code": 200,
  "status": "OK",
  "data": [ {
    "id" : "UUID",
    "plantName" : "Siapa",
    "plantClass" : "Magnoliopsida",
    "plantSpecies" : "Oryza sativa L.",
    "plantHumidity" : 10.0,
    "plantLighting" : 10.0,
    "plantFertilizer" : 10.0,
    "plantPrice" : 39000,
    "plantSalesPrice" : 39000,
    "plantMonthHarvest" : "Magnoliopsida",
    "plantPreparation" : "tanaman ini perlu ...",
    "createdAt" : "datetime",
    "updatedAt" : "datetime",
    "deleted" : "0"
  }	]
}
```

+ Response Body (Fail) :

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```
```json
{
  "code": 404,
  "status": "NOT_FOUND"
}
```
##  Users API

###  Sign Up
+ Endpoint : ``/api/users/_sign-up``
+ HTTP Method : `POST`
+ Request Body :

```json
{
  "fullName" : "Yubisayu",
  "email" : "yubisayu@gmail.com",
  "password": "password123",
  "birthDate" : "datetime",
  "sex": 0,
  "address": "Jl. Bancung",
  "city": "Jakarta"
}
```

+ Response Body (Success) :

```json
{
  "code": 200,
  "status": "OK",
  "data": {
    "id" : "UUID",
    "fullName" : "Siapa",
    "birthDate": 1611669999,
    "profilePicture": null,
    "sex": 0,
    "address": "Jl. Bancung",
	  "city": "Jakarta"
  }
}
```

+ Response Body (Fail) :

```json
{
  "code": 400,
  "status": "BAD_REQUEST",
  "errors": {
    "email": [
      "Required", "Email", "NotAvailable"
    ],
    "fullName": [
      "Required"
    ],
    "password": [
      "Required"
    ],
    "birthDate": [
      "Positive"
    ]
  }
}
```

###  Sign In

+ Endpoint : ``/api/users/_sign-in``
+ HTTP Method : ``POST``
+ Request Body :

```json
{
  "email" : "syntia@gmail.com",
  "password": "passworedq13213"
}
```

+ Response Body (Success) :

```json
{
  "code": 200,
  "status": "OK",
  "data": {
    "token": {
      "access": "b3912854-5bc2-46a8-b57a-8828daf395f6",
      "refresh": "b3912854-5bc2-46a8-b57a-8828daf395f6"
    },
    "user": {
      "id" : "UUID",
      "fullName" : "Siapa",
      "birthDate": 1611669999,
      "profilePicture": null,
      "sex": 0,
      "address": "Jl. Bancung",
	    "city": "Jakarta"
    }
  }
}
```

+ Response Body (Fail) :

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```

### Get Access Token

+ Endpoint : ``/api/users/_refresh-token``
+ HTTP Method : ``POST``
+ Request Body :

```json
{
  "refreshToken": "b3912854-5bc2-46a8-b57a-8828daf395f6"
}
```

+ Response Body (Success) :

```json
{
  "code": 200,
  "status": "OK",
  "data": {
    "token": {
      "access": "b3912854-5bc2-46a8-b57a-8828daf395f6",
      "refresh": "b3912854-5bc2-46a8-b57a-8828daf395f6"
    }
  }
}
```

+ Response Body (Fail) :

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```
### Get User by Id

+ Endpoint : ``/api/users/{id}``
+ HTTP Method : `GET`
+ Required : Auth
+ Path Variable :
    + id
+ Response Body (Success) :

```json
{
  "code": 200,
  "status": "OK",
  "data": {
    "id" : "UUID",
     "fullName" : "Siapa",
     "birthDate": 1611669999,
     "profilePicture": null,
     "sex": 0,
     "address" : "JlBancung",
	   "city" : "Jakarta"
  }
}
```

+ Response Body (Fail) :

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```

```json
{
  "code": 404,
  "status": "NOT_FOUND"
}
```

### Edit User Basic Information by Id

+ Endpoint : ``/api/users/{id}/_update-basic-info``
+ HTTP Method : `PUT`
+ Auth : Required
+ Path Variable :
    + id
+ Request Body :

```json
{
  "fullName" : "Siapa",
  "birthDate": 1611669999,
  "profilePicture": null,
  "sex": 0,
  "address" : "JlBancung",
  "city" : "Jakarta"
}
```

+ Response Body (Success) :

```json
{
  "code": 200,
  "status": "OK",
  "data": {
    "fullName" : "Siapa",
	  "birthDate": 1611669999,
	  "profilePicture": null,
	  "sex": 0,
	  "address" : "JlBancung",
	  "city" : "Jakarta"
  }
}
```

+ Response Body (Fail) :

```json
{
  "code": 400,
  "status": "BAD_REQUEST",
  "errors": {
    "sex": [
      "Required", "InvalidFormat"
    ],
    "fullName": [
      "Required", "InvalidFormat"
    ],
    "birthDate": [
      "Required", "InvalidFormat"
    ]
  }
}
```

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```

```json
{
  "code": 404,
  "status": "NOT_FOUND"
}
```
##  Upload Image to Cloud Bucket API

+ Endpoint : ``/api/upload/{folder}``
+ HTTP Method : `POST`
+ Auth : Required
+ Path Variable :
    + folder: [plants. users, diseases]
+ Request Header :
    + Accept: `multipart/form-data`
    + Content-Type: `multipart/form-data`
+ Request Part :
    + file
+ Response Body (Success) :

```json
{
  "code": 200,
  "status": "OK",
  "data": {
    "imageUrl": null
  }
}
```

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```
## User Plant API

### Add User Plant by User Id

+ Endpoint : ``/api/users/{userId}/plants``
+ HTTP Method : `POST`
+ Auth : Required
+ Request Body :

```json
{
  "userId": "UUID",
  "userPlantName": "Padi Pojok Taman",
  "plantId": "UUID",
  "plantPhase": "Sprout",
  "plantImage": "gcp bucket link"
}
```
+ Response Body (Success) :
```json
{
  "code": 200,
  "status": "OK",
  "data": {
    "id": "UUID",
    "plantId": "Siapa",
    "userId": "UUID",
    "userPlantName": "Padi Pojok Taman",
    "plantPhase": "Sprout",
    "plantHealth": null,
    "plantImage": null,
    "plantDetail": null,
    "plantSuggestion": null,
    "createdAt": "datetime",
    "updatedAt": "datetime",
    "deleted": "0"
  }
}
```
+ Response Body (Fail) :

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```
```json
{
  "code": 404,
  "status": "NOT_FOUND"
}
```
### Get All User's Plants by User Id

+ Endpoint : ``/api/users/{userId}/plants``
+ HTTP Method : `GET`
+ Auth : Required
+ Path Variable :
    + userId
+ Response Body (Success) :

```json
{
  "code": 200,
  "status": "OK",
  "data": [{
    "id" : "UUID",
    "plantId" : "Siapa",
    "userId" : "UUID",
    "userPlantName" : "Padi Pojok Taman",
    "plantPhase" : "Sprout",
    "plantHealth" : null,
    "plantImage" : null,
    "plantDetail" : null,
    "plantSuggestion" : null,
    "createdAt" : "datetime",
    "updatedAt" : "datetime",
    "deleted" : "0"
  }]
}
```

+ Response Body (Fail) :

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```
```json
{
  "code": 404,
  "status": "NOT_FOUND"
}
```
### Get User's Plants by User Plant Id

+ Endpoint : ``/api/users/{userId}/plants/{plantId}``
+ HTTP Method : `GET`
+ Auth : Required
+ Path Variable :
    + userId
    + plantId
+ Response Body (Success) :

```json
{
  "code": 200,
  "status": "OK",
  "data": {
    "id" : "UUID",
    "plantId" : "Siapa",
    "userId" : "UUID",
    "userPlantName" : "Padi Pojok Taman",
    "plantPhase" : "Sprout",
    "plantHealth" : null,
    "plantImage" : null,
    "plantDetail" : null,
    "plantSuggestion" : null,
    "createdAt" : "datetime",
    "updatedAt" : "datetime",
    "deleted" : "0"
  }
}
```

+ Response Body (Fail) :

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```
```json
{
  "code": 404,
  "status": "NOT_FOUND"
}
```
## User Plant Checkups  API

### Add User Plant Checkups by User Plant Id

+ Endpoint : ``/api/users/{userId}/plants/{plantId}/checkups``
+ HTTP Method : `POST`
+ Auth : Required
+ Request Body :

```json
{
  "userId": "UUID",
  "userPlantId": "UUID",
  "plantHumidity": 10.0,
  "plantTemperature": 10.0,
  "plantNitrogen": 10.0,
  "plantPotassium": 10.0,
  "plantPhosphorus": 10.0
}
```
+ Response Body (Success) :
```json
{
  "code": 200,
  "status": "OK",
  "data": {
    "id": "UUID",
    "plantId": "Siapa",
    "userPlantId": "UUID",
    "plantHumidity": 10.0,
    "plantTemperature": 10.0,
    "plantNitrogen": 10.0,
    "plantPotassium": 10.0,
    "plantPhosphorus": 10.0,
    "createdAt": "datetime",
    "updatedAt": "dateti",
    "deleted": "0"
  }
}
```
+ Response Body (Fail) :

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```
```json
{
  "code": 404,
  "status": "NOT_FOUND"
}
```
### Get All User Plant's Checkups by User's Plant Id

+ Endpoint : ``/api/users/{userId}/plants/{plantId}/checkups``
+ HTTP Method : `GET`
+ Auth : Required
+ Path Variable :
    + userId
    + plantId
    + checkupId
+ Response Body (Success) :

```json
{
  "code": 200,
  "status": "OK",
  "data": [{
    "id" : "UUID",
    "plantId" : "Siapa",
    "userPlantId": "UUID",
    "plantHumidity": 10.0,
    "plantTemperature": 10.0,
    "plantNitrogen": 10.0,
    "plantPotassium": 10.0,
    "plantPhosphorus": 10.0,
    "createdAt" : "datetime",
    "updatedAt" : "dateti",
    "deleted" : "0"
  }]
}
```

+ Response Body (Fail) :

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```
```json
{
  "code": 404,
  "status": "NOT_FOUND"
}
```
### Get User Plant's Checkups by Check Up Id

+ Endpoint : ``/api/users/{userId}/plants/{plantId}/checkups/{checkupId}``
+ HTTP Method : `GET`
+ Auth : Required
+ Path Variable :
    + userId
    + plantId
    + checkupId
+ Response Body (Success) :

```json
{
  "code": 200,
  "status": "OK",
  "data": {
    "id" : "UUID",
    "plantId" : "Siapa",
    "userPlantId": "UUID",
    "plantHumidity": 10.0,
    "plantTemperature": 10.0,
    "plantNitrogen": 10.0,
    "plantPotassium": 10.0,
    "plantPhosphorus": 10.0,
    "createdAt" : "datetime",
    "updatedAt" : "dateti",
    "deleted" : "0"
  }
}
```

+ Response Body (Fail) :

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```
```json
{
  "code": 404,
  "status": "NOT_FOUND"
}
```
## Plant Diseases API
### Get Plant Diseases by diseases name

+ Endpoint : ``/api/diseases?name={diseasesName}``
+ HTTP Method : `GET`
+ Auth : Required
+ Path Variable :
    + diseasesName
+ Response Body (Success) :
```json
{
  "code": 200,
  "status": "OK",
  "data": {
    "id": "UUID",
    "diseasesName": "bercak",
    "diseasesDetail": "detail",
    "diseasesTreatment": "detail",
    "diseasesTreatmentVideos": "detail",
    "createdAt": "datetime",
    "updatedAt": "dateti",
    "deleted": "0"
  }
}
```
+ Response Body (Fail) :

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```
```json
{
  "code": 404,
  "status": "NOT_FOUND"
}
```
## User Plant Diseases API
### Get All User Plant Diseases by User Plant Id

+ Endpoint : ``/api/users/{userId}/plants/{plantId}/diseases``
+ HTTP Method : `GET`
+ Auth : Required
+ Path Variable :
    + userId
    + plantId
+ Response Body (Success) :
```json
{
  "code": 200,
  "status": "OK",
  "data": {
    "id": "UUID",
    "userPlantId": "UUID",
    "planDiseaseId": "UUID",
    "createdAt": "datetime",
    "updatedAt": "datetime",
    "deleted": "0"
  }
}
```
+ Response Body (Fail) :

```json
{
  "code": 401,
  "status": "UNAUTHORIZED"
}
```
```json
{
  "code": 404,
  "status": "NOT_FOUND"
}
```
