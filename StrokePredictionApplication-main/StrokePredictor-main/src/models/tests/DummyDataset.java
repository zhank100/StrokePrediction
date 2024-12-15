package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Dataset;
import models.Node;

public class DummyDataset {
	
	public static Dataset getDummyDataset() {
		List<Map<String, Object>> sample = new ArrayList<>();
		Map<String, Object> mapOne = new HashMap<>();
		Map<String, Object> mapTwo = new HashMap<>();
		Map<String, Object> mapThree = new HashMap<>();	
		Character cap = 'A';
		Character low = 'a';
		Character num = '0';
		String capStr;
		String lowStr;
		String numStr;
		for (int i = 0; i < 10; i++) {
			capStr = String.valueOf(cap);
			lowStr = String.valueOf(low);
			numStr = String.valueOf(num);
			mapOne.put(capStr, i);
			mapTwo.put(lowStr, i);
			mapThree.put(numStr, i);
			cap++;
			low++;
			num++;
		}		
		sample.add(mapOne);
		sample.add(mapTwo);
		sample.add(mapThree);
		return new Dataset(sample);
	}
	
	public static Node getInternalNode() {
		Node internal =  new Node();
		internal.setLeaf(true);
		return internal;
	}
	
	public static Node getExternalNode() {
		Node dummyNode = new Node();
		dummyNode.setLeft(new Node());
		dummyNode.setRight(new Node());
		return dummyNode;
	}
	
	public static Node getNodeWithData(String feature, double threshold, int prediction) {
		return new Node(feature, threshold, prediction);
	}
}
