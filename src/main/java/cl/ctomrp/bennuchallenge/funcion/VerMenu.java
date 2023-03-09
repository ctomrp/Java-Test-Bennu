package cl.ctomrp.bennuchallenge.funcion;

public final class VerMenu {

    protected String[] menu = {
        "||- MENU DE OPCIONES -||",
        "Generar un archivo",
        "Leer archivo generado",
        "Ordenar archivo",
        "Leer archivo ordenado",
        "Buscar número en archivo",
        "Salir"
    };

    public void verMenu() {
        for (int i = 0; i < menu.length; i++) {
            if (i > 0) {
                System.out.println(i + ") " + menu[i]);
            } else {
                System.out.println(menu[i]);
            }
        }
    }

}
