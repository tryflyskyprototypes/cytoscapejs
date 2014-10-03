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

	private final String SYMBOL_1 = "ONE";
	private final String SYMBOL_2 = "TWO";
	private final String SYMBOL_3 = "THREE";

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






	private static final String JSON_URL = GWT.getModuleBaseURL() + "pathway?q=";	//TODO URL修正

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
//	                      updateTable(asArrayOfStockData(response.getText()));

	                	  String json = response.getText();
	                	  asArrayOfPathwayData(json);

//	                	  Elements elements = JsonUtils.safeEval(response.getText());
//	                	  updateTable(asArrayOfPathwayData(elements));
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

	 //	 private final native Elements asArrayOfPathwayData(Elements json) /*-{
	 private final native JsArray<Elements> asArrayOfPathwayData(String json) /*-{

			var javaele = {
			    nodes: [
			      { data: { id: 'j', name: 'java1' } },
			      { data: { id: 'e', name: 'Elaine' } },
			      { data: { id: 'k', name: 'Kramer' } },
			      { data: { id: 'g', name: 'George' } }
			    ],
			    edges: [
			      { data: { source: 'j', target: 'e' } },
			      { data: { source: 'j', target: 'k' } },
			      { data: { source: 'j', target: 'g' } },
			      { data: { source: 'e', target: 'j' } },
			      { data: { source: 'e', target: 'k' } },
			      { data: { source: 'k', target: 'j' } },
			      { data: { source: 'k', target: 'e' } },
			      { data: { source: 'k', target: 'g' } },
			      { data: { source: 'g', target: 'j' } }
			    ]
			  };

			var javaele2 = json;


//			$wnd.alert(json);
//			$wnd.alert(javaele2);

			var cy = $wnd.$("#cy").cytoscape("get");
//			$wnd.alert(cy.width());
			cy.load(json);
//			cy.load(javaele);

//			$wnd.testload(json);
//			$wnd.testload(javaele);


//	    	return eval(json);
	  }-*/;





	  /**
	   * Update the Price and Change fields all the rows in the stock table.
	   *
	   * @param pathways Stock data for all rows.
	   */
	 /* private void updateTable(StockPrice[] prices) {
	    for (int i = 0; i < prices.length; i++) {
	      updateTable(prices[i]);
	    }

	    // Display timestamp showing last refresh.
	    lastUpdatedLabel.setText("Last update : "  + DateTimeFormat.getMediumDateTimeFormat().format(new Date()));

	    // ここまで処理がくれば、エラーは発生していない
	    // エラーメッセージ領域を非表示にする
	    errorMsgLabel.setVisible(false);
	  }*/
//	  private void updateTable(JsArray<Elements> pathways) {
//	      // テーブルの更新処理
//	      for (int i = 0; i < pathways.length(); i++) {
//	          updateTable(pathways.get(i));
//	      }
//	  }





	  private void updateTable(Elements elements) {

//		  label_json.setText(elements.toString());
//		  label_json.setText(elements.getNodes().getData().get(0).getName());
	  }


	/**
	   * Update a single row in the stock table.
	   *
	   * @param price Stock data for a single row.
	   */
	//  private void updateTable(StockPrice price) {
//	  private void updateTable(StockData price) {
//	    // Make sure the stock is still in the stock table.
//	    if (!stocks.contains(price.getSymbol())) {
//	      return;
//	    }
//
//	    int row = stocks.indexOf(price.getSymbol()) + 1;
//
//	    // Format the data in the Price and Change fields.
//	    String priceText = NumberFormat.getFormat("#,##0.00").format(
//	        price.getPrice());
//	    NumberFormat changeFormat = NumberFormat.getFormat("+#,##0.00;-#,##0.00");
//	    String changeText = changeFormat.format(price.getChange());
//	    String changePercentText = changeFormat.format(price.getChangePercent());
//
//	    // Populate the Price and Change fields with new data.
//	    stocksFlexTable.setText(row, 1, priceText);
//	    stocksFlexTable.setText(row, 2, changeText + " (" + changePercentText
//	        + "%)");
//	  }






	protected void setLavel(String msg) {
		label_symbol.setText(msg);
	}






	  // エラー表示
	  private void displayError(String error) {
	      label_errMsg.setText("Error: " + error);
	      label_errMsg.setVisible(true);
	  }


}
