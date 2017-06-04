function loadNotebooksAction(){
	//console.log("loadNotebooksAction");
	var url = 'notebook/list.do';
	var data = {userId:getCookie('userId')};
	//console.log(data);
	//console.log(url);
	$.getJSON(url,data,function(result){
		if(result.state==SUCCESS){
			var list = result.data;
			//console.log(list);
			model.updateNotebooks(list);
		}
	});
}

/*
 *  <li class="online">
	<a  class='checked'>
	<i class="fa fa-book" title="online" rel="tooltip-bottom">
	</i> 默认笔记本</a></li>
 */
model.updateNotebooks=function(list){
	this.notebooks = list;
	//console.log(this);
	var ul = $('#notebooks').empty();
	for(var i=0;i<this.notebooks.length;i++){
		var notebook = this.notebooks[i];
		//console.log(notebook);
		//id name
	    
		//console.log(notebook.id+":"+notebook.name);
		
		var li =
			'<li class="online">'+
		'<a >'+
		'<i class="fa fa-book" title="online" rel="tooltip-bottom">'+
		'</i>'+notebook.name+'</a></li>';
		li = $(li).data('index',i);//绑定笔记本序号，this.notebooks[i]中的i刚好为序号
		ul.append(li);
	}
}