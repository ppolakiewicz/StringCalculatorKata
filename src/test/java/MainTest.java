import com.company.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {

    @Test
    public void stringEndingWithCarriageReturnWillCauseException(){
        //given
        String input = "1,2,3\n";

        //when
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> Main.add(input)
        );

        //then
        assertEquals(exception.getMessage(), new IllegalArgumentException().getMessage());
    }

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
                Arguments.of("1,2,3,4", 10),
                Arguments.of("1,2,3\n4", 10),
                Arguments.of("1\n2\n3\n4", 10),
                Arguments.of("//;\n 1;2;3\n4", 10),
                Arguments.of("//}\n1}2", 3),
                Arguments.of("//}\n1}2}2000", 3),
                Arguments.of("1,2,3,1001", 6),
                Arguments.of("//@\n1@2001", 1)
        );
    }
}
