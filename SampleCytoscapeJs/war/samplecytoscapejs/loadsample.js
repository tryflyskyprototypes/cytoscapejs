//var jsele = {
//			    nodes: [
//			      { data: { id: 'j', name: 'js1' } },
//			      { data: { id: 'e', name: 'Elaine' } },
//			      { data: { id: 'k', name: 'Kramer' } },
//			      { data: { id: 'g', name: 'George' } }
//			    ],
//			    edges: [
//			      { data: { source: 'j', target: 'e' } },
//			      { data: { source: 'j', target: 'k' } },
//			      { data: { source: 'j', target: 'g' } },
//			      { data: { source: 'e', target: 'j' } },
//			      { data: { source: 'e', target: 'k' } },
//			      { data: { source: 'k', target: 'j' } },
//			      { data: { source: 'k', target: 'e' } },
//			      { data: { source: 'k', target: 'g' } },
//			      { data: { source: 'g', target: 'j' } }
//			    ]
//			  };



function testload(elements) {
//	alert("testload()");
//	alert(elements);
	var cy = $("#cy").cytoscape("get");
//	cy.load(elements);
	cy.load(JSON.parse(elements));
};