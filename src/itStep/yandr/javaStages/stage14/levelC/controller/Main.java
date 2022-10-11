package itStep.yandr.javaStages.stage14.levelC.controller;

public class Main {
    public static void main(String[] args) {
        int [] ar={2525, 30 , 5,1024,85225,2056225 };
        long mpl = 1L;
        for (int i = 0; i <ar.length ; i++) {
            mpl*=ar[i];
        }
        System.out.println(Math.round(Math.pow(mpl,1.0 / ar.length)));

        double sum =0L;
        for (int i = 0; i < ar.length ; i++) {
            sum+=ar[i];
        }
        System.out.println(sum / ar.length);

    }
}
