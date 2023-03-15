package trabajolistas;

import javax.swing.JOptionPane;

public class Listas {
    Nodo Punta;
    Nodo Final;

    /**
     * @param Listas Este constructor permite agregar valores iniciales a un objeto
     *               creado con la clase lista
     * @param Final  Este nodo en el constructor, por defecto sera "null"
     * @param Punta  Este nodo en el constructor, por defecto sera "null"
     */
    public Listas() {
        Punta = null;
        Final = null;
    }

    /**
     * @param InsertarInicio Esta Funcion permite añadir un elemento a una lista en
     *                       la primera posicion de la misma.
     * @param entrada        Este parametro de entrada a esta funcion, es el dato
     *                       tipo entero que se va a agregar a la lista.
     * @param posicion       Esta variable, permite ubicar el inicio de la lista, en
     *                       caso de que se mueva la punta, dicha lista no se pierda
     * @param Final          Esta variable tipo Nodo permite ubicar el fin de la
     *                       lista
     * @param Punta          Esta variable tipo Nodo permite Ubicar el inicio de
     *                       dicha lista
     * @param nuevo          Esta variable tipo Nodo es el nuevo objeto creado que
     *                       se va a agregar a la lista
     */
    public void InsertarInicio(int entrada) {
        Nodo posicion;
        Nodo nuevo = new Nodo(entrada);
        if (Punta == null) {
            Punta = nuevo;
            Final = Punta;
            Punta.setLigaDerecha(Punta);
            Punta.setLigaIzquierda(Punta);
        } else {
            posicion = Punta;
            Punta = nuevo;
            Final.setLigaDerecha(Punta);
            Punta.setLigaIzquierda(Final);
            Punta.setLigaDerecha(posicion);
            posicion.setLigaIzquierda(Punta);
        }

    }

    /**
     * @param InsertarFinal Esta funcion permite ingresar datos a la lista en la
     *                      ultima posicion
     * @param entrada       Es el atributo que va a tener la funcion como entrada de
     *                      datos tipo enteros para agregar a la lista
     * @param nuevo         Es el nuevo objeto o nodo que se crea para agregar a la
     *                      lista
     * @param posicion      Esta variable tipo nodo, permite recorrer la lista,
     *                      hasta encontrar el ultimo nodo o la ultima posicion y
     *                      alli insertar el valor
     * @param Punta         Esta variable tipo nodo Indica el nodo de inicio de la
     *                      lista
     * @param Final         Esta VARIABLE TIPO nodo Indica el nodo final de la lista
     */
    public void InsertarFinal(int entrada) {
        Nodo posicion;
        Nodo nuevo = new Nodo(entrada);

        if (Punta == null) {
            Punta = nuevo;
            Final = Punta;
            Punta.setLigaDerecha(Punta);
            Punta.setLigaIzquierda(Punta);
        } else {
            posicion = Punta;

            while (posicion.getLigaDerecha() != Punta) {
                posicion = posicion.getLigaDerecha();
            }
            Final = nuevo;
            posicion.setLigaDerecha(Final);
            Final.setLigaIzquierda(posicion);
            Final.setLigaDerecha(Punta);
            Punta.setLigaIzquierda(Final);
        }
    }

    public void InsertarOrdenadoAscendente(int entrada) {

    }

    public void SumaListas() {

    }

    public void OrdenarAscendente() {
        if (Punta == null) {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } else {
            Nodo posicion1;
            Nodo posicion2;
            Nodo auxiliar;
            Nodo auxiliar2;
            Nodo auxiliar3;
            Nodo auxiliar4;
            posicion1 = Punta;
            while (posicion1.getLigaDerecha() != null) {
                posicion2 = posicion1.getLigaDerecha();
                boolean condicion = true;
                while (condicion) {
                    if (posicion2.getDato() <= posicion1.getDato()) {
                        auxiliar = posicion2.getLigaIzquierda();
                        auxiliar2 = posicion2.getLigaDerecha();
                        auxiliar.setLigaDerecha(posicion2.getLigaDerecha());
                        auxiliar2.setLigaIzquierda(posicion2.getLigaIzquierda());
                        if (Punta == posicion1) {
                            auxiliar3 = posicion1;
                            posicion1 = posicion2;
                            posicion1.setLigaDerecha(auxiliar3);
                            posicion1.setLigaIzquierda(null);
                            auxiliar3.setLigaIzquierda(posicion1);
                            Punta = posicion1;
                            posicion2 = auxiliar;

                            /*
                             * Punta = posicion2;
                             * posicion2.setLigaDerecha(posicion1);
                             * posicion2.setLigaIzquierda(null);
                             * posicion1.setLigaIzquierda(posicion2);
                             */
                        } else {
                            auxiliar3 = posicion1;
                            posicion1 = posicion2;
                            posicion1.setLigaDerecha(auxiliar3);
                            posicion1.setLigaIzquierda(auxiliar3.getLigaIzquierda());
                            auxiliar.setLigaIzquierda(posicion1);
                            auxiliar4 = posicion1.getLigaIzquierda();
                            auxiliar4.setLigaDerecha(posicion1);
                            posicion2 = auxiliar;

                            /*
                             * posicion2.setLigaIzquierda(posicion1.getLigaIzquierda());
                             * posicion2.setLigaDerecha(posicion1);
                             * posicion1.setLigaIzquierda(posicion2);
                             */
                        }
                    }
                    if (posicion2.getLigaDerecha() == null) {
                        condicion = false;
                    } else {
                        posicion2 = posicion2.getLigaDerecha();

                    }
                }
                posicion1 = posicion1.getLigaDerecha();

            }
        }
    }

    
    public void MostrarLista() {
        if (Punta != null) {
            String salida = " ";
            Nodo posicion = Punta;
            do{
                salida = salida + " | " + posicion.getDato() + " | ";
                posicion = posicion.getLigaDerecha();
            }
            while(posicion != Punta);
            JOptionPane.showMessageDialog(null, salida);
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }
}
