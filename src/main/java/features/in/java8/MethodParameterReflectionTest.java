package features.in.java8;


import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;
 

class MethodParameterReflectionTest {

	@Test
	public void whenGetConstructorParams_thenOk() throws NoSuchMethodException, SecurityException {

		List<Parameter> parameters = Arrays.asList(Person.class.getConstructor(String.class).getParameters());
		Optional<Parameter> parameter = parameters.stream().filter(Parameter::isNamePresent).findFirst();

		assertSame(parameter.get().getName(), "fullName");
	}

	@Test
	public void whenGetMethodParams_thenOk() throws NoSuchMethodException, SecurityException {

		List<Parameter> parameters = Arrays.asList(Person.class.getMethod("setFullName", String.class).getParameters());
		Optional<Parameter> parameter = parameters.stream().filter(Parameter::isNamePresent).findFirst();

		assertSame(parameter.get().getName(), "fullName");
	}

}
