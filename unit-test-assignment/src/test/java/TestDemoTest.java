import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.spy;

class TestDemoTest {

	private TestDemo testDemo = new TestDemo();
	
	
	@BeforeEach
	void setUp() throws Exception {
		 TestDemo testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	 void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
		} else {
			assertThatThrownBy (() -> 
				
				testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
				
		} 
	}
	static Stream <Arguments> argumentsForAddPositive() {
		//@formatter: off
		return Stream.of(
		
		arguments (3, 3, 6, false),
		arguments (32, 4, 36, false),
		arguments (100, 250, 350, false),
		arguments (0, 4, 0, true),
		arguments (-2, 8, 0, true),
		arguments (-22, -10, 0, true),
		arguments (952, -31, 0, true)
		
		);
		//@formatter:on
	
	}

	@Test
	 void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared =mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	
	
	
}
