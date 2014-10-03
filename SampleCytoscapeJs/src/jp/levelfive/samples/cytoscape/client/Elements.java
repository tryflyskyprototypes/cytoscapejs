package jp.levelfive.samples.cytoscape.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Elements extends JavaScriptObject {
    // Overlay types always have protected, zero argument constructors.
    protected Elements() {
    }


    public final native Nodes getNodes() /*-{ return this.nodes; }-*/;



    // JSNI methods to get stock data.
//    public final native String getSymbol() /*-{ return this.symbol; }-*/;
//
//    public final native double getPrice() /*-{ return this.price; }-*/;
//
//    public final native double getChange() /*-{ return this.change; }-*/;
//
//    // Non-JSNI method to return change percentage. // [4]
//    public final double getChangePercent() {
//        return 100.0 * getChange() / getPrice();
//    }
}
