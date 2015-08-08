package com.mechanitis.demo.sense.client.mood;

import com.mechanitis.demo.sense.infrastructure.MessageListener;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import static javafx.collections.FXCollections.observableArrayList;

public class MoodChartData implements MessageListener<TweetMood> {
    private final PieChart.Data sadPortion = new PieChart.Data("Sad", 0);
    private final PieChart.Data happyPortion = new PieChart.Data("Happy", 0);
    private final PieChart.Data confusedPortion = new PieChart.Data("Errr...", 0);
    private final ObservableList<PieChart.Data> pieChartData = observableArrayList(sadPortion, happyPortion, confusedPortion);

    public ObservableList<PieChart.Data> getPieChartData() {
        return pieChartData;
    }

    @Override
    public void onMessage(TweetMood tweetMood) {
        incrementPie(tweetMood.isHappy(), happyPortion);
        incrementPie(tweetMood.isSad(), sadPortion);
        incrementPie(tweetMood.isConfused(), confusedPortion);
    }

    private void incrementPie(boolean criteria, PieChart.Data portion) {
        System.out.println("cheking moode of message");
        if (criteria) {
            System.out.println("message found to be " + portion.getName() + "!");
            portion.setPieValue(portion.getPieValue() + 1);
        }
    }
}
