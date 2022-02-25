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
var pageSize = 10;

function LoadUP(page) {
	
	

	country = typeof $('#selCountry option:selected').val() !== "undefined" ?  $('#selCountry option:selected').val() : "*";
	state =  typeof $('#selState option:selected').val() !== "undefined" ?  $('#selState option:selected').val() : "*";
	
	$("#customersJson").empty();
	table = "";
	
				$.getJSON("http://localhost:8080/customersFiltered/"+country+"/"+state+"/"+ page +"/"+ pageSize, function(result) {
					table+=header;
					$.each(result.pageList, function(key, value) {
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
					if(result.pageList.length==0){
						table+=empty;
					}else{					
						if(result.pageCount > 0){
							table+="<tr><td colspan=\"6\"><center>";
							for(var i = 0; i < result.pageCount; i++ ){
								table+= "&nbsp;&nbsp;<input type=\"button\" value=\""+(i+1)+"\"  onclick=\"LoadUP("+i+")\"></input>"
							}
							table+="</center></td></tr>";
						}
					}					
					
					table+=footer;

					$("#customersJson").append(table);

				});			
				
			}


	$(document).ready(LoadUP(0));			
