package world.ntdi.mathutils.Api;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class BasicMath {
    public static double simplfy(String Expression) throws IOException, ParseException {
        String output = SimplifyApi.simpApiResult(Expression);
        return Double.parseDouble(output);
    }

    public static String convertToFraction(Double decimal) {
        return QuadraticMath.convertDecimalToFraction(decimal);
    }
}
