package analyser;

final class ProbabilityChecker {

    private ProbabilityChecker() {
    }

    static boolean violateByChebyshevCheck(double value, double mathExp, double variance, double threshold) {
        double k = Math.abs(value - mathExp) / Math.sqrt(variance);
        double probability = 1d / (k * k);
        return violateByThreshold(probability, threshold);
    }

    static boolean violateByThreshold(double eventProbability, double threshold) {
        return eventProbability - threshold < 1e-6;
    }

}
