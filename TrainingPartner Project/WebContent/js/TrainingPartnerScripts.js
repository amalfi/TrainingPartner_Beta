/**
 * Scripts for TrainingPartner application
 */
$(document).ready(function()
	{
	
	setDateForDiaryCreation();
	setNewDiaryAuthor();
	
    $('#menu a').each(function()
    {
        id = $(this).attr('href');
        id = id.substring(id.lastIndexOf('/'));
        id = id.substring(0,id.indexOf('.'));
        $(this).attr('rel',id);
    });
    $('#home').show();
    $('#menu a').click( function(e)
    {
        e.preventDefault();
        $('.content').hide();
        $('#'+$(this).attr('rel')).show();
        location.hash = '#!/'+$(this).attr('rel');
        return false;
    });
});

 function setDateForDiaryCreation()
{
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();

	if(dd<10) {
	    dd='0'+dd
	} 

	if(mm<10) {
	    mm='0'+mm
	} 

	today = mm+'/'+dd+'/'+yyyy;
	
	document.getElementById('date').value=today;
	
	return true;
}
 
 function setNewDiaryAuthor()
 {
 	var h3Value = document.getElementById('name_header').innerHTML;	
 	var h3ValueArray = h3Value.split(" ");
 	var currentUser = h3ValueArray[1];
 		
 	document.getElementById('author').value=currentUser;
 	
 	return true;	
 }