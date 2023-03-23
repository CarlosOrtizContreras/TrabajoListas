package trabajolistas;

import javax.swing.JOptionPane;

public class Listas {
    public Nodo Punta;
    public Nodo Final;

    public Listas() {
        Punta = null;
        Final = null;
    }

    public void InsertarInicio(int entrada) {
        Nodo posicion;
        Nodo nuevo = new Nodo(entrada);
        if (Punta == null) {
            Punta = nuevo;
            Punta.setLigaDerecha(Punta);
            Punta.setLigaIzquierda(Punta);
            Final = Punta;
        } else {
            posicion = Punta;
            Punta = nuevo;
            Final.setLigaDerecha(Punta);
            Punta.setLigaIzquierda(Final);
            Punta.setLigaDerecha(posicion);
            posicion.setLigaIzquierda(Punta);
        }

    }

    public void InsertarOrdenadoAscendente(int entrada) {
        Nodo nuevo = new Nodo(entrada);
        Nodo posicion;
        Nodo auxiliar;
        if (Punta == null) {
            Punta = nuevo;
            Punta.setLigaDerecha(Punta);
            Punta.setLigaIzquierda(Punta);
            Final = Punta;
        } else {
            posicion = Punta;
            while (posicion.getDato() <= entrada && posicion.getLigaDerecha() != Punta) {
                posicion = posicion.getLigaDerecha();
            }
            if (posicion == Punta) {
                Punta = nuevo;
                Punta.setLigaDerecha(posicion);
                Punta.setLigaIzquierda(Final);
                Final.setLigaDerecha(Punta);
                posicion.setLigaIzquierda(Punta);
            } else if (posicion == Final) {
                Final = nuevo;
                Final.setLigaDerecha(Punta);
                Final.setLigaIzquierda(posicion);
                posicion.setLigaDerecha(Final);
                Punta.setLigaIzquierda(Final);
            } else {
                auxiliar = posicion.getLigaIzquierda();
                auxiliar.setLigaDerecha(nuevo);
                nuevo.setLigaIzquierda(auxiliar);
                nuevo.setLigaDerecha(posicion);
                posicion.setLigaIzquierda(nuevo);
            }
        }
    }

    public void InsertarOrdenadoDescendente(int entrada) {
        Nodo nuevo = new Nodo(entrada);
        Nodo posicion;
        Nodo auxiliar;
        if (Punta == null) {
            Punta = nuevo;
            Punta.setLigaDerecha(Punta);
            Punta.setLigaIzquierda(Punta);
            Final = Punta;
        } else {
            posicion = Punta;
            while (posicion.getDato() >= entrada && posicion.getLigaDerecha() != Punta) {
                posicion = posicion.getLigaDerecha();
            }
            if (posicion == Punta) {
                Punta = nuevo;
                Punta.setLigaDerecha(posicion);
                Punta.setLigaIzquierda(Final);
                Final.setLigaDerecha(Punta);
                posicion.setLigaIzquierda(Punta);
            } else if (posicion == Final) {
                Final = nuevo;
                Final.setLigaDerecha(Punta);
                Final.setLigaIzquierda(posicion);
                posicion.setLigaDerecha(Final);
                Punta.setLigaIzquierda(Final);
            } else {
                auxiliar = posicion.getLigaIzquierda();
                auxiliar.setLigaDerecha(nuevo);
                nuevo.setLigaIzquierda(auxiliar);
                nuevo.setLigaDerecha(posicion);
                posicion.setLigaIzquierda(nuevo);
            }
        }
    }

    public void InsertarFinal(int entrada) {
        Nodo posicion;
        Nodo nuevo = new Nodo(entrada);

        if (Punta == null) {
            Punta = nuevo;
            Punta.setLigaDerecha(Punta);
            Punta.setLigaIzquierda(Punta);
            Final = Punta;
        } else {
            posicion = Final;
            Final = nuevo;
            posicion.setLigaDerecha(Final);
            Final.setLigaIzquierda(posicion);
            Final.setLigaDerecha(Punta);
            Punta.setLigaIzquierda(Final);
        }
    }

    public void OrdenarAscendente() {
        if (Punta == null) {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } else {
            Nodo posicion;
            Nodo posicion2;
            Nodo auxiliar;
            Nodo auxiliar2;
            Nodo auxiliar3;
            posicion = Punta;
            while (posicion.getLigaDerecha() != Punta) {
                posicion2 = posicion.getLigaDerecha();
                while (posicion2.getDato() >= posicion.getDato() && posicion2 != Punta) {
                    posicion2 = posicion2.getLigaDerecha();
                }
                if (posicion2 != Punta) {
                    auxiliar = posicion2.getLigaIzquierda();
                    auxiliar2 = posicion2.getLigaDerecha();
                    auxiliar.setLigaDerecha(auxiliar2);
                    auxiliar2.setLigaIzquierda(auxiliar);
                    if (posicion == Punta) {
                        posicion2.setLigaDerecha(Punta);
                        posicion2.setLigaIzquierda(Final);
                        Punta = posicion2;
                        posicion.setLigaIzquierda(Punta);
                        Final.setLigaDerecha(Punta);
                        posicion = Punta;
                    } else {
                        if (posicion2 == Final) {
                            Final = auxiliar;
                        }
                        posicion2.setLigaDerecha(posicion);
                        auxiliar3 = posicion.getLigaIzquierda();
                        posicion2.setLigaIzquierda(auxiliar3);
                        posicion.setLigaIzquierda(posicion2);
                        auxiliar3.setLigaDerecha(posicion2);
                        posicion = posicion2.getLigaIzquierda()
                        ;
                        ;
                    }
                }
                if (posicion2 == Punta) {
                    posicion2 = Punta.getLigaDerecha();
                    posicion = posicion.getLigaDerecha();
                } else {
                    posicion2 = posicion2.getLigaDerecha();
                }
            }
        }
    }

    public void BuscarDato(int entrada) {
        Nodo posicion;
        boolean condicion = true;
        boolean condicion2 = false;
        if (Punta == null) {
            JOptionPane.showMessageDialog(null, "La lista esta vacia, imposible buscar");
        } else {
            posicion = Punta;
            do {
                if (posicion.getDato() == entrada) {
                    JOptionPane.showMessageDialog(null, "El dato si esta en la Lista");
                    condicion = false;
                    condicion2 = true;
                }
                
                if (posicion.getLigaDerecha() == Punta && condicion2 == false) {
                    posicion = null;
                }else {
                    posicion = posicion.getLigaDerecha();
                }

                if (posicion == null){
                    JOptionPane.showMessageDialog(null, "El Dato no esta en la lista");
                    condicion = false;
                }

            } while (condicion);
        }

    }

    public void MostrarLista() {
        if (Punta != null) {
            String salida = " ";
            Nodo posicion = Punta;
            do {
                salida = salida + " | " + posicion.getDato() + " | ";
                posicion = posicion.getLigaDerecha();
            } while (posicion != Punta);
            JOptionPane.showMessageDialog(null, salida);
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }

    public void ReemplazarDato(int entrada, int reemplazo) {
        Nodo posicion;
        boolean condicion = true;
        boolean condicion2 = true;

        if (Punta == null) {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } else {
            posicion = Punta;
            do {
                if (entrada == posicion.getDato()) {
                    posicion.setDato(reemplazo);
                    condicion = false;
                    condicion2 = false;
                }
                posicion = posicion.getLigaDerecha();
                if (posicion == Punta && condicion2 == true) {
                    JOptionPane.showMessageDialog(null, "El dato que se desea reemplazar no existe");
                    condicion = false;
                }
            } while (condicion);
        }
    }

    public void EliminarDato(int entrada) {
        Nodo posicion;
        Nodo auxiliar;
        Nodo auxiliar2;
        boolean condicion3 = false;

        if (Punta == null) {
            JOptionPane.showMessageDialog(null, "La Lista esta vacida");

        } else {

            boolean condicion1 = true;

            if (Punta == null) {
                JOptionPane.showMessageDialog(null, "La lista esta vacia, imposible buscar");
            } else {
                posicion = Punta;
                do {
                    if (posicion.getDato() == entrada) {
                        JOptionPane.showMessageDialog(null, "El dato si esta en la Lista");
                        condicion1 = false;
                        condicion3 = true;
                    }
                    posicion = posicion.getLigaDerecha();
                    if (posicion == Punta) {
                        JOptionPane.showMessageDialog(null, "El Dato no esta en la lista");
                        condicion1 = false;
                    }

                } while (condicion1);
            }

            if (condicion3) {

                posicion = Punta;
                boolean condicion = true;
                do {
                    if (posicion.getDato() == entrada) {
                        if (posicion.getLigaDerecha() == Punta && posicion.getLigaIzquierda() == Punta) {
                            Punta = null;
                            condicion = false;
                        } else if (posicion == Punta) {
                            auxiliar2 = posicion.getLigaDerecha();
                            posicion.setLigaDerecha(null);
                            posicion.setLigaIzquierda(null);
                            Punta = auxiliar2;
                            Punta.setLigaIzquierda(Final);
                            Final.setLigaDerecha(Punta);
                            condicion = false;
                        } else if (posicion == Final) {
                            auxiliar = Final.getLigaIzquierda();
                            posicion.setLigaDerecha(null);
                            posicion.setLigaIzquierda(null);
                            Final = auxiliar;
                            Final.setLigaDerecha(Punta);
                            Punta.setLigaIzquierda(Final);
                            condicion = false;
                        } else {
                            auxiliar = posicion.getLigaIzquierda();
                            auxiliar2 = posicion.getLigaDerecha();
                      
                            posicion.setLigaDerecha(null);
                            posicion.setLigaIzquierda(null);
                            auxiliar.setLigaDerecha(auxiliar2);
                            auxiliar2.setLigaIzquierda(auxiliar);
                            condicion = false;
                        }
                        posicion = posicion.getLigaDerecha();
                        if (posicion == Punta) {
                            JOptionPane.showMessageDialog(null, "El dato a eliminar no se encuentra en la lista");
                            condicion = false;
                        }
                    }
                } while (condicion);
            }
        }
    }

    public void OrdenarDescendente() {
        if (Punta == null) {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } else {
            Nodo posicion;
            Nodo posicion2;
            Nodo auxiliar;
            Nodo auxiliar2;
            Nodo auxiliar3;
            posicion = Punta;
            while (posicion.getLigaDerecha() != Punta) {
                posicion2 = posicion.getLigaDerecha();
                while (posicion2.getDato() <= posicion.getDato() && posicion2 != Punta) {
                    posicion2 = posicion2.getLigaDerecha();
                }
                if (posicion2 != Punta) {
                    auxiliar = posicion2.getLigaIzquierda();
                    auxiliar2 = posicion2.getLigaDerecha();
                    auxiliar.setLigaDerecha(auxiliar2);
                    auxiliar2.setLigaIzquierda(auxiliar);
                    if (posicion == Punta) {
                        posicion2.setLigaDerecha(Punta);
                        posicion2.setLigaIzquierda(Final);
                        Punta = posicion2;
                        posicion.setLigaIzquierda(Punta);
                        Final.setLigaDerecha(Punta);
                        posicion = Punta;
                    } else {
                        if (posicion2 == Final) {
                            Final = auxiliar;
                        }
                        posicion2.setLigaDerecha(posicion);
                        auxiliar3 = posicion.getLigaIzquierda();
                        posicion2.setLigaIzquierda(auxiliar3);
                        posicion.setLigaIzquierda(posicion2);
                        auxiliar3.setLigaDerecha(posicion2);
                        posicion = posicion2.getLigaIzquierda();
                    }
                }
                if (posicion2 == Punta) {
                    posicion2 = Punta.getLigaDerecha();
                    posicion = posicion.getLigaDerecha();
                } else {
                    posicion2 = posicion2.getLigaDerecha();
                }
            }
        }
    }

    public Listas Suma(Listas L1, Listas L2) {
        Listas Lista3 = new Listas();
        Nodo posicion = L1.Punta;
        Nodo posicion2 = L2.Punta;

        if (posicion == null && posicion2 == null) {
            JOptionPane.showMessageDialog(null, "Las Listas estan vacidas");

        } else {
            do {
                if (posicion != null && posicion2 != null) {
                    Lista3.InsertarFinal(posicion.getDato() + posicion2.getDato());
                }
                if (posicion != null && posicion2 == null) {
                    Lista3.InsertarFinal(posicion.getDato());
                } else if (posicion2 != null && posicion == null) {
                    Lista3.InsertarFinal(posicion2.getDato());
                }
                if (posicion == null && posicion2 != null) {
                    posicion2 = posicion2.getLigaDerecha();
                } else if (posicion2 == null && posicion != null) {
                    posicion = posicion.getLigaDerecha();
                } else {
                    posicion = posicion.getLigaDerecha();
                    posicion2 = posicion2.getLigaDerecha();
                }

                if (posicion == L1.Punta) {
                    posicion = null;
                }
                if (posicion2 == L2.Punta) {
                    posicion2 = null;
                }
            } while ((posicion != null) || (posicion2 != null));

        }
        return Lista3;
    }

    public Listas Resta(Listas L1, Listas L2) {
        Listas Lista3 = new Listas();
        Nodo posicion = L1.Punta;
        Nodo posicion2 = L2.Punta;

        if (posicion == null && posicion2 == null) {
            JOptionPane.showMessageDialog(null, "Las Listas estan vacidas");

        } else {
            do {
                if (posicion != null && posicion2 != null) {
                    Lista3.InsertarFinal(posicion.getDato() - posicion2.getDato());
                }
                if (posicion != null && posicion2 == null) {
                    Lista3.InsertarFinal(posicion.getDato());
                } else if (posicion2 != null && posicion == null) {
                    Lista3.InsertarFinal(-posicion2.getDato());
                }
                if (posicion == null && posicion2 != null) {
                    posicion2 = posicion2.getLigaDerecha();
                } else if (posicion2 == null && posicion != null) {
                    posicion = posicion.getLigaDerecha();
                } else {
                    posicion = posicion.getLigaDerecha();
                    posicion2 = posicion2.getLigaDerecha();
                }

                if (posicion == L1.Punta) {
                    posicion = null;
                }
                if (posicion2 == L2.Punta) {
                    posicion2 = null;
                }
            } while ((posicion != null) || (posicion2 != null));

        }
        return Lista3;
    }

    public Listas Multiplicacion(Listas L1, Listas L2) {
        Listas Lista3 = new Listas();
        Nodo posicion = L1.Punta;
        Nodo posicion2 = L2.Punta;

        if (posicion == null && posicion2 == null) {
            JOptionPane.showMessageDialog(null, "Las Listas estan vacidas");

        } else {
            do {
                if (posicion != null && posicion2 != null) {
                    Lista3.InsertarFinal(posicion.getDato() * posicion2.getDato());
                }
                if (posicion != null && posicion2 == null) {
                    Lista3.InsertarFinal(posicion.getDato());
                } else if (posicion2 != null && posicion == null) {
                    Lista3.InsertarFinal(posicion2.getDato());
                }
                if (posicion == null && posicion2 != null) {
                    posicion2 = posicion2.getLigaDerecha();
                } else if (posicion2 == null && posicion != null) {
                    posicion = posicion.getLigaDerecha();
                } else {
                    posicion = posicion.getLigaDerecha();
                    posicion2 = posicion2.getLigaDerecha();
                }

                if (posicion == L1.Punta) {
                    posicion = null;
                }
                if (posicion2 == L2.Punta) {
                    posicion2 = null;
                }
            } while ((posicion != null) || (posicion2 != null));

        }
        return Lista3;
    }

    public Listas Division(Listas L1, Listas L2) {
        Listas Lista3 = new Listas();
        Nodo posicion = L1.Punta;
        Nodo posicion2 = L2.Punta;

        if (posicion == null && posicion2 == null) {
            JOptionPane.showMessageDialog(null, "Las Listas estan vacidas");

        } else {
            do {
                if (posicion != null && posicion2 != null) {
                    Lista3.InsertarFinal(posicion.getDato() / posicion2.getDato());
                }
                if (posicion != null && posicion2 == null) {
                    Lista3.InsertarFinal(posicion.getDato());
                } else if (posicion2 != null && posicion == null) {
                    Lista3.InsertarFinal(posicion2.getDato());
                }
                if (posicion == null && posicion2 != null) {
                    posicion2 = posicion2.getLigaDerecha();
                } else if (posicion2 == null && posicion != null) {
                    posicion = posicion.getLigaDerecha();
                } else {
                    posicion = posicion.getLigaDerecha();
                    posicion2 = posicion2.getLigaDerecha();
                }

                if (posicion == L1.Punta) {
                    posicion = null;
                }
                if (posicion2 == L2.Punta) {
                    posicion2 = null;
                }
            } while ((posicion != null) || (posicion2 != null));

        }
        return Lista3;
    }
}
