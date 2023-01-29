/**
 * This Competition class is an abstract class.  It contains two protected String variables in name and region 
 * and have two abstract method in setDescription and setSponsorship.
 */

package tongbu.nattadol.lab6;

import java.util.ArrayList;

public abstract class Competition {
    protected String name;
    protected String region;

    // Getter and setter methods for the name and region variables
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }

    // These are the abstract methods.
    public abstract void setDescription();
    public abstract void setSponsorship(ArrayList<String> sponsors);
}