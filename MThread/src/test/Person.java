/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author 挺
 */
public class Person {
     private String name = "joyang";
    private String fun = "software engineer";
    private boolean flag = false; //标志位

    //同步方法，也可使用同步代码块的方式synchronized(object){};  线程同步问题
    public synchronized void set(String n, String f) {
        //flag 为真是表示不需要等，可以直接设置，否则需要等待
        if (!this.flag) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.name = n;
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.fun = f;
        //修改标志
        flag = false;
        notifyAll();
    }

    public synchronized String get() {
        //flag 为真是表示需要等，可以直接设置，否则不需要等待
        if (this.flag) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = this.name + "--->" + this.fun;
        flag = true;
        notifyAll();
        return str;
    }
}
