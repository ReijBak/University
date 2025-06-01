import javax.swing.JOptionPane;

public class Equipo {
    public String nombre;
    public String pais;
    public int puntos;
    public int golesAFavor;
    public int golesEnContra;
    public int primerGolMinuto = Integer.MAX_VALUE;

    public int puntosFase1;
    public int golesAFavorFase1;
    public int golesEnContraFase1;
    public int primerGolMinutoFase1 = Integer.MAX_VALUE;

    public Equipo(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getNombre() { return nombre; }
    public int getPuntos() { return puntos; }
    public int getGolesAFavor() { return golesAFavor; }
    public int getGolesEnContra() { return golesEnContra; }
    public int getDiferenciaDeGoles() { return golesAFavor - golesEnContra; }
    public int getPrimerGolMinuto() { return primerGolMinuto; }

    public void registrarPartido(int golesAFavor, int golesEnContra, int minutoPrimerGol) {
        this.golesAFavor += golesAFavor;
        this.golesEnContra += golesEnContra;

        if (golesAFavor > golesEnContra) puntos += 3;
        else if (golesAFavor == golesEnContra) puntos += 1;

        if (golesAFavor > 0 && minutoPrimerGol < primerGolMinuto) {
            primerGolMinuto = minutoPrimerGol;
        }
    }

    public void guardarEstadisticasFase1() {
        puntosFase1 = puntos;
        golesAFavorFase1 = golesAFavor;
        golesEnContraFase1 = golesEnContra;
        primerGolMinutoFase1 = primerGolMinuto;
    }

    public void resetEstadisticas() {
        puntos = 0;
        golesAFavor = 0;
        golesEnContra = 0;
        primerGolMinuto = Integer.MAX_VALUE;
    }

    public void imprimirEstadisticas() {
        String mensaje = String.format("%-20s %4d %4d %4d %4d",
            nombre, puntos, golesAFavor, golesEnContra, getDiferenciaDeGoles());
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @Override
    public String toString() {
        return nombre + " (" + pais + ")";
    }
}