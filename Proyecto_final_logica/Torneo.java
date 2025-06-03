import java.util.Arrays;
import javax.swing.JOptionPane;

public class Torneo {
    public Equipo[] datos = new Equipo[10];

    public void registrarEquipos() {
    for (int i = 0; i < datos.length; i++) {
        String nombre = "";
        String pais = "";

        while (true) {
            try {
                nombre = JOptionPane.showInputDialog("Nombre del equipo " + (i + 1) + ":");
                
                if (nombre == null) {
                JOptionPane.showMessageDialog(null, "Programa finalizado por el usuario.");
                System.exit(0);
            }
                
                if (nombre == null || nombre.trim().isEmpty())
                    throw new Exception("Nombre vacío");
                nombre = nombre.trim();

                boolean nombreRepetido = false;
                for (int j = 0; j < i; j++) {
                    if (datos[j].getNombre().equalsIgnoreCase(nombre)) {
                        nombreRepetido = true;
                        break;
                    }
                }

                if (nombreRepetido) {
                    JOptionPane.showMessageDialog(null, "Ese equipo ya fue registrado. Intenta con otro nombre.");
                } else {
                    break;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
            }
        }

        while (true) {
            try {
                pais = JOptionPane.showInputDialog("País del equipo " + (i + 1) + ":");
                if (pais == null || pais.trim().isEmpty())
                    throw new Exception("País vacío");
                pais = pais.trim();
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El país no puede estar vacío.");
            }
        }

        datos[i] = new Equipo(nombre, pais);
    }
}

    public void etapaTodosContraTodos() {
        StringBuilder resultados = new StringBuilder("--- Etapa 1: Todos contra todos ---\n");
        for (int i = 0; i < datos.length; i++) {
            for (int j = i + 1; j < datos.length; j++) {
                Partido p = new Partido(datos[i], datos[j]);
                p.jugar();
                resultados.append(datos[i]).append(" ")
                        .append(p.golesLocal).append(" - ")
                        .append(p.golesVisitante).append(" ")
                        .append(datos[j]).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, resultados.toString());
        mostrarTabla();
    }

    public void mostrarTabla() {
        String encabezado = String.format("%-20s %4s %4s %4s %4s", "Equipo", "Pts", "+GF", "-GC", "+/-");
        StringBuilder tabla = new StringBuilder(encabezado + "\n");
        Arrays.sort(datos, (a, b) -> {
            if (b.getPuntos() != a.getPuntos()) return b.getPuntos() - a.getPuntos();
            if (b.getDiferenciaDeGoles() != a.getDiferenciaDeGoles()) return b.getDiferenciaDeGoles() - a.getDiferenciaDeGoles();
            if (b.getGolesAFavor() != a.getGolesAFavor()) return b.getGolesAFavor() - a.getGolesAFavor();
            return a.getPrimerGolMinuto() - b.getPrimerGolMinuto();
        });
        for (Equipo e : datos) {
            tabla.append(String.format("%-20s %4d %4d %4d %4d\n",
                    e.getNombre(), e.getPuntos(), e.getGolesAFavor(), e.getGolesEnContra(), e.getDiferenciaDeGoles()));
        }
        JOptionPane.showMessageDialog(null, tabla.toString());
    }

    public void etapaFaseDeGrupos() {
        JOptionPane.showMessageDialog(null, "--- Etapa 2: Fase de Grupos ---");
        Equipo[] clasificados = Arrays.copyOfRange(datos, 0, 8);
        for (Equipo e : clasificados) {
            e.guardarEstadisticasFase1();
            e.resetEstadisticas();
        }

        Equipo[] grupoA = {clasificados[1], clasificados[3], clasificados[5], clasificados[7]};
        Equipo[] grupoB = {clasificados[0], clasificados[2], clasificados[4], clasificados[6]};

        Equipo finalistaA = jugarGrupo("Grupo A", grupoA);
        Equipo finalistaB = jugarGrupo("Grupo B", grupoB);

        Partido finalPartido = new Partido(finalistaA, finalistaB);
        finalPartido.jugarFinal(finalistaA, finalistaB);

        String resultadoFinal = "--- Final ---\n" + finalPartido.getResultadoFinal();
        JOptionPane.showMessageDialog(null, resultadoFinal);

        Equipo campeon = finalPartido.golesLocal > finalPartido.golesVisitante ? finalistaA : finalistaB;

        String estadisticas = "\uD83C\uDFC6 CAMPEÓN DEL TORNEO \uD83C\uDFC6\n\n" +
            "Nombre: " + campeon.getNombre() + "\n\n" +
            "[Fase 1 - Todos contra todos]\n" +
            "Puntos: " + campeon.puntosFase1 + "\n\n" +
             
            "[Fase 2 - Grupos y Final]\n" +
             "Goles a favor: " + campeon.getGolesAFavor() + "\n";
        JOptionPane.showMessageDialog(null, estadisticas);
    }

    public Equipo jugarGrupo(String nombre, Equipo[] grupo) {
        StringBuilder resultados = new StringBuilder(nombre + "\n");
        for (int i = 0; i < grupo.length; i++) {
            for (int j = i + 1; j < grupo.length; j++) {
                Partido p = new Partido(grupo[i], grupo[j]);
                p.jugarGrupo(grupo[i], grupo[j]);
                resultados.append(grupo[i]).append(" ")
                        .append(p.golesLocal).append(" - ")
                        .append(p.golesVisitante).append(" ")
                        .append(grupo[j]).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, resultados.toString());
        Arrays.sort(grupo, (a, b) -> {
            if (b.getPuntos() != a.getPuntos()) return b.getPuntos() - a.getPuntos();
            if (b.getDiferenciaDeGoles() != a.getDiferenciaDeGoles()) return b.getDiferenciaDeGoles() - a.getDiferenciaDeGoles();
            if (b.getGolesAFavor() != a.getGolesAFavor()) return b.getGolesAFavor() - a.getGolesAFavor();
            return a.getPrimerGolMinuto() - b.getPrimerGolMinuto();
        });

        String encabezado = String.format("%-20s %4s %4s %4s %4s", "Equipo", "Pts", "+GF", "-GC", "+/-");
        StringBuilder tabla = new StringBuilder(nombre + " - Tabla de posiciones\n\n" + encabezado + "\n");
        for (Equipo e : grupo) {
            tabla.append(String.format("%-20s %4d %4d %4d %4d\n",
                    e.getNombre(), e.getPuntos(), e.getGolesAFavor(), e.getGolesEnContra(), e.getDiferenciaDeGoles()));
        }
        JOptionPane.showMessageDialog(null, tabla.toString());

        return grupo[0];
    }
}
