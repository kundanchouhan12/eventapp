# 📊 Public Event Analysis App

An Android application designed for **organizations and government bodies** to analyze **public sentiment and reactions** from past events.  
It helps predict how the public might respond to upcoming events in a particular location using **sentiment analysis**, **interactive charts**, and **news insights**.

---

## 🚀 Features

### 📅 1. Event Management
- View **all events** with filters: `Upcoming`, `Past`, and `Recent`
- **Search bar** to quickly find specific events  
- Detailed event pages display:
  - Event Title, Location & Description  
  - Sentiment breakdown (Positive / Neutral / Negative)  
  - Line & Scatter charts using **MPAndroidChart**

---

### 💬 2. Sentiment Analysis
- Performs **real-time sentiment analysis** of past events  
- Visualized via **line and scatter plots**  
- Helps organizations **predict audience sentiment** for upcoming events  

---

### 🔥 3. Firebase Integration
- Secure **Login / Signup / Forgot Password** using Firebase Authentication  
- Fetches real-time **user profile** (username, image, email)  
- Supports **email verification** for new users  

---

### 📰 4. Google News Integration
- Fetches latest event-related news using **Google News API**  
- Displays top trending news with title, source & publication time  
- *(Future enhancement)*: Integrate **fake news detection** and **sentiment polarity**  

---

### 🎨 5. Modern UI/UX
- Built using **Material Design Components**  
- Smooth navigation with **Bottom Navigation Bar**  
- Clean, interactive and responsive interface  

---

## 🧠 Tech Stack

| Component | Technology Used |
|------------|-----------------|
| **Frontend** | Android (Java, XML) |
| **Backend / Auth** | Firebase |
| **Charts** | MPAndroidChart |
| **API** | Google News API |
| **UI Library** | Material Design Components |
| **Data Processing** | NLP-based Sentiment Analysis |

---

## 📂 Project Structure

```plaintext
EventApp/
│
├── app/src/main/java/com/example/eventapp/
│   ├── activities/         → Login, Signup, Profile, Event Details
│   ├── adapters/           → RecyclerView adapters for events
│   ├── models/             → Event, User models
│   ├── utils/              → Sentiment logic, API handling
│   └── fragments/          → Home, Events, Profile, News sections
│
├── res/
│   ├── layout/             → XML layout files (UI)
│   ├── drawable/           → Icons, images, and backgrounds
│   └── values/             → Colors, strings, and styles
│
└── google-services.json    → Firebase configuration file
⚙️ Installation & Setup
🪜 Step 1 — Clone the Repository
bash
Copy code
git clone https://github.com/kundanchouhan12/eventapp.git
🪜 Step 2 — Open in Android Studio
Open the cloned project in Android Studio

Allow Gradle to sync automatically

🪜 Step 3 — Add Firebase Configuration
Go to Firebase Console

Create a new project

Add your Android app and download google-services.json

Place it inside the /app/ folder

🪜 Step 4 — Add Google News API Key
Get your API key from NewsAPI.org

Add it inside your API utility file (e.g., NewsFragment.java)

🪜 Step 5 — Run the App
Connect your Android device or start an emulator

Click Run ▶️ in Android Studio

📈 Sentiment Visualization
The app uses MPAndroidChart to display data-driven insights:

📊 Line Chart: Sentiment trend over multiple past events

⚪ Scatter Plot: Distribution of positive, neutral, and negative sentiments

Example sentiment breakdown:

Sentiment	Percentage
Positive	65%
Neutral	20%
Negative	15%

🧩 Screenshots (Preview)
(Replace these with real screenshots)

Home	Event Details	Sentiment Chart	Profile

🛠️ Future Enhancements
🧠 Integrate ML-based fake news detection

🌐 Add real-time social media sentiment analysis

📊 Export insights as PDF/CSV reports

🔔 Push notifications for upcoming events

👨‍💻 Developed By
Kundan Singh Chouhan
📧 chouhankundan197@gmail.com
🔗 GitHub Profile

🔗 Resources
GitHub Repo: Public Event Analysis App

Live Demo: Google Drive Demo Video

📜 License
This project is licensed under the MIT License.
