package learn.zno.znostudy.Recycler;

public class ExampleItem {

    private String numbQuest;
    private String quest;
    private String ans1;
    private String ans5;

    public ExampleItem(String numbQuest, String quest, String ans1, String ans5) {
        this.numbQuest = numbQuest;
        this.quest = quest;
        this.ans1 = ans1;
        this.ans5 = ans5;
    }

    public String getNumbQuest() {
        return numbQuest;
    }

    public String getQuest() {
        return quest;
    }

    public String getAns1() {
        return ans1;
    }

    public String getAns5() {
        return ans5;
    }

}
