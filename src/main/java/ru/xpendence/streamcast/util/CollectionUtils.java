package ru.xpendence.streamcast.util;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 09.09.18
 * Time: 22:17
 * e-mail: 2262288@gmail.com
 */
public class CollectionUtils {

    private CollectionUtils() {
    }

    private static <T> boolean isEmpty(Collection<T> c) {
        return Objects.isNull(c) || c.isEmpty();
    }

    @SafeVarargs
    public static <T> Set<T> asSet(T... t) {
        return Stream.of(t).collect(Collectors.toSet());
    }

    public static <T> Collection<T> remove(Collection<T> a, Collection<T> b) {
        if (isEmpty(a)) {
            return Collections.emptySet();
        }
        if (isEmpty(b)) {
            return a;
        }
        Set<T> result = new HashSet<>(a);
        result.removeAll(new HashSet<>(b));
        return result;
    }

    public static <K, V> Map<V, K> reverse(Map<K, V> m) {
        return m.entrySet().stream().collect(CollectionUtils.toLinkedMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    private static <T, K, U> Collector<T, ?, Map<K, U>> toLinkedMap(Function<? super T, ? extends K> keyMapper,
                                                                    Function<? super T, ? extends U> valueMapper) {
        return Collectors.toMap(keyMapper, valueMapper, throwingMerger(), LinkedHashMap::new);
    }

    public static <K, V> Map.Entry<K, V> entry(K key, V value) {
        return new AbstractMap.SimpleEntry<>(key, value);
    }

    public static <K, U> Collector<Map.Entry<K, U>, ?, Map<K, U>> entriesToMap() {
        return Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue);
    }

    public static <K, U> Collector<Map.Entry<K, U>, ?, ConcurrentMap<K, U>> entriesToConcurrentMap() {
        return Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue);
    }

    private static <T> BinaryOperator<T> throwingMerger() {
        return (u, v) -> {
            throw new IllegalStateException(String.format("Duplicate key %s", u));
        };
    }
}
