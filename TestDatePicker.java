import java.awt.*;
import java.awt.event.*;

import static javax.swing.GroupLayout.Alignment.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.BorderFactory;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.SqlDateModel;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class TestDatePicker {

    public static void main(String[] args)
    {
        final String text = "Date Picker example";

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final ApplicationWindow wnd = new ApplicationWindow(text);
                wnd.setVisible(true);                
            }
        });
    }
}

class ApplicationWindow extends JFrame {

    // Name-constants to define the various dimensions
    public static final int WINDOW_WIDTH  = 640;
    public static final int WINDOW_HEIGHT = 480;

    private Container          mainContentPane;
    private FlowLayout         layout;
    private JPanel             inputPanel;


    public ApplicationWindow(String title)
    {
        mainContentPane = this.getContentPane();

        // Content-pane sets layout
        // cp.setLayout(new ....Layout());        
        layout = new FlowLayout();
        mainContentPane.setLayout(layout);
        
        // Allocate the UI components
        initComponents();   

        // Content-pane adds components
        mainContentPane.add(inputPanel, BorderLayout.NORTH);   

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);       
        setTitle(title);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);        
    }

    private void initComponents()
    {

        inputPanel = new JPanel();

        UtilDateModel model = new UtilDateModel();
        model.setDate(1990, 8, 24);
        model.setSelected(true); 

        JDatePanelImpl  datePanel  = new JDatePanelImpl(model);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

        inputPanel.add(datePicker);
    }
}