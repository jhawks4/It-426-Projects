/*
* Joshua Hawks
* 10/06/2017
* Calculator.java
* This file contains code for our calculator to calculate simple Mathematical problems.
*/
package calculator;

/**
 * This class provides the controls for doing all the calculations as well as providing the output for those
 * calculations.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class Calculator{

    //Constants.
    private final String EMPTY_STRING = "";
    private static final int DEFAULT_INDEX_VALUE = 0;

    //Variables.
    private double primaryNumber;
    private double secondaryNumber;
    private double answer;
    private String inputText;
    private StringBuilder textNumberBuilder = new StringBuilder();
    private String operator = EMPTY_STRING;

    /**
     * Constructor for the calculator class.
     */
    //Default constructor.
    public Calculator(){ }

    /**
     * A method that is used to set the values from the number buttons on the calculator.
     *
     * @param inputText This parameter is used to get the input from the number buttons.
     */
    //Sets both text and numerical value.
    public void setTextAndNumericalValue(String inputText, double inputNumber){
        if (operator == ""){
            textNumberBuilder(inputText);
            setText(textNumberBuilder);
            setPrimaryNumber(numberBuilder(this.primaryNumber, inputNumber));
        }else{
            textNumberBuilder(inputText);
            setText(textNumberBuilder);
            setSecondaryNumberNumber(numberBuilder(this.secondaryNumber, inputNumber));
        }

    }

    /**
     * This method is used after the enter button has been fired and provides a way to ensure that unnecessary
     * values are cleaned up and only the result is supplied.
     *
     * @param answer This parameter passes in the calculated value.
     */
    //This sets the primary number to the answer calculated after pressing enter on the calculator.
    public void setAfterEnter(double answer){
        clearPrimaryNumber();
        clearSecondaryNumber();
        setPrimaryNumber(numberBuilder(this.primaryNumber, answer));
        textNumberBuilder.append(this.primaryNumber); //Is making a string for the screen
        setText(textNumberBuilder);
    }

    //Builds the number so it's not lost when a new input is received.
    private double numberBuilder(double answerNumber, double inputNumber){
        return answerNumber = answerNumber * 10 + inputNumber;
    }

    /**
     * This sets the primary number.
     *
     * @param primaryNumber This parameter is used to help set the primary number.
     */
    //Sets the primary number.
    public void setPrimaryNumber(double primaryNumber) {
        this.primaryNumber = primaryNumber;
    }

    /**
     * This sets the primary number.
     *
     * @param secondaryNumber This parameter is used to help set the secondary number.
     */
    //Sets the secondary number.
    public void setSecondaryNumberNumber(double secondaryNumber) {
        this.secondaryNumber = secondaryNumber;
    }

    /**
     * This sets the answer number.
     *
     * @param answer This parameter is ued to help set the answer number.
     */
    //Sets the answer number.
    public void setAnswer(double answer) {
        this.answer = answer;
    }

    /**
     * This sets the text that is displayed in the calculator view.
     *
     * @param textNumberBuilder This parameter is used to help set the string value that is viewed on the
     *                          calculator UI.
     */
    //Sets input text.
    public void setText(StringBuilder textNumberBuilder){
        this.inputText = textNumberBuilder.toString();
    }

    //Builds text string.
    private void textNumberBuilder(String inputText){
        textNumberBuilder.append(inputText);
    }

    /**
     * This method gets the text value that is viewed on the calculator UI.
     *
     * @return This method returns a String.
     */
    //Gets input text.
    public String getInputText() {
        return inputText;
    }

    /**
     * This method gets the primary number value.
     *
     * @return This method returns a double.
     */
    //Gets primary number.
    public double getPrimaryNumber(){
        return primaryNumber;
    }

    /**
     * This method gets the secondary number value.
     *
     * @return This method returns a double.
     */
    //Gets secondary number.
    public double getSecondaryNumber() {
        return secondaryNumber;
    }

    /**
     * This method gets the answer number value.
     *
     * @return This method returns a double.
     */
    //Gets answer number.
    public double getAnswer() {
        return answer;
    }

    /**
     * This sets the operator with the appropriate String.
     *
     * @param operator This parameter passes a String to our variable.
     */
    //Sets the operator.
    public void setOperator(String operator) {
        clearStringBuilder();
        this.operator = operator;
    }

    /**
     * This method gets the value of the operator variable.
     *
     * @return This method returns a String.
     */
    //Gets the operator.
    public String getOperator() {
        return operator;
    }

    /**
     * This method calculates the square of a number and then sets it.
     */
    //Calculates the square of a number.
    public void squared(){
        clearStringBuilder();
        setAnswer(primaryNumber * primaryNumber);
    }

    /**
     * This method calculates the cube of a number and then sets it.
     */
    //Calculates the cube of a number.
    public void cubed(){
        clearStringBuilder();
        setAnswer(primaryNumber * primaryNumber * primaryNumber);
    }

    /**
     * This method provides a recursive calculation to find the power of any given number.
     *
     * @param primaryNumber This parameter is the number that is being exponentially multiplied.
     * @param exponent This parameter provides the exponential value that will be used to multiply the number.
     * @return Has a base case that returns the value one when the exponential value reaches zero. Until the
     * exponential value reaches zero the method returns itself.
     */
    //Calculates a custom exponential value for a given numerical value.
    public double customExponent(double primaryNumber, double exponent){
        if(exponent == DEFAULT_INDEX_VALUE){
            return 1;
        }else{
            return primaryNumber * customExponent(primaryNumber, exponent - 1);
        }
    }

    /**
     * Provides a calculation to find the percentile of any given value.
     */
    //Calculates the percentile of a value.
    public void percentile(){
        clearStringBuilder();
        setAnswer(primaryNumber / 100);
    }

    /**
     * This method provides a way to calculate all base operators and the custom exponential value.
     * It also sets the answer after calculating the values.
     *
     * @param primaryNumber This parameter is the first number that is inputted from the calculator.
     * @param secondaryNumber This paramether is the second number that is inputted from the calculator.
     * @param operator This parameter provides the string to know what equation to use for the calculation.
     */
    //Calculates the number based on the operator.
    public void enter(double primaryNumber, double secondaryNumber, String operator){
        clearStringBuilder();
        double answer = operatorSwitch(primaryNumber, secondaryNumber, operator);
        setAnswer(answer);
    }


    //Calculates the answer.
    private double operatorSwitch(double answerNumber, double inputNumber, String operator){
        double answer = DEFAULT_INDEX_VALUE;

        switch (operator){
            //Addition.
            case "+":
                answer = answerNumber + inputNumber;
                break;

            //Subtraction.
            case "-":
                answer = answerNumber - inputNumber;
                break;

            //Multiplication.
            case "*":
                answer = answerNumber * inputNumber;
                break;

            //Division.
            case "/":

                //Tells the user they cannot divide by zero.
                if(inputNumber == DEFAULT_INDEX_VALUE){
                    throw new IllegalArgumentException("Cannot divide by zero.");
                }

                answer = answerNumber / inputNumber;
                break;

            case "x^y":
                answer = customExponent(answerNumber, inputNumber);
                break;
        }

        return answer;
    }

    //Clears out the current string in the string builder.
    private void clearStringBuilder(){
        this.textNumberBuilder = new StringBuilder();
    }

    //Sets the primary number to zero.
    private void clearPrimaryNumber(){
        this.primaryNumber = 0;
    }

    //Sets the secondary number to zero.
    private void clearSecondaryNumber(){
        this.secondaryNumber = 0;
    }

    /**
     * Helps the controls to clear the text from the UI.
     *
     * @return This method returns an empty String.
     */
    //Clears the screen.
    public String clearScreen(){
        return EMPTY_STRING;
    }

    //Clears the answer number to zero.
    private void clearAnswer(){
        this.answer = 0;
    }

    //Clears the input text to empty string.
    private void clearInputText(){
        this.inputText = EMPTY_STRING;
    }

    //Clears the operator.
    private void clearOperator(){
        this.operator = EMPTY_STRING;
    }

    /**
     * This method provides a convenient way to quickly clear all values from the calculator.
     */
    //Clears everything by calling all necessary clear methods in the class.
    public void clearAll(){
        clearStringBuilder();
        clearPrimaryNumber();
        clearSecondaryNumber();
        clearAnswer();
        clearInputText();
        clearOperator();

    }
}
