
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Desc: Ticket Machine program for an assignment 5
 * Date: March 16, 2020
 *
 * @author Eunjoo Na
 **/

public class TicketMachineView extends Application {

    // TODO: Instance Variables for View Components and Model

    GraphicsContext gc;
    /** Buttons of the machine **/
    Button adultAdd, adultDelete, childAdd, childDelete, routeEnter, quarter, loonie, toonie, print, clear, back;
    /** TextField of the machine **/
    TextField routeField;
    /** Labels of the machine **/
    Label machineName, output, route, passengers, adult, child, coinOutput;
    /** TicketMachine object **/
    TicketMachineModel model;

    // TODO: Private Event Handlers and Helper Methods

    /**set route of the machine
     * @param e ActionEvent
     **/
    private void setRoute(ActionEvent e) {
        String route = routeField.getText();
        model.setRouteMainKing(route);
        drawing();
        routeField.setText("");
    }

    /**add number of adult in the machine
     * @param e ActionEvent
     **/
    private void setAdultAdd(ActionEvent e) {
        model.setTicket(3);
        model.getTotal();
        drawing();
    }

    /**delete number of adult in the machine
     * @param e ActionEvent
     **/
    private void setAdultDelete(ActionEvent e) {
        model.setTicket(4);
        model.getTotal();
        drawing();
    }

    /**Add number of child in the machine
     * @param e ActionEvent
     **/
    private void setChildAdd(ActionEvent e) {
        model.setTicket(5);
        model.getTotal();
        drawing();
    }

    /**delete number of adult in the machine
     * @param e ActionEvent
     **/
    private void setChildDelete(ActionEvent e) {
        model.setTicket(6);
        model.getTotal();
        drawing();
    }

    /**add up quarter in the credit
     * @param e ActionEvent
     **/
    private void setQuarter(ActionEvent e) {
        model.setCredit(7);
        coinOutput.setText(" " + model.creditTotal());
    }

    /**add up loonie in the credit
     * @param e ActionEvent
     **/
    private void setLoonie(ActionEvent e) {
        model.setCredit(8);
        coinOutput.setText(" " + model.creditTotal());
    }

    /**add up toonie in the credit
     * @param e ActionEvent
     **/
    private void setToonie(ActionEvent e) {
        model.setCredit(9);
        coinOutput.setText(" " + model.creditTotal());
    }

    /**process printing
     * @param e ActionEvent
     **/
    private void setPrint(ActionEvent e) {
        output.setText(" " + model.getPrintTicket());
        coinOutput.setText(" " + model.creditTotal());
        routeField.setText("");
    }

    /**initialize the data in the machine
     * @param e ActionEvent
     **/
    private void setClear(ActionEvent e) {
        routeField.setText("");
        model.routeInitialized();
        model.setInitialized();
        output.setText(" " + model);
        coinOutput.setText(" " + model.creditTotal());

    }

    /**show the latest data in the machine
     * @param e ActionEvent
     **/
    private void setBack(ActionEvent e) {
        output.setText(" " + model);
    }

    /**draw the screen and the image of the machine
     **/
    private void drawing() {
        gc.setFill(Color.rgb(102, 102, 153));
        gc.fillRect(0, 0, 600, 520);
        Image img = new Image("coin4.png");
        gc.drawImage(img, 400, 230, 110, 100);
        output.setText(" " + model);
    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 520); // set the size here
        stage.setTitle("Ticket Machine"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here


        // 1. Create the model
        model = new TicketMachineModel();

        // 2. Create the GUI components
        Canvas c = new Canvas(600, 520);
        adultAdd = new Button("+");
        adultDelete = new Button("-");
        childAdd = new Button("+");
        childDelete = new Button("-");
        quarter = new Button("0.25");
        loonie = new Button("1.00");
        toonie = new Button("2.00");
        machineName = new Label("Hamilton Subway Ticket Machine");
        output = new Label("---");
        route = new Label("---Type the Route ('Main' or 'king')---");
        passengers = new Label("-------Passengers-------");
        adult = new Label("Adult");
        child = new Label("Child");
        coinOutput = new Label("  Credit: $ 0.00   ");
        routeField = new TextField("");
        routeEnter = new Button("Enter");
        print = new Button("PRINT THE TICKET");
        clear = new Button("Clear");
        back = new Button("Back");

        // 3. Add components to the root
        root.getChildren().addAll(c, machineName, output, route, routeField, routeEnter, passengers, adultDelete,
                adult, adultAdd, childDelete, child, childAdd, coinOutput, quarter, loonie, toonie, print, clear, back);

        // 4. Configure the components (colors, fonts, size, location)
        machineName.relocate(80, 10);
        output.relocate(50, 60);
        route.relocate(50, 220);
        routeField.setPrefColumnCount(4);
        routeField.relocate(90, 260);
        routeEnter.relocate(170, 260);
        passengers.relocate(50, 300);
        adultDelete.relocate(100, 340);
        adultAdd.relocate(180, 340);
        adult.relocate(130, 340);
        childDelete.relocate(100, 380);
        childAdd.relocate(180, 380);
        child.relocate(130, 380);
        coinOutput.relocate(390, 330);
        quarter.relocate(390, 375);
        loonie.relocate(435, 375);
        toonie.relocate(480, 375);
        print.relocate(190, 460);
        clear.relocate(410, 460);
        back.relocate(100, 460);

        machineName.setFont(new Font("System", 30));
        output.setFont(new Font("System", 20));
        route.setFont(new Font("System", 20));
        passengers.setFont(new Font("System", 20));
        adult.setFont(new Font("System", 17));
        child.setFont(new Font("System", 17));
        coinOutput.setFont(new Font("System", 18));

        machineName.setStyle("-fx-text-fill:white;");
        output.setStyle("-fx-background-color: greenyellow;-fx-text-fill:black;");
        route.setStyle("-fx-text-fill:white;");
        adult.setStyle("-fx-text-fill:white;");
        child.setStyle("-fx-text-fill:white;");
        passengers.setStyle("-fx-text-fill:white;");
        coinOutput.setStyle("-fx-background-color: greenyellow;-fx-text-fill:black;");
        print.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9;");
        clear.setStyle("-fx-font: 20 arial;");
        back.setStyle("-fx-font: 20 arial;");

        // 5. Add Event Handlers and do final setup
        routeEnter.setOnAction(this::setRoute);
        adultAdd.setOnAction(this::setAdultAdd);
        adultDelete.setOnAction(this::setAdultDelete);
        childAdd.setOnAction(this::setChildAdd);
        childDelete.setOnAction(this::setChildDelete);
        quarter.setOnAction(this::setQuarter);
        loonie.setOnAction(this::setLoonie);
        toonie.setOnAction(this::setToonie);
        print.setOnAction(this::setPrint);
        clear.setOnAction(this::setClear);
        back.setOnAction(this::setBack);

        gc = c.getGraphicsContext2D();
        drawing();

        // 6. Show the stage
        stage.show();
    }


    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}

