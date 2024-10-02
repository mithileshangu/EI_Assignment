import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private SmartHomeHub hub;

    // GUI Components
    private JTextArea statusArea; // To display status updates
    private JComboBox<String> deviceSelector; // Dropdown to select device
    private JComboBox<String> commandSelector; // Dropdown to select command
    private JTextField timeField; // To input time for scheduling
    private JTextField temperatureField; // To input temperature for a trigger

    public Main() {
        hub = new SmartHomeHub();

        // Create devices and add them to the hub
        Device light1 = new DeviceProxy(DeviceFactory.createDevice("light", 1, null));
        Device thermostat1 = new DeviceProxy(DeviceFactory.createDevice("thermostat", 2, 70));
        Device doorLock1 = new DeviceProxy(DeviceFactory.createDevice("door", 3, null));

        hub.addDevice(light1);
        hub.addDevice(thermostat1);
        hub.addDevice(doorLock1);

        // Set up the GUI
        JFrame frame = new JFrame("Smart Home System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Text area for status updates
        statusArea = new JTextArea();
        statusArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(statusArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel for command input
        JPanel commandPanel = new JPanel();
        commandPanel.setLayout(new GridLayout(5, 2));

        // Dropdown for selecting devices
        deviceSelector = new JComboBox<>(new String[]{"Select Device", "1 - Light", "2 - Thermostat", "3 - Door Lock"});
        commandPanel.add(new JLabel("Select Device:"));
        commandPanel.add(deviceSelector);

        // Dropdown for selecting commands
        commandSelector = new JComboBox<>(new String[]{"Select Command", "Turn On", "Turn Off", "Set Schedule", "Add Trigger"});
        commandPanel.add(new JLabel("Select Command:"));
        commandPanel.add(commandSelector);

        // Input fields for additional command parameters
        timeField = new JTextField();
        commandPanel.add(new JLabel("Time (for Schedule):"));
        commandPanel.add(timeField);

        temperatureField = new JTextField();
        commandPanel.add(new JLabel("Temperature (for Trigger):"));
        commandPanel.add(temperatureField);

        // Button to execute command
        JButton executeButton = new JButton("Execute Command");
        commandPanel.add(executeButton);
        frame.add(commandPanel, BorderLayout.NORTH);

        // Button action: Process the user's selected command
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand();
            }
        });

        // Finalize frame
        frame.setVisible(true);
    }

    // Method to execute the selected command based on user input
    private void executeCommand() {
        int selectedDeviceId = deviceSelector.getSelectedIndex(); // Get selected device
        String selectedCommand = (String) commandSelector.getSelectedItem(); // Get selected command
        String time = timeField.getText().trim(); // Get the time input
        String temperature = temperatureField.getText().trim(); // Get the temperature input

        if (selectedDeviceId == 0 || selectedCommand == null || selectedCommand.equals("Select Command")) {
            statusArea.append("Please select a valid device and command.\n");
            return;
        }

        // Execute the command based on user's selection
        switch (selectedCommand) {
            case "Turn On":
                hub.turnOnDevice(selectedDeviceId);
                break;
            case "Turn Off":
                hub.turnOffDevice(selectedDeviceId);
                break;
            case "Set Schedule":
                if (!time.isEmpty()) {
                    hub.setSchedule(selectedDeviceId, time, "Turn On");
                    statusArea.append("Scheduled Task: Device ID: " + selectedDeviceId + ", Time: " + time + ", Command: Turn On\n");
                } else {
                    statusArea.append("Please enter a time for scheduling.\n");
                }
                break;
            case "Add Trigger":
                if (!temperature.isEmpty()) {
                    hub.addTrigger("temperature > " + temperature, "turnOff(" + selectedDeviceId + ")");
                    statusArea.append("Automated Trigger: Condition: temperature > " + temperature + ", Action: turnOff(" + selectedDeviceId + ")\n");
                } else {
                    statusArea.append("Please enter a temperature for the trigger.\n");
                }
                break;
            default:
                statusArea.append("Unknown command.\n");
        }

        // Display status, scheduled tasks, and automated triggers
        displayStatus();
    }

    // Method to display device statuses, scheduled tasks, and triggers with separators
    private void displayStatus() {
        StringBuilder statusReport = new StringBuilder();
        for (Device device : hub.getDevices()) {
            statusReport.append(device.getStatus()).append("\n");
        }
        statusArea.append("\n----- Status Report -----\n");
        statusArea.append(statusReport.toString());

        statusArea.append("\n----- Scheduled Tasks -----\n");
        statusArea.append(hub.getScheduledTasks() + "\n");

        statusArea.append("\n----- Automated Triggers -----\n");
        statusArea.append(hub.getAutomatedTriggers() + "\n");
        statusArea.append("\n-----------------------------\n");
    }

    public static void main(String[] args) {
        new Main();
    }
}
