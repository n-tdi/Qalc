package Bot.Api;

import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;

public class MathUtils {

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 = qalc");
        System.out.println("2 = find x");
        System.out.println("3 = find y");
        System.out.println("4 = get 3 points to graph");
        System.out.println("5 = all quadratic functions");
        System.out.println("6 = force calculation (gravity)");
        System.out.println("7 = force calculation");
        System.out.println("8 = work calculation");
        System.out.println("9 = Power (work)");
        System.out.println("10 = Power (force n distance)");
        System.out.println("11 = All Physics");
        System.out.println("What function to run:");
        int n = scanner.nextInt();
        if (n == 1) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("expression: ");
            String expression = scanner1.nextLine();
            System.out.println("ans: " + QuadraticMath.qalc(expression));
        } else if (n == 2) {
            System.out.println("a: ");
            double a = scanner.nextDouble();
            System.out.println("b: ");
            double b = scanner.nextDouble();
            System.out.println("x: " + QuadraticMath.getX(a, b));
        } else if (n == 3) {
            System.out.println("x: ");
            double x = scanner.nextDouble();
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("expression: ");
            String expression = scanner1.nextLine();
            System.out.println("y: " + QuadraticMath.getY(x, expression));
        } else if (n == 4) {
            System.out.println("x: ");
            double x = scanner.nextDouble();
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("expression: ");
            String expression = scanner1.nextLine();
            System.out.println(QuadraticMath.getPoint(x, expression));
            System.out.println(QuadraticMath.getPoint(x+1, expression));
            System.out.println(QuadraticMath.getPoint(x+2, expression));
        } else if (n == 5) {
            System.out.println("a: ");
            double a = scanner.nextDouble();
            System.out.println("b: ");
            double b = scanner.nextDouble();
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("expression: ");
            String expression = scanner1.nextLine();

            double x = QuadraticMath.getX(a, b);
            System.out.println("x: " + x);
            double y = QuadraticMath.getY(x, expression);
            System.out.println("y: " + y);
            System.out.println(QuadraticMath.getPoint(x, expression));
            System.out.println(QuadraticMath.getPoint(x+1, expression));
            System.out.println(QuadraticMath.getPoint(x+2, expression));

        } else if (n == 6) {
            System.out.println("Mass (kg): ");
            double mass = scanner.nextDouble();
            System.out.println("Force (N): " + ScienceMath.getForce(mass, 9.81));
        } else if (n == 7) {
            System.out.println("Mass (kg): ");
            double mass = scanner.nextDouble();
            System.out.println("Acceleration (m/s^2): ");
            double acceleration = scanner.nextDouble();
            System.out.println("Force (N): " + ScienceMath.getForce(mass, acceleration));
        } else if (n == 8) {
            System.out.println("Force (N): ");
            double force = scanner.nextDouble();
            System.out.println("Distance (M): ");
            double distance = scanner.nextDouble();
            System.out.println("Work (J): " + ScienceMath.getWork(force, distance));
        } else if (n == 9) {
            System.out.println("Work (J): ");
            double force = scanner.nextDouble();
            System.out.println("Time (S): ");
            double time = scanner.nextDouble();
            System.out.println("Power (W): " + ScienceMath.getPower(force, time));
        } else if (n == 10) {
            System.out.println("Force (N): ");
            double force = scanner.nextDouble();
            System.out.println("Distance (M): ");
            double distance = scanner.nextDouble();
            System.out.println("Time (S): ");
            double time = scanner.nextDouble();
            System.out.println("Power (W): " + ScienceMath.getPower(force, distance, time));
        } else if (n == 11) {
            System.out.println("Mass (kg): ");
            double mass = scanner.nextDouble();
            System.out.println("Acceleration (m/s^2) (Gravity is 9.81): ");
            double acceleration = scanner.nextDouble();
            System.out.println("Distance (M): ");
            double distance = scanner.nextDouble();
            System.out.println("Time (S): ");
            double time = scanner.nextDouble();
            System.out.println("Force (N): " + ScienceMath.getForce(mass, acceleration));
            System.out.println("Work (J): " + ScienceMath.getWork(ScienceMath.getForce(mass, acceleration), distance));
            System.out.println("Power (W): " + ScienceMath.getPower(ScienceMath.getForce(mass, acceleration), time));
        }
    }
}
