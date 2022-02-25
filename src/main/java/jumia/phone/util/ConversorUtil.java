package jumia.phone.util;

public class ConversorUtil {

    private static ConversorUtil conversorUtil;


    static String regCameroon =   "\\(237\\)\\ ?[2368]\\d{7,8}$";
    static String regEthiopia =   "\\(251\\)\\ ?[1-59]\\d{8}$";
    static String regMorocco =    "\\(212\\)\\ ?[5-9]\\d{8}$";
    static String regMozambique = "\\(258\\)\\ ?[28]\\d{7,8}$";
    static String regUganda=      "\\(256\\)\\ ?\\d{9}$";

    
    public String[] validatePhoneNumber(String phone){
        
        String[] validatedValues = new String[3];
        validatedValues[0] = "Invalid";
        validatedValues[1] = "Invalid";
        validatedValues[2] = "Invalid";


        if (phone.matches(regCameroon)){
            validatedValues[0] = "Cameroon";
            validatedValues[1] = "+237";
            validatedValues[2] = "Valid";

            return validatedValues;
        }
        
        if (phone.matches(regEthiopia)){
            validatedValues[0] = "Ethiopia";
            validatedValues[1] = "+251";
            validatedValues[2] = "Valid";

            return validatedValues;
        }

        if (phone.matches(regMorocco)){
            validatedValues[0] = "Morocco";
            validatedValues[1] = "+212";
            validatedValues[2] = "Valid";

            return validatedValues;
        }

        if (phone.matches(regMozambique)){
            validatedValues[0] = "Mozambique";
            validatedValues[1] = "+258";
            validatedValues[2] = "Valid";

            return validatedValues;
        }

        if (phone.matches(regUganda)){
            validatedValues[0] = "Uganda";
            validatedValues[1] = "+256";
            validatedValues[2] = "Valid";

            return validatedValues;
        }

        return validatedValues;
        
    }

    public static ConversorUtil getConversorUtilFactory() {
        if(conversorUtil == null){
            conversorUtil = new ConversorUtil();
        }
        return conversorUtil;
    }
    
}
