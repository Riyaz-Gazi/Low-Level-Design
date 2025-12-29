package solid_principle;

interface RecommendationStrategy {
    void recommend();
}

class TrendingRecommendation implements RecommendationStrategy {
    @Override
    public void recommend() {
        System.out.println("Trending Recommendation");
    }
}

class GenreRecommendation implements RecommendationStrategy {
    @Override
    public void recommend() {
        System.out.println("Genre Recommendation");
    }
}

class RecentRecommendation implements RecommendationStrategy {
    @Override
    public void recommend() {
        System.out.println("Recent Recommendation");
    }
}

class RecommendationAlgorithm{
    private RecommendationStrategy strategy;
    public RecommendationAlgorithm(RecommendationStrategy recommendationStrategy){
        this.strategy = recommendationStrategy;
    }
    public void recommend(){
        strategy.recommend();
    }
}

public class DIP {
    public static void main(String[] args) {
        RecommendationAlgorithm algorithm =  new RecommendationAlgorithm(new RecentRecommendation());
        algorithm.recommend();
    }
}
