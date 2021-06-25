package com.company;

import java.util.logging.Logger;

public class Main {
    public static int getAreaValue(int x, int y){
        if(x < 0 || y < 0 )throw new IllegalArgumentException("value of 'x' or 'y' is negative: x="+x+", y="+y);
        return x * y;
    }

    public static void main(String[] args) {
	    int result = 0;
	     try {
	         result = getAreaValue(-1,100);
         }catch (IllegalArgumentException e){
	         throw e;
         }

        System.out.println("Result is - " + result);
    }

    //Вызов метода, который «пугает» unchecked исключением не накладывает на нас никаких обязанностей.
    static class UncheckedThrows{
        public static void main(String[] args) {
            f();
        }
        public static void f() throws RuntimeException {
        }
    }
}


