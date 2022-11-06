package Lab1;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Lab1 extends Thread{

//    public static final Lock CS1 = new ReentrantLock();
//    public static final Lock CS2 = new ReentrantLock();
//    public static final Lock CS3 = new ReentrantLock();

    //    Initialize a barrier to control input from all processors
//    public static final CyclicBarrier B1 = new CyclicBarrier(PROCESSORS, () -> System.out.println("All data saved. The next step in calculation"));

//
//    //    Initialize a semaphore to synchronize the access to the shared resource to d
//    public static final Semaphore S11 = new Semaphore(0);
//
//    //    Initialize a semaphore to synchronize the access to the shared resource to B
//    public static final Semaphore S12 = new Semaphore(0);
//
//    //    Initialize a semaphore to synchronize T2,T3,T4 with ending calculation 'd' in T1
//    public static final Semaphore S1 = new Semaphore(0);
//
//    //    Initialize a semaphore to synchronize T1,T3,T4 with ending calculation 'd' in T2
//    public static final Semaphore S2 = new Semaphore(0);
//
//    //    Initialize a semaphore to synchronize T1,T2,T4 with ending calculation 'd' in T3
//    public static final Semaphore S3 = new Semaphore(0);
//
//    //    Initialize a semaphore to synchronize T1,T2,T3 with ending calculation 'd' in T4
//    public static final Semaphore S4 = new Semaphore(0);
//
//    //    Initialize a semaphore to synchronize T2 with ending RH of calculations in T1,T3,T4
//    public static final Semaphore S5 = new Semaphore(0);


    //Синхронизация T2,T3,T4 с введением данных в T1
    public static Semaphore S1 = new Semaphore(0, true);

    //Синхронизация T1,T3,T4 с введением данных в T2
    public static Semaphore S2 = new Semaphore(0, true);

    // цей семафор можна видалити, бо він не використовується, але це вже вирішуй сам :)
    public static Semaphore S3 = new Semaphore(0, true);

    //Синхронизация T1,T2,T3 с введением данных в T4
    public static Semaphore S4 = new Semaphore(0, true);

    //Синхронизация T2,T3,T4 с вычислением d в T1

    public static Semaphore S5 = new Semaphore(0, true);

    //Синхронизация T1,T3,T4 с вычислением d в T2

    public static Semaphore S6 = new Semaphore(0, true);


    //Синхронизация T1,T2,T4 с вычислением d в T3
    public static Semaphore S7 = new Semaphore(0, true);

    //Синхронизация T1,T2,T3 с вычислением d в T4
    public static Semaphore S8 = new Semaphore(0, true);
    //Синхронизация T2 из завершением вычислений в потоках T2,T3,T4
    public static Semaphore S9 = new Semaphore(0, true);

//    public static Semaphore S10 = new Semaphore(0, true);

    //For shared resource

    //B (потрібно встановити початкове значення 1, а не 0, тому що з самого початку в нас має бути один доступ до цього ресурсу)
    public static Semaphore S11 = new Semaphore(1, true);

    //d (так само як і в S11)
    public static Semaphore S12 = new Semaphore(1, true);



    //Critical sections
    //For e
    public static final Object CS1 = new Object();
    //For X
    public static final Object CS2 = new Object();
    //For MM
    public static final Object CS3 = new Object();

    public static void main (String[] args) throws InterruptedException {
        System.out.print("Lab1 started. Enter N:");
        Scanner scanner = new Scanner(System.in);
        Data.setN(scanner.nextInt());
        Data.setH();
        Thread1 T1 = new Thread1();
        Thread2 T2 = new Thread2();
        Thread3 T3 = new Thread3();
        Thread4 T4 = new Thread4();


        T1.start();
        T2.start();
        T3.start();
        T4.start();
//
        T1.join();
        T2.join();
        T3.join();
        T4.join();
        System.out.println("Lab1 finished.");
    }
}
