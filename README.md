# Cryptocurrency Trading Platform

This project is a Java Spring-based cryptocurrency trading platform that enables users to sign up, log in, and execute cryptocurrency transactions. It employs JWT (JSON Web Tokens) for secure authentication, with user data stored in a MySQL database. Real-time cryptocurrency market data is seamlessly integrated from the Gecko API. This repository focuses on user management, while the crypto-marketplace project functions as a microservice, responsible for fetching cryptocurrency data and handling order processing.

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
* GET /api/portfolio - Get the user's portfolio. 
* POST /api/order - Place an order for cryptocurrency.
