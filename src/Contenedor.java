public abstract class Contenedor {
    private String numserie, capacidad, estado;
    private final Mercancia[] ME = new Mercancia[100];

    public Contenedor(String numserie, String capacidad, String estado) {
        this.numserie = numserie;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public void addMercancia(int i, Mercancia[] ME) {
        for (int j = 0; j < i; j++) {
            this.ME[j]=ME[j];
        }
    }

    public void SetNumSerie(String numserie){ this.numserie = numserie; }
    public void SetCapacidad(String capacidad){ this.capacidad = capacidad; }
    public void SetEstado(String estado){ this.estado = estado; }

    @Override
    public String toString() {
        return "Numero: " + numserie + "\nCapacidad: " + capacidad + "\nEstado: " + estado;
    }
}
