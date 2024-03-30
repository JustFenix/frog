package at.hwg.frog.views;

import com.storedobject.chart.Data;
import com.storedobject.chart.DataType;
import com.storedobject.chart.LineChart;
import com.storedobject.chart.RectangularCoordinate;
import com.storedobject.chart.SOChart;
import com.storedobject.chart.Title;
import com.storedobject.chart.XAxis;
import com.storedobject.chart.YAxis;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The main view is a top-level placeholder for other views.
 */
@Route
public class MainView extends VerticalLayout {

    private SOChart soChartPressure;

    public MainView() {
        Button button = new Button("Click me",
                event -> Notification.show("Clicked!"));

        add(getchart());
    }

    private Component getchart() {
        String title = "Temperatur";
        
        // Creating a chart display area
        soChartPressure = new SOChart();
        soChartPressure.setSize("100%", "400px");
        soChartPressure.clear();
        soChartPressure.add(updateLineChart(), new Title(title));

        return soChartPressure;

    }

    private com.storedobject.chart.Component updateLineChart() {

        Data xValues = new Data(1.1), yValues = new Data((Number) null);
        xValues.clear();
        yValues.clear();
        xValues.add(1);
        xValues.add(2);
        xValues.add(3);
        xValues.add(4);

        yValues.add(25);
        yValues.add(30);
        yValues.add(35);
        yValues.add(28);
        float x = (float) 4.0;
        float min = (float) 5;
       
        xValues.setName("X Values");
        yValues.setName("Random Values");

        // Line chart is initialized with the generated XY values
        LineChart lineChart = new LineChart(xValues, yValues);
        lineChart.setName(" - ");

        // Line chart needs a coordinate system to plot on
        // We need Number-type for both X and Y axes in this case
        XAxis xAxis = new XAxis(DataType.NUMBER);
        YAxis yAxis = new YAxis(DataType.NUMBER);
        yAxis.setMin(min);
        RectangularCoordinate rc = new RectangularCoordinate(xAxis, yAxis);
        lineChart.plotOn(rc);

        return (lineChart);

    }
}
