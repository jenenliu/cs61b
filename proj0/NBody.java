public class NBody {
    public static Double readRadius(String planetFile) {
        Double result = 0D;
        In in = new In(planetFile);
        while (!in.isEmpty()) {
            in.readInt();
            result = in.readDouble();
            break;
        }

        return result;
    }

    public static Planet[] readPlanets(String planetFile) {
        Planet[] planets = new Planet[5];

        In in = new In(planetFile);
        in.readInt();
        in.readDouble();
        while (!in.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                double xPos = in.readDouble();
                double yPos = in.readDouble();
                double xVel = in.readDouble();
                double yVel = in.readDouble();
                double mass = in.readDouble();
                String img = in.readString();

                planets[i] = new Planet(xPos, yPos, xVel, yVel, mass, img);
            }
            break;
        }

        return planets;
    }

    public static void main(String[] args) {
        // first part
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double universeRadius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        double[] xForces = new double[5];
        double[] yForces = new double[5];

        // second part
        String backgroundImg = "./images/starfield.jpg";
        StdDraw.setXscale(-universeRadius, universeRadius);
        StdDraw.setYscale(-universeRadius, universeRadius);
        StdDraw.clear();

        int initialDt = 0;
        int endDt = 20000;

        while (initialDt <= endDt) {
            StdDraw.picture(0, 0, backgroundImg);

            for (int i = 0; i < 5; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);

                planets[i].update(initialDt, xForces[i], yForces[i]);

                planets[i].draw();
            }

            StdDraw.show(10);

            initialDt += 10;
        }

        StdOut.printf("%d\n", 5);
        StdOut.printf("%.2e\n", dt);
        for (int i = 0; i < 5; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }


        StdDraw.show();
    }
}
