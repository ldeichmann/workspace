package graph;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by lukas on 4/15/16.
 */
public class Graph {

    Map<String, List<AdjazenzNode>> adjlist;
    List<String> L;
    Map<String, String> farbe;

    public Graph(Map<String, List<AdjazenzNode>> a) {
        adjlist = a;
        L = new LinkedList<>();
        farbe = new HashMap<>();


    }

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public void topoSort() {
        farbe = new HashMap<>();
        for(Map.Entry<String, List<AdjazenzNode>> entry : adjlist.entrySet()) {
            String key = entry.getKey();
            farbe.put(key, "W");
        }
        for(Map.Entry<String, List<AdjazenzNode>> entry : adjlist.entrySet()) {
            String key = entry.getKey();
            if (farbe.get(key).equals("W")) {
                RektTiefensuche(key);
            }
        }
    }

    public void RektTiefensuche(String u) {

        farbe.put(u, "R");
        if (adjlist.containsKey(u)) {
            List<AdjazenzNode> tmp = adjlist.get(u);
            for (AdjazenzNode n : tmp) {
                if (farbe.containsKey(n.getNodeName()) && farbe.get(n.getNodeName()).equals("W")) {
                    RektTiefensuche(n.getNodeName());
                }
            }
        }
        farbe.put(u, "G");
        L.add(0, u);
    }





    public static void main(String args[]) {
        try {
            InputStream in;
            Map<String, List<AdjazenzNode>> Adjazenzliste = new HashMap<>();
            String content = readFile("/home/lukas/Code/workspace/intellij/InformatikII_12/files/graph.txt", StandardCharsets.UTF_8);
            String lines[] = content.split("\\r?\\n");
            String fields[];
            List<AdjazenzNode> ajl;
            AdjazenzNode tmp;
            for (String s : lines) {
                fields = s.split("\\s+");
                if (!Adjazenzliste.containsKey(fields[0])) {
                    ajl = new LinkedList<>();
                    Adjazenzliste.put(fields[0], ajl);

                    tmp = new AdjazenzNode(fields[1], Integer.parseInt(fields[2]));
                    ajl.add(tmp);
                } else {
                    tmp = new AdjazenzNode(fields[1], Integer.parseInt(fields[2]));
                    Adjazenzliste.get(fields[0]).add(tmp);
                }
                if (!Adjazenzliste.containsKey(fields[1])) {
                    ajl = new LinkedList<>();
                    Adjazenzliste.put(fields[1], ajl);
                }
            }
            System.out.println(Adjazenzliste);

            Graph g = new Graph(Adjazenzliste);
            g.topoSort();
            System.out.println(g.L);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
