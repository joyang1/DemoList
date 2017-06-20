/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test3;

/**
 *
 * @author 挺
 */
public class Answer implements Runnable {

    private String name;
    private Asker asker;
    private String[] answers;
    private String answer;

    public Answer(String name, Asker asker) {
        this.name = name;
        this.asker = asker;
        answers = new String[]{"我挺好的！", "你在开玩笑嘛！", "上帝都不同意啊！", "我去吃饭了！", "再见！", "你滚吧！", "别开玩笑了！", "你再这样我就走了!"};
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
     * @return the asker
     */
    public Asker getAsker() {
        return asker;
    }

    /**
     * @param asker the asker to set
     */
    public void setAsker(Asker asker) {
        this.asker = asker;
    }

    /**
     * @return the answers
     */
    public String[] getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public void run() {
        synchronized (asker) {
            while (true) {
                myanswer();
            }
        }

    }

    private void myanswer() {
        try {
            if (asker.isIsAsked()) {
                if (asker.getQuestion().indexOf("大笨蛋") > 0) {
                    Thread.sleep(1000);
                    System.out.println(name + "：你丫才是大笨蛋！呵呵");
                    System.out.println("");
                } else {
                    Thread.sleep(1000);
                    answer = answers[asker.ran.nextInt(answers.length)];
                    System.out.println(name + ":" + this.getAnswer());
                    System.out.println("");
                }

            } else {
                asker.wait();
            }
            asker.setIsAsked(false);
            asker.notify();
            asker.wait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
