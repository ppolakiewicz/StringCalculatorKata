import com.company.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @ParameterizedTest
    @MethodSource("provideStringsToAdd")
    public void testAddMethod(String input, int result){

        //when
        int methodResult = Main.add(input);

        //then
        assertEquals(methodResult, result);
    }


    private static Stream<Arguments> provideStringsToAdd() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("1", 1),
                Arguments.of("1,2", 3),
                Arguments.of("1,2,3,4", 10)
        );
    }
}
