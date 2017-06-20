/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test3;

import java.util.Random;

/**
 *
 * @author 挺
 */
public class Asker implements Runnable {

    private String name;
    private String[] questions;
    private String question;
    private boolean isAsked;
    public  Random ran = new Random();

    public Asker(String name) {
        this.name = name;
        this.isAsked = false;
        questions = new String[]{"你还好吧？", "你睡了吗？", "中国足球进世界杯了吗？", "你喜欢我吗？", "你多大了", "你干什么工作啊？", "你在哪？", "你是干什么的?", "你家在哪？","你是大笨蛋吗？"};
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the questions
     */
    public String[] getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the isAsked
     */
    public boolean isIsAsked() {
        return isAsked;
    }

    /**
     * @param isAsked the isAsked to set
     */
    public void setIsAsked(boolean isAsked) {
        this.isAsked = isAsked;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 20; i++) {
            ask();
        }
    }

    private void ask() {
        try {
            if (!this.isAsked) {
                Thread.sleep(1000);
                int index = ran.nextInt(questions.length);
                this.question = questions[index];
                System.out.println(name + ":" + this.getQuestion());
                
            }else{
                this.wait();
            }
            this.isAsked = true;
            this.notify();
            this.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
