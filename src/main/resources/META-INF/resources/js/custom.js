var header = "<table id=grid>"+
					"<tr>"+ 
						"<td>Id</td>"+
						"<td>Name</td>"+
						"<td>Phone</td>"+
						"<td>Country</td>"+
						"<td>Country Code</td>"+
						"<td>State</td>"+
					"</tr>";
var footer = "</table>";
var empty = "<tr><td colspan=\"6\"><center> Resultset is empty !</center></td></tr>";

function LoadUP() {
	
	country = typeof $('#selCountry option:selected').val() !== "undefined" ?  $('#selCountry option:selected').val() : "*";
	state =  typeof $('#selState option:selected').val() !== "undefined" ?  $('#selState option:selected').val() : "*";
	
	$("#customersJson").empty();
	table = "";
	
				$.getJSON("http://localhost:8080/customersFiltered/"+country+"/"+state, function(result) {
					table+=header;
					$.each(result, function(key, value) {
						table += 
							"<tr>"+
								"<td>" + value.id + "</td>"+
								"<td>" + value.name + "</td>"+
								"<td>" + value.phone+ "</td>"+
								"<td>" + value.country + "</td>"+
								"<td>" + value.countryCode + "</td>"+
								"<td>" + value.state + "</td>"+
							"</tr>";
					});
					if(result.length==0){
						table+=empty;
					}

					table+=footer;
					
					$("#customersJson").append(table);

				});
				
				
			}


	$(document).ready(LoadUP());			
