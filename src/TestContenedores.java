import javax.swing.JOptionPane;

public class TestContenedores {

    public static void main(String[] args) {
        Contenedor[] CO = new Contenedor[100];
        Mercancia[] ME = new Mercancia[100];
        int j = 0;

        int x = AskQuestion();
        while (x != 0) {
            switch (x) {
                case 1 -> { CreateContenedor(CO, j, ME); j++; }
                case 2 -> ModificarContenedor(CO, j);
                case 3 -> PrintContenedores(CO, j);
                case 4 -> j = VaciarBarco();
            }
            x = AskQuestion();
        }
    }

    private static int AskQuestion(){
        String[] con={"salir", "Crear contenedor", "Modificar contenedor", "listar contenedores", "descargar barco"};
        return JOptionPane.showOptionDialog(null, "Que quieres hacer", "BARCO CAPITÁN ENRIC", 0, JOptionPane.QUESTION_MESSAGE, null, con, "");
    }

    private static void CreateContenedor(Contenedor[] CO, int j, Mercancia[] ME){
        String numserie = JOptionPane.showInputDialog("Numero de serie: ");
        String capacidad = JOptionPane.showInputDialog("Capacidad: ");
        int i = CreateMercancia(ME, numserie);
        String estado;
        String[] s ={"abierto", "cerrado"};
        int state = JOptionPane.showOptionDialog(
                null,
                "¿Cual es el estado del contenedor?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, s,
                "");
        if (state == 0){ estado = "abierto"; }
        else { estado = "cerrado"; } //si hubiere de escribirse podrias poner cualquier palabra

        String[] opciones={"Seco","Refrigerado","Cisterna"};
        int tipo = JOptionPane.showOptionDialog(null, "Tipo de contenedor", "Contenedores", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, "Seco");
        switch (tipo) {
            case 0 -> { String color = JOptionPane.showInputDialog("¿Cual es el color");
                        CO[j] = new ContenedorSeco(numserie, capacidad, estado, color);
                        CO[j].addMercancia(i, ME);}
            case 1 -> { String temperatura = JOptionPane.showInputDialog("¿Cual es la temperatura?");
                        CO[j] = new ContenedorRefrigerado(numserie, capacidad, estado, temperatura);
                        CO[j].addMercancia(i, ME);}
            case 2 -> { String volumen = JOptionPane.showInputDialog("¿Cual es el volumen?");
                        CO[j] = new ContenedorCisterna(numserie, capacidad, estado, volumen);
                        CO[j].addMercancia(i, ME);}
        }
    }

    private static int CreateMercancia(Mercancia[] ME, String numserie) {
        int i = 0;
        int MER = JOptionPane.showConfirmDialog(null, "¿Quieres añadir una mercancia?", "Mercancias", JOptionPane.YES_NO_OPTION);
        String mercancia = "", cantidad = "";
        if ( MER == 0) {
            while (MER != 1) {
                mercancia = JOptionPane.showInputDialog("Añade una mercancia: ");
                cantidad = JOptionPane.showInputDialog("Cantidad: ");
                ME[i] = new Mercancia(numserie, mercancia, cantidad);
                i++;
                MER = JOptionPane.showConfirmDialog(null, "¿Quieres añadir otra mercancia?", "Mercancias", JOptionPane.YES_NO_OPTION);
            }
        }
        else {JOptionPane.showMessageDialog(null, "No has añadido ninguna mercancia");}
        ME[i] = new Mercancia(numserie, mercancia, cantidad);
        return i;
    }

    private static void ModificarContenedor(Contenedor[] CO, int j){
        int z = ElegirContenedor(CO, j);
        //impido que se reviente el programa si selecciona esta opcion sin haber creado un contenedor
        if (j == 0){JOptionPane.showMessageDialog(null, "El barco esta vacio");}
        else {
            String[] x = {"Numero de Serie", "Capacidad", "estado"};
            int y = JOptionPane.showOptionDialog(null, "¿Que quieres modificar?", "Contenedor", 0, JOptionPane.QUESTION_MESSAGE, null, x, "");
            switch (y) {
                case 0 -> { String numserie = JOptionPane.showInputDialog("Numero de Serie: ");
                            CO[z].SetNumSerie(numserie); }
                case 1 -> { String capacidad = JOptionPane.showInputDialog("Capacidad: ");
                            CO[z].SetCapacidad(capacidad); }
                case 2 -> { String estado = JOptionPane.showInputDialog("Estado: ");
                            CO[z].SetEstado(estado); }
            }
        }
    }

    private static int ElegirContenedor(Contenedor[] CO, int j){
        int mod = 1;
        int i = 99;
        if (j == 0){JOptionPane.showMessageDialog(null, "El barco esta vacio");}
        else {
            JOptionPane.showMessageDialog(null, "¿Que contenedor quieres modificar?");
            while (mod != 0) {
                while (i >= j) {
                    i = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero entre 0 y " + j + "este ultimo excluido"));
                }
                JOptionPane.showMessageDialog(null, CO[i].toString());
                mod = JOptionPane.showConfirmDialog(null, "¿Quieres modificar este barco?", "", JOptionPane.YES_NO_OPTION);
                if (mod == 1) {i = 99;}
            }
        }
        return i;
    }

    private static void PrintContenedores(Contenedor[] CO, int j) {
        StringBuilder cadena = new StringBuilder();
        if (j == 0){JOptionPane.showMessageDialog(null, "El barco esta vacio");}
        else {
            for (int i = 0; i < j; i++) {
                cadena.append(CO[i]);
                cadena.append("\n");
                cadena.append("\n");
            }
            JOptionPane.showMessageDialog(null, cadena);
        }
    }

    private static int VaciarBarco(){
        int j = 0;
        JOptionPane.showMessageDialog(null, "Se ha vaciado el barco");
        return j;
    }
}