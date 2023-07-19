import javax.swing.*;

public class Calculator {
    private String displayedNum;
    private String bufferNum;
    private String selectedOperation;
    private String operation;

    public Calculator() {
        displayedNum = "0";
        bufferNum = "0";
        selectedOperation = null;
        operation = null;
    }

    public String getDisplayedNum() {
        return displayedNum;
    }

    private void clear() {
        displayedNum = "0";
        bufferNum = "0";
        selectedOperation = null;
        operation = null;
    }

    private void undo() {
        if(displayedNum.length() > 1)
            displayedNum = displayedNum.substring(0, displayedNum.length() - 1);
        else
            displayedNum = "0";
    }

    private void setPoint() {
        if(!displayedNum.contains("."))
            displayedNum += ".";
    }

    private void formatNumber() {
        double floatingPoint = Double.parseDouble(displayedNum);
        int integer = (int)floatingPoint;

        if(floatingPoint == integer)
            displayedNum = Integer.toString(integer);
    }

    private void calculate() {
        double rightNum = Double.parseDouble(displayedNum);
        double leftNum = Double.parseDouble(bufferNum);
        double result = 0;

        if(operation != null) {
            if(operation.equals("/")) {
                if(rightNum != 0)
                    result = leftNum / rightNum;
                else {
                    result = leftNum;
                    String message = "Do not divide by zero !";
                    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(operation.equals("*"))
                result = leftNum * rightNum;
            else if(operation.equals("-"))
                result = leftNum - rightNum;
            else if(operation.equals("+"))
                result = leftNum + rightNum;
        }
        else
            result = rightNum;

        displayedNum = Double.toString(result);
        bufferNum = Double.toString(result);

        formatNumber();
    }

    private void clickOperator(String operator) {
        if(operation != null) {
            calculate();
        }
        bufferNum = displayedNum;
        selectedOperation = operator;
        operation = operator;
    }

    private void clickNumber(String number) {
        if(displayedNum.equals("0") || selectedOperation != null)
            displayedNum = number;
        else
            displayedNum += number;

        if(selectedOperation != null) {
            operation = selectedOperation;
            selectedOperation = null;
        }
    }

    private void clickEquals() {
        calculate();
        selectedOperation = null;
        operation = null;
    }

    private void changeSign() {
        if(!displayedNum.equals("0")) {
            double num = Double.parseDouble(displayedNum) * -1;
            displayedNum = Double.toString(num);

            formatNumber();
        }
    }

    public void handleClickButton(String button) {
        switch (button) {
            case "=": clickEquals(); break;
            case "/":
            case "*":
            case "+":
            case "-": clickOperator(button); break;
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0": clickNumber(button); break;
            case ".": setPoint(); break;
            case "+/-": changeSign(); break;
            case "<-": undo(); break;
            case "C": clear(); break;
        }
    }
}