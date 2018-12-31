public class NBody {

    public static double readRadius(String filename) {
       In in = new In(filename);
       int N = in.readInt();
       double radius = in.readDouble();
       return radius;
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int N = in.readInt();
        double radius = in.readDouble();

        Planet[] planets = new Planet[N];
        int i = 0;
        while (i != N) {
            double xP = in.readDouble();
            double yp = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xP, yp, xV, yV, m, img);
            i += 1;
        }

        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        /*Initial Drawing Section*/
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0,0, "./images/starfield.jpg");

        for (Planet p : planets)
            p.draw();


        /*Animation Section */
        double time = 0;
        StdAudio.play("2001.mid");  /**BGM */
        while (time != T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            for(int i=0; i<planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for(int i=0; i<planets.length; i++)
                planets[i].update(dt, xForces[i], yForces[i]);

            StdDraw.picture(0, 0, "images/starfield.jpg");

            for(int i=0; i<planets.length; i++)
                planets[i].draw();

            StdDraw.show();
            StdDraw.pause(10);

            time += dt;
        }

    }

}
