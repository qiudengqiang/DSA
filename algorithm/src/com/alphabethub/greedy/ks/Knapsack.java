package com.alphabethub.greedy.ks;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 0-1背包问题
 */
public class Knapsack {
    public static void main(String[] args) {
        select("价值主导", (Article a1, Article a2) -> a2.getValue() - a1.getValue());
        select("重量主导", (Article a1, Article a2) -> a1.getWeight() - a2.getWeight());
        select("价值密度主导", (Article a1, Article a2) -> {
            return Double.compare(a2.getValueDensity(), a1.getValueDensity());
        });
    }

    static void select(String title, Comparator<Article> comparator) {
        Article[] articles = new Article[]{
                new Article(35, 10), new Article(30, 40),
                new Article(60, 30), new Article(50, 50),
                new Article(40, 35), new Article(10, 40),
                new Article(25, 30)
        };

        Arrays.sort(articles, comparator);

        int capacity = 150, weight = 0, value = 0;
        List<Article> selectedArticles = new ArrayList<>();
        for (int i = 0; i < articles.length; i++) {
            int newWeight = articles[i].getWeight() + weight;
            if (newWeight <= capacity) {
                weight = newWeight;
                value += articles[i].getValue();
                selectedArticles.add(articles[i]);
            }
        }

        System.out.println("【" + title + "】");
        System.out.println("总价值：" + value);
        for (int i = 0; i < selectedArticles.size(); i++) {
            System.out.println(selectedArticles.get(i));
        }
        System.out.println("-----------------------------");

    }
}
