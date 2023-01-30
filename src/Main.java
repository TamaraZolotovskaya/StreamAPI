import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> arrayList = new ArrayList<>();
        T min;
        T max;
        arrayList = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (arrayList.size() != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
            minMaxConsumer.accept(min, max);
            if (min == null && max == null) {
                minMaxConsumer.accept(null, null);
            }
        }
    }

    public static void evenNumbersWithStream(List<Integer> numbers) {
        int count = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList()
                .size();
        System.out.println("Колличество четных чисел " + count);
    }



    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(37, 2, 16, 4, 5, 6, 12, 1);
        evenNumbersWithStream(list);

        Stream<Integer> stream = list.stream();
        findMinMax(
                stream,
                Comparator.naturalOrder(),
                (min, max) -> System.out.println("min: " +min+ " max: "+max));

    }
}