package project;

import java.io.*;
import java.util.LinkedList;

public class FileHandler {
    LinkedList<Member> members = new LinkedList<>();
    String lineRead;
    String[] splitLine;
    Member mem;

    public LinkedList<Member> readFile() {


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("members.csv"))) {
            lineRead = bufferedReader.readLine();
            while (lineRead != null) {

                splitLine = lineRead.split(", ");
                if (splitLine[0].equals("S")) {
                    mem = new SingleClubMember('S', Integer.parseInt(splitLine[1]),
                            splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                } else {
                    mem = new MultiClubMember('M', Integer.parseInt(splitLine[1]),
                            splitLine[2], Double.parseDouble(splitLine[3]),
                            Integer.parseInt(splitLine[4]));
                }
                members.add(mem);
                lineRead = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return members;
    }

    public void appendFile(String mem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true))){

            writer.write(mem + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void overwriteFile(LinkedList<Member> m){
        String s;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp",
                false))){
            for (int i=0; i< m.size(); i++)
            {
                s = m.get(i).toString();
                writer.write(s + "\n");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try{
            File f = new File("members.csv");
            File tf = new File("members.temp");
            f.delete();
            tf.renameTo(f);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
