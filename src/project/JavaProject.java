package project;


import java.util.LinkedList;

public class JavaProject {
    public static void main(String... args) {
        String mem;
        MembershipManagementClass manage = new MembershipManagementClass();
        FileHandler fileHandler = new FileHandler();

        LinkedList<Member> members = fileHandler.readFile();
        int choice = manage.getChoice();
        while (choice != -1) {
            switch (choice) {
                default:
                    System.out.println("1 Add new member" +
                            "\n" + "2 Remove member" +
                            "\n" + "3 " + "Display information");

                case 1:

                    fileHandler.appendFile(manage.addMembers(members));
                    break;
                case 2:

                    manage.removeMember(members);
                    fileHandler.overwriteFile(members);
                    break;
                case 3:
                    manage.printMemberInfo(members);
                    break;
            }
            choice = manage.getChoice();
        }
        System.out.println("ggwp");

    }
}
