package analyser;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

final class ProbabilityCalculator {

    private ProbabilityCalculator() {
    }

    static List<Pair<Integer, Double>> getDistribution(List<Integer> rawValues) {
        return rawValues.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().map(entry -> ImmutablePair.of(entry.getKey(), ((double) entry.getValue()) / rawValues.size()))
                .collect(Collectors.toList());
    }

    static Pair<Double, Double> getDistributionParameters(List<Integer> rawValues) {
        List<Pair<Integer, Double>> distribution = getDistribution(rawValues);
        double mathExpectation = distribution.stream().mapToDouble(p -> p.getLeft() * p.getRight()).sum();
        double variance = distribution.stream().mapToDouble(p -> (p.getLeft() - mathExpectation) * (p.getLeft() - mathExpectation) * p.getRight()).sum();
        return ImmutablePair.of(mathExpectation, variance);
    }

}
