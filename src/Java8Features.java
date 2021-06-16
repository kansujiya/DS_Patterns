
/*
Lambda expression: To provide implementation of functional interface.
Functional interface : A interface which have only one abstract method
Syntax : (params) -> {expression/statements}


* */

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface checkMe {
    public void check();
}

interface Drawable {
    public void draw();
}

@FunctionalInterface
interface DrawableLambda {
    public void draw();
}

interface Sayable {
    public String say();
}

interface Sayable2 {
    public String say(String name);
}

interface Sayable3 {
    public void say();
}

interface Addable {
    public int add(int a, int b);
}

class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}

/* Method reference : Method reference is used to refer method of functional interface. It is compact and easy form of lambda expression
    - Static method
    - instance method
    - Constructor
* */

interface Messenger {
    Message getMessage(String msg);
}

class Message {
    Message(String str) {
        System.out.println(str);
    }
}

/* Stream: package in Java 8 called java.util.stream
    - Stream does not store elements. It simply conveys elements from a source such as a data structure, an array, or an I/O channel, through a pipeline of computational operations.
    - Stream is functional in nature. Operations performed on a stream does not modify it's source. For example, filtering a Stream obtained from a collection produces a new Stream without the filtered elements, rather than removing elements from the source collection.
    - Stream is lazy and evaluates code only when required.
    - The elements of a stream are only visited once during the life of a stream. Like an Iterator, a new stream must be generated to revisit the same elements of the source.
* */

class Test
{
    int test_a, test_b;
    Test(int a, int b)
    {
        test_a = a;
        test_b = b;
    }
}

class testClass3 extends testClass1 {}
class testClass2 extends testClass1 {}
class testClass1 {}

public class Java8Features extends Student implements Runnable, test2, test1 {

    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void SayingSomething() {
        System.out.println("I am saying about static method reference");
    }

    public void SayingSomething1() {
        System.out.println("I am saying about instance method reference");
    }

    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {

//        Test test = new Test();
//        System.out.println(test.test_a+" "+test.test_b);

        //Thread
        Thread t1 = new Thread(new Java8Features());
        t1.setName("POLO-1");
        t1.setPriority(10);
        t1.start();

        Thread t2 = new Thread(new Java8Features());
        t2.setName("POLO-2");
        t2.setPriority(1);
        t2.start();

        List lll = new ArrayList();
        lll.add(2);
        lll.add(3);
        lll.add(5);
        //System.out.println(lll.get(3));

        List<Integer> TS = new ArrayList<>();
        TS.add(100);
        TS.add(1);
        TS.add(1000);
        TS.add(10);
        TS.add(10000);
        TS.add(10);
        NavigableSet<Integer> N = new TreeSet<>(TS);
        System.out.println(N.tailSet(10,false));
        System.out.println(N.tailSet(10));
        System.out.println(N.higher(10));

        int A = N.pollFirst();
        System.out.println(N.size());

        //With anonymous class
        int width = 10;

        Drawable d=new Drawable(){
            public void draw(){System.out.println("Drawing "+width);}
        };
        d.draw();

        //With Lambda function () -> {}
        DrawableLambda d2= ()->{
            System.out.println("Drawing with Lambda"+ width);
        };
        d2.draw();

        //with no params lambda
        Sayable s = ()->{
            return "Suresh saying about lambda";
        };

        System.out.println(s.say());

        //With lambda one params
        Sayable2 s2 = (name) -> {
            return name + " " + "Saying about lambda with one param";
        };

        System.out.println(s2.say("Kansujiya"));

        //with multiple params
        Addable a = (x, y)->(x+y); //{}

        System.out.println(a.add(5,10));

        //Lambda expression with For each loop
        List<String> list = new ArrayList<>();
        list.add("Suresh");
        list.add("Kansujiya");
        list.add("Delhi");

        list.forEach(
                (n)->{
                    System.out.println(n);
                }
        );

        //Thread Example without lambda
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 is running");
            }
        };

//        Thread t11 = new Thread(r);
//        t11.setPriority(91);
//        t11.start();


        Runnable r2 = ()->{
          System.out.println("Thread2 is running");
        };

        Thread t22 = new Thread(r2);
        t22.start();


        //Lambda example with Collection framework
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"HP Laptop",25000f));
        productList.add(new Product(3,"Keyboard",300f));
        productList.add(new Product(2,"Dell Mouse",150f));

        System.out.println("Sorting based on name");

        Collections.sort(productList,(p1,p2) -> {
            return p1.name.compareTo(p2.name);
        });

        productList.forEach((product)->{
            System.out.println(product.name + product.id + product.price);
        });


        // Lambda with filter
        List<Product> filterProduct = new ArrayList<>();

        filterProduct.add(new Product(1,"Samsung A5",17000f));
        filterProduct.add(new Product(3,"Iphone 6S",65000f));
        filterProduct.add(new Product(2,"Sony Xperia",25000f));
        filterProduct.add(new Product(4,"Nokia Lumia",15000f));
        filterProduct.add(new Product(5,"Redmi4 ",26000f));
        filterProduct.add(new Product(6,"Lenevo Vibe",19000f));

        Stream<Product> filter_data = filterProduct.stream().filter( productItem -> productItem.price > 1000);
        //List<Product> filter_data1 = (List<Product>) filterProduct.stream().filter(productItem -> productItem.price > 1000);

        filter_data.forEach( item -> {
            System.out.println(item.name + item.id + item.price);
        });

        // Static method reference
        Sayable3 sayable3 = Java8Features::SayingSomething;
        sayable3.say();

        //Instance method reference
        Java8Features feature = new Java8Features();
        Sayable3 say3 = feature::SayingSomething1;
        say3.say();

        //Constructor method reference
        Messenger ms = Message::new;
        ms.getMessage("Call Message class constructor");

        //Sort products using stream
        List<Float> productListStream = filterProduct.stream()
                                        .filter(product2 -> product2.price > 2000)
                                        .map(product2 -> product2.price)
                                        .collect(Collectors.toList());
        System.out.println(productListStream);

        // Stream with Iteration
        Stream.iterate(1, element->element+1)
                .filter(element->element%5==0)
                .map(element->element+3)
                .limit(5)
                .forEach(System.out::println);

        // Using stream calculate total price of filtered product
        Float totalPrice = filterProduct.stream()
                            .map(p->p.price)
                            .reduce(0.0f, (sum, price)->sum+price);
        System.out.println(totalPrice);

        // Using stream calculate total price of filtered product + method reference
        Float tPrice = filterProduct.stream()
                        .map(pr->pr.price)
                        .reduce(0.0f, Float::sum);
        System.out.println(tPrice);

        // Using stream calculate total price of filtered product + collector method
        double dtPrice = filterProduct.stream()
                         .collect(Collectors.summingDouble(pr->pr.price));
        System.out.println(dtPrice);

        // Using stream find min & max price in filtered product list
        Product maxPriceProduct = filterProduct.stream()
                .max((p1, p2) -> p1.price > p2.price ? 1: -1).get();

        Product minPriceProduct = filterProduct.stream()
                .max((pp1, pp2) -> pp1.price < pp2.price ? 1: -1).get();

        System.out.println(maxPriceProduct.price);
        System.out.println(minPriceProduct.price);

        // Convert product list into map
        Map<Integer, String> map = filterProduct.stream()
                .collect(Collectors.toMap(p->p.id, p->p.name));
        System.out.println(map);

        // Method reference with Stream()
        List<Float> mrProduct = filterProduct.stream()
                                  .filter(p->p.price > 15000)
                                  .map(Product::getPrice)
                                  .collect(Collectors.toList());
        System.out.println(mrProduct);

        // Run Java Script code in Java
        ScriptEngine jjs = new ScriptEngineManager().getEngineByName("Nashorn");
        jjs.eval(new FileReader("src/Nashorn.js"));

        //Call JS method
        ScriptEngine jj = new ScriptEngineManager().getEngineByName("Nashorn");
        jj.eval(new FileReader("src/Nashorn.js"));
        Invocable invoke = (Invocable)jj;
        invoke.invokeFunction("functionDemo1");
        invoke.invokeFunction("functionDemo1", "Nashorn");


        //{int i; getRole = i-> 2 * i;} //I. compile time II. Runtime III. Warning IV. No error (a. -compile time).
        //List<String> lili = List.stream().map(p->p.getName()).collect(toList())

        final String str = "test";
        str.chars().forEach(ch -> System.out.println(ch));

        List<Integer> listlist = Arrays.asList(20, 44, 6, 89, 10);

        listlist.stream().parallel().forEach( System.out::println );        //1

        listlist.stream().parallel().forEachOrdered( System.out::println ); //2

//        ArrayList<testClass1> oList = new ArrayList<>();
//        testClass2 test2 = new testClass2();
//        testClass1 test1 = new testClass1();
//        oList.add((testClass2) test1);
//        oList.add(test2);

        List [] arrOfLists = new ArrayList[2];

        StringBuffer x = new StringBuffer("A");
        StringBuffer y = new StringBuffer("B");

        operate(x,y);
        System.out.println(x + " "+","+" " + y);
        //String sss = ""test"";
//        testClass1 test1 = new testClass1();
//        testClass2 test2 = new testClass2();
//        testClass3 test3 = new testClass3();
//        oList.add(test1);
//        oList.add(test2);
//        oList.add(test3);

        test1 ttr = new Java8Features();
        ttr.show();

        Java8Features ff = new Java8Features();
//        int  ias = ff.check();
//        System.out.println(ias);



        try {
            System.out.println("Hi");
            shown();
        } catch(Exception e){
            System.out.println("Caught");
        } finally {
            System.out.println("Finally");
        }

        System.out.println("Last");

        String stt = "XYZ";
        //System.out.println(stt.compareTo(new Student()));

        if("String".endsWith("")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        String strs = "AAB";
        //System.out.println(Java8Features.strs);

        ff.display(null);

        Student stu = new Java8Features();
        //stu.ttest();
    }

    void display(Object o) {
        System.out.println("Finally");
    }

    void display(String str) {
        System.out.println("String");
    }

    static {
        String strs = "Hi";
        strs = "XYY";
    }


    static void operate(StringBuffer a, StringBuffer b) {
        b.append(b);
        a = b.append("C");
        a.append("D");
    }

    static void ttest() {
        System.out.println("child claSS");
    }

    @Override
    public void show() {
        System.out.println("Show");
    }

    static void shown() {
        System.out.println("show ");
        throw  new RuntimeException();
    }

    public int returnTry() {
        try {
            return 1;
        } catch(Exception e){
            return 2;
        } finally {
            return 3;
        }
    }

//    int check() {
//        try {
//            //System.out.println("Try block");
//            //return 1;
//            throw  new IOException();
//        } catch(Exception e){
//            System.out.println("Catch block");
//            return 2;
//        } finally {
//            System.out.println("Finally");
//            return 3;
//        }
//    }
}

class Student {
    static void check() {
        System.out.println("String");
    }
}

interface test1 {
    void show();
}

interface test2 {
    void show();
}