package cs350s21task2;

public class Mover {
    private double x;
    private double y;
    private double z;
    private double heading;
    private double headingTarget;
    private double speedHorizontal;
    private double speedHorizontalTarget;
    private double speedVertical;
    private double accelerationHorizontal;
    private double turnRate;
    private boolean direction;

    public Mover(double x, double y, double z, double heading, double speedHorizontal, double speedVertical, double accelerationHorizontal, double turnRate) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.heading = heading;
        this.headingTarget = heading;
        this.speedHorizontal = speedHorizontal;
        this.speedHorizontalTarget = speedHorizontal;
        this.speedVertical = speedVertical;
        this.accelerationHorizontal = accelerationHorizontal;
        this.turnRate = turnRate;
        this.direction = true;
    }

    public double getAccelerationHorizontal() {
        return this.accelerationHorizontal;
    }

    public double getHeading() {
        return this.heading;
    }

    public double getHeadingTarget() {
        return this.headingTarget;
    }

    public boolean getHeadingTargetDirection() {
        return this.direction;
    }

    public double getSpeedHorizontal() {
        return this.speedHorizontal;
    }

    public double getSpeedHorizontalTarget() {
        return this.speedHorizontalTarget;
    }

    public void setSpeedHorizontalTarget(double speed) {
        this.speedHorizontalTarget = speed;
    }

    public double getSpeedVertical() {
        return this.speedVertical;
    }

    public void setSpeedVertical(double speed) {
        this.speedVertical = speed;
    }

    public String getState() {
        return Double.toString(this.x) + "," + 
            Double.toString(this.y) + "," + 
            Double.toString(this.z) + "," + 
            Double.toString(this.heading) + "," + 
            Double.toString(this.speedHorizontal) + "," + 
            Double.toString(this.speedVertical);
    }

    public double getTurnRate() {
        return this.turnRate;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public void setHeadingTarget(double heading, boolean direction) {
        this.headingTarget = heading;
        this.direction = direction;
    }

    public void update() {
        if(this.speedHorizontalTarget > this.speedHorizontal) {
            this.speedHorizontal += this.accelerationHorizontal;
            if(this.speedHorizontal > this.speedHorizontalTarget) this.speedHorizontal = this.speedHorizontalTarget;
        }
        else if(this.speedHorizontalTarget < this.speedHorizontal) {
            this.speedHorizontal -= this.accelerationHorizontal;
            if(this.speedHorizontal < this.speedHorizontalTarget) this.speedHorizontal = this.speedHorizontalTarget;
        }
        boolean cap = false;
        if(this.direction) {
            if(this.heading <= this.headingTarget || this.heading + this.turnRate <= this.headingTarget) cap = true;
            this.heading += this.turnRate;
            if(this.heading > 360.0) this.heading -= 360.0;
            if(this.heading > this.headingTarget && cap) this.heading = this.headingTarget;
        }
        else {
            if(this.heading >= this.headingTarget || this.heading - this.turnRate >= this.headingTarget) cap = true;
            this.heading -= this.turnRate;
            if(this.heading < 0) this.heading += 360.0;
            if(this.heading < this.headingTarget && cap) this.heading = this.headingTarget;
        }
        this.z += this.speedVertical;
        this.x += Math.sin(Math.toRadians(this.heading)) * this.speedHorizontal;
        this.y += Math.cos(Math.toRadians(this.heading)) * this.speedHorizontal;
    }
}
