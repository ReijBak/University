import java.util.Random;
import javax.swing.JOptionPane;

public class Partido {
    public Equipo local;
    public Equipo visitante;
    public int golesLocal;
    public int golesVisitante;
    public int minutoPrimerGol;
    public boolean huboPenales = false;
    public String resultadoPenales = "";

    public Partido(Equipo local, Equipo visitante) {
        this.local = local;
        this.visitante = visitante;
    }

    public void jugar() {
        Random rand = new Random();
        golesLocal = rand.nextInt(6);
        golesVisitante = rand.nextInt(6);
        minutoPrimerGol = (golesLocal + golesVisitante > 0) ? rand.nextInt(90) + 1 : Integer.MAX_VALUE;

        local.registrarPartido(golesLocal, golesVisitante, minutoPrimerGol);
        visitante.registrarPartido(golesVisitante, golesLocal, minutoPrimerGol);
    }

    public void jugarGrupo(Equipo local, Equipo visitante) {
        Random rand = new Random();
        JOptionPane.showMessageDialog(null, "Partido entre " + local + " y " + visitante);
        golesLocal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los goles del equipo " + local + ":"));
        golesVisitante = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los goles del equipo " + visitante + ":"));
        if (golesLocal < 0 || golesVisitante < 0) {
            JOptionPane.showMessageDialog(null, "Los goles no pueden ser negativos. Intente de nuevo.");
            jugarGrupo(local, visitante);
            return;
        }
        minutoPrimerGol = (golesLocal + golesVisitante > 0) ? rand.nextInt(90) + 1 : Integer.MAX_VALUE;

        local.registrarPartido(golesLocal, golesVisitante, minutoPrimerGol);
        visitante.registrarPartido(golesVisitante, golesLocal, minutoPrimerGol);
    }

    public void jugarFinal(Equipo local, Equipo visitante) {
        jugarGrupo(local, visitante);
        if (golesLocal == golesVisitante) {
            huboPenales = true;
            Random rand = new Random();
            int penalesLocal = rand.nextInt(6);
            int penalesVisitante = rand.nextInt(6);
            while (penalesLocal == penalesVisitante) {
                penalesLocal += rand.nextInt(2);
                penalesVisitante += rand.nextInt(2);
            }
            resultadoPenales = " (Penales: " + penalesLocal + " - " + penalesVisitante + ")";
        }
    }

    public void mostrarResultado() {
        String resultado = local + " " + golesLocal + " - " + golesVisitante + " " + visitante;
        if (huboPenales) {
            resultado += resultadoPenales;
        }
        JOptionPane.showMessageDialog(null, resultado);
    }

    public String getResultadoFinal() {
        String resultado = local + " "+ + golesLocal + " - " + golesVisitante + " " + visitante;
        if (huboPenales) {
            resultado += resultadoPenales;
        }
        return resultado;
    }
}
