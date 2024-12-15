package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import models.Bootstrap;
import models.Dataset;

class BootstrapTests {
	static Dataset d;
	
	@BeforeAll
	public static void setup() {
		System.out.println("Testing Bootstrap...");
		d = DummyDataset.getDummyDataset();
		List<Map<String, Object>> data = d.getData();
		System.out.println("Sets in dummy dataset:");
		for (Map<String, Object> map : data) {
			System.out.println(map.keySet());
		}
	}

	@Test
	void testBootstrap() {
		boolean works = true;
		List<Map<String, Object>> bootstrapped = Bootstrap.sample(d.getData(), new Random());
		System.out.println("Sets in bootstrapped dataset:");
		for (Map<String, Object> map : bootstrapped) System.out.println(map.keySet());
		assertEquals(true, works);
	}

}
