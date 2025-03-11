# Cryptocurrency Trading Platform

A Java Spring-based cryptocurrency trading platform that allows users to sign up, log in, and place orders for cryptocurrency transactions. The system uses JWT for secure authentication, stores user data in a MySQL database, and integrates real-time cryptocurrency data fetched from the Gecko API.

## Features

- **User Authentication:** Secure sign-up and login using JWT.
- **Real-Time Coin Data:** Integrated with the Gecko API to fetch live cryptocurrency market data.
- **Portfolio Management:** Completed orders are added to the user’s portfolio, allowing them to track and manage their cryptocurrency assets.
- **Kafka Integration:** Real-time data updates using Kafka for market information.

In development
- **Order Execution:** Users can place buy orders, which are added to a market and executed when matching buy/sell orders are found.


## Configure MySQL:
Set up a MySQL database and configure your database connection in the application.properties file.

## Install Dependencies:
  ./mvnw spring-boot:run


## Kafka Setup:
Ensure you have Kafka running locally or in your preferred environment.

## API Endpoints
* POST /api/signup - Create a new user account.
* POST /api/login - Authenticate and obtain a JWT token.
* GET /api/coin - Get a complete coin list. 
* GET /api/coin/{id} - Get one coin by id. 
* GET /api/wallet - Get the user's wallet. 
* GET /api/portfolio - Get the user's wallet. 
* POST /api/order - Place an order for cryptocurrency.
