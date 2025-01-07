# URL Shortener

## Overview
A simple and efficient URL shortener service that allows users to transform long URLs into short, easy-to-share links. It also tracks usage statistics and provides analytics for shortened URLs.

### Landing Page
<img width="1726" alt="Screenshot 2024-12-30 at 1 47 53 PM" src="https://github.com/user-attachments/assets/76aa1c65-9793-4aa0-b44f-0e05a4f3f280" />

### List of URLs
<img width="1728" alt="Screenshot 2024-12-30 at 1 48 42 PM" src="https://github.com/user-attachments/assets/fa5d029d-9903-423b-b689-5a68f663bba4" />

### Log In Page
<img width="1728" alt="Screenshot 2024-12-30 at 1 49 35 PM" src="https://github.com/user-attachments/assets/0501d215-4d66-4105-8521-e36341a09574" />

### URLs With Analytics
<img width="1727" alt="Screenshot 2024-12-30 at 5 28 06 PM" src="https://github.com/user-attachments/assets/870eefff-e28c-4a87-b55d-c3ea3e8bd322" />

### Update Alias
<img width="1728" alt="Screenshot 2024-12-30 at 10 46 54 PM" src="https://github.com/user-attachments/assets/fc12e64a-c944-45df-8d6c-45f662b14b03" />


---

## Features
- **Shorten URLs:** Convert long URLs into concise links.
- **Analytics:** View usage statistics such as click count and referral sources.
- **Custom Aliases:** Optionally define custom aliases for your short URLs.
- **Expiration Dates:** Set expiration dates for short URLs.

---

## Tech Stack
- **Backend:** [Java, Spring Boot]
- **Frontend:** [React, TypeScript]
- **Database:** [PostgreSQL]
- **Others:** [JWT Authentication]

---

## Installation

### Prerequisites
- Java 17
- PostgreSQL Database

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/url-shortener.git
   cd url-shortener
   ```
2. Install dependencies:
   ```bash
   npm install
   # or
   pip install -r requirements.txt
   ```
3. Set up environment variables:
   Create a `.env` file in the root directory and configure the following variables:
   ```env
   DATABASE_URL=your-database-url
   BASE_URL=http://localhost:3000
   SECRET_KEY=your-secret-key
   ```
4. Run the application:
   ```bash
   npm start
   # or
   python manage.py runserver
   ```
5. Access the application at `http://localhost:3000`.

---

## Usage
1. Navigate to the homepage.
2. Paste a long URL into the input field.
3. Click the "Shorten URL" button to generate a short link.
4. Share the short link or manage it in your dashboard.

---

## API Endpoints

### Shorten URL
**POST** `/api/v1/url`
- **Body:**
  ```json
  {
    "long_url": "https://example.com",
    "alias": "optional-alias"
  }
  ```
- **Response:**
  ```json
  {
    "short_url": "http://8080/abc123"
  }
  ```

### Sign Up
**POST** `/auth/signup`
- **Body:**
  ```json
  {
    "username": "testusername",
    "email": "testEmail@gmail.com",
    "password": "testPassword"
  }
  ```
- **Response:**
  ```json
  {
    "username": "testEmail2@gmail.com",
    "user_id": 2,
    "password": "***",
    "email": "testEmail2@gmail.com",
    "created_at": "2024-12-30T13:49:16.345210"
  }
  ```

### Log In
**POST** `/auth/login`
- **Body:**
  ```json
  {
    "email": "testEmail@gmail.com",
    "password": "testPassword"
  }
  ```
- **Response:**
  ```json
  {
    "token": "",
    "expiresIn": 3600000,
    "email": "testEmail2@gmail.com",
    "userId": 2
  }
  ```

### Get URL Analytics
**GET** `/api/analytics/{alias}`
- **Response:**
  ```json
  {
    "short_url": "http://8080/abc123",
    "total_clicks": 5,
    "last_accessed": "1735599700473"
  }
  ```

### Get URLs With Analytics
**GET** `/api/v1/url/{user_id}`
- **Response:**
  ```json
  {
      "url_id": null,
      "short_url": "http://localhost:8080/7f9324",
      "long_url": "https://leetcode.com/problem-list/oizxjoit/",
      "alias": null,
      "expires_at": "2025-01-06T17:18:00.855965",
      "created_at": "2024-12-30T17:18:00.855916",
      "user_id": 2,
      "url_analytic_id": 6,
      "total_clicks": 0,
      "last_accessed": null
  }
  ```
  
### Update Alias
**PUT** `/api/v1/url`
- **Body:**
  ```json
  {
      "short_url": "http://localhost:8080/c9ec8d",
      "new_alias": "testNewAlias"
  }
  ```
- **Response:**
  ```json
  {
    "userId": 2,
    "url_id": 2,
    "short_url": "http://localhost:8080/testNewAlias",
    "long_url": "https://leetcode.com/problem-list/oizxjoit/",
    "alias": "testNewAlias",
    "expires_at": "2025-01-06T21:41:43.770444",
    "created_at": "2024-12-30T21:41:43.769958"
  }
  ```
