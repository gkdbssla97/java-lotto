package lotto.model.domain;

import java.util.HashMap;

public class Rank {

    private HashMap<String, Integer> rankChart;

    public Rank() {
        this.rankChart = initRankChart();
    }

    public HashMap<String, Integer> initRankChart() {
        return new HashMap<>(5){
            {
                put("3", 0);
                put("4", 0);
                put("5", 0);
                put("5 + 보너스", 0);
                put("6", 0);
            }
        };
    }

    public HashMap<String, Integer> getRank() {
        return rankChart;
    }

    public void setRankChart(int count) {
        if (count == 0) {
            rankChart.put("5 + 보너스", rankChart.get("5 + 보너스") + 1);
            return;
        }
        String ranking = Integer.toString(count);
        rankChart.put(ranking, rankChart.get(ranking) + 1);
    }

    public double setYield(Integer playerPrice) {
        int sum = 0;
        sum = getSum(sum);
        return (double) (sum * 100) / playerPrice;
    }

    private int getSum(int sum) {
        sum += Prize.MATCHING_THREE.getReward() * rankChart.get("3");
        sum += Prize.MATCHING_FOUR.getReward() * rankChart.get("4");
        sum += Prize.MATCHING_FIVE.getReward() * rankChart.get("5");
        sum += Prize.MATCHING_FIVE_WITH_BONUS.getReward() * rankChart.get("5 + 보너스");
        sum += Prize.MATCHING_SIX.getReward() * rankChart.get("6");
        return sum;
    }

    public HashMap<String, Integer> getRankChart() {
        return rankChart;
    }

    public String toString(int idx) {
        return idx + "개";
    }

    public String toString(String yield) {
        return yield + "%" + "입니다.";
    }
}
