package Source;

public class RomanNumberConverter {

    public static void main(String[] args) {
        System.out.println(Numeral.ONE.mRoman + Numeral.ONE.mRoman);
    }

    public static String toRoman(int aNumber)
    {
        String romanNumber = "";
        for (var numeral : Numeral.values()){
            while(aNumber >= numeral.mArabic) {
                romanNumber += numeral.mRoman;
                aNumber -= numeral.mArabic;
            }
        }
        return romanNumber;
    }

    public static int toArabic(String roman)
    {
        if(roman == Numeral.FIVE.mRoman)
        {
            return 5;
        }
        if(roman == Numeral.ONE.mRoman)
        {
            return 1;
        }
        if(roman.equals((Numeral.ONE.mRoman + Numeral.ONE.mRoman)))
        {
            return 2;
        }
        return 0;
    }
    enum Numeral{
        TEN(10, "X"),
        NINE(9,"IX"),
        FIVE(5,"V"),
        FOUR(4,"IV"),
        ONE(1,"I");

        private final int mArabic;
        private final String mRoman;

        Numeral(int arabic, String roman) {
            mArabic = arabic;
            mRoman = roman;
        }
    }
}
