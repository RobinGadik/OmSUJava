package P1;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws TraineeException, FileNotFoundException {
        try {
            Trainee a = new Trainee("", null, 0);
        } catch (TraineeException e) {
            //e.printStackTrace();
            System.out.println(e.getErrorCode().getMsg());
        }
        try {
            Trainee b = new Trainee("s", "", 0);
        } catch (TraineeException e) {
            //e.printStackTrace();
            System.out.println(e.getErrorCode().getMsg());
        }
        try {
            Trainee c = new Trainee("s", "sd", 0);
        } catch (TraineeException e) {
            //e.printStackTrace();
            System.out.println(e.getErrorCode().getMsg());
        }
        Trainee d = null;
        try {
            d = new Trainee("s", "sd", 3);
        } catch (TraineeException e) {
            // e.printStackTrace();
            System.out.println(e.getErrorCode().getMsg());
        }
        try {
            d.setFirstName(null);
        } catch (TraineeException e) {
            //e.printStackTrace();
            System.out.println(e.getErrorCode().getMsg());
        }
        try {
            d.setFirstName("UKKUKUKU");
        } catch (TraineeException e) {
            //e.printStackTrace();
            System.out.println(e.getErrorCode().getMsg());
        }

        File f = new File("C:\\Users\\kkp\\IdeaProjects\\OmSUJava\\some\\", "bebe.txt");
        File fn = new File("C:\\Users\\kkp\\IdeaProjects\\OmSUJava\\some\\", "fuuu.bin");

        if (!f.exists()) {
            try {
                new File(f.getParent()).mkdirs();
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        f.renameTo(fn);
        System.out.println(f.getAbsolutePath());
        if (f.isDirectory()) {
            System.out.println("is Directory");
        } else {
            System.out.println("is File");
        }

        f = new File(f.getParent());

        System.out.println(f.getAbsolutePath());
        if (f.isDirectory()) {
            System.out.println("is Directory");
        } else {
            System.out.println("is File");
        }


        File fSystem32 = new File("C:/Windows/System32");
        String[] fullList = fSystem32.list();

        Pattern pattern = Pattern.compile("^*fy.exe");

        String[] exeListViaLambda = fSystem32.list((dir, name) -> pattern.matcher(name).find());
        for (String i : exeListViaLambda){
            System.out.println(i);
        }


        Rectangle rec = new Rectangle(100,200,300,400);

        final int SIZE = 10;
        try (FileOutputStream fos = new FileOutputStream(fn))
        {
            fos.write(rec.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(fn)) {
            byte[] array1 = new byte[3];
            byte[] array2 = new byte[4];
            fis.read(array1);
            for(int a : array1)
                System.out.print(a + " ");
            System.out.println();
            fis.skip(3);
            fis.read(array2);
            for(int a : array2)
                System.out.print(a + " ");
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("1.dat")))) {
            oos.writeObject(rec);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("1.dat")))) {
            Rectangle p = (Rectangle)ois.readObject();
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Rectangle[] recList = {
                new Rectangle(1,2,3,4)
                ,new Rectangle(1,2,3,5)
                ,new Rectangle(1,2,3,6)
                ,new Rectangle(1,2,3,7)
                ,new Rectangle(1,2,3,8)};

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("1.dat")))) {
            oos.writeObject(recList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("1.dat")))) {
            Rectangle[] list = (Rectangle[])ois.readObject();
            for (int i = 1 ; i <= list.length ; i++ ){
                System.out.println(list[list.length - i]);
            }
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


        Trainee tr = new Trainee("NAME" , "SECOND NAME" , 5);
        try (FileOutputStream fos = new FileOutputStream(new File("11.dat")))
        {
            fos.write((tr.getFirstName() + '\n' + tr.getSecondName() + '\n' + tr.getRating()).getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(new File("11.dat"));

        System.out.printf(String.valueOf(new Trainee(sc.nextLine(), sc.nextLine(), sc.nextInt())));


        try (FileOutputStream fos = new FileOutputStream(new File("13.dat")))
        {
            fos.write((tr.getFirstName() + ',' + tr.getSecondName() + ',' + tr.getRating()).getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc = new Scanner(new File("13.dat"));
        String[] values = sc.nextLine().split(",");
        tr = new Trainee(values[0], values[1], Integer.valueOf(values[2]));
        System.out.printf(tr.toString());



        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("15.dat")))) {
            oos.writeObject(tr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("15.dat")))) {
            Trainee p = (Trainee) ois.readObject();
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Byte array test ");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(tr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
            Trainee p = (Trainee) ois.readObject();
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("18");
        Trainee t1,t2;
        t1 = new Trainee("Some", "Another", 2);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("17.dat")))) {
            oos.writeObject(t1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("17.dat")))) {
            t2 = (Trainee) ois.readObject();
            System.out.println(t2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


        //Serialization=
        Gson gson = new Gson();
        String json = gson.toJson(t1);
        System.out.println(json);
        // Deserialization
        t2 = gson.fromJson(json, Trainee.class);
        System.out.println(t2);

        try (FileOutputStream fos = new FileOutputStream(new File("18.dat")))
        {
            fos.write(json.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc = new Scanner(new File("18.dat"));
        json = sc.nextLine();
        t2 = gson.fromJson(json, Trainee.class);
        System.out.printf(tr.toString());
    }
}
