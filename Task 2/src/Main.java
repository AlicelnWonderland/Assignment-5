import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserView view = new UserView();
        UserViewModel viewModel = new UserViewModel();

        while (true) {
            int option = view.showMenu();
            switch (option) {
                case 1:
                    String name = view.getUserNameInput();
                    viewModel.addUser(name);
                    view.displayMessage("User added!");
                    break;
                case 2:
                    List<String> userNames = viewModel.getUserNames();
                    view.displayUsers(userNames);
                    break;
                case 3:
                    view.displayMessage("Exiting...");
                    return;
                default:
                    view.displayMessage("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
