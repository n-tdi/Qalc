package Bot.Api;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class QuadraticMath {
    public static double qalc(String expr) throws IOException, ParseException {
        return Double.parseDouble(MathApi.mathApiResult(expr));
    }

    public static double getX(double a, double b) throws IOException, ParseException {
        return -b / (2 * a);
    }

    public static double getY(double x, String expr) throws IOException, ParseException {
        String expression = expr.replaceAll("x", String.valueOf(x));
        System.out.println(expression);
        return Double.parseDouble(MathApi.mathApiResult(expression));
    }

    public static String getPoint(double x, String expr) throws IOException, ParseException {
        String expression = expr.replaceAll("x", String.valueOf(x));
        System.out.println(expression);
        return "(" + x + ", " + MathApi.mathApiResult(expression) + ")";
    }
}
