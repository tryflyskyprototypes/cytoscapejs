package jp.levelfive.samples.cytoscape.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Edges extends JavaScriptObject {

	protected Edges(){};

	public final native JsArray<Data> getData() /*-{ return this.data; }-*/;




	static protected class Data extends JavaScriptObject {

		protected Data(){};

		public final native String getSource() /*-{ return this.source; }-*/;

		public final native String getTarget()  /*-{ return this.target; }-*/;
	}
}
