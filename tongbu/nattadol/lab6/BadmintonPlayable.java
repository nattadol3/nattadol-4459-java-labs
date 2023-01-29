/**
 * This BadmintonPlayable interface contains two variables in racketLength and worldRanking and 4 methods in getRacketLength(), setRacketLength(double racketLength),
 * getWorldRanking(), setWorldRanking(int worldRanking).
 */

package tongbu.nattadol.lab6;

public interface BadmintonPlayable {
    double racketLength = 0;
    int worldRanking = 0;

    public double getRacketLength();
    public void setRacketLength(double racketLength);
    public int getWorldRanking();
    public void setWorldRanking(int worldRanking);
}
