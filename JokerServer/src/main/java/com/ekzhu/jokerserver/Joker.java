package com.ekzhu.jokerserver;

import java.util.Random;

public class Joker {
   private static String[] jokes={"Q: What's the difference between my ex and the titanic?A: The titanic only went down on 1,000 people.",
            "Q: Why is 6 afraid of 7?A: Because 7 is a registered 6 offender.",
            "Q: What do you call it when Batman skips church?A: Christian Bale.",
            "Q: What's E.T. short for?A: Because he's only got little legs.",
            "Q: What is the resemblance between a green apple and a red apple?A: They’re both red except for the green one.",
            "Q: Why does Peter Cottontail go hopping down the bunny trail?A: Because he's too young to drive.",
            "Q: Why aren’t koalas actual bears?A: The don’t meet the koalafications.",
            "Q: What is red and smells like blue paint?A: Red paint.",
            "Q: Where do you find a cow with no legs?A: Right where you left it.",
            "Q: What’s brown and sticky?A: A stick.",
            "Q: What's the best thing about Switzerland?A: I don't know, but their flag is a huge plus.",
            "Q: What do you call bears with no ears?A: B",};

    Random random=new Random();



    public String tellJoke(){
        //11 is the maximum and the 1 is our minimum
        int  n = random.nextInt(11) + 1;
        return jokes[n];
    }
}
