# ratpack-configoverride-example
[![Build Status](https://travis-ci.org/gregwhitaker/ratpack-configoverride-example.svg?branch=master)](https://travis-ci.org/gregwhitaker/ratpack-configoverride-example)

An example of layering configuration mechanisms in [Ratpack](https://www.ratpack.io).

This example starts a simple Ratpack application that loads a default database configuration from `config.yaml`. The default 
database configuration can be overridden by setting environment variables.

## Running the Example
1. Start the example application by running the following command:

        $ ./gradlew run
        
2. Run the following curl command to retrieve the current database configuration:

        $ curl http://localhost:5050/config
        
    You should see the following:
    
        {
          "host": "localhost",
          "port": 5432,
          "username": "postgres",
          "password": "postgres",
          "database": "mydb"
        }

3. Stop the application.

4. Now assume that we want to override the default database port at runtime via environment variables. Start the application using the following command:

        $ RATPACK_DATABASE__PORT=8001 ./gradlew run
        
5. Run the curl command again to retrieve the current database configuration:

        $ curl http://localhost:5050/config
        
    Note that the default port has been overridden with `8001`:
    
        {
          "host": "localhost",
          "port": 8001,
          "username": "postgres",
          "password": "postgres",
          "database": "mydb"
        }

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/ratpack-configoverride-example/issues).

## License
MIT License

Copyright (c) 2018 Greg Whitaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.