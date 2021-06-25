package com.company;

import java.io.EOFException;
import java.io.FileNotFoundException;

public class OrCatchOrThrows {
    //Не надо пугать тем, что вы перехватили

    //так
    static class Example1{
        public static void main(String[] args) {
            try {
                throw new Exception();
            } catch (Exception e) {
                // ...
            }
        }
    }


    //или так (ставим catch по предку и точно перехватываем)
    static class Example2{
        public static void main(String[] args) {
            try {
                throw new Exception();
            } catch (Throwable e) {
                // ...
            }
        }
    }


    //Но если перехватили только потомка, то не выйдет
    static class Example3{
        public static void main(String[] args) {
            try {
                //throw new Throwable(); //ошибка компиляции
            } catch (Exception e) {
                // ...
            }
        }
    }

    //Не годится, естественно, и перехватывание «брата»
    static class Example4{
        public static void main(String[] args) {
            try {
                //throw new Exception(); //ошибка компиляции
            } catch (Error e) {
                // ...
            }
        }
    }

    //Если вы часть перехватили, то можете этим не пугать
    static class Example5{
        // EOFException перехватили catch-ом, им не пугаем
        public static void main(String[] args) throws FileNotFoundException {
            try {
                if (System.currentTimeMillis() % 2 == 0) {
                    throw new EOFException();
                } else {
                    throw new FileNotFoundException();
                }
            } catch (EOFException e) {
                // ...
            }
        }
    }
}
