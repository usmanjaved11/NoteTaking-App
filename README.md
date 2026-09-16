# 📝 Note Taking App

A simple **Java Desktop Note Taking Application** built with **Java Swing**, **Object-Oriented Programming (OOP)** concepts, and **File Handling**.

This project is designed as a beginner-friendly Java application for creating, viewing, deleting, and storing notes locally in a text file.

---

## ✨ Features

- 📝 Create notes with a **title** and **content**
- 📋 Display saved notes in a list
- 👀 Click a note to view its content
- 🗑️ Delete the selected note
- 💾 Save notes automatically to a local `notes.txt` file
- 📂 Load saved notes from the file
- 🔄 Automatically load previously saved notes when the application starts
- ⚠️ Basic validation for empty title/content
- 🚨 Error messages for file-related problems
- 🖥️ Simple desktop GUI using Java Swing

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| ☕ Java | Main programming language |
| 🖼️ Java Swing | Graphical User Interface |
| 📁 File Handling | Save and load notes |
| 📦 ArrayList | Store notes in memory |
| 📋 JList | Display notes |
| 🧩 OOP | Classes, objects, constructors, getters and setters |

---

## 📸 Application Overview

The application contains three main areas:

### 1. 📋 Notes List
The left side displays all saved note titles.

### 2. ✏️ Note Editor
The center area contains:
- Note title field
- Note content area

### 3. 🔘 Action Buttons
The bottom section contains:
- **Save Note**
- **Delete Note**
- **Load Notes**

---

## 🧠 OOP Concepts Used

This project demonstrates several important Java OOP concepts.

### `Note` Class

The `Note` class represents a single note.

```java
class Note {
    private String title;
    private String content;
}
```

It uses:

- **Encapsulation** through private fields
- **Constructor** to initialize objects
- **Getters** to access data
- **Setter** to modify content
- **`toString()`** to display the note title in the `JList`

### `NoteTakingApp` Class

The main application extends `JFrame`:

```java
public class NoteTakingApp extends JFrame
```

This class manages the GUI, note collection, button actions, and file operations.

---

## 📂 Project Structure

```text
NoteTakingApp/
│
├── NoteTakingApp.java
├── notes.txt              # Created automatically when notes are saved
└── README.md
```

> `notes.txt` does not have to be created manually. The application creates/updates it when notes are saved.

---

## 🚀 How to Run

### Method 1 — Terminal / Command Prompt

Make sure Java is installed.

Check your Java installation:

```bash
java -version
```

Compile the program:

```bash
javac NoteTakingApp.java
```

Run the application:

```bash
java NoteTakingApp
```

---

### Method 2 — VS Code

1. Install the **Java Extension Pack** in VS Code.
2. Open the project folder.
3. Open `NoteTakingApp.java`.
4. Click **Run**.
5. The Note Taking App window will open.

---

### Method 3 — IntelliJ IDEA / Eclipse

1. Create/open a Java project.
2. Add `NoteTakingApp.java`.
3. Run the `main()` method.
4. The application will start.

---

## 💾 How File Storage Works

The application uses a local text file:

```text
notes.txt
```

When you save notes, the program writes the title, content, and a separator into the file.

Example structure:

```text
My First Note
This is my first note.
-----
Java
Learning Java OOP.
-----
```

When the application starts, it automatically calls the load method and attempts to restore previously saved notes.

---

## 🔄 Application Flow

```text
                ┌─────────────────┐
                │  Start Program  │
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │ Load notes.txt  │
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │   Main Window   │
                └────────┬────────┘
                         │
          ┌──────────────┼──────────────┐
          ▼              ▼              ▼
     Save Note      Select Note     Delete Note
          │              │              │
          ▼              ▼              ▼
     Save to File   Show Content    Remove Note
```

---

## 🛡️ Validation & Error Handling

The application performs basic validation before saving.

If the title or content is empty, the application displays:

```text
Please enter title and content
```

It also handles file-related problems using `IOException`.

For example, if saved notes cannot be loaded, the application displays:

```text
No saved notes found
```

---

## 📚 Java Concepts Practiced

This project is useful for practicing:

- Classes and Objects
- Constructors
- Encapsulation
- Getters and Setters
- `ArrayList`
- `JFrame`
- `JPanel`
- `JTextField`
- `JTextArea`
- `JButton`
- `JList`
- `DefaultListModel`
- `JScrollPane`
- Event Handling
- `ActionListener`
- `MouseAdapter`
- File Reading
- File Writing
- `BufferedReader`
- `BufferedWriter`
- `FileReader`
- `FileWriter`
- `try-catch`
- `IOException`

---

## 🎯 Learning Purpose

This project was created to practice how **Java OOP, GUI development, event handling, collections, and file handling** can work together in one application.

The code is intentionally kept straightforward so that beginners can understand the main concepts and extend the project later.

---

## 🔮 Possible Future Improvements

The current application can be extended with:

- ✏️ Edit/update existing notes
- 🔍 Search notes
- 🏷️ Note categories/tags
- 📅 Date and time for each note
- 🌙 Dark mode
- 🎨 Improved modern UI
- 📌 Favorite/pin notes
- 🗂️ Multiple note files
- 🔐 Password-protected notes
- 🧹 Clear-all-notes option
- 💾 JSON/database storage instead of a text file

---

## 👨‍💻 Author

**M Usman**

Java Developer | Software Engineering Student

---

## ⭐ Support

If you find this project useful for learning Java, consider giving the repository a ⭐ on GitHub.

---

## 📄 License

This project is available for educational and learning purposes.
