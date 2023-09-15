package source;

import org.junit.jupiter.params.provider.Arguments;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class FactoryMethod {
    private static Stream<Arguments> factoryInterseccion(){
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);
        set1.add(4);
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        Set<Integer> set3 = new HashSet<>();
        set3.add(1);
        set3.add(8);
        set3.add(6);
        return Stream.of(
                Arguments.of((new int [] { 1, 2, 3,4,5}),(new int [] {2, 4,3,6,8 }),set1),
                Arguments.of((new int [] { 3, 4, 5 ,6}),(new int [] { 3, 5, 4,7}),set2),
                Arguments.of((new int [] {2, 1, 6, 3, 8}),(new int [] {1,6,8,9,7}), set3)
        );
    }
}
