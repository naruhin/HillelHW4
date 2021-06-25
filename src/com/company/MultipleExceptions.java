package com.company;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MultipleExceptions {

    static class Example1{
        // пугаем ОБОИМИ исключениями
        public static void main(String[] args) throws EOFException, FileNotFoundException {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new EOFException();
            } else {
                throw new FileNotFoundException();
            }
        }
    }

    static class Example2{
        // пугаем ОБОИМИ исключениями
        public static void main(String[] args) throws EOFException, FileNotFoundException {
            f0();
            f1();
        }
        public static void f0() throws EOFException {/*...*/}
        public static void f1() throws FileNotFoundException {/*...*/}
    }

    static class Example3{
        // пугаем ПРЕДКОМ исключений
        public static void main(String[] args) throws IOException {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new EOFException();
            } else {
                throw new FileNotFoundException();
            }
        }
    }

    static class Example4{
        // пугаем ПРЕДКОМ исключений
        public static void main(String[] args) throws IOException {
            f0();
            f1();
        }
        public static void f0() throws EOFException {/*...*/}
        public static void f1() throws FileNotFoundException {/*...*/}
    }

    static class Example5{
        public static void main(String[] args) throws IOException, InterruptedException {
            f0();
            f1();
            f2();
        }
        public static void f0() throws EOFException {/*...*/}
        public static void f1() throws FileNotFoundException {/*...*/}
        public static void f2() throws InterruptedException {/*...*/}
    }


}
