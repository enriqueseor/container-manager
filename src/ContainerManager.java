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
        int i = CreateMercancia(ME, numContainer);
        String estado;
        String[] s ={"OPEN", "CLOSED"};

        int state = JOptionPane.showOptionDialog(
                null,
                "¿Cual es el estado del contenedor?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, s,
                ""
        );
        if (state == 0){
            estado = "abierto";
        } else { estado = "cerrado"; }

        String[] opciones={"Seco","Refrigerado","Cisterna"};
        int tipo = JOptionPane.showOptionDialog(
                null,
                "Tipo de contenedor",
                "Contenedores",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                "Seco"
        );
        switch (tipo) {
            case 0 -> { String color = JOptionPane.showInputDialog("¿Cual es el color");
                        CO[j] = new ContainerDry(numContainer, capacity, estado, color);
                        CO[j].addMerchandise(i, ME);}
            case 1 -> { String temperatura = JOptionPane.showInputDialog("¿Cual es la temperatura?");
                        CO[j] = new ContainerRefrigerated(numContainer, capacity, estado, temperatura);
                        CO[j].addMerchandise(i, ME);}
            case 2 -> { String volumen = JOptionPane.showInputDialog("¿Cual es el volumen?");
                        CO[j] = new ContainerTank(numContainer, capacity, estado, volumen);
                        CO[j].addMerchandise(i, ME);}
        }
    }

    private static int CreateMercancia(Merchandise[] ME, String numserie) {
        int i = 0;
        int MER = JOptionPane.showConfirmDialog(
                null,
                "¿Quieres añadir una mercancia?",
                "Mercancias",
                JOptionPane.YES_NO_OPTION
        );
        String mercancia = "", cantidad = "";
        if ( MER == 0) {
            while (MER != 1) {
                mercancia = JOptionPane.showInputDialog("Añade una mercancia: ");
                cantidad = JOptionPane.showInputDialog("Cantidad: ");
                ME[i] = new Merchandise(numserie, mercancia, cantidad);
                i++;
                MER = JOptionPane.showConfirmDialog(
                        null,
                        "¿Quieres añadir otra mercancia?",
                        "Mercancias",
                        JOptionPane.YES_NO_OPTION
                );
            }
        }
        else {JOptionPane.showMessageDialog(null, "No has añadido ninguna mercancia");}
        ME[i] = new Merchandise(numserie, mercancia, cantidad);
        return i;
    }

    private static void ContainerModify(Container[] CO, int j){
        int z = ElegirContenedor(CO, j);
        //impido que se reviente el programa si selecciona esta opcion sin haber creado un contenedor
        if (j == 0){JOptionPane.showMessageDialog(null, "El barco esta vacio");}
        else {
            String[] x = {"Numero de Serie", "Capacidad", "estado"};
            int y = JOptionPane.showOptionDialog(null, "¿Que quieres modificar?", "Contenedor", 0, JOptionPane.QUESTION_MESSAGE, null, x, "");
            switch (y) {
                case 0 -> { String numserie = JOptionPane.showInputDialog("Numero de Serie: ");
                            CO[z].setNumContainer(numserie); }
                case 1 -> { String capacidad = JOptionPane.showInputDialog("Capacidad: ");
                            CO[z].setCapacity(capacidad); }
                case 2 -> { String estado = JOptionPane.showInputDialog("Estado: ");
                            CO[z].setState(estado); }
            }
        }
    }

    private static int ElegirContenedor(Container[] CO, int j){
        int mod = 1;
        int i = 99;
        if (j == 0){
            JOptionPane.showMessageDialog(
                null,
                "El barco esta vacio"
            );
        }
        else {
            JOptionPane.showMessageDialog(
                    null,
                    "¿Que contenedor quieres modificar?"
            );
            while (mod != 0) {
                while (i >= j) {
                    i = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    "Introduce un numero entre 0 y " + j + "este ultimo excluido"
                            )
                    );
                }
                JOptionPane.showMessageDialog(
                        null,
                        CO[i].toString()
                );
                mod = JOptionPane.showConfirmDialog(
                        null,
                        "¿Quieres modificar este barco?",
                        "",
                        JOptionPane.YES_NO_OPTION
                );
                if (mod == 1) {i = 99;}
            }
        }
        return i;
    }

    private static void ContainerShow(Container[] CO, int j) {
        StringBuilder cadena = new StringBuilder();
        if (j == 0){
            JOptionPane.showMessageDialog(
                null,
                "El barco esta vacio"
            );
        }
        else {
            for (int i = 0; i < j; i++) {
                cadena.append(CO[i]);
                cadena.append("\n");
                cadena.append("\n");
            }
            JOptionPane.showMessageDialog(
                    null,
                    cadena
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