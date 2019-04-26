package P1;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
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

    }
}
