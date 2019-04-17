package lesson5Main;

public class lesson5Main {
    public static int size                  = 10000000;
    public static int h                     = size / 2;
    public static float[] arrPlain          = new float[size];
    public static float[] arrThreads        = new float[size];

    public static void main(String[] args) {
//заполняем единицами
        fillOnes(arrPlain);
        fillOnes(arrThreads);
//считаем просто
        jobPlain();
//считаем с потоками
        jobThreads();
    }

    public static void fillOnes( float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1; }
    }

    public static void jobPlain(){
        System.out.println("Без потоков!");
        long begin = System.currentTimeMillis();
        fillMath(arrPlain, 0);
        System.out.println("Время:" + (System.currentTimeMillis() - begin)) ;
    }

    public static void fillMath( float[] arr , int start ){
        int arrLen = arr.length;
        for (int i = 0; i < arrLen; i++) {
           arr[i] = (float) ( arr[i] * Math.sin(0.2f + (i+start)/5) * Math.cos(0.2f+(i+start)/5) * Math.cos(0.4f+(i+start)/2) );
           }
    }

    public static void jobThreads(){
        System.out.println("С потоками!");

        long begin = System.currentTimeMillis();

        float[] a1     = new float[h];
        float[] a2     = new float[h];

        System.arraycopy(arrThreads, 0, a1, 0, h);
        System.arraycopy(arrThreads, h, a2, 0, h);

        MyThread T1 = new MyThread(a1, 0);
        Thread t1 = new Thread(T1);
        t1.start();

        MyThread T2 = new MyThread(a2, h);
        Thread t2 = new Thread(T2);
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch ( InterruptedException e ) {
            System.out.println( "Выполнение прервано!" );
        }
        System.arraycopy( a1, 0, arrThreads, 0, h );
        System.arraycopy( a2, 0, arrThreads, h, h );
        System.out.println( "Время:" + (System.currentTimeMillis() - begin) );
    }

    static class MyThread implements Runnable{
        float[] a     = new float[h];
        int start     = 0;

        public MyThread (float[] arr, int from){
            this.a = arr;
            this.start = from;
        }

        public void run(){
                fillMath( a , start );
        }
    }
 }



