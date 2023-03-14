package trabajolistas;

import javax.swing.JOptionPane;

public class Listas {
    Nodo Punta;

    public Listas() {
        Punta = null;
    }

    /**
     * @param InsertarInicio Esta Funcion permite añadir un elemento a una lista en
     *                       la primera posicion de la misma.
     * @param entrada        Este parametro de entrada a esta funcion, es el dato
     *                       tipo entero que se va a agregar a la lista.
     * @param posicion       Esta variable, permite ubicar el inicio de la lista, en
     *                       caso de que se mueva la punta, dicha lista no se pierda
     */
    public void InsertarInicio(int entrada) {
        Nodo posicion;
        Nodo nuevo = new Nodo(entrada);
        if (Punta == null) {
            Punta = nuevo;
        } else {
            posicion = Punta;
            Punta = nuevo;
            nuevo.setLigaDerecha(posicion);
            posicion.setLigaIzquierda(nuevo);
        }
    }

    public void InsertarFinal(int entrada){
        Nodo posicion;
        Nodo nuevo = new Nodo (entrada);

        if (Punta == null){
            Punta = nuevo;
        } else{
            posicion = Punta;
            while (posicion.getLigaDerecha()!= null){
                posicion = posicion.getLigaDerecha();
            }
            posicion.setLigaDerecha(nuevo);
            nuevo.setLigaIzquierda(posicion);
        }
    } 

    public void OrdenarAscendente (Listas lis){
        if (lis.Punta == null){
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }else{
            Nodo posicion1;
            Nodo posicion2;
            Nodo auxiliar;
            posicion1 = Punta;
            while (posicion1.getLigaDerecha()!= null){
                posicion2 = posicion1.getLigaDerecha();
                    while(posicion2.getLigaDerecha()!= null){
                        if(posicion2.getDato()< posicion1.getDato()){
                            
                        }
                    }
            }
        }
    }

    public void MostrarLista() {
        if (Punta != null) {
            String salida = " ";
            for (Nodo p = Punta; p != null; p.getLigaDerecha()) {
                salida = salida + " | " + p.getDato() + " | ";
            }
            JOptionPane.showMessageDialog(null, salida);
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }
}
