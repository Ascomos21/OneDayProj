package project;

public class SingleClubMember extends Member {

    public int getClub() {
        return club;
    }

    public void setClub(int club) {
        this.club = club;
    }

    private int club;

    SingleClubMember(char cmemberType, int cMemberID, String cName, double cFees, int cClub) {
        super(cmemberType, cMemberID, cName, cFees);
        this.club = cClub;

    }

    @Override
    public String toString() {
        return (super.toString() +  ", " + club);
    }
}

