package com.company;

import java.io.*;

class MyException extends Exception {
    public MyException(Throwable e){
        initCause(e);
    }

}

public class NewClass {
    public static int getAreaValue(int x, int y){
        if(x < 0 || y < 0 )throw new IllegalArgumentException("value of 'x' or 'y' is negative: x="+x+", y="+y);
        return x * y;
    }

    public static String main(String[] args) throws MyException, IOException {
        /*int result = 0;

        try{
            result = getAreaValue(-1, 100);
        }catch(IllegalArgumentException e){
            throw new MyException(e);
        }
        System.out.println("Result is : "+result);*/


        FileInputStream fis = null;
        String filename = "sdsd.txt";
        try{
            fis = new FileInputStream(filename);
        }catch(FileNotFoundException ex){
            System.out.println("Oops, FileNotFoundException caught");
        }catch(IOException e){
            System.out.println("IOEXCEPTION");
        }


        //Конструкция try-with-resources
        BufferedReader br = new BufferedReader(new FileReader("путь к фалу"));
        try {
            return br.readLine();
        } finally {
            if (br != null) br.close();
        }
//        //or
//        try (BufferedReader br1 = new BufferedReader(new FileReader("путь к файлу"))) {
//            return br.readLine();
//        }



    }
}
