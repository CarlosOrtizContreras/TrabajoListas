package trabajolistas;

public class Nodo {
    public Nodo LigaIzquierda;
    public Nodo LigaDerecha;
    public int Dato;

    public Nodo() {
        LigaIzquierda = null;
        LigaDerecha = null;
        Dato = 0;
    }
    
    public Nodo(int entrada) {
        LigaIzquierda = null;
        LigaDerecha = null;
        Dato = entrada;

    }

    public Nodo getLigaIzquierda() {
        return LigaIzquierda;
    }


    public void setLigaIzquierda(Nodo LI) {
        LigaIzquierda = LI;
    }


    public Nodo getLigaDerecha() {
        return LigaDerecha;
    }


    public void setLigaDerecha(Nodo LD) {
        LigaDerecha = LD;
    }


    public int getDato() {
        return Dato;
    }


    public void setDato(int entrada) {
        Dato = entrada;
    }

}
