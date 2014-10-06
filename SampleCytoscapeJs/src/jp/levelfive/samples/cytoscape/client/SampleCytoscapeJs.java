package jp.levelfive.samples.cytoscape.client;

import java.util.Date;
import java.util.Iterator;

import jp.levelfive.samples.cytoscape.shared.FieldVerifier;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.i18n.client.TimeZone;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SampleCytoscapeJs implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	//	private final GreetingServiceAsync greetingService = GWT
	//			.create(GreetingService.class);



	private VerticalPanel mainPanel = new VerticalPanel();

	private HorizontalPanel btnPanel = new HorizontalPanel();
	private Button btn_1 = new Button("ONE");
	private Button btn_2 = new Button("TWO");
	private Button btn_3 = new Button("THREE");
	private Label label_symbol = new Label();
	private Label label_json = new Label();
	private Label label_errMsg = new Label();

	public static final String SYMBOL_1 = "ONE";
	public static final String SYMBOL_2 = "TWO";
	public static final String SYMBOL_3 = "THREE";

	private final String URL_GET_PARAM = "pathway?q=";
	private final String JSON_URL = GWT.getModuleBaseURL() + URL_GET_PARAM;	//TODO URL修正

	@Override
	public void onModuleLoad() {

		btnPanel.add(btn_1);
		btnPanel.add(btn_2);
		btnPanel.add(btn_3);


		mainPanel.add(btnPanel);
		mainPanel.add(label_symbol);
		mainPanel.add(label_json);

		RootPanel.get("gwt").add(mainPanel);



		btn_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				setLavel(SYMBOL_1);
				doGet(SYMBOL_1);

			}
		});

		btn_2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				setLavel(SYMBOL_2);
				doGet(SYMBOL_2);
			}
		});

		btn_3.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				setLavel(SYMBOL_3);
				doGet(SYMBOL_3);
			}
		});
	}







	/**
	 * ボタン(btn_X)をクリックすると呼ばれる
	 * 各ボタンから渡される値を元にJSON取得
	 *
	 * @param symbol
	 */
	 private void doGet(String symbol) {

	      String url = JSON_URL + "+" + symbol;
	      url = URL.encode(url);

	      // Send request to server and catch any errors.
	      RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);

	      try {
	          Request request = builder.sendRequest(null, new RequestCallback() {
	              public void onError(Request request, Throwable exception) {
	                  displayError("Couldn't retrieve JSON");
	              }

	              public void onResponseReceived(Request request,
	                      Response response) {
	                  if (200 == response.getStatusCode()) {

	                	  String json = response.getText();		//JSON取得
	                	  refreshPathwayView(json);

	                  } else {
	                      displayError("Couldn't retrieve JSON ("
	                              + response.getStatusText() + ")");
	                  }
	              }
	          });
	      } catch (RequestException e) {
	          displayError("Couldn't retrieve JSON : " + e.toString());
	      }
	 }







	 /**
	  * JSONを受け取り、pathwayを描写する
	  * .jsに記述したfunctionにjsonの文字列を渡す
	  *
	  * @param json
	  */
	 private final native void refreshPathwayView(String json) /*-{

			$wnd.testload(json);

		//	cy.load(elements);				//↑のjsonは直接渡しても描写される

		//	var cy = $wnd.$("#cy").cytoscape("get");
		//	cy.load(JSON.parse(json));	//GWTから来たjson（文字列）はパースが必要

//	    	return eval(json);
	  }-*/;







	protected void setLavel(String msg) {
		label_symbol.setText(msg);
	}







	  // エラー表示
	  private void displayError(String error) {
	      label_errMsg.setText("Error: " + error);
	      label_errMsg.setVisible(true);
	  }


}
