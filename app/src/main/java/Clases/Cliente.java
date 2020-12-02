package Clases;

public class Cliente
{
    private String id;
    private String IngreseNombre2;
    private String IngreseDestino;
    private String IngresePromocion;

    public Cliente()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIngreseNombre2() {
        return IngreseNombre2;
    }

    public void setIngreseNombre2(String ingreseNombre2) {
        IngreseNombre2 = ingreseNombre2;
    }

    public String getIngreseDestino() {
        return IngreseDestino;
    }

    public void setIngreseDestino(String ingreseDestino) {
        IngreseDestino = ingreseDestino;
    }

    public String getIngresePromocion() {
        return IngresePromocion;
    }

    public void setIngresePromocion(String ingresePromocion) {
        IngresePromocion = ingresePromocion;
    }

    @Override
    public String toString() {
        return "Cliente =" + "Nombre ='" + IngreseNombre2 ;
    }
}
