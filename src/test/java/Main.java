public class Main {

    public static void main (String[] args){

        int numberOfPeople = 16;
        String peopleInGroup = String.join(" ", "My group contains", Integer.toString(numberOfPeople),  "persons");
        System.out.println(peopleInGroup);

        int firstNumberForSum = 8;
        int secondNumberForSum = 2;
        int sum = firstNumberForSum + secondNumberForSum;
        String messageForSum = firstNumberForSum + " + " + secondNumberForSum + " = " + sum;
        System.out.println(messageForSum);


        int numberForMultiplication = 5;
        int resultOfMultiplication = numberForMultiplication * numberForMultiplication;
        String messageForMultiplication = numberForMultiplication + " * " + numberForMultiplication + " = " + resultOfMultiplication;
        System.out.println(messageForMultiplication);


        int numberForSqrt = 16;
        int resultOfSqrt = (int) Math.sqrt(numberForSqrt);
        String messageForSqrt = "sqrt(" + numberForSqrt + ") = " + resultOfSqrt;
        System.out.println(messageForSqrt);


        int leftValueForMin = 3;
        int rightValueMin = 28;
        int minValue = Math.min(leftValueForMin, rightValueMin);
        String messageForMin = "Math.min(" + leftValueForMin + ", " + rightValueMin + ") = " + minValue;
        System.out.println(messageForMin);


        int leftValueForMax = 3;
        int rightValueMax = 28;
        int maxValue = Math.max(leftValueForMax, rightValueMax);
        String messageForMax = "Math.max(" + leftValueForMax + ", " + rightValueMax + ") = " +maxValue ;
        System.out.println(messageForMax);


        int numberForAbs = -16;
        int absValue = Math.abs(numberForAbs);
        String messageForAbs = "Math.abs(" + numberForAbs + ") = " + absValue;
        System.out.println(messageForAbs);

    }
}