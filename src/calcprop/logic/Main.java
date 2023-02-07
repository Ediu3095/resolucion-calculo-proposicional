package calcprop.logic;

import calcprop.form.*;
import calcprop.interpreter.CalculoBasicListener;
import calcprop.interpreter.CalculoLexer;
import calcprop.interpreter.CalculoParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.misc.Triple;
import org.antlr.v4.runtime.tree.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length != 1 && args.length != 2) {
            System.err.println("Uso: java -jar RCP-XX.jar <modo> <archivo>");
            System.err.println("Para mas informacion utilizar: java -jar RCP-XX.jar --help");
            System.exit(1);
        }

        if (args.length == 1 && args[0].equals("--help")) {
            System.out.println("Uso: java -jar RCP-XX.jar <modo> <archivo>");
            System.out.println("\t<modo> puede ser uno de los siguientes: tablero-semantico, resolucion");
            System.out.println("\t<archivo> es la ruta del archivo que contiene la formula a procesar");
            System.exit(0);
        }

        CalculoLexer lexer = new CalculoLexer(CharStreams.fromFileName(args[1], StandardCharsets.UTF_8));
        CalculoParser parser = new CalculoParser(new CommonTokenStream(lexer));

        ParseTree tree = parser.formula();
        CalculoBasicListener listener = new CalculoBasicListener();
        ParseTreeWalker.DEFAULT.walk(listener, tree);

        Formula formula = listener.getFormula();

        if (args[0].equals("tablero-semantico")) {
            // Creamos el grafo
            Nodo nodo = new Nodo(formula);
            nodo.desarrollar();

            // Escribimos el grafo en un fichero .dot
            try (FileWriter fw = new FileWriter(Paths.get(args[1] + ".dot").toFile())) {
                fw.write("digraph G {\n");
                fw.write("    rankdir=TB;\n");
                fw.write("    bgcolor=\"#ffffff\";\n"); // "transparent"
                fw.write(nodo.toGraphviz());
                fw.write("}\n");
            }

            // Utilizamos Graphviz para convertir el .dot a .svg
            String[] c = {"dot", "-Tsvg", "-o", args[1] + ".svg", args[1] + ".dot"};
            Process p = Runtime.getRuntime().exec(c);

            // Eliminamos el fichero .dot
            p.waitFor();
            Files.deleteIfExists(Paths.get(args[1] + ".dot"));
            System.out.println("Hecho!");
        } else if (args[0].equals("resolucion")) {
            System.out.println("Formula: " + formula);
            Formula f1 = formula.toFormaNormalCojuntiva();
            System.out.println("Forma normal conjuntiva: " + f1);
            FormaClausal fc = FormaClausal.fromFormula(f1);
            // System.out.println("Forma clausal: " + fc);
            List<Triple<Clausula, Pair<Integer, Integer>, Integer>> res = fc.resolucion();
            System.out.println("Resolucion: ");
            int i = 0;
            for (Triple<Clausula, Pair<Integer, Integer>, Integer> r : res) {
                System.out.println("" +
                        new Formatter().format("%c %2d. %-20s ", (r.c != null ? '×' : ' '), (i + 1), r.a.toFormula()) +
                        (r.b == null ? "" : new Formatter().format("(%2d, %2d)", r.b.a + 1, r.b.b + 1)) +
                        (r.c == null ? "" : new Formatter().format(" × %2d", r.c + 1))
                );
                if (r.c == null) i++;
            }
        } else {
            System.err.println("Uso: java -jar RCP-XX.jar <modo> <archivo>");
            System.err.println("Para mas informacion utilizar: java -jar RCP-XX.jar --help");
            System.exit(1);
        }
    }
}
