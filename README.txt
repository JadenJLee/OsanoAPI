Hi! Welcome to my Osano API take home test. This application allows a user to input a currency from the ISO-4217 List and it returns:
1. A cryptocurrency code
2. The current value of that cryptocurrency
3. What percent it has lost/gained against Bitcoin in the last 24 hours
4. How much money you would have if you converted one Bitcoin to the cryptocurrency 24 hours ago! (Sometimes, if there is data for it).

This project connects to https://api.coinbase.com/v2/exchange-rates?currency= as well as https://api.binance.us/api/v3/ticker/24hr for the data.
To validate Iso codes, we used: https://developers.google.com/adsense/management/appendix/currencies.

Note: Normally, I wouldn't leave comments in production code as the variable names should be easy enough to follow, but for the sake of the exercise, I left them in for clarity.

To run the project:
1. Clone repository locally with IDE of choice (I used intelliJ).
2. Run the main file.
3. Input chosen currency into the console.
4. See output in console.