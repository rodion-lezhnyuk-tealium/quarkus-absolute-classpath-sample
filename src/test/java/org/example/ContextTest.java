package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class ContextTest {

	@Test
	void testContextLoads() {
		Assertions.assertTrue(true);
	}
}
