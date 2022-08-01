import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;

public class CurrencyConverter {

    void convertCurrency() {
        // Pick Naira to Dollar or dollar to Naira

        // Create JFrame
        JFrame frame = new JFrame("Converter");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(1, 2));

        // 2 Buttons
        JButton n2dButton = new JButton("Naira to Dollar");
        JButton d2nButton = new JButton("Dollar to Naira");
        frame.add(n2dButton);
        frame.add(d2nButton);

        frame.setVisible(true);

        n2dButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                enterCurrencyForConversion("n2d");
            }
        });

        d2nButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                enterCurrencyForConversion("d2n");
            }
        });
    }

    void enterCurrencyForConversion(String typeOfConversion) {
        // Create JFrame
        JFrame frame = new JFrame("Converter");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(2, 1));

        JTextField input = new JTextField();
        frame.add(input);
        JButton button = new JButton("convert");
        frame.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = input.getText();
                float inputNumber = Integer.parseInt(inputText);
                double money = 0.0;

                if (typeOfConversion == "n2d") {
                    money = inputNumber / 700;

                    System.out.println("Thats " + money + " Dollars");
                } else if (typeOfConversion == "d2n") {
                    money = inputNumber * 700;

                    System.out.println("Thats " + money + " Naira");
                }

                // write to file
                try {
                    FileWriter file = new FileWriter("file.txt");
                    file.write("Your Conversion " + typeOfConversion + " is " + money );
                    file.close();
                } catch (Exception anError){
                    System.out.println(anError);
                }
            }
        });


        frame.setVisible(true);
    }

    void convertAndWrite() {

    }
}
