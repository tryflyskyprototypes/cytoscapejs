package jp.levelfive.samples.cytoscape.server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Get送信されたパラメータからjson生成
 *
 * @author admin
 *
 */
public class JsonPathwayData extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


    	PrintWriter out = resp.getWriter();

//    	out.println("  elements: {");
    	out.println("  {");
    	out.println("    \"nodes\": [");
    	out.println("      { \"data\": { \"id\": \"j\", \"name\": \"Jerry\" } },");
    	out.println("      { \"data\": { \"id\": \"e\", \"name\": \"Elaine\" } },");
    	out.println("      { \"data\": { \"id\": \"k\", \"name\": \"Kramer\" } },");
    	out.println("      { \"data\": { \"id\": \"g\", \"name\": \"George\" } }");
    	out.println("    ],");
    	out.println("    \"edges\": [");
    	out.println("      { \"data\": { \"source\": \"j\", \"target\": \"e\" } },");
    	out.println("      { \"data\": { \"source\": \"j\", \"target\": \"k\" } },");
    	out.println("      { \"data\": { \"source\": \"j\", \"target\": \"g\" } },");
    	out.println("      { \"data\": { \"source\": \"e\", \"target\": \"j\" } },");
    	out.println("      { \"data\": { \"source\": \"e\", \"target\": \"k\" } },");
    	out.println("      { \"data\": { \"source\": \"k\", \"target\": \"j\" } },");
    	out.println("      { \"data\": { \"source\": \"k\", \"target\": \"e\" } },");
    	out.println("      { \"data\": { \"source\": \"k\", \"target\": \"g\" } },");
    	out.println("      { \"data\": { \"source\": \"g\", \"target\": \"j\" } }");
    	out.println("    ]");
//    	out.println("  };");
    	out.println("  }");


//    	out.println("elements: {");
////    	out.println("{");
//    	out.println(" nodes: [");
//    	out.println("  { \"data\": { \"id\": 'g', \"name\": 'guu' } },");
//    	out.println("  { \"data\": { \"id\": 'c', \"name\": 'choki' } },");
//    	out.println("  { \"data\": { \"id\": 'p', \"name\": 'paa' } }");
//    	out.println(" ]");
//    	out.println("}");



    	out.flush();



    }

}
