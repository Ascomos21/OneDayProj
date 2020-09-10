package project;

public class MultiClubMember  extends Member{

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public void setMembershipPoints(int membershipPoints) {
        this.membershipPoints = membershipPoints;
    }

    private int membershipPoints;

    MultiClubMember (char cmemberType, int cMemberID, String cName, double cFees, int cmembershipPoints){

        super(cmemberType,cMemberID,cName,cFees);
        this.membershipPoints = cmembershipPoints;
    }

    @Override
    public String toString(){
        return super.toString() + ", " + getMembershipPoints();
    }
}
