NEWS FEED APPLICATION - README
================================

1. PROJECT OVERVIEW
------------------
A Java command-line application that fetches and displays news articles from 
NewsData.io API. Users can select a category to get the latest news with titles, 
descriptions, and source links.

2. KEY FEATURES
--------------
- Fetches news from 12+ categories (Technology, Sports, Business, etc.)
- Displays article title, description and link
- Supports UTF-8 encoding for multilingual content
- Handles API errors gracefully

3. TECHNOLOGIES USED
-------------------
- Java
- HttpURLConnection (for API requests)
- org.json library (JSON parsing)
- Scanner (user input)
- StandardCharsets (text encoding)

4. HOW TO RUN
------------
PREREQUISITES:
- Java JDK 8+
- NewsData.io API key (free tier available)

STEPS:
1. Replace API key in SimpleNewsFeed.java:
   private static final String API_KEY = "your_api_key_here";

2. Compile and run:
   javac SimpleNewsFeed.java
   java SimpleNewsFeed

3. Select category when prompted:
   1. Technology   4. World      7. Food     10. Science
   2. Sports      5. Entertainment 8. Health  11. Tourism
   3. Business    6. Environment 9. Politics 12. Top (default)

5. SAMPLE OUTPUT
---------------
==================== TOP TECHNOLOGY NEWS ====================

<==> Title: AI Breakthrough in Healthcare
>>> Description: Researchers develop new AI model...
>>> Link: https://example.com/news/123
--------------------------------------------------

6. TROUBLESHOOTING
------------------
- Garbled text: Ensure your terminal supports UTF-8
- Connection errors: Check internet/API key
- JSON errors: Verify API response format


NOTES:
- Free API tier has limited daily requests
- Consider GUI enhancements for future versions