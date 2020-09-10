package project;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagementClass {
    final private Scanner reader = new Scanner(System.in);

    private int getIntInput() {

        System.out.println("Enter int value");
        int a = 0;
        while (a == 0) {
            try {
                a = reader.nextInt();
                if (a == 0)
                    throw new InputMismatchException();
                reader.nextLine();
            } catch (InputMismatchException e) {

                reader.nextLine();
                System.out.println("Input valid data");
            }
        }
        return a;
    }

    private void printClubOptions() {
        System.out.println("\n1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoice() {
        int choice;
        System.out.println("\nWELCOME TO OZONE FITNESS CENTER");
        System.out.println("================================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");

        System.out.print("\nPlease select an option (or Enter -1 to quit): ");

        choice = getIntInput();

        return choice;
    }

    public String addMembers(LinkedList<Member> members) {
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member member;
        Calculator<Integer> calculator;

        System.out.println("Enter name");
        name = reader.nextLine();

        printClubOptions();
        System.out.print("\nPlease enter the member's clubID: ");
        club = getIntInput();

        while (club < 1 || club > 4) {

            System.out.println("Try again:");
            club = getIntInput();

        }

        if (members.size() > 0) memberID = members.getLast().getMemberID() + 1;
        else memberID = 1;

        if (club != 4) {
            calculator = (n) -> {
                switch (n) {
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    default:
                        return -1;
                }
            };

            fees = calculator.calculateFees(club);
            member = new SingleClubMember('S', memberID, name, fees, club);

            System.out.println(member.toString());
            System.out.println("\nSingle club member added");
        } else {
            calculator = (n) -> {
                if (n == 4)
                    return 1200;
                else
                    return -1;
            };
            fees = calculator.calculateFees(club);
            member = new MultiClubMember('M', memberID, name, fees, 100);
            members.add(member);
            mem = member.toString();
            System.out.println("\nSTATUS: Multi Club Member added");
        }
        return member.toString();
    }

    public void removeMember(LinkedList<Member> members) {
        int memberID = reader.nextInt();

        for (int i = 0; i < members.size(); i++) {

            if (members.get(i).getMemberID() == memberID) {
                members.remove(memberID);
                return;
            }

        }

        System.out.println("\nMember ID not found");
    }

    public void printMemberInfo(LinkedList<Member> members) {

        int memberID = reader.nextInt();

        for (Member member : members) {
            if (member.getMemberID() == memberID) {
                String[] memberInfo = member.toString().split(", ");
                System.out.println("\n\nMember Type = " +
                        memberInfo[0]);
                System.out.println("Member ID = " + memberInfo[1]);
                System.out.println("Member Name = " + memberInfo[2]);
                System.out.println("Membership Fees = " + memberInfo[3]);
                if (memberInfo[0].equals("S")) {
                    System.out.println("Club ID = " +
                            memberInfo[4]);
                } else {
                    System.out.println("Membership Points = " +
                            memberInfo[4]);
                }
                return;
            }
        }
        System.out.println("ID not found");
    }
}
