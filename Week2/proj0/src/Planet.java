public class Planet {
    public double xxPos;    /*its current x position*/
    public double yyPos;    /*Its current y position*/
    public double xxVel;    /*Its current velocity in the x direction**/
    public double yyVel;    /*Its current velocity in the y direction*/
    public double mass;     /*Its mass*/
    public String imgFileName;   /*The name of the file that corresponds to the image that depicts the planet */

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double delta_x = this.xxPos - p.xxPos;
        double delta_y = this.yyPos - p.yyPos;
        double squared = (delta_x * delta_x) + (delta_y * delta_y);
        return Math.sqrt(squared);
    }

    public double calcForceExertedBy(Planet p) {
        double G = 6.67e-11;
        double r = calcDistance(p);
        double force = (G * p.mass * this.mass ) / (r*r) ;
        return force;
    }

    public double calcForceExertedByX(Planet p) {
        double delta_x = p.xxPos - this.xxPos;
        double r = calcDistance(p);
        double force = calcForceExertedBy(p);
        double forceX = force * delta_x/r ;
        return forceX;
    }

    public double calcForceExertedByY(Planet p) {
        double delta_y = p.yyPos - this.yyPos;
        double r = calcDistance(p);
        double force = calcForceExertedBy(p);
        double forceY = force * delta_y/r ;
        return forceY;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double netForceX = 0;
        for(Planet p:planets) {
            if(p==this) continue;
            else netForceX += calcForceExertedByX(p);
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double netForceY = 0;
        for(Planet p:planets) {
            if(p==this) continue;
            else netForceY += calcForceExertedByY(p);
        }
        return netForceY;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;    /*Newton's Law,  a = force/mass   */
        double aY = fY / this.mass;

        this.xxVel = this.xxVel + aX*dt;  /* v = a*t + v */
        this.yyVel = this.yyVel + aY*dt;

        this.xxPos = this.xxPos + (this.xxVel * dt);
        this.yyPos = this.yyPos + (this.yyVel * dt);

    }

    public void draw() {
        String filename = "./images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, filename);
    }










}
