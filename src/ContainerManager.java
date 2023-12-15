import javax.swing.JOptionPane;

public class ContainerManager {

    public static void main(String[] args) {
        Container[] CO = new Container[100];
        int numberOfContainers = 0;

        int Option = mainScreen();
        while (Option != 0) {
            switch (Option) {
                case 1 -> { createContainer(CO, numberOfContainers); numberOfContainers++; }
                case 2 -> modifyContainer(CO, numberOfContainers);
                case 3 -> ContainerShow(CO, numberOfContainers);
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

    private static void createContainer(Container[] CO, int numberOfContainers){
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
                        CO[numberOfContainers] = new ContainerDry(numContainer, capacity, stateString, color);}
            case 1 -> { String temperature = JOptionPane.showInputDialog("WITCH IS THE TEMPERATURE?");
                        CO[numberOfContainers] = new ContainerRefrigerated(numContainer, capacity, stateString, temperature);}
            case 2 -> { String volume = JOptionPane.showInputDialog("WITCH IS THE VOLUME?");
                        CO[numberOfContainers] = new ContainerTank(numContainer, capacity, stateString, volume);}
        }
    }

    private static void modifyContainer(Container[] CO, int numberOfContainers){
        if (numberOfContainers == 0){
            JOptionPane.showMessageDialog(
                    null,
                    "THE BOAT IS EMPTY");
        }
        else {
            int z = chooseContainer(CO, numberOfContainers);
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
                            CO[z].setNumContainer(numContainer); }
                case 1 -> { String capacity = JOptionPane.showInputDialog("CAPACITY: ");
                            CO[z].setCapacity(capacity); }
                case 2 -> { String state = JOptionPane.showInputDialog("STATE: ");
                            CO[z].setState(state); }
            }
        }
    }

    private static int chooseContainer(Container[] CO, int numberOfContainers){
        int mod = 1;
        int i = 99;
        if (numberOfContainers == 0){
            JOptionPane.showMessageDialog(
                null,
                "THE BOAT IS EMPTY"
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "WITCH CONTAINER DO YOU WANT TO MODIFY?"
            );
            while (mod != 0) {
                while (i >= numberOfContainers) {
                    i = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    "INPUT A NUMBER BETWEEN 0 AND " + numberOfContainers + " THE LAST ONE EXCLUDED"
                            )
                    );
                }
                JOptionPane.showMessageDialog(
                        null,
                        CO[i].toString()
                );
                mod = JOptionPane.showConfirmDialog(
                        null,
                        "DO YOU WANT TO MODIFY THIS CONTAINER?",
                        "",
                        JOptionPane.YES_NO_OPTION
                );
            }
        }
        return i;
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