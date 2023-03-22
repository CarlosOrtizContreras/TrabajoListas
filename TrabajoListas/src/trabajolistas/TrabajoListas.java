
package trabajolistas;

import javax.swing.JOptionPane;

public class TrabajoListas {

    public static void main(String[] args) {

        Listas lista1 = new Listas();

        boolean condicion = true;
        int opcion;
        int entrada;
        JOptionPane.showMessageDialog(null,
                "Bienvenido a nuestro menu de Listas, En el cual podras realizar lo siguiente: ");
        do {
            opcion = Integer.parseInt((JOptionPane.showInputDialog("          MENU      \n"
                    + "1. Insertar datos a la lista\n" + "2. Ordenar los datos de la lista\n" + "3. Buscar datos \n"
                    + "4. Mostrar Lista\n" + "5. Operaciones con dos listas\n" + "9. Salir del menu")));
            switch (opcion) {
                case 1:
                    boolean condicion2 = true;
                    do {
                        int opcion2 = Integer.parseInt((JOptionPane
                                .showInputDialog("        SUBMENU       \n" + "1. Insertar al inicio de la lista\n"
                                        + "2. Insertar al Final de la lista\n" + "3. Insertar Ordenado Ascendente\n"
                                        + "4. Insertar Ordenado Descendente\n" + "9. Salir del Submenu")));
                        switch (opcion2) {
                            case 1:
                                entrada = Integer.parseInt(
                                        JOptionPane.showInputDialog("Ingrese el dato que va a agragar a la lista"));
                                lista1.InsertarInicio(entrada);
                                break;
                            case 2:
                                entrada = Integer.parseInt(
                                        JOptionPane.showInputDialog("Ingrese el dato que va a agragar a la lista"));
                                lista1.InsertarFinal(entrada);
                                break;
                            case 3:
                                entrada = Integer.parseInt(
                                        JOptionPane.showInputDialog("Ingrese el dato que va a agragar a la lista"));
                                lista1.OrdenarAscendente();
                                lista1.InsertarOrdenadoAscendente(entrada);
                                break;
                            case 4:
                                entrada = Integer.parseInt(
                                        JOptionPane.showInputDialog("Ingrese el dato que va a agragar a la lista"));
                                lista1.OrdenarDescendente();
                                lista1.InsertarOrdenadoDescendente(entrada);
                                break;
                            case 9:
                                condicion2 = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                                break;
                        }
                    } while (condicion2);
                    break;
                case 2:
                    boolean condicion3 = true;
                    do {
                        int opcion3 = Integer.parseInt(JOptionPane
                                .showInputDialog("        SUBMENU       \n" + "1. Ordenar Lista de forma Ascendente\n"
                                        + "2. Ordenar Lista de forma Descendente\n" + "9. Para salir del submenu"));
                        switch (opcion3) {
                            case 1:
                                lista1.OrdenarAscendente();
                                break;
                            case 2:
                                lista1.OrdenarDescendente();
                                break;
                            case 9:
                                condicion3 = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                                break;
                        }
                    } while (condicion3);
                    break;
                case 3:
                    int reemplazo;
                    boolean condicion4 = true;
                    do {
                        int opcion4 = Integer.parseInt(JOptionPane
                                .showInputDialog("        SUBMENU       \n" + "1. Mostrar Dato\n"
                                        + "2. Reemplazar dato\n" + "3. Eliminar Dato\n" + "9. Para salir del submenu"));
                        switch (opcion4) {
                            case 1:
                                entrada = Integer
                                        .parseInt(JOptionPane.showInputDialog("Ingrese el dato a buscar de la Lista"));
                                lista1.BuscarDato(entrada);
                                break;
                            case 2:
                                entrada = Integer
                                        .parseInt(JOptionPane.showInputDialog("Ingrese el dato a reemplazar"));
                                reemplazo = Integer
                                        .parseInt(JOptionPane.showInputDialog("Ingrese el nuevo dato"));

                                lista1.ReemplazarDato(entrada, reemplazo);
                                break;
                            case 3:
                                entrada = Integer
                                        .parseInt(JOptionPane.showInputDialog("Ingrese el dato a eliminar"));
                                lista1.EliminarDato(entrada);
                                break;
                            case 9:
                                condicion4 = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                                break;
                        }
                    } while (condicion4);
                    break;
                case 4:
                    lista1.MostrarLista();
                    break;
                case 5:
                    int cantidad;
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese la cantidad de datos que va a ingresar a la nueva lista para realizar las operaciones"));
                    Listas lista2 = new Listas();
                    for (int i = 0; i < cantidad; i++) {
                        entrada = Integer
                                .parseInt(JOptionPane.showInputDialog("Ingrese el dato a insertar en la lista"));
                        lista2.InsertarFinal(entrada);
                    }

                    boolean condicion5 = true;
                    do {
                        int opcion5 = Integer.parseInt(JOptionPane
                                .showInputDialog("        SUBMENU       \n"
                                        + " Ten en cuanta que todo dato que no encuentre pareja, devolvera el mismo numero\n"
                                        + "1. Sumar Listas\n" + "2. Restar Listas\n" + "3. Multiplicar Listas\n"
                                        + "4. Dividir Listas\n" + "9. Para salir del submenu"));
                        switch (opcion5) {
                            case 1:
                                Listas suma = new Listas();
                                suma.Suma(lista1, lista2).MostrarLista();
                                break;
                            case 2:
                                Listas resta = new Listas();
                                resta.Resta(lista1, lista2).MostrarLista();
                                break;
                            case 3:
                                Listas multiplicacion = new Listas();
                                multiplicacion.Multiplicacion(lista1, lista2).MostrarLista();
                                break;
                            case 4:
                                Listas division = new Listas();
                                division.Division(lista1, lista2).MostrarLista();
                                break;
                            case 9:
                                condicion5 = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                                break;
                        }
                    } while (condicion5);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Muchas gracias por utilizar nuestro programa");
                    condicion = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                    break;
            }
        } while (condicion);
    }

}
