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
public class Xiaoming implements Runnable {

    private Clock c = null;

    public Xiaoming(Clock c) {
        this.c = c;
    }

    @Override
    public void run() {
        synchronized (c) {
            while (true) {
                op();
            }
        }

    }

    private void op() {
        try {
            if (c.isWakeup()) {
                Thread.sleep(2000);   
                System.out.println("小明：知道了！知道了！知道了！");
            } else {
                c.wait();
            }
            c.setWakeup(false);
            c.notify();
            c.wait();

        } catch (Exception e) {
        }

    }

}
