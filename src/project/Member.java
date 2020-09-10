package project;

public class Member {


    private char memberType;
    private int memberID;
    private String name;
    private  double fees;

    Member(char cmemberType, int cMemberID, String cName, double cFees){
        this.memberType = cmemberType;
        this.memberID = cMemberID;
        this.name = cName;
        this.fees = cFees;
    }

    public char getMemberType() {
        return memberType;
    }

    public void setMemberType(char memberType) {
        this.memberType = memberType;
    }

    public int getMemberID(){
        return memberID;
    }

    public void setMemberID(int memberID){
        this.memberID = memberID;
    }

    public String getName (){
        return name;
    }

    public void setName(String name){
        this.name = name;

    }

    public double getFees(){
        return fees;
    }

    public void setFees(double fees){
        this.fees = fees;
    }

    @Override
    public String toString(){
        return (memberType+ ", " + memberID +", "
        + name + ", " + fees);
    }

}
