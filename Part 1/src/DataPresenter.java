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
