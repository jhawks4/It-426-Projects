package facade;

import string_manipulation.StringRegex;

public class StringFacade {

    public static boolean isValid(String subject, ValidationType type){

        switch (type){
            case EMAIL:
                return StringRegex.isEmail(subject);

            case PHONE:
                return  StringRegex.isPhoneNumber(subject);

            case URL:
                return StringRegex.isUrl(subject);

            case ZIP_CODE:
                return StringRegex.isZipCode(subject);
        }

        throw new IllegalStateException("Missing enum value " + type.toString());
    }

    public static void  foo(){

        Operation operation = new Operation(new String[] {"money", "lunch", "lunch", "money", "counter",
                                                          "Mashed Potato", "Turkey", "Turkey"});

        operation.filter("Turkey").removeDuplicates().resize(4);
    }

    public enum ValidationType{
        EMAIL,
        PHONE,
        URL,
        ZIP_CODE
    }
}
