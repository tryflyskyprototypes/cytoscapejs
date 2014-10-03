package jp.levelfive.samples.cytoscape.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Nodes extends JavaScriptObject {


	protected Nodes(){};

	public final native JsArray<Data> getData() /*-{ return this.data; }-*/;




	static protected class Data extends JavaScriptObject {

		protected Data(){};

		public final native String getId() /*-{ return this.id; }-*/;

		public final native String getName()  /*-{ return this.name; }-*/;
	}

}
