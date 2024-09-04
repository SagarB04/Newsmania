/**
 * 
 */

function handleChange(event) {
	var selectedValue = event.target.value;
	if (selectedValue) {
		window.location.href = selectedValue;
	}
}

function handleSubmit(event){
	event.preventDefault(); 
	
	let keyword = document.querySelector('input[name="keyword"').value;
	
	if(keyword.trim() ){
		
		let finalKeyword =  encodeURIComponent(keyword);
		window.location.href = "/newsmania/news/"+finalKeyword;
	}
}