import javax.swing.JOptionPane;

public class ContainerManager {

    public static void main(String[] args) {
        Container[] CO = new Container[100];
        Merchandise[] ME = new Merchandise[100];
        int numberOfBoats = 0;

        int Option = AskQuestion();
        while (Option != 0) {
            switch (Option) {
                case 1 -> { ContainerCreate(CO, numberOfBoats, ME); numberOfBoats++; }
                case 2 -> ContainerModify(CO, numberOfBoats);
                case 3 -> ContainerShow(CO, numberOfBoats);
                case 4 -> numberOfBoats = EmptyBoat();
            }
            Option = AskQuestion();
        }
    }

    private static int AskQuestion(){
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

    private static void ContainerCreate(Container[] CO, int j, Merchandise[] ME){
        String numContainer = JOptionPane.showInputDialog("CONTAINER NUMBER: ");
        String capacity = JOptionPane.showInputDialog("CAPACITY: ");
        int i = CreateMerchandise(ME, numContainer);
        String stateString;
        String[] s ={"OPEN", "CLOSED"};

        int stateInt = JOptionPane.showOptionDialog(
                null,
                "Witch is the state of the container?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, s,
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
                        CO[j] = new ContainerDry(numContainer, capacity, stateString, color);
                        CO[j].addMerchandise(i, ME);}
            case 1 -> { String temperature = JOptionPane.showInputDialog("WITCH IS THE TEMPERATURE?");
                        CO[j] = new ContainerRefrigerated(numContainer, capacity, stateString, temperature);
                        CO[j].addMerchandise(i, ME);}
            case 2 -> { String volume = JOptionPane.showInputDialog("WITCH IS THE VOLUME?");
                        CO[j] = new ContainerTank(numContainer, capacity, stateString, volume);
                        CO[j].addMerchandise(i, ME);}
        }
    }

    private static int CreateMerchandise(Merchandise[] ME, String numContainer) {
        int i = 0;
        int MER = JOptionPane.showConfirmDialog(
                null,
                "DO YOU WANT TO ADD A MERCHANDISE?",
                "MERCHANDISES",
                JOptionPane.YES_NO_OPTION
        );
        String merchandise = "", quantity = "";
        if ( MER == 0) {
            while (MER != 1) {
                merchandise = JOptionPane.showInputDialog("ADD A MERCHANDISE: ");
                quantity = JOptionPane.showInputDialog("QUANTITY: ");
                ME[i] = new Merchandise(numContainer, merchandise, quantity);
                i++;
                MER = JOptionPane.showConfirmDialog(
                        null,
                        "DO YOU WANT TO ADD ANOTHER MERCHANDISE?",
                        "MERCHANDISES",
                        JOptionPane.YES_NO_OPTION
                );
            }
        }
        else {JOptionPane.showMessageDialog(null, "YOU HAVE NOT ADDED ANY MERCHANDISE");}
        ME[i] = new Merchandise(numContainer, merchandise, quantity);
        return i;
    }

    private static void ContainerModify(Container[] CO, int j){
        int z = chooseContainer(CO, j);
        if (j == 0){
            JOptionPane.showMessageDialog(
                    null,
                    "THE BOAT IS EMPTY");
        }
        else {
            String[] x = {"NUMBER OF BOAT", "CAPACITY", "STATE"};
            int question = JOptionPane.showOptionDialog(
                    null,
                    "WANT DO YOU WANT TO MODIFY?",
                    "CONTAINER",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, x,
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
                                    "INPUT A NUMBER BETWEEN 0 AND " + j + "THE LAST ONE EXCLUDED"
                            )
                    );
                }
                JOptionPane.showMessageDialog(
                        null,
                        CO[i].toString()
                );
                mod = JOptionPane.showConfirmDialog(
                        null,
                        "DO YOU WANT TO MODIFY THUS BOAT?",
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