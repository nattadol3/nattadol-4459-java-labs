/**
 * This BadmintonPlayerV3 is the subclass of BadmintonPlaterV2 and it implement two interface in BadmintonPlayable and Sprinter.
 */

package tongbu.nattadol.lab6;

public class BadmintonPlayerV3 extends BadmintonPlayerV2 implements BadmintonPlayable, Sprinter {
    protected double racketLength;
    protected int worldRanking;
    protected double speed;

    // BadmintonPlayerV3 Class constructor.
    public BadmintonPlayerV3(String name, double weight, double height, Gender gender, String nationality,
            String birthDate) {

        // Call constructor from super class.
        super(name, weight, height, gender, nationality, birthDate);
    }

    // Overriding methods from interfaces and toString() method.
    @Override
    public double getRacketLength() {
        return racketLength;
    }

    @Override
    public void setRacketLength(double racketLength) {
        this.racketLength = racketLength;
    }

    @Override
    public int getWorldRanking() {
        return worldRanking;
    }

    @Override
    public void setWorldRanking(int worldRanking) {
        this.worldRanking = worldRanking;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + name + " is a Badminton player whose world ranking is " + worldRanking +
            " and has sprint speed as " + speed;
    }
    
}
