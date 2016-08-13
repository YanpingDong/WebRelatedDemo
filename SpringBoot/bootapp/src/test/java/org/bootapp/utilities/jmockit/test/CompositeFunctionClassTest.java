package org.bootapp.utilities.jmockit.test;

import mockit.NonStrictExpectations;
import mockit.Verifications;

import org.bootapp.utilities.jmockit.test.BasedFunctionClass;
import org.bootapp.utilities.jmockit.test.CompositeFunctionClass;
import org.junit.Test;

public class CompositeFunctionClassTest {

	@Test
	public void testCompositeFunction() {
		final BasedFunctionClass basedFunctionClass = new BasedFunctionClass();
		
		new NonStrictExpectations(basedFunctionClass) {
			{
				basedFunctionClass.basedFunction("info");
				returns("hi info");
			}
		};
		
		CompositeFunctionClass compositeFunctionClass = new CompositeFunctionClass();
		compositeFunctionClass.setBasedFunctionClass(basedFunctionClass);
		System.out.println(compositeFunctionClass.compositeFunction("info"));
		
		new Verifications() {
			{
				basedFunctionClass.basedFunction("info");
				times = 1;
			}
		};
	}

}