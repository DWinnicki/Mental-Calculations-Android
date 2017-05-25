package com.winnicki.mentalcalculations.model;

import com.winnicki.mentalcalculations.EnumMark;

public class Operation {
    private int firstOperand;
    private String operator;
    private int secondOperand;
    private String equalSign;
    private String result;
    private EnumMark mark;

    public Operation(int firstOperand, String operator, int secondOperand, String equalSign, String result) {
        this.firstOperand = firstOperand;
        this.operator = operator;
        this.secondOperand = secondOperand;
        this.equalSign = equalSign;
        this.result = result;
        this.mark = EnumMark.EMPTY;
    }

    public int getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(int firstOperand) {
        this.firstOperand = firstOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(int secondOperand) {
        this.secondOperand = secondOperand;
    }

    public String getEqualSign() {
        return equalSign;
    }

    public void setEqualSign(String equalSign) {
        this.equalSign = equalSign;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public EnumMark getMark() {
        return mark;
    }

    public void setMark(EnumMark mark) {
        this.mark = mark;
    }

    public boolean checkResult(String userResult) {
        int answer = 0;
        switch (getOperator()) {
            case "+":
                answer = getFirstOperand() + getSecondOperand();
                break;
            case "-":
                answer = getFirstOperand() - getSecondOperand();
                break;
            case "x":
                answer = getFirstOperand() * getSecondOperand();
        }
        return Integer.parseInt(userResult) == answer;
    }
}
