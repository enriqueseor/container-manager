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

    private static void createContainer(Container[] CO, int j){
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
                        CO[j] = new ContainerDry(numContainer, capacity, stateString, color);}
            case 1 -> { String temperature = JOptionPane.showInputDialog("WITCH IS THE TEMPERATURE?");
                        CO[j] = new ContainerRefrigerated(numContainer, capacity, stateString, temperature);}
            case 2 -> { String volume = JOptionPane.showInputDialog("WITCH IS THE VOLUME?");
                        CO[j] = new ContainerTank(numContainer, capacity, stateString, volume);}
        }
    }

    private static void modifyContainer(Container[] CO, int j){
        int z = chooseContainer(CO, j);
        if (j == 0){
            JOptionPane.showMessageDialog(
                    null,
                    "THE BOAT IS EMPTY");
        }
        else {
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

    private static int chooseContainer(Container[] CO, int j){
        int mod = 1;
        int i = 99;
        if (j == 0){
            JOptionPane.showMessageDialog(
                null,
                "THE BOAT IS EMPTY"
            );
        }
        else {
            JOptionPane.showMessageDialog(
                    null,
                    "WITCH CONTAINER DO YOU WANT TO MODIFY?"
            );
            while (mod != 0) {
                while (i >= j) {
                    i = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    "INPUT A NUMBER BETWEEN 0 AND " + j + " THE LAST ONE EXCLUDED"
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
                if (mod == 1) {i = 99;}
            }
        }
        return i;
    }

    private static void ContainerShow(Container[] CO, int j) {
        StringBuilder string = new StringBuilder();
        if (j == 0){
            JOptionPane.showMessageDialog(
                null,
                "THE BOAT IS EMPTY"
            );
        }
        else {
            for (int i = 0; i < j; i++) {
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
        int j = 0;
        JOptionPane.showMessageDialog(
                null,
                "THE BOAT WAS EMPTIED"
        );
        return j;
    }
}