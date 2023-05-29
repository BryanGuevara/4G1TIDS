package clases;

public class Entrenador extends Padre {

    int idFederacion;

    public void DirigirPartido() {

        System.out.println("Dirigiendo el Partido");
    }

    public void DirijgirEntrenamiento() {

        System.out.println("Dirigiendo el Entrenamiento ...");
    }

    @Override
    public void Concentrarse() {

        System.out.println("Concentrados los Entrenadores");
    }

    @Override
    public void Viajar() {
        System.out.println("Viaje Programado para los Entrenador");
    }
}
