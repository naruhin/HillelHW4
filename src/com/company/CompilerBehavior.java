package com.company;

public class CompilerBehavior {
    /**
     * Необходимо понимать, что
     * — проверка на cheched исключения происходит в момент компиляции (compile-time checking)
     * — перехват исключений (catch) происходит в момент выполнения (runtime checking)
     */
    static class Example1{
        // пугаем Exception
        public static void main(String[] args) throws Exception {
            Throwable t = new Exception(); // и лететь будет Exception
            //throw t; // но тут ошибка компиляции
        }
    }

    static class Example2{
        public static void main(String[] args) throws Exception {
            Object ref = "Hello!";  // ref указывает на строку
            //char c = ref.charAt(0); // но тут ошибка компиляции
        }
    }

    // НЕ КОМПИЛИРУЕТСЯ! ИССЛЕДУЕМ ГИПОТЕТИЧЕСКУЮ СИТУАЦИЮ!
    static class Example3{
        public static void f0(Throwable t) throws Exception {
            //throw t;
        }
        public static void f1(Object ref){
            //char c = ref.charAt(0);
        }
    }

    //Компилятор не пропустит этот код, хотя метод main ГАРАНТИРОВАННО НЕ ВЫБРОСИТ ИСКЛЮЧЕНИЯ
    static class Example4{
        // пугаем Exception
        public static void main(String[] args) throws Exception {
            try {
                Throwable t = new Exception(); // и лететь будет Exception
                //throw t; // но тут ошибка компиляции
            } catch (Exception e) {
                System.out.println("Перехвачено!");
            }
        }
    }


    static class Example5{
        // ТЕПЕРЬ пугаем Throwable
        public static void main(String[] args) throws Throwable {
            try {
                Throwable t = new Exception(); // а лететь будет Exception
                throw t;
            } catch (Exception e) { // и мы перехватим Exception
                System.out.println("Перехвачено!");
            }
        }
    }
}
