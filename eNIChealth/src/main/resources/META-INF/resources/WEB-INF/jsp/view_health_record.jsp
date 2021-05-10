<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
  
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.5/css/buttons.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.1/css/select.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://editor.datatables.net/extensions/Editor/css/editor.bootstrap4.min.css"/>
  
  
  
<title>View health records</title>

</head>

<body style="background-color:#FFFFFF">
   <div class="navbar bg-dark w3-large" >
            
            <span class="nav-item text-light ">Health Care</span>
   </div>
   
   <br/>
 <div class="container-fluid" >
 
	<div class="row">
	  	<div class="col-sm-4 ">
					 	<div class="form-group">
					    	<label for="nicno">NIC number:</label>
					    	<input type="text" class="form-control" id="nicno" readonly>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="fullname">Full name:</label>
					    	<input type="text" class="form-control" id="fullname" readonly>
					  	</div>
					  	
					  	<div class="form-row">
					  		<div class="form-group">
						    	<label for="dob">Date of Birth:</label>
						    	<input type="date" class="form-control" id="dob" readonly>
					  		</div>
					  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  		<div class="form-group">
						    	<label for="gender">Gender:</label>
					  		<br>
						    	<div class="form-check-inline">
									  <label class="form-check-label">
									  	<input type="radio" class="form-check-input" name="optradio" readonly>Female
									  </label>
								</div>
								<div class="form-check-inline">
									 <label class="form-check-label">
									    <input type="radio" class="form-check-input" name="optradio" readonly>Male
									  </label>
								</div>
					  		</div>
					  	</div>
					  	
				
					  	<div class="form-group">
					    	<label for="permanentaddress">Permanent Address:</label>
					    	<textarea rows="5" class="form-control" id="permanentaddress" readonly></textarea>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="postaladdress">Postal Address:</label>
					    	<textarea rows="5" class="form-control" id="postaladdress" readonly></textarea>
					  	</div>
					  	
					  	<div class="form-row">
					  		<div class="form-group">
						    	<label for="homeno">Resident Number:</label>
						    	<input type="tel" class="form-control" id="homeno" readonly>
					  		</div>
					  		&nbsp;&nbsp;&nbsp;
					  		<div class="form-group">
						    	<label for="mobileno">Mobile Number:</label>
						    	<input type="tel" class="form-control" id="mobileno" readonly>
					  		</div>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="emailaddress">E-mail Address:</label>
					    	<input type="email" class="form-control" id="emailaddress" readonly>
					  	</div>

	  	</div>
	  	<div class="col-sm-8">
	  	<div class="row d-flex justify-content-end  pr-3" >
	  		<div class="form-inline">
				<label for="blood">Blood type:&nbsp;&nbsp;</label>
				<input type="text" class="form-control" id="blood" width="200px" readonly>
				&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-success" data-toggle="modal" data-target="#bloodModel">&nbsp;&nbsp;&nbsp;Add&nbsp;&nbsp;&nbsp;</button>
				</div>
		   </div>	
		   
		   <br><br>
		   
		   <div class="table-responsive">
                <table id="healthrectable" class="table table-striped table-bordered container table-hover " style="width:100%;">
                    <thead class="thead-light">
                        <tr>
                            <th>Health record</th>
                            <th>Description</th>
                            <th>Date</th>
                            <th>Clinic</th>
                            <th>Doctor</th>
                            <th>Report</th>
                        </tr>
                    </thead>

                    <tbody>
                                    <tr>
                                        <td>Diabete</td>
                                        <td>ABCDEFGHIJKLMNOPQRSTUVWXYZ</td>
                                        <td> 2021/02/19</td>
                                        <td>General Hospital, Piliyandala</td>
                                        <td>Nippa Sandaruwan}</td>
                                        <td><a href="#">View</a></td>
                                    </tr>
                                    <tr>
                                        <td>Heart Attack</td>
                                        <td>AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz</td>
                                        <td> 2021/04/01</td>
                                        <td>Apollo</td>
                                        <td>Divya Nimsara</td>
                                        <td><a href="#">View</a></td>
                                    </tr>
                    </tbody> 
                </table>

            </div>
		     	
	  	</div>  
	</div> 
	
	<div class="modal fade" id="bloodModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                        <div class="modal-body">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <form action="#"  method="POST">
                            
								<div class="form-group">
                                    <label for="blood">Blood Type</label>
                                    <select class="form-control browser-default custom-select"  id="blood" name="blood">
                                            <option value="O+">O+</option>
                                            <option value="O-">O-</option>
                                    </select>
                                </div>
                             

                                <button type="submit" class="btn btn-primary">Add</button>

                            </form>

                        </div>
                    </div>
                </div>

            </div>
	
	
</div> 
</body>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js|https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.5/js/dataTables.buttons.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.5/js/dataTables.buttons.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/select/1.3.1/js/dataTables.select.min.js"></script>
        <script type="text/javascript" src="https://editor.datatables.net/extensions/Editor/js/dataTables.editor.min.js"></script>
        <script type="text/javascript" src="https://editor.datatables.net/extensions/Editor/js/editor.bootstrap4.min.js"></script>
<script>
$(document).ready(function () {
    var table = $('#healthrectable').DataTable({
        lengthChange: false,
        "paging": false,
        "info": false,
        select: true
    });
    $('#healthrectable tbody').on('click', 'tr', function () {
        var selectRow = table.rows(this).data()[0];
    });
});

$('#bloodModel').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus');
});
</script>

</html>

