import java.util.List;

public class Hipodromo {
    public static void main(String[] args) {
        int numProcesadores = Runtime.getRuntime().availableProcessors();
        System.out.println("Número de procesadores disponibles: " + numProcesadores);
        
        Caballo caballo1 = new Caballo("Caballo 1");
        Caballo caballo2 = new Caballo("Caballo 2");
        Caballo caballo3 = new Caballo("Caballo 3");
        
        caballo1.start();
        caballo2.start();
        caballo3.start();
        
        try {
            caballo1.join();
            caballo2.join();
            caballo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Registros de tiempo de carrera:");
        System.out.println("-------------------------------");
        
        mostrarTiemposCarrera(caballo1);
        mostrarTiemposCarrera(caballo2);
        mostrarTiemposCarrera(caballo3);
    }
    
    private static void mostrarTiemposCarrera(Caballo caballo) {
        List<Long> tiemposCarrera = caballo.getTiemposCarrera();
        System.out.println("Caballo: " + caballo.getNombre());
        
        for (int i = 0; i < tiemposCarrera.size(); i += 2) {
            long tiempoInicio = tiemposCarrera.get(i);
            long tiempoFin = tiemposCarrera.get(i + 1);
            long duracion = tiempoFin - tiempoInicio;
            long procesadorId = Thread.currentThread().getId();
            
            System.out.println("Carrera " + (i / 2 + 1) + ": " + duracion + " ms (Procesador: " + procesadorId + ")");
        }
        
        System.out.println();
        
 
        
        
    }
}
