package design_pattern.singleton_pattern;

// Thread Safe Eager Loading
//class JudgeAnalytics{
//    private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
//    private JudgeAnalytics(){
//
//    }
//    public static JudgeAnalytics getInstance(){
//        return judgeAnalytics;
//    }
//}

// Lazy Loading Not Thread Safe
//class JudgeAnalytics{
//    private static JudgeAnalytics judgeAnalytics;
//    private JudgeAnalytics(){
//
//    }
//    public static JudgeAnalytics getInstance(){
//        if(judgeAnalytics == null){
//            judgeAnalytics = new JudgeAnalytics();
//        }
//        return judgeAnalytics;
//    }
//}

//class JudgeAnalytics{
//    private static JudgeAnalytics judgeAnalytics;
//    private JudgeAnalytics(){
//
//    }
//    public static synchronized JudgeAnalytics getInstance(){
//        if(judgeAnalytics == null){
//            judgeAnalytics = new JudgeAnalytics();
//        }
//        return judgeAnalytics;
//    }
//}


//class JudgeAnalytics {
//    private static volatile JudgeAnalytics judgeAnalytics;
//    private JudgeAnalytics() {
//
//    }
//    public static JudgeAnalytics getInstance() {
//        if (judgeAnalytics == null) {
//            synchronized (JudgeAnalytics.class) {
//                if (judgeAnalytics == null) {
//                    judgeAnalytics = new JudgeAnalytics();
//                }
//            }
//        }
//        return judgeAnalytics;
//    }
//}

class JudgeAnalytics {
    private JudgeAnalytics() {}

    // Method to hold the Singleton Instance
    private static class Holder {
        private static final JudgeAnalytics INSTANCE = new JudgeAnalytics();
    }

    public static JudgeAnalytics getInstance() {
        return Holder.INSTANCE;
    }
}


public class SingletonPatternMain {
    public static void main(String[] args) {
        JudgeAnalytics judgeAnalytics = JudgeAnalytics.getInstance();
    }
}

