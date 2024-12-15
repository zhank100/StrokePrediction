
package models;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;


class StrokePrediction {

    public static void main(String[] args) {
        try {
        	File currentDir = new File(""); //PlaceHolder
        	System.out.println(currentDir.getAbsolutePath());
            // Step 1: Load and preprocess the dataset
        	String filePath = currentDir.getAbsolutePath() + "\\src\\models\\models\\stroke-data2.csv";
        	System.out.println(filePath);
        		
            Dataset dataset = new Dataset(filePath);
            dataset.preprocess();

            // Step 2: Bootstrap the dataset for Random Forest
            int numTrees = 100;
            RandomForest randomForest = new RandomForest(numTrees);

            randomForest.train(dataset);

            // Step 3: Save the Random Forest
            String RFmodelPath = currentDir.getAbsolutePath() + "\\src\\models\\models\\random_forest_model.dat";
            randomForest.saveForest(RFmodelPath);
            System.out.println("Random Forest model saved to: " + RFmodelPath);

            // Step 4: Load the Random Forest
            RandomForest loadedForest = RandomForest.loadForest(RFmodelPath);
            System.out.println("Random Forest model loaded successfully.");

            // Step 5: Predict stroke risk for a test data point
            Map<String, Double> testData = new HashMap<>();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter age:");
            testData.put("age", input.nextDouble());
            System.out.println("Enter hypertension:");
            testData.put("hypertension", input.nextDouble());
            System.out.println("Enter heart disease:");
            testData.put("heart_disease", input.nextDouble());
            System.out.println("Enter glucose level:");
            testData.put("avg_glucose_level", input.nextDouble());
            System.out.println("Enter bmi:");
            testData.put("bmi", input.nextDouble());
            System.out.println("Enter smoking_status:");
            testData.put("smoking_status",input.nextDouble());

            int prediction = loadedForest.predict(testData);
            System.out.println("Predicted Stroke Risk: " + prediction);
            switch(prediction) {
            case 1 :  System.out.println("You have a low predicted stroke risk!");
            			break;
            case 2 :  System.out.println("You have a moderate risk.");
						break;
            case 3 :  System.out.println("You are at high risk of suffering from a stroke! Please seek advice from a health care professional!");
						break;
            }
           

            // Step 6: Visualize the first decision tree
//            System.out.println("Visualization of the first tree:");
//            loadedForest.printTree(0);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}