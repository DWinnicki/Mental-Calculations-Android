package com.winnicki.mentalcalculations.model;

public class Operation {
    private String firstOperand;
    private String operator;
    private String secondOperand;
    private String equalSign;
    private String result;
    private String mark;

    public Operation(String firstOperand, String operator, String secondOperand, String equalSign, String result) {
        this.firstOperand = firstOperand;
        this.operator = operator;
        this.secondOperand = secondOperand;
        this.equalSign = equalSign;
        this.result = result;
        this.mark = "empty";
    }

    public Operation(String firstOperand, String operator, String secondOperand, String equalSign, String result, String mark) {
        this.firstOperand = firstOperand;
        this.operator = operator;
        this.secondOperand = secondOperand;
        this.equalSign = equalSign;
        this.result = result;
        this.mark = mark;
    }

    public String getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(String firstOperand) {
        this.firstOperand = firstOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(String secondOperand) {
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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
