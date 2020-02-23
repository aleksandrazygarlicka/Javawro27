package pl.sda.rafal.zientara.tdd.HenioSimulation;

import java.util.concurrent.atomic.AtomicInteger;

public class Heniek implements DownloadProcess.OnProgressListener{
    private int count;
    private AtomicInteger finishCount = new AtomicInteger();
    private AtomicInteger errorCount = new AtomicInteger();

    public void startThreads(int count) {

        this.count=count;
        for (int i = 0; i <count; i++) {
            DownloadProcess process  = new DownloadProcess();
            process.setListener(this);
            Thread thread = new Thread(process);
            thread.start();
        }
    }

    @Override
    public void onSuccess() {
        finishCount.incrementAndGet();
        checkFinish();
    }

    @Override
    public void onError() {
        errorCount.incrementAndGet();
        System.out.println("Error");
        checkFinish();
    }

    private void checkFinish() {
        int finished = finishCount.get();
        int errors = errorCount.get();
        int sum = finished+errors;
        if (sum==count) {
            System.out.printf("Udało się pobrać %d/%d\n",finished,count);
            System.out.println("Work is done");
        }
    }
}
