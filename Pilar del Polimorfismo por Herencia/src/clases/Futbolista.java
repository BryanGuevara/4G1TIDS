package clases;

public class Futbolista extends Padre {

    int dorsal;
    String Demarcacion;


    
    public void jugarPartido() {

        System.out.println("Jugando Partido ...");
    }

    public void Entrenar() {

        System.out.println("Entrenando ...");
    }

    @Override
    public void Concentrarse() {
        System.out.println("Concentrados los futbolistas");
    }

    @Override
    public void Viajar() {

        System.out.println("Viaje Programado para los Futbolistas");
    }
}
