/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bmicalculator;

/**
 *
 * @author lenovo
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMIcalculator extends JFrame {
    private JTextField weightField;
    private JTextField heightField;
    private JTextField genderField;
    private JTextArea resultArea;

    public BMIcalculator() {
        setTitle("BMI Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel weightLabel = new JLabel("Weight (kg):");
        weightLabel.setBounds(10, 20, 80, 25);
        panel.add(weightLabel);

        weightField = new JTextField(20);
        weightField.setBounds(100, 20, 165, 25);
        panel.add(weightField);

        JLabel heightLabel = new JLabel("Height (cm):");
        heightLabel.setBounds(10, 50, 80, 25);
        panel.add(heightLabel);

        heightField = new JTextField(20);
        heightField.setBounds(100, 50, 165, 25);
        panel.add(heightField);

        JLabel genderLabel = new JLabel("Gender (M/F):");
        genderLabel.setBounds(10, 80, 80, 25);
        panel.add(genderLabel);

        genderField = new JTextField(20);
        genderField.setBounds(100, 80, 165, 25);
        panel.add(genderField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(10, 110, 150, 25);
        panel.add(calculateButton);

        resultArea = new JTextArea();
        resultArea.setBounds(10, 140, 350, 100);
        resultArea.setEditable(false);
        panel.add(resultArea);

        calculateButton.addActionListener((ActionEvent e) -> {
            calculateBMI();
        });
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());
            String gender = genderField.getText().toLowerCase();

            height /= 100; // Convert height to meters

            double bmi = weight / (height * height);

            double ob = 27;
            double gem = 23;
            double norm = 17;
            if (gender.equals("f")) {
                gem = 25;
                norm = 18;
            }

            StringBuilder resultText = new StringBuilder();
            resultText.append("BMI: ").append(bmi).append("\n");

            if (bmi > ob) {
                resultText.append("OBESITY\nWarning: You are in the obesity category. It's advisable to work on weight loss for better health.\n");
            } else if (bmi > gem) {
                resultText.append("OVERWEIGHT\nBe cautious: You are in the overweight category. Try to avoid fatty foods and increase physical activity at least twice a week.\n");
            } else if (bmi > norm) {
                resultText.append("NORMAL\nCongratulations! Your weight is ideal.\n");
            } else {
                resultText.append("UNDERWEIGHT\nConsider gaining weight by consuming carbohydrate-rich foods and incorporating exercise into your routine.\n");
            }

            resultArea.setText(resultText.toString());
        } catch (NumberFormatException ex) {
            resultArea.setText("Please enter valid numeric values for weight and height.");
        }
    }

    public static void main(String[] args) {
        new Test();
    }
}
    

