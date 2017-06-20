/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/**
 *
 * @author 挺
 */
public class Clock implements Runnable {

    private boolean wakeup;

    public Clock() {
        this.wakeup = false;
    }

    /**
     * @return the wakeup
     */
    public boolean isWakeup() {
        return wakeup;
    }

    /**
     * @param wakeup the wakeup to set
     */
    public void setWakeup(boolean wakeup) {
        this.wakeup = wakeup;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            wake();
        }

    }

    private void wake() {
        try {
            if (!this.wakeup) {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(1000);
                    System.out.println("闹钟：起床了！");
                }
                this.wakeup = true;
                this.notify();
                this.wait();
            } else {
                this.wait();
            }

        } catch (Exception e) {

        }

    }

}
