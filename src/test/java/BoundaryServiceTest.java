import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.OptionalInt;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoundaryServiceTest {

    private final BoundaryService boundaryService = new BoundaryService();

    @ParameterizedTest(name = "Тест для массива: {0}")
    @DisplayName("Проверка непустых массивов с различными наборами значений")
    @Description("Проверка нахождения минимального элемента в массиве")
    @MethodSource("arrayProvider")
    public void findMinForDifferentValues(int[] array) {
        OptionalInt min = OptionalInt.of(boundaryService.findMin(array));

        OptionalInt expectedMin = stream(array).min();

        assertEquals(expectedMin, min);
    }

    private static Stream<int[]> arrayProvider() {
        return Stream.of(
                (new int[]{}),
                (new int[]{2, 3, 4, 5}),
                (new int[]{5, 4, 3, 2}),
                (new int[]{0, 8, 3, 5}),
                (new int[]{0, -8, 3, -5})
        );
    }
}