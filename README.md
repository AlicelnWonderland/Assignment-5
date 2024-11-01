# The Model-View-Presenter (MVP) pattern

Welcome! This project is structured using the **Model-View-Presenter (MVP)** design pattern, which separates the application's data management, UI, and business logic into distinct components. This README provides an overview of the MVP structure, making the code modular, scalable, and maintainable.

---

## 📐 Project Structure

The **MVP** pattern divides the code into three main components:

- **UserModel**: Represents the user’s data, with properties like name.
- **UserView**: Handles user interaction by showing menus, getting input, and displaying data.
- **UserViewModel**: Acts as an intermediary. It stores a list of UserModel objects, performs logic like adding users, and provides formatted data for the UserView.

---

## 🔍 Components

### 1. **Model**

The `Model` is responsible for data structure and business logic. It doesn’t interact with the user directly; instead, it only provides data to the `ViewModel`.

#### Example
```java
// DataModel.java
public class DataModel {
    private String data;

    public DataModel() {
        this.data = "Initial Data";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void appendData(String moreData) {
        this.data += " | " + moreData;
    }
}


```

### 2. **View**

The `View` manages the user interface, displaying data and capturing user actions like button clicks. It relies on the `ViewModel` to get data and bind it automatically.

#### Example
```java
// ConsoleView.java
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayData(String data) {
        System.out.println("Current Data: " + data);
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}

```
### 3. **DataPresenter**
The `ViewModel` coordinates data between the `Model` and `View`. It holds all UI logic, formatting data from the `Model` for display in the `View` and updating the `Model` based on user input.

```java
// DataPresenter.java
public class DataPresenter {
    private final DataModel model;
    private final ConsoleView view;

    public DataPresenter(DataModel model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void updateData() {
        view.displayData(model.getData());
        String newData = view.getInput("Enter new data: ");
        model.setData(newData);
        view.showMessage("Data updated to: " + model.getData());
    }

    public void addMoreData() {
        String moreData = view.getInput("Enter another piece of data: ");
        model.appendData(moreData);
        view.showMessage("Final combined data: " + model.getData());
    }
}

```
