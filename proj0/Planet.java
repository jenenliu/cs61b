public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    String imgFileName;

    private static double G = 6.67 * Math.pow(10, -11);

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt((p.xxPos - xxPos) * (p.xxPos - xxPos) +
                (p.yyPos - yyPos) * (p.yyPos - yyPos));
    }

    public double calcForceExertedBy(Planet p) {
        return G * mass * p.mass / (calcDistance(p) * calcDistance(p));
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double force = 0D;
        for (Planet p : planets) {
            if (!this.equals(p)) {
                force += calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
            }
        }

        return force;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double force = 0D;
        for (Planet p : planets) {
            if (!this.equals(p)) {
                force += calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
            }
        }
        return force;
    }

    public void update(double dt, double xForce, double yForce) {
        double aX = xForce / mass;
        double aY = yForce / mass;

        xxVel = xxVel + dt * aX;
        yyVel = yyVel + dt * aY;

        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, imgFileName);
    }
}
