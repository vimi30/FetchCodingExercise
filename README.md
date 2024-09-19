Fetch Rewards Coding Exercise

Description

This is a native Android application developed as a solution to the Fetch Rewards Coding Exercise. The app retrieves data from given endpoint in the assignemnt and displays a list of items to the user based on the following requirements:

	•	Group items by listId: All items are grouped according to their listId.
	•	Sort items: Items are sorted first by listId and then by name.
	•	Filter items: Any items where name is blank or null are excluded.
	•	User-friendly display: The final list is presented in an easy-to-read format using Jetpack Compose.

Features

	•	Ktor for Network Calls: Efficiently fetches data from the API.
	•	Jetpack Compose UI: Modern toolkit for building native Android UI.
	•	MVVM Architecture: Separates data presentation logic from UI for cleaner code and easier testing.
	•	Dependency Injection: Manages dependencies efficiently (specify DI framework if applicable, e.g., Hilt or Koin).
	•	Kotlin Language: Leverages Kotlin features for concise and effective code.

Technologies Used

	•	Kotlin
	•	Ktor
	•	Jetpack Compose
	•	MVVM Architecture
	•	Dependency Injection (e.g., Hilt)
	•	Coroutines for asynchronous programming

Installation

Follow these steps to set up the project on your local machine:

	1.	Clone the Repository
 	2.	Open the Project in Android Studio
	•	Ensure you have the latest stable version of Android Studio installed.
	•	Open Android Studio and select File > Open.
	•	Navigate to the cloned repository folder and click OK.
	3.	Sync and Build
	•	Allow Gradle to sync the project. This may take a few minutes depending on your internet speed.
	•	Make sure all dependencies are resolved without errors.
	4.	Run the App
	•	Connect an Android device via USB with USB debugging enabled, or start an Android emulator.
	•	Click the Run button or select Run > Run ‘app’ from the menu.

Usage

Once the app is installed and running:

	•	The app automatically fetches data from the API using Ktor.
	•	Data is processed to filter out any items with blank or null name fields.
	•	Items are grouped by listId and sorted by listId and name.
	•	The organized list is displayed using Jetpack Compose for a smooth and modern UI experience.

Demo




https://github.com/user-attachments/assets/c5694635-e310-49a1-8bd0-4e8e381d3e39


