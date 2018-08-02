package com.softserve.numbersequence.numbertoword;

class NumberToText {

    private static String numText;// number in the form of text


    private static final String[][] sampleText = {{"", "од", "дв", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "десять ", "двадцать ", "тридцать ", "сорок ", "пятьдесят ", "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто "},
            {"", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ", "семьсот ", "восемьсот ", "девятьсот "}};

    private static final String[] sample11to19 = {"десять ", "одинадцать ", "двенадцать ", "тринадцать ", "четырнадцать ", "пятнадцать ",
            "шестнадцать ", "семнадцать ", "восемнадцать ", "девятнадцать "};

    private static final String[][] textMillion = {{"", "", "", "", ""},
            {"триллионов ", "миллиардов ", "миллионов ", "тысяч ", ""},
            {"триллион ", "миллиард ", "миллион ", "тысяча ", ""},
            {"триллиона ", "миллиарда ", "миллиона ", "тысячи ", ""},
            {"триллионов ", "миллиардов ", "миллионов ", "тысяч ", ""}};

    /**
     * Convert number in the range -999 - 999 into text form
     *
     * @param number - given number
     * @return text String representation of number
     */
    static String WordsRus(long number) {
        int trillion;
        long billion;
        int million;
        int thousand;
        long toThousand;
        long numberA;
        long numberMax = 999999999999999L;
        numberA = number;


        numText = "";
        if (numberA < -numberMax || numberA > numberMax) {
            return numText = "Число выходит за рамки указанного диапазона";
        }
        if (numberA == 0) {
            return numText = "ноль ";
        }
        if (number < 0) {
            numText = "минус ";
            numberA = -numberA;
        } //do positive number value

// divide the number into billions, millions, thousands and units
        trillion = (int) (numberA / 1000000000000L);
        billion = (numberA - (trillion * 1000000000000L)) / 1000000000;
        million = (int) (numberA - (trillion * 1000000000000L) - (billion * 1000000000)) / 1000000;
        thousand = (int) (numberA - (trillion * 1000000000000L) - (billion * 1000000000) - (million * 1000000)) / 1000;
        toThousand = (int) (numberA % 1000);

        //  form the text of the number in words
        numText = numText + WordsToThousand(trillion, 0) + WordsToThousand(billion, 1) + WordsToThousand(million, 2) + WordsToThousand(thousand, 3) + WordsToThousand(toThousand, 4);
        return numText;

    }

    /**
     * Form the text representation of a three-digit number, taking into account its digit
     *
     *
     * @param numericalValue - value to convert into pronounced string
     * @param index
     * @return
     */
    private static String WordsToThousand(long numericalValue, int index) {

        int indexA;
        int units;
        int decimal;
        int hundreds;

// break the sample number into its components
        hundreds = (int) numericalValue / 100;
        decimal = (int) (numericalValue - (hundreds * 100)) / 10;
        units = (int) numericalValue % 10;

// form a number without a power of number
        numText = "";
        if (decimal == 1) numText = sampleText[2][hundreds] + sample11to19[units];
        else numText = sampleText[2][hundreds] + sampleText[1][decimal] + sampleText[0][units];

        // form endings in units
        if (index == 2) {
            if (units == 1 && decimal != 1) numText = numText + "на ";
            else if (units == 2 & decimal != 1) numText = numText + "е ";
            if (units > 1 && decimal != 1) numText = numText + " ";
        } else {
            if (units == 1 && decimal != 1) numText = numText + "ин ";
            if (units == 2 & decimal != 1) {
                numText = numText + "а ";
            } else if (units != 0 & decimal != 1) numText = numText + " ";
        }

        // add the degree of a number
        indexA = 0;
        if (numericalValue != 0) {
            if (units == 0 || decimal == 1) indexA = 1;
            else if (units == 1) indexA = 2;
            else if (units < 5) indexA = 3;
            else indexA = 4;
        }
        numText = numText + textMillion[indexA][index];
        return numText;
    }
}
