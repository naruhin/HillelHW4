package com.company;

public class PessimisticMechanism {
    //Мы не можем бросать, но не предупредить
    static class Example1{
        public static void main(String[] args) {
            //throw new Exception(); // тут ошибка компиляции
        }
    }

    //Мы не можем бросать, но предупредить о «меньшем»
    static class Example2{
        public static void main(String[] args) {
            //throw new Exception(); // тут ошибка компиляции
        }
    }

    //Мы можем предупредить точно о том, что бросаем
    static class Example3{
        public static void main(String[] args)  throws Exception {
            throw new Exception(); // и кидаем Exception
        }
    }

    //Мы можем предупредить о большем, чем мы бросаем
    static class Example4 {
        public static void main(String[] args) throws Throwable { // предупреждаем "целом" Throwable
            throw new Exception(); // а кидаем только Exception
        }
    }

    //Можем даже предупредить о том, чего вообще нет
    static class Example5 {
        public static void main(String[] args) throws Exception { // пугаем
            // но ничего не бросаем
        }
    }

    //Даже если предупреждаем о том, чего нет — все обязаны бояться
    static class Example6 {
        public static void main(String[] args) {
            //f(); // тут ошибка компиляции
        }

        public static void f() throws Exception {
        }
    }

    //Хотя они (испугавшиеся) могут перепугать остальных еще больше
    static class Example7{
        // они пугают целым Throwable
        public static void main(String[] args) throws Throwable {
            f();
        }
        // хотя мы пугали всего-лишь Exception
        public static void f() throws Exception {
        }
    }



}
