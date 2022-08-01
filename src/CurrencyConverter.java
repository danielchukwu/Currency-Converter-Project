import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;

public class CurrencyConverter {

    // First Page
    void convertCurrency() {
        // Pick Naira to Dollar or dollar to Naira (n2d or d2n)

        // Create JFrame, setSize, setLayout
        JFrame frame = new JFrame("Converter");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(1, 2));

        // Create and add buttons to frame
        JButton n2dButton = new JButton("Naira to Dollar");
        JButton d2nButton = new JButton("Dollar to Naira");
        frame.add(n2dButton);
        frame.add(d2nButton);

        frame.setVisible(true);  // set frame to visible

        // Set listener for first button
        n2dButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                enterCurrencyForConversion("n2d");    // if Dollar to naira button clicked on call enterCurrencyForConversion method(in line 47) with n2d
            }
        });

        // Set listener for first button
        d2nButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                enterCurrencyForConversion("d2n");     // if Dollar to naira button clicked on call enterCurrencyForConversion method(in line 47) with d2n
            }
        });
    }

    // Second Page
    void enterCurrencyForConversion(String typeOfConversion) {
        // Create JFrame
        JFrame frame = new JFrame("Converter");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(2, 1));

        // create TextField to recieve data from user for conversion
        JTextField input = new JTextField();
        frame.add(input);    // add input to frame
        JButton button = new JButton("convert");
        frame.add(button);   // add button to frame

        frame.setVisible(true);  // set frame to visible

        // add event listener on button. when button is clicked execute the below block of code
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = input.getText();
                float inputNumber = Integer.parseInt(inputText);
                double money = 0.0;

                // if n2d convert input from naira to dollar
                if (typeOfConversion == "n2d") {
                    money = inputNumber / 700;

                    System.out.println("Thats " + money + " Dollars");

                // if n2d convert input from dollar to naira
                } else if (typeOfConversion == "d2n") {
                    money = inputNumber * 700;

                    System.out.println("Thats " + money + " Naira");
                }

                // write to file
                try {
                    FileWriter file = new FileWriter("file.txt");      // create file
                    file.write("Your Conversion " + typeOfConversion + " is " + money );       // write to file
                    file.close();  // close file
                } catch (Exception anError){
                    System.out.println(anError);
                }
            }
        });
    }

    void convertAndWrite() {

    }
}
