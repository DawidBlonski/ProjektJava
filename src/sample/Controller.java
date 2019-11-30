import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.MyGraph;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

public class Controller implements Initializable {

    @FXML
    private TextField display1;

    @FXML
    private TextField display2;

    @FXML
    private LineChart<Double, Double> lineGraph;

    @FXML
    private Label labeltext;

    private MyGraph mathsGraph;

    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
        mathsGraph = new MyGraph(lineGraph, 10);
        lineGraph.setVisible(true);
    }


    @FXML
    private void cubeFunction(final ActionEvent event) {
        if (display1.getText().isEmpty() ||  (display2.getText().isEmpty() ))
        {
        labeltext.setText("Brakuje wartosci");
        }

        else {
            try{
                labeltext.setText("");
                double d1 = Double.parseDouble(display1.getText());
                double d2 = Double.parseDouble(display2.getText());
                plotLine(x -> (x*d1)*(x*d1) + d2);
            }catch (NumberFormatException e)
            {labeltext.setText("Wpisz prawidłowe wartości");}
            }

    }


    @FXML
    private void linearFunction(final ActionEvent event)  {
        System.out.println(display1.getText());
        if (display1.getText().isEmpty() ||  (display2.getText().isEmpty() ))
        {
            labeltext.setText("Brakuje wartosci");
        }

        else {
            try{
                labeltext.setText("");
                double d1 = Double.parseDouble(display1.getText());
                double d2 = Double.parseDouble(display2.getText());
                System.out.println(display1.getText());
                plotLine(x -> (d1*x) + d2);
            }catch (NumberFormatException e)
            {labeltext.setText("Wpisz prawidłowe wartości");}
        }

    }


    private void plotLine(Function<Double, Double> function) {
        mathsGraph.plotLine(function);

        }


    @FXML
    private void ClearGraphAction(final ActionEvent event) {
        clear();
    }

    private void clear() {
        mathsGraph.clear();
        }
    }




