# TradeInsight

TradeInsight is a desktop application that combines stock data visualization as well as writing reports and linking to certain stock's data, urls, or graphs. It serves as a comprehensive tool for data analyst to make informed decisions by analyzing both quantitative stock data and writing comprehensive reports.

## Features

- **Stock Data Visualization**
  - Interactive charts with historical data and multiple time frame options.
  - Technical indicators like Moving Averages (SMA, EMA), RSI, MACD, and Bollinger Bands.
  - Customizable dashboards for tracking user-selected stocks.
 
= **Integrated Notes Taking
  - Interactive Notes taking feature that allows users to write reports on stock data, document methodologies, assumptions, and steps taken during data analysis, or write technical documentation for tools, data pipelines, or workflows.
  - Ability to create interactive links within the notes, so that analysts can easily search stocks, articles ,urls, or graphs.
- **Company News and Articles**
  - Real-time news articles about companies fetched from financial news APIs.
  - Sentiment analysis of news articles (positive, negative, neutral) to understand market sentiment.
  - Filters for different types of news like earnings, mergers, and industry trends.

- **Trending Articles**
  - A homepage featuring trending articles based on user activity and social media buzz.
  - Highlighted news about popular companies and stocks.

- **User Experience Enhancements**
  - Responsive design for seamless use.
  - Dark mode for a more comfortable viewing experience.
  - Real-time updates for stock prices and news.

- **User Accounts and Watchlists**
  - Ability to create a personalized watchlist of favorite stocks.
  - Notifications for significant stock movements and relevant news.

- **Social Integration**
  - Discussion forums for users to share opinions and analyze market trends.
  - Social media sharing for articles and user analysis.

## Technology Stack
- **Backend**: Spring Boot for handling data processing, API integrations, and user management.
- **Data Visualization**: Chart.js or D3.js for detailed and interactive stock data charts.
- **APIs**: Alpha Vantage api
  - News articles: NewsAPI or similar providers for the latest news updates.
- **Database**: PostgreSQL or MongoDB for user data, watchlists, and article storage.
- **Authentication**: OAuth for secure user login.
- **Hosting**: AWS, Google Cloud, or Heroku for deployment.

## Getting Started

### Prerequisites

- **Java** and **Maven** for the Spring Boot backend.
- **Git** for version control.
- An account with the chosen stock data and news APIs (e.g., Yahoo Finance, NewsAPI).

### Installation

1. **Clone the repository**
   ```bash
   git clone git@github.com:your-username/TradeInsight.git
   cd TradeInsight

3. Backend Setup
   ```bash
   cd backend
   mvn clean install
   mvn spring-boot:run
4. Environmental Variables
- Set up your API keys for stock data and news services in the .env file or as environment variables.
   
 

