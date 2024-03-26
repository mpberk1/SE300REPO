import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Aircraft {
    private String tailNumber;
    private Map<String, Component> components;

    public Aircraft(String tailNumber) {
        this.tailNumber = tailNumber;
        components = new HashMap<>();
    }

    public void addComponent(String componentName) {
        components.put(componentName, new Component(componentName));
    }

    public Component getComponent(String componentName) {
        return components.get(componentName);
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public Map<String, Component> getComponents() {
        return components;
    }
}

class Component {
    private String componentName;
    private List<File> partFiles;

    public Component(String componentName) {
        this.componentName = componentName;
        partFiles = new ArrayList<>();
        File directory = new File(componentName.toLowerCase()); // Assuming directory names are lowercase
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    partFiles.add(file);
                }
            }
        }
    }

    public String getComponentName() {
        return componentName;
    }

    public List<File> getPartFiles() {
        return partFiles;
    }
}

public class AircraftSystem {
    private static Map<String, Aircraft> aircrafts = new HashMap<>();

    public static void main(String[] args) {
        // Sample aircrafts
        Aircraft aircraft1 = new Aircraft("N12345");
        aircraft1.addComponent("Fuselage");
        aircraft1.addComponent("Empennage");
        aircraft1.addComponent("Engine");
        aircraft1.addComponent("Wings");
        aircrafts.put(aircraft1.getTailNumber(), aircraft1);

        // Search for aircraft
        searchAircraft();
    }

    public static void searchAircraft() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the tail number of the aircraft:");
            String tailNumber = scanner.nextLine();
            Aircraft aircraft = aircrafts.get(tailNumber);
            if (aircraft != null) {
                System.out.println("Aircraft found with tail number: " + aircraft.getTailNumber());
                System.out.println("Select a component:");
                int index = 1;
                for (String componentName : aircraft.getComponents().keySet()) {
                    System.out.println(index + ". " + componentName);
                    index++;
                }
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                String selectedComponentName = null;
                switch (choice) {
                    case 1:
                        selectedComponentName = "Fuselage";
                        break;
                    case 2:
                        selectedComponentName = "Empennage";
                        break;
                    case 3:
                        selectedComponentName = "Engine";
                        break;
                    case 4:
                        selectedComponentName = "Wings";
                        break;
                    default:
                        System.out.println("Invalid selection.");
                        return;
                }
                Component selectedComponent = aircraft.getComponent(selectedComponentName);
                if (selectedComponent != null) {
                    System.out.println("Selected Component: " + selectedComponent.getComponentName());
                    displayParts(selectedComponent);
                } else {
                    System.out.println("Component not found.");
                }
            } else {
                System.out.println("Aircraft not found with tail number: " + tailNumber);
            }
        }
    }

    public static void displayParts(Component component) {
        List<File> partFiles = component.getPartFiles();
        if (!partFiles.isEmpty()) {
            System.out.println("Available parts for " + component.getComponentName() + ":");
            for (int i = 0; i < partFiles.size(); i++) {
                System.out.println((i + 1) + ". " + partFiles.get(i).getName());
            }
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter the number of the part you want to see:");
                int partChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                if (partChoice >= 1 && partChoice <= partFiles.size()) {
                    File selectedPartFile = partFiles.get(partChoice - 1);
                    try (BufferedReader reader = new BufferedReader(new FileReader(selectedPartFile))) {
                        System.out.println("Details of " + selectedPartFile.getName() + ":");
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    }
                } else {
                    System.out.println("Invalid part selection.");
                }
            }
        } else {
            System.out.println("No parts available for " + component.getComponentName());
        }
    }
}
