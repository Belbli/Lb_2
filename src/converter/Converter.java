package converter;

import abstractTest.AbstractTest;

public interface Converter<S, T extends AbstractTest> {
    T convert(S source);
}
