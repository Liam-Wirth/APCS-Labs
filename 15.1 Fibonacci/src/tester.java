public class tester {
    public static void main(String[] args){
        fibonacci fibonacci = new fibonacci();
        System.out.println("----------Recursive----------");
        System.out.println("Fib0  : "+fibonacci.recursive(0));
        System.out.println("Fib3  : "+fibonacci.recursive(2));
        System.out.println("Fib11 : "+fibonacci.recursive(10));
        System.out.println("--------Non Recursive--------");
        System.out.println("Fib1  : " + fibonacci.nonRecursive(1));
        System.out.println("Fib5  : " + fibonacci.nonRecursive(5));
        System.out.println("fib14 : " + fibonacci.nonRecursive(14));
        System.out.println("--Recursive  Multiplication--");
        System.out.println("0 x 4 = " + fibonacci.mult(0, 4));
        System.out.println("3 x 1 = " + fibonacci.mult(3,1));
        System.out.println("7 x 8 = " + fibonacci.mult(7, 8));
        System.out.println("5 x 0 = "+ fibonacci.mult(5, 0));


    }
}
