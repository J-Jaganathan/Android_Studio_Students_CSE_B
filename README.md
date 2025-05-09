# Application Development in Android Studio

## 🎯 Project Purpose (Why This Matters)
This Repository is created for my classmates earlier and this is created 5 days ago, but today, as these might not be useful for them. These will be useful them in future and for my viewers and subscribers who wants to explore and test their configurations on Android Studio 2024 version and yes, it is made based on 2024 version of Android Studio.

This entire repository consists of 11 experiments is designed to help you understand the fundamental building blocks of Android app development:
- How user interfaces are constructed using XML layouts
- How Java/Kotlin code brings these interfaces to life
- The event-driven nature of mobile applications

By working with basic GUI components and event listeners, you'll gain practical experience with:
1. **Visual Design**: Creating responsive layouts that adapt to different screen sizes
2. **User Interaction**: Making your apps respond to user input
3. **State Management**: Tracking and modifying UI properties programmatically

These skills form the foundation for all Android development - whether you're building simple utility apps or complex mobile systems!

---

# Experiment 1 - GUI Components, Layout Managers, and Event Listeners

## AIM
To develop an Android application that demonstrates the use of GUI components, layout managers, and event listeners to create interactive UI elements.

## Experiment Details
- **Folder Location**: `Android_Studio_Students_CSE_B/Experiment_1/`
- **Files**:
  - `activity_main.xml` (Layout file)
  - `MainActivity.java` (Main Activity file)
  - `AndroidManifest.xml` (Default configuration - unchanged)
  - `build.gradle` (Default configuration - unchanged)

## Code Explanation

### 1. activity_main.xml
This XML file defines the user interface layout using ConstraintLayout as the root layout manager.

#### Key Components:
- **Title TextView**: A black title bar at the top displaying "Ex_No_1"
- **Main TextView**: Displays "MAD Lab" text which will be modified through button interactions
- **Three Buttons**:
  1. Change Font Size
  2. Change Font Color
  3. Change Font Style

#### Layout Features:
- Uses `ConstraintLayout` for flexible positioning
- All components are constrained relative to each other and parent
- Buttons span full width of the screen (`0dp` width with constraints)

### 2. MainActivity.java
This Java file implements the functionality for the UI components.

#### Key Functionalities:

1. **Font Size Change** (`button1`):
   - Increments font size by 5sp on each click
   - Resets to 20sp when exceeding 50sp
   - Uses `textView1.setTextSize()`

2. **Font Color Change** (`button2`):
   - Cycles through 4 colors (Purple → Green → Red → Blue)
   - Uses `textView1.setTextColor()`
   - Implements color cycling with a counter variable

3. **Font Style Change** (`button3`):
   - Cycles through 4 different font styles and typefaces:
     1. Default + Italic
     2. Monospace + Normal
     3. Sans-serif + Bold
     4. Serif + Bold Italic
   - Uses `textView1.setTypeface()`

#### Implementation Details:
- Uses `View.OnClickListener` for button click events
- Maintains state with three counter variables:
  - `fontSize` for size tracking
  - `colorCount` for color cycling
  - `styleCount` for style cycling

### 3. Default Configuration Files
The following files remain unchanged from the default Android Studio template:

#### AndroidManifest.xml:
- Declares MainActivity as the launcher activity
- Sets basic application metadata and permissions
- Uses standard theme and icon configurations

#### build.gradle:
- Sets minimum SDK to 21 and target SDK to 35
- Includes standard dependencies:
  - AppCompat for backward compatibility
  - Material Design components
  - ConstraintLayout
  - Testing libraries (JUnit, Espresso)

## Expected Output
- A simple UI with a title bar and "MAD Lab" text
- Three buttons that modify the text properties when clicked:
  - First button increases font size (resets after reaching maximum)
  - Second button changes text color cyclically
  - Third button changes font style and typeface cyclically

## Concepts Demonstrated
- GUI Component usage (TextView, Button)
- Layout management (ConstraintLayout)
- Event handling (OnClickListener)
- Dynamic UI modification
- State management in Android apps
- Default Android project structure and configuration

---
# MAD Lab Experiment: Basic Calculator Implementation

## 🎯 Project Purpose (Why This Matters)

This experiment helps you understand core Android development concepts through building a functional calculator:

1. **User Input Handling**  
   Learn how to properly capture and validate numeric input from users

2. **Event-Driven Programming**  
   Master button click handling and UI updates based on user actions

3. **Error Handling**  
   Implement robust validation for edge cases (division by zero, invalid inputs)

4. **Practical Math Operations**  
   Apply fundamental programming concepts to create real calculator functionality

These skills are essential for:
- Building interactive apps that process user input
- Creating responsive UIs that provide immediate feedback
- Developing error-resistant applications

---

# Experiment 2 - Basic Calculator with Arithmetic Operations

## AIM
To create an Android application that performs basic arithmetic operations (addition, subtraction, multiplication, and division) based on user input, demonstrating proper input handling and event management.

## Experiment Details
- **Folder Location**: `Android_Studio_Students_CSE_B/Experiment_2/`
- **Files**:
  - `activity_main.xml` (Layout file)
  - `MainActivity.java` (Main Activity file)

## Code Explanation

### 1. activity_main.xml
This XML file defines the calculator interface using ConstraintLayout.

#### Key Components:
- **Title TextView**: Black title bar displaying "Ex_No_2"
- **Two EditText Fields**: For numeric input (with numberDecimal inputType)
- **Four Operation Buttons**: ADD, SUB, MUL, DIV
- **Result TextView**: Displays calculation results

#### Layout Features:
- Responsive design using ConstraintLayout
- Buttons evenly distributed across the screen
- Proper spacing and margins between components
- Input type restricted to numbers/decimal points

### 2. MainActivity.java
This Java file implements the calculator logic.

#### Key Functionalities:

1. **Input Handling**:
   - Retrieves values from EditText fields
   - Parses strings to double values
   - Handles NumberFormatException for invalid inputs

2. **Arithmetic Operations**:
   - Addition (+)
   - Subtraction (-)
   - Multiplication (*)
   - Division (/) with zero-division check

3. **Result Display**:
   - Formats results to 2 decimal places
   - Shows operation equation and result
   - Displays error messages for invalid cases

#### Implementation Details:
- Uses View.OnClickListener for all operation buttons
- Implements try-catch blocks for robust error handling
- Formats output using String.format()
- Clears previous result on new operation

## How to Run
1. Open the project in Android Studio
2. Build and run on an emulator or physical device
3. Enter two numbers in the input fields
4. Click any operation button to see the result

## Expected Output
- Clean calculator interface with input fields and operation buttons
- Correct arithmetic results displayed when valid numbers are entered
- Appropriate error messages for:
  - Invalid/non-numeric input
  - Division by zero attempts

## Key Learnings
1. How to process and validate user input in Android
2. Implementing different event handlers for similar components
3. Formatting numeric output for display
4. Handling runtime exceptions gracefully
5. Building a complete functional component (calculator)

---

# Experiment 3 - Interactive Drawing Application

## AIM
To create an Android application that allows users to draw different shapes (lines, circles, rectangles, and squares) on a canvas using touch input, demonstrating custom drawing and touch event handling.

## Experiment Details
- **Folder Location**: `Android_Studio_Students_CSE_B/Experiment_3/`
- **Files**:
  - `activity_main.xml` (Layout file)
  - `MainActivity.java` (Main Activity file)

## Code Explanation

### 1. activity_main.xml
This XML file defines a simple full-screen drawing canvas.

#### Key Components:
- **RelativeLayout**: Root layout manager
- **ImageView**: Serves as the drawing canvas (full-screen)

#### Layout Features:
- Minimalist design focused on the drawing surface
- Full-screen canvas using match_parent dimensions
- No additional UI elements (clean drawing space)

### 2. MainActivity.java
This Java file implements the drawing functionality.

#### Key Components:
- **Bitmap**: Backing store for the drawing
- **Canvas**: Drawing surface
- **Paint**: Style configuration for shapes
- **OnTouchListener**: Handles touch interactions

#### Core Functionalities:

1. **Initialization**:
   - Creates a full-screen bitmap matching device dimensions
   - Sets up drawing tools (Paint with blue stroke)
   - Configures the ImageView as touch-sensitive canvas

2. **Touch Handling**:
   - `ACTION_DOWN`: Records starting position
   - `ACTION_UP`: Records ending position and draws shape
   - Cycles through shapes automatically after each draw

3. **Shape Drawing**:
   - **Line**: Drawn between touch start and end points
   - **Circle**: Radius calculated from touch distance
   - **Rectangle**: Drawn between diagonal corners
   - **Square**: Equal sides based on largest dimension

#### Implementation Details:
- Implements `View.OnTouchListener` interface
- Uses `Canvas` methods for shape drawing
- Maintains shape state with `currentShape` counter
- Invalidates view after each draw to update display
- Handles coordinate calculations for proper shape rendering

## How to Run
1. Open the project in Android Studio
2. Build and run on an emulator or physical device
3. Touch and drag on screen to draw shapes:
   - First touch: Line
   - Second touch: Circle
   - Third touch: Rectangle
   - Fourth touch: Square
   - Subsequent touches cycle through shapes again

## Expected Output
- Blank canvas when app launches
- Blue shapes drawn on screen with each touch gesture
- Automatic cycling through different shape types:
  1. Line between touch points
  2. Circle centered at start point
  3. Rectangle between corners
  4. Perfect square

## Key Learnings
1. How to implement custom drawing in Android
2. Processing touch input for interactive apps
3. Mathematical calculations for shape rendering
4. Managing drawing state between interactions
5. Creating a responsive drawing surface
6. Implementing shape-drawing algorithms

---
# Experiment 4 - Student Database Management System

## AIM
To create an Android application that demonstrates CRUD (Create, Read, Update, Delete) operations using SQLite database, implementing a complete student records management system.

## Experiment Details
- **Folder Location**: `Android_Studio_Students_CSE_B/Experiment_4/`
- **Files**:
  - `activity_main.xml` (Layout file)
  - `MainActivity.java` (Main Activity file)

## Code Explanation

### 1. activity_main.xml
This XML file defines a student record management interface using LinearLayout.

#### Key Components:
- **Input Fields**:
  - Registration number (numeric input)
  - Student name (text input)
  - Marks (numeric input)
  
- **Action Buttons**:
  - ADD: Insert new record
  - VIEW: Fetch single record
  - VIEW ALL: Display all records
  - UPDATE: Modify existing record
  - DELETE: Remove record

#### Layout Features:
- Vertical LinearLayout as root container
- Horizontal LinearLayouts for each input field
- Two button rows for balanced UI
- Proper spacing and margins
- Input type restrictions for numeric fields

### 2. MainActivity.java
This Java file implements the complete database operations.

#### Database Setup:
```java
db = openOrCreateDatabase("Students", MODE_PRIVATE, null);
db.execSQL("CREATE TABLE IF NOT EXISTS student(regno VARCHAR PRIMARY KEY, name VARCHAR, mark VARCHAR);");
```
---
# Experiment 5 - Background Image Loading with Progress Tracking

## AIM
To create an Android application that demonstrates background thread operations for image loading with progress visualization, implementing proper UI thread communication and resource management.

## Experiment Details
- **Folder Location**: `Android_Studio_Students_CSE_B/Experiment_5/`
- **Files**:
  - `activity_main.xml` (Layout file)
  - `MainActivity.java` (Main Activity file)
  - Image resources (`download.jpg`, `images.jpg`)

## Code Explanation

### 1. activity_main.xml
This XML file defines an image viewer interface with progress tracking using RelativeLayout.

#### Key Components:
- **Title Bar**: Black header showing "Ex_No_5"
- **ImageView**: Main display area for loaded images (centered, with fitCenter scaling)
- **Progress Bar**: Horizontal bar showing load progress
- **Progress Text**: Percentage indicator
- **Action Buttons**: Two buttons for loading different images

#### Layout Features:
- RelativeLayout for flexible component positioning
- Proper margin management between elements
- Visibility control for progress indicators
- Weight-based button distribution
- ImageView with adjustViewBounds for proper aspect ratio

### 2. MainActivity.java
This Java file implements background image loading with progress updates.

#### Core Components:
- **Executor Service**: Manages background thread (`SingleThreadExecutor`)
- **UI Elements**: ImageView, ProgressBar, TextView references
- **Image Resources**: Two drawable resources (download.jpg, images.jpg)

#### Key Functionalities:

1. **Background Loading**:
   ```java
   executor.execute(() -> {
       // Background work here
       runOnUiThread(() -> {
           // UI updates here
       });
   });
   ```
2. **Progress Simulation**:
- Updates progress from 0-100% with 30ms intervals
- Synchronized UI updates via runOnUiThread()

3. **Image Loading**:
  ```java
  Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
  ```
4. **State Management**:
--Shows/hides progress indicators
- Handles image display/error cases
- Resets view before new load

#### Implementation Details:
- Uses separate thread for loading operations
- Proper UI thread communication
- Progress visualization with percentage text
- Resource-efficient bitmap loading
- Error handling for image loading

#### Expected Output
- Clean interface with title and two action buttons
- Visible progress indicators during loading
- Smooth transition from 0% to 100% progress
- Clear image display after loading completes
- Proper error handling if image fails to load

---
# Experiment 6 - Real-Time Location Tracking

## AIM
To develop an Android application that demonstrates real-time location tracking using Google Play Services' Fused Location Provider API, implementing proper permission handling and location updates.

## Experiment Details
- **Folder Location**: `Android_Studio_Students_CSE_B/Experiment_6/`
- **Files**:
  - `activity_main.xml` (Layout file)
  - `MainActivity.java` (Main Activity file)
  - `AndroidManifest.xml` (Permission declarations)
  - `build.gradle` (Dependency configuration)

## Configuration Requirements
1. **AndroidManifest.xml**:
```xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
```
2. **build.gradle (Module: app)**:

```gradle
implementation 'com.google.android.gms:play-services-location:21.0.1'
```
## Code Explanation
1. **activity_main.xml**
This XML file defines a clean location display interface using RelativeLayout.

### Key Components:
**Title**: "Current Location" header
**Latitude Display**: Shows latitude with high precision
**Longitude Display**: Shows longitude with high precision

### Layout Features:
- RelativeLayout for component positioning
- Proper text sizing and appearance
- Logical spacing between elements
- Clear hierarchy of information

2. **MainActivity.java**
This Java file implements the complete location tracking functionality.

### Core Components:
- FusedLocationProviderClient: Main location services interface
- LocationRequest: Configures location update parameters
- LocationCallback: Handles incoming location updates
- Permission Handling: Manages runtime permissions

### Key Functionalities:
1. **Permission Management**:
- Checks and requests location permissions
- Handles permission grant/deny scenarios
- Implements onRequestPermissionsResult

2. **Location Updates**:
```java
LocationRequest locationRequest = new LocationRequest.Builder(
        Priority.PRIORITY_HIGH_ACCURACY, 20000)
        .setMinUpdateIntervalMillis(1000)
        .build();
```
3. **UI Updates**:
- Displays latitude/longitude with 15 decimal precision
- Shows error messages when location unavailable

4. **Lifecycle Management**:
- Properly registers/unregisters location updates
- Handles activity pause/resume scenarios

## Implementation Details:
- Uses high accuracy location priority
- 20-second maximum update interval
- 1-second minimum update interval
- Precision formatting for coordinates
- Comprehensive error handling

## Expected Output
- Clean interface showing current location
- Continuously updating coordinates
- High-precision values (15 decimal places)
- Proper permission request flow
- Error messages when: Location unavailable & Permissions denied

---
# Experiment 7 - File Storage Operations

## AIM
To develop an Android application that demonstrates file read/write operations with proper storage permission handling across different Android versions, implementing both legacy and modern storage access approaches.

## Experiment Details
- **Folder Location**: `Android_Studio_Students_CSE_B/Experiment_7/`
- **Files**:
  - `activity_main.xml` (Layout file)
  - `MainActivity.java` (Main Activity file)
  - `AndroidManifest.xml` (Permission declarations)

## Configuration Changes
### AndroidManifest.xml
```xml
<!-- For Android 9 and below -->
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

<application
    android:requestLegacyExternalStorage="true"
    ...>
</application>
```
## Code Explanation
1. **activity_main.xml**
This XML file defines a file management interface using LinearLayout.

### Key Components:
- **Path Input**: EditText with file path
- **Read Button**: Triggers file reading
- **Content Area**: Multi-line EditText for file contents
- **Save Button**: Writes content to file
- **Footer**: Developer credit text

### Layout Features:
- Vertical LinearLayout for clear hierarchy
- Proper weighting for responsive design
- Logical component grouping
- Appropriate margins and padding

2. **MainActivity.java**
This Java file implements file operations with version-aware permission handling.

## Core Components:
- **Permission Management**: Handles storage permissions
- **File Operations**: Read/write functionality
- **Path Handling**: Defaults to app-specific storage
## Key Functionalities:
### Storage Permission Handling:
```java
private boolean hasStoragePermission() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        return true; // No permission needed for app-specific storage
    } else {
        return ContextCompat.checkSelfPermission(...) == PERMISSION_GRANTED;
    }
}
```
### File Reading:
```java
try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    // Read file line by line
}
```
### File Writing:
```java
try (FileWriter writer = new FileWriter(file)) {
    writer.write(content);
}
```
### Directory Creation:
```java
if (parentDir != null && !parentDir.exists()) {
    parentDir.mkdirs();
}
```
## Implementation Details:
- Uses try-with-resources for automatic stream closing
- Handles both legacy and scoped storage
- Provides detailed error feedback
- Defaults to safe app-specific directory
- Comprehensive permission flow

## Expected Output
- Clean file management interface
- Default path to app-specific storage
- Successful read/write operations with toast confirmation
- Appropriate error messages for: Missing permissions, Non-existent files, I/O errors
- Automatic directory creation when needed

---
# Experiment 8 - Notification System Implementation

## AIM
To develop an Android application that demonstrates modern notification implementation with proper channel creation and Android 13+ notification permission handling.

## Experiment Details
- **Folder Location**: `Android_Studio_Students_CSE_B/Experiment_8/`
- **Files**:
  - `activity_main.xml` (Layout file)
  - `MainActivity.java` (Main Activity file)
  - `AndroidManifest.xml` (Permission declaration)

## Configuration Changes
### AndroidManifest.xml
```xml
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
```
## Code Explanation
1. **activity_main.xml**
This XML file defines a simple notification interface using LinearLayout.

### Key Components:
- **Title Bar**: Blue header showing "Exp_no_8"
- **Message Input**: EditText for notification content
- **Notify Button**: Triggers notification display
- **Layout Features**:
- Clean vertical LinearLayout
- Appropriate spacing and margins
- Clear visual hierarchy
- Centered action button

2. **MainActivity.java**
This Java file implements the complete notification system.

### Core Components:
- **Notification Channel**: Required for Android 8.0+
- **Permission Handler**: Manages Android 13+ notification permission
- **Notification Builder**: Creates and displays notifications

### Key Functionalities:
- **Notification Channel Creation**:
```java
private void createNotificationChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        NotificationChannel channel = new NotificationChannel(
            CHANNEL_ID, 
            "SMS Notifications", 
            NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Channel for SMS alert notifications");
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
}
```
- **Permission Handling**:
```java
private boolean checkNotificationPermission() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        return checkSelfPermission(POST_NOTIFICATIONS) == PERMISSION_GRANTED;
    }
    return true; // Permission not required pre-Android 13
}
```
- **Notification Display**:
```java
NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
    .setSmallIcon(android.R.drawable.ic_dialog_email)
    .setContentTitle(title)
    .setContentText(message)
    .setPriority(NotificationCompat.PRIORITY_DEFAULT);
```
## Implementation Details:
- Version-aware permission checking
- Proper notification channel setup
- User feedback via Toast messages
- Input validation
- Notification importance configuration

## Expected Output
- Clean notification composition interface
- Proper permission request flow on Android 13+
- Notification with:
- Email icon
- Custom title ("Test Notification")
- User-provided message content
- Toast messages for: Success/failure, Permission status, Empty input warning

---
# Experiment 9 - Android Menu Implementation

## Description
This Android application demonstrates two types of menu implementations:
1. **Options Menu** (three-dot menu in the ActionBar)
2. **Popup Menu** (triggered by a button click)

## Features
- Black title bar with white text
- Menu button that triggers a popup
- Three menu options: Settings, About, Exit
- Toast messages on menu item selection
- Exit functionality to close the app

## Files Structure

### 1. MainActivity.java
Handles both menu types and their click events.

**Key Methods:**
- `onCreateOptionsMenu()` - Inflates the options menu
- `onOptionsItemSelected()` - Handles options menu clicks
- `PopupMenu` implementation - Creates and shows popup menu
- Menu item click listeners

### 2. activity_main.xml
Defines the app's layout with:
- Black title bar with app name and menu button
- Main content area

**Key Components:**
- LinearLayout for overall structure
- TextView for title
- Button for popup menu trigger
- Styling attributes for colors and padding

### 3. main_menu.xml (in res/menu)
Defines the menu items used by both menu types.

**Menu Items:**
- Settings
- About 
- Exit

## Implementation Details

### Options Menu (ActionBar)
1. Automatically appears as three-dot icon
2. Shows when user clicks the icon
3. Handles selections in `onOptionsItemSelected()`

### Popup Menu
1. Triggered by clicking the "Menu" button
2. Created programmatically using PopupMenu class
3. Uses same menu resource as options menu
4. Has separate but identical click handler

## Expected Output
- Black title bar with "MainActivity" text
- Menu button on right side
- Both menu types show same three options
- Toast messages appear when items selected
- Exit option closes the application

## Customization Options
1. Change colors in activity_main.xml
2. Add more menu items in main_menu.xml
3. Modify click handlers for different actions
4. Change menu icons (not shown in current implementation)

---
# Experiment 10 - Alarm Clock Application

## AIM
To create an Android application that demonstrates alarm scheduling using AlarmManager, with notification channel setup and proper broadcast receiver implementation.

## Code Explanation

### 1. activity_main.xml
This layout creates a dark-themed alarm interface with three main components:

#### UI Components:
- **TimePicker**: Spinner-style time selection widget with custom styling (orange header, white numbers on dark background)
- **Toggle Button**: Orange button that switches between "SET ALARM" and "CANCEL ALARM" states
- **Status Indicator**: Text view showing current alarm state (ON/OFF) with color coding

#### Design Features:
- Dark theme background (#121212)
- RelativeLayout for component positioning
- Visual hierarchy with proper spacing
- Color-coded status feedback (green=ON, red=OFF)

### 2. MainActivity.java
The core alarm scheduling logic:

#### Key Components:
- **AlarmManager**: System service for scheduling alarms
- **PendingIntent**: For triggering the alarm broadcast
- **Notification Channel**: Required for Android 8.0+

#### Main Functionalities:
1. **Alarm Setting**:
   ```java
   alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTime.getTimeInMillis(), pendingIntent);
   ```
- Uses RTC_WAKEUP to wake device
- Validates future time selection
- Updates UI state

2. **Alarm Cancellation**:
```java
alarmManager.cancel(pendingIntent);
Removes scheduled alarm
```
- Resets UI state

### Notification Channel Creation:

```java
NotificationChannel channel = new NotificationChannel("alarm_channel", 
    "AlarmChannel", NotificationManager.IMPORTANCE_HIGH);
```
### UI State Management:

- Toggle button text changes
- Status text color changes (green/red)

3. **AlarmReceiver.java**
#### Handles alarm triggering:
- Key Actions:
- Plays Alarm Sound:
```java
Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
ringtone.play();
```

- Falls back to notification sound if alarm sound unavailable

#### Displays Notification:
```java
new NotificationCompat.Builder(context, "alarm_channel")
    .setContentTitle("Alarm!")
    .setContentText("Wake up! Wake up!");
```
#### High priority notification
- Auto-cancellable
- Updates Main Activity:
```java
MainActivity.instance().updateAlarmStatus("OFF");
```
4. **AndroidManifest.xml**
#### Key Declarations:
```xml
<uses-permission android:name="android.permission.SCHEDULE_EXACT_ALARM" />
<uses-permission android:name="android.permission.USE_EXACT_ALARM" />
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />

<receiver android:name=".AlarmReceiver" />
```

#### Technical Highlights
- Proper notification channel setup for Android 8.0+
- Exact alarm permissions for Android 12+
- Fallback sound handling
- Thread-safe UI updates via runOnUiThread()
- Visual feedback through color-coded status
- Singleton pattern for Activity access from Receiver

#### Permission Requirements
- SCHEDULE_EXACT_ALARM: For precise alarm timing (Android 12+)
- USE_EXACT_ALARM: For critical alarm functionality
- POST_NOTIFICATIONS: For displaying alarm notifications (Android 13+)

This implementation provides a complete alarm clock solution while demonstrating modern Android development practices for scheduling and notifications.

---
# Experiment 11 - WebView Todo List Application

## Project Description
This Android application demonstrates the integration of a web-based todo list interface within a native Android app using WebView. The experiment showcases hybrid app development by rendering an HTML/CSS/JavaScript todo list inside an Android WebView component.

## Code Components

### 1. todo_list.html
This file contains the complete web implementation of the todo list interface:

- Uses semantic HTML5 structure
- Implements modern CSS styling with:
  - Clean card-based layout
  - Custom circular checkboxes
  - Responsive design principles
- Includes JavaScript functionality for:
  - Interactive checkbox toggling
  - Real-time item counting
  - Dynamic UI updates

### 2. activity_main.xml
The Android layout file containing:

- A single WebView component
- Full-screen display configuration
- Basic RelativeLayout structure

### 3. MainActivity.java
The Android activity that handles:

- WebView initialization and configuration
- JavaScript and DOM storage enabling
- Local HTML file loading from assets
- WebView debugging setup (for development)

## Technical Implementation

The application works by:

1. Loading the pre-built HTML todo list interface
2. Enabling JavaScript execution in WebView
3. Supporting DOM storage for web features
4. Handling all navigation internally
5. Providing visual feedback for task completion
6. Maintaining a real-time count of remaining items

## Key Features

- Pure web-based UI rendered natively
- Interactive task completion tracking
- Clean material-inspired design
- Responsive layout for different devices
- No external dependencies required
- Efficient local asset loading

## Usage

The app requires no special permissions and works immediately upon launch, displaying the todo list interface with sample tasks that can be marked complete/incomplete.

---

# Android Experiments Quick Reference

### Core Concepts Covered:

1. **Basic UI Components**
   - Buttons, TextViews, EditTexts
   - Linear/Constraint/Relative layouts
   - Event listeners

2. **User Interactions**  
   - Touch events
   - Click handlers  
   - Gesture detection

3. **Data Handling**
   - SQLite databases
   - File I/O operations
   - SharedPreferences

4. **System Features**
   - Location services
   - AlarmManager
   - Notifications
   - WebView

5. **Visual Elements**
   - Custom drawing
   - Animations
   - Material design

6. **Background Operations**
   - Async tasks
   - Services
   - Broadcast receivers

7. **Permissions**
   - Runtime requests
   - Permission groups
   - Legacy vs new models

### Key Technical Takeaways:

- Activity lifecycle management
- View binding techniques
- Intent handling
- Resource management
- UI thread vs background thread
- Basic debugging methods
- Hybrid app development
- Notification channels
- Alarm scheduling
- Canvas drawing operations

### Experiment Categories:

1-4: Basic UI & Interactions  
5-8: System Integration  
9-11: Advanced Features


Thank you for looking at this repository till end. Make sure to star this repo!!
