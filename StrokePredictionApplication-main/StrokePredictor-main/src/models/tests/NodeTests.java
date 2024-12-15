package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import models.Node;

class NodeTests {
	static Node internalNode;
	static Node externalNode;

	@BeforeAll
	public static void setup() {
		internalNode = DummyDataset.getInternalNode();
		externalNode = DummyDataset.getExternalNode();
	}
	
	@Test
	void testExternallNode() {
		assertEquals(true, externalNode.getLeft() != null && externalNode.getRight() != null);
	}
	
	@Test
	void testInternalNode() {
		assertEquals(true, internalNode.getLeft() == null && internalNode.getRight() == null);
	}
	
	@Test
	void testNodeData() {
		String feature = "feature";
		double threshold = 1.0;
		int prediction = 1;
		Node node = DummyDataset.getNodeWithData(feature, threshold, prediction);
		assertEquals(feature, node.getFeature());
		assertEquals(threshold, node.getThreshold());
		assertEquals(prediction, node.getPrediction());
	}
	
}
