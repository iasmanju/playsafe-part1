# playsafe-part1

# Project Title
 Convertor

# Built With Maven
Run the below bash command on each of the above artifacts to have it installed locally.

```sh
mvn clean install
```

## Usage

```sh
mvn spring-boot:run
```

## Run tests

```sh
mvn clean test
```
### [Demo](http://localhost:8086/api/v1/)

For all of the below endpoints a log entry needs to be created for their execution duration.

/conversions/ktoc
The ktoc endpoint should produce an output amount in celsius when given an input amount in kelvin.

/conversions/ctok
The ctok endpoint should produce an output amount in kelvin when given an input amount in celsius.

/conversions/mtok
The mtok endpoint should produce, when given an input amount in miles, an output amount in kilometers.

/conversions/ktom
The ktom endpoint should produce, when given an input amount in kilometers, an output amount in miles.

## Author

 **Manjunath Vaidya**

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
**Spotted an error?** **Something doesn't make sense?** Send  a pull request! Please avoid making stylistic changes though -- they are unlikely to be accepted. Thanks!
**Please make sure to update tests as appropriate.**








