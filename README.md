# Task List Application (MVVM Pattern)

Welcome to the **Task List Application**! This project is structured using the **Model-View-ViewModel (MVVM)** design pattern, which separates the application's data management, UI, and business logic into distinct components. This README provides an overview of the MVVM structure, making the code modular, scalable, and maintainable.

---

## 📐 Project Structure

The **MVVM** pattern divides the code into three main components:

- **Model**: Manages the application’s data and business logic.
- **View**: Handles the UI, presenting data and gathering user input.
- **ViewModel**: Acts as an intermediary between the Model and the View, holding logic to format and present data.

---

## 🔍 Components

### 1. **Model**

The `Model` is responsible for data structure and business logic. It doesn’t interact with the user directly; instead, it only provides data to the `ViewModel`.

#### Example
```java
// Task.java
public class Task {
    private String title;
    private boolean isComplete;

    public Task(String title) {
        this.title = title;
        this.isComplete = false;
    }

    // Getters, Setters, and methods like toggleComplete()...
}```

