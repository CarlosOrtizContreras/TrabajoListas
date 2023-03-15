
package trabajolistas;

import javax.swing.JOptionPane;

public class TrabajoListas {

    public static void main(String[] args) {
        boolean condicion = true;
        int opcion;
        JOptionPane.showMessageDialog(null,
                "Vienvenido a nuestro menu de Listas, En el cual podras realizar lo siguiente: ");
        do {
            opcion = Integer.parseInt((JOptionPane.showInputDialog("          MENU      \n" + "1. Insertar datos a la lista\n" + "2. Ordenar los datos de la lista\n" + "3. Buscar datos \n" + "4. Mostrar Lista\n" + "5. Operaciones con dos listas\n" + "9. Salir del menu")));
            switch (opcion) {
                case 1:
                    boolean condicion2 = true;
                    do {
                        int opcion2 = Integer.parseInt((JOptionPane.showInputDialog("        SUBMENU       \n" + "1. Insertar al inicio de la lista\n" + "2. Insertar al Final de la lista\n" + "3. Insertar Ordenado Ascendente\n" + "4. Insertar Ordenado Descendente\n" + "9. Salir del Submenu")));
                        switch (opcion2) {
                            case 1:
                            case 9:
                                condicion2 = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                                break;
                        }
                        break;
                    } while (condicion2);
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
