import javax.swing.JOptionPane;

public class ContainerManager {

    public static void main(String[] args) {
        Container[] containers = new Container[100];
        int numberOfContainers = 0;

        int Option = mainScreen();
        while (Option != 0) {
            switch (Option) {
                case 1 -> { createContainer(containers, numberOfContainers); numberOfContainers++; }
                case 2 -> modifyContainer(containers, numberOfContainers);
                case 3 -> ContainerShow(containers, numberOfContainers);
                case 4 -> numberOfContainers = EmptyBoat();
            }
            Option = mainScreen();
        }
    }

    private static int mainScreen(){
        String[] strings = {
                "EXIT",
                "CREATE CONTAINER",
                "MODIFY CONTAINER",
                "SHOW CONTAINERS",
                "EMPTY BOAT"
        };
        return JOptionPane.showOptionDialog(
                null,
                "SELECT AN OPTION",
                "BOAT CONTAINER MANAGER",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                strings,
                ""
        );
    }

    private static void createContainer(Container[] containers, int numberOfContainers){
        String numContainer = JOptionPane.showInputDialog("CONTAINER NUMBER: ");
        String capacity = JOptionPane.showInputDialog("CAPACITY: ");
        String stateString;
        String[] str ={"OPEN", "CLOSED"};

        int stateInt = JOptionPane.showOptionDialog(
                null,
                "Witch is the state of the container?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, str,
                ""
        );
        if (stateInt == 0){
            stateString = "OPEN";
        } else { stateString = "CLOSED"; }

        String[] options={"DRY","REFRIGERATED","TANK"};
        int type = JOptionPane.showOptionDialog(
                null,
                "TYPE OF CONTAINER",
                "CONTAINERS",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                "Seco"
        );
        switch (type) {
            case 0 -> { String color = JOptionPane.showInputDialog("WITCH IS THE COLOR");
                        containers[numberOfContainers] = new ContainerDry(numContainer, capacity, stateString, color);}
            case 1 -> { String temperature = JOptionPane.showInputDialog("WITCH IS THE TEMPERATURE?");
                        containers[numberOfContainers] = new ContainerRefrigerated(numContainer, capacity, stateString, temperature);}
            case 2 -> { String volume = JOptionPane.showInputDialog("WITCH IS THE VOLUME?");
                        containers[numberOfContainers] = new ContainerTank(numContainer, capacity, stateString, volume);}
        }
    }

    private static void modifyContainer(Container[] containers, int numberOfContainers){
        if (numberOfContainers == 0){
            JOptionPane.showMessageDialog(
                    null,
                    "THE BOAT IS EMPTY");
        }
        else {
            int z = chooseContainer(containers, numberOfContainers);
            String[] optionsArray = {"NUMBER OF CONTAINER", "CAPACITY", "STATE"};
            int question = JOptionPane.showOptionDialog(
                    null,
                    "WANT DO YOU WANT TO MODIFY?",
                    "CONTAINER",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsArray,
                    "");
            switch (question) {
                case 0 -> { String numContainer = JOptionPane.showInputDialog("NUMBER OF CONTAINER: ");
                            containers[z].setNumContainer(numContainer); }
                case 1 -> { String capacity = JOptionPane.showInputDialog("CAPACITY: ");
                            containers[z].setCapacity(capacity); }
                case 2 -> { String state = JOptionPane.showInputDialog("STATE: ");
                            containers[z].setState(state); }
            }
        }
    }

    private static int chooseContainer(Container[] containers, int numberOfContainers){
        int modifyChoice = 1;
        int containerIndex = 99;
        JOptionPane.showMessageDialog(
                null,
                "WITCH CONTAINER DO YOU WANT TO MODIFY?"
        );
        do {
            do {
                containerIndex = Integer.parseInt(JOptionPane.showInputDialog(
                        "ENTER A NUMBER BETWEEN 0 AND " + (numberOfContainers - 1))
                );
            } while (containerIndex < 0 || containerIndex >= numberOfContainers);
            JOptionPane.showMessageDialog(null, containers[containerIndex].toString());
            modifyChoice = JOptionPane.showConfirmDialog(
                    null,
                    "DO YOU WANT TO MODIFY THIS CONTAINER?",
                    "",
                    JOptionPane.YES_NO_OPTION
            );
        } while (modifyChoice == JOptionPane.YES_OPTION);
        return containerIndex;
    }

    private static void ContainerShow(Container[] CO, int numberOfContainers) {
        StringBuilder string = new StringBuilder();
        if (numberOfContainers == 0){
            JOptionPane.showMessageDialog(
                null,
                "THE BOAT IS EMPTY"
            );
        } else {
            for (int i = 0; i < numberOfContainers; i++) {
                string.append(CO[i]);
                string.append("\n");
                string.append("\n");
            }
            JOptionPane.showMessageDialog(
                    null,
                    string
            );
        }
    }

    private static int EmptyBoat(){
        int numberOfContainers = 0;
        JOptionPane.showMessageDialog(
                null,
                "THE BOAT WAS EMPTIED"
        );
        return numberOfContainers;
    }
}