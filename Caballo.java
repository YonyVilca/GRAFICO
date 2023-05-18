import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Caballo extends Thread {
    private final String nombre;
    private final Random random;
    private final List<Long> tiemposCarrera;
    
    public Caballo(String nombre) {
        this.nombre = nombre;
        this.random = new Random();
        this.tiemposCarrera = new ArrayList<>();
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            int tiempoCorriendo = random.nextInt(11) + 10;  // Generar un número aleatorio entre 10 y 20
            int tiempoDescanso = random.nextInt(11) + 10;
            
            System.out.println(nombre + " corriendo: " + tiempoCorriendo + " segundos");
            registrarTiempoInicioCarrera();
            
            try {
                Thread.sleep(tiempoCorriendo * 1000);  // Convertir a milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            registrarTiempoFinCarrera();
            
            System.out.println(nombre + " descansando: " + tiempoDescanso + " segundos");
            
            try {
                Thread.sleep(tiempoDescanso * 1000);  // Convertir a milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void registrarTiempoInicioCarrera() {
        long tiempoInicio = System.currentTimeMillis();
        tiemposCarrera.add(tiempoInicio);
    }
    
    private void registrarTiempoFinCarrera() {
        long tiempoFin = System.currentTimeMillis();
        tiemposCarrera.add(tiempoFin);
    }
    
    public List<Long> getTiemposCarrera() {
        return tiemposCarrera;
    }
    
    public String getNombre() {
        return nombre;
    }
}
