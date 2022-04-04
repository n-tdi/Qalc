package world.ntdi.mathutils.Api;

public class ScienceMath {
    public static double getForce(double mass, double acceleration) {
        return mass * acceleration;
    }

    public static double getWork(double force, double distance) {
        return force * distance;
    }
    public static double getWork(double mass, double acceleration, double distance) {
        return (mass * acceleration) * distance;
    }

    public static double getPower(double work, double time) {
        return work / time;
    }
    public static double getPower(double force, double distance, double time) {
        return (force * distance) / time;
    }
    public static double getPower(double mass, double acceleration, double distance, double time) {
        return (mass * acceleration * distance) / time;
    }

    public static double getKE(double mass, double velocity) {
        return 0.5 * mass * Math.pow(velocity, 2);
    }
    public static double getGPE(double height, double mass, double velocity) {
        return mass * velocity * height;
    }
}
