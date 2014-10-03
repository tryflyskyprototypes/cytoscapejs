package jp.levelfive.samples.cytoscape.client;

import com.google.gwt.core.client.JavaScriptObject;



/**
 * cytoscape.jsでpathwayの描写を指定するJSON用
 *
 * 動作確認はしておりません
 *
 * @author admin
 *
 */
public class Elements extends JavaScriptObject {
    // Overlay types always have protected, zero argument constructors.
    protected Elements() {
    }


    public final native Nodes getNodes() /*-{ return this.nodes; }-*/;

    public final native Edges getEdges() /*-{ return this.edges; }-*/;
}
