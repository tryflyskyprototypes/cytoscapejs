package jp.levelfive.samples.cytoscape.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.levelfive.samples.cytoscape.client.SampleCytoscapeJs;


/**
 * Get送信されたパラメータからjson生成
 * Web画面のボタンごとに違うJSONを生成させる
 *
 * @author admin
 *
 */
public class JsonPathwayData extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	String simbol = req.getParameter("q").trim();


    	//手抜きです。
    	PrintWriter out = resp.getWriter();

    	out.println("  {");
//    	out.println("  elements: {");

    	switch (simbol) {
    	case SampleCytoscapeJs.SYMBOL_1:
        	out.println("    \"nodes\": [");
        	out.println("      { \"data\": { \"id\": \"j\", \"name\": \"Javaaa\" } },");
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
    		break;

    	case SampleCytoscapeJs.SYMBOL_2:
        	out.println("    \"nodes\": [");
        	out.println("      { \"data\": { \"id\": \"g\", \"name\": \"gu\" } },");
        	out.println("      { \"data\": { \"id\": \"c\", \"name\": \"choki\" } },");
        	out.println("      { \"data\": { \"id\": \"p\", \"name\": \"pa\" } }");
        	out.println("    ],");
        	out.println("    \"edges\": [");
        	out.println("      { \"data\": { \"source\": \"g\", \"target\": \"c\" } },");
        	out.println("      { \"data\": { \"source\": \"c\", \"target\": \"p\" } },");
        	out.println("      { \"data\": { \"source\": \"p\", \"target\": \"g\" } }");
        	out.println("    ]");
    		break;

//    	case SampleCytoscapeJs.SYMBOL_3:
//    		break;

    	default:
    		//JSONが空なので、GWTがexceptinを出します
    		break;
    	}



//    	out.println("  };");
    	out.println("  }");
    	out.flush();



    }

}
