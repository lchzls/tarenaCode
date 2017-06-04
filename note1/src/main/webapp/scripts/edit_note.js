function showNotesAction(){
	//console.log('showNotesAction');
	//获取选中元素的序号，此序号是在显示笔记本列表的时候绑定的
//	console.log(this); this代表当前的li
	var li = $(this);
	var index = li.data('index');
	//console.log(index);
	//处理视觉效果
	/*
	 *  <li class="online">
		<a  class='checked'>
		<i class="fa fa-book" title="online" rel="tooltip-bottom">
		</i> 默认笔记本</a></li>
		将所有li的a的样式都去掉，再给当前的这个li添加选中的样式。执行第一步是因为，若不每次点击都清除，则第二次
	    点击li时，第一个li的选中的样式仍然在，因此每次要添加选中样式之前，将原来的选中的样式都清除。而由于不清楚原来
	    选中的是哪个li，因此采取对所有的li的样式都设置为未选中。
	 */
	li.parent().find('a').removeClass('checked');
	li.find('a').addClass('checked');
	
	model.showNotes(index);
}

//显示选定笔记本的全部笔记
model.showNotes = function(notebookIndex){
	//console.log(notebookIndex);
	//console.log(this);
	this.notebookIndex = notebookIndex; //重构
	var notebook = this.notebooks[notebookIndex];
//	console.log(notebook);
	var url = "note/list.do";
	var data={notebookId:notebook.id};
	//console.log(data);
	$.getJSON(url,data,function(result){
		if(result.state==SUCCESS){
			//console.log(result.data);
			model.updateNotes(result.data);
		}else{
			alert(result.message);
		}
	});
	
}

/*
<li class="online">
<a  class='checked'>
	<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> 使用Java操作符<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>
</a>
<div class="note_menu" tabindex='-1'>
	<dl>
		<dt><button type="button" class="btn btn-default btn-xs btn_move" title='移动至...'><i class="fa fa-random"></i></button></dt>
		<dt><button type="button" class="btn btn-default btn-xs btn_share" title='分享'><i class="fa fa-sitemap"></i></button></dt>
		<dt><button type="button" class="btn btn-default btn-xs btn_delete" title='删除'><i class="fa fa-times"></i></button></dt>
	</dl>
</div>
</li>
*/

//将model显示到界面
model.updateNotes=function(notes){
	//console.log(notes);
	/*
	 * 由于在model.updateTitle函数中调用了this.updateNotes(),用于更新笔记列表的显示
	 * 因此，若是修改了title，则对应的笔记列表也要改变，this.updateNotes()，传入的notes参数为
	 * null，因此，这里要判断notes是否为空，若非空，则表示是正常的点击笔记本显示笔记列表，否则，在第一次显示
	 * 了笔记后，再修改标题，此时即传入的notes为空，那么this.notes = notes;执行后this.notes
	 * 的值即为null，这样his.notes.length会报错，因此，需要对notes做判断。若notes为空，
	 * 则不执行this.notes=notes,即this.notes仍然为之前的notes，在显示this.notes之前，
	 * 已经在model.updateTitle中将对应笔记的title做了修改了，	
	 * this.notes[index].title = title;这样就保证将model显示到界面时，model里的notes
	 * 的值已经发生改变了，最后能显示修改标题后的笔记。
	 */
	
	if(notes){
		this.notes = notes;
	}
	
	var ul = $('#notes').empty();
	for(var i=0;i<this.notes.length;i++){
		var note = this.notes[i];
		//console.log(note.title);
		var li = 
		'<li class="online">'+
		'<a>'+
		'<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+ note.title+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>'+
		'</a>'+
		'<div class="note_menu" tabindex="-1">'+
		'<dl>'+
				'<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>'+
				'<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>'+
				'<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>'+
			'</dl>'+
		'</div>'+
		'</li>';
		li = $(li).data('index',i);
		//这段代码是为了保证在点击保存后，被选中的笔记仍然显示墨绿色表示被选中，若不添加，则保存后，则无被选中样式
		//这整个的函数是处理笔记显示，这个函数之后是笔记点击事件相关函数。谁被选定，即i==this.noteIndex，
		//则保存后显示的笔记则必须显示被选中。而在处理列表点击事件时，首先将所有被选中的样式清除，然后将当前被选中的
		//再显示被选中的效果
		if(i==this.noteIndex){
			li.children('a').addClass('checked');
		}
		ul.append(li);
	}
	//重构内容：1.判断可变参数 2、记录显示索引号index 3、添加默认选定功能
}

//处理笔记列表点击事件
function loadNoteAction(){
	//console.log('loadNoteAction');
	//console.log(this); //即当前的li
	var li = $(this);
	//处理视觉效果
	li.parent().find('a').removeClass('checked');
	li.find('a').addClass('checked');
	//获取选的元素的序号
	var index = li.data('index');
	//console.log(index);
	model.loadNote(index);
}

//加载选定的笔记
model.loadNote=function(index){
	//console.log(index);
	//console.log(this);
	this.noteIndex = index; //model中存好当前笔记的index
	var url = 'note/load.do';
	var data = {id:model.notes[index].id};
	//console.log(data);
	$.getJSON(url,data,function(result){
		if(result.state==SUCCESS){
			//console.log(result.data);
			model.updateNote(result.data);
		}else{
			alert(result.message);
		}
		
	});
};

//将note对象显示在编辑区域
//model.updateNote = function(note){
model.updateNote = function(note,newNote){//重构
	//当再次点击另一个笔记li时，则this.note被赋值为当前这个li对应的笔记
	this.note = note;  
	$('#input_note_title').val(this.note.title);
	um.setContent(this.note.body);
	
	if(newNote){
		//console.log(this);
		this.noteIndex = 0; //这一句的作用在于，指定当前被选中的笔记的序号为0，这样在显示笔记列表时才好确定是哪个列表被选中，以显示被选中的样式
		//unshift可以查看jScript手册，表示将指定的元素插入到数组的第一个位置，并且其他的按顺序推后。
		//unshift中的参数表示插入元素的可选项，该数组中的每一个元素都是map，其中包含了id和title。
		//可以通过查看model元素中的notes对象，从而看到数组中的每个元素的具体的值
		this.notes.unshift({id:note.id,title:note.title});
		this.updateNotes(); //负责将所有的notes列出显示
	}
}


function saveNoteAction(){
	//console.log('saveNoteAction');
	//当前点击是那个笔记，则model中的note存的就是那个笔记 由model.updateNote中的this.note = note;得到
	//console.log(model);
	var title =  $('#input_note_title').val();
	//console.log("title:"+title);
	var body = um.getContent();
	//console.log("body:"+body);
	var id = model.note.id;
	
	//不允许空title,若为空，则将其设置为原来的title值
	if(title.replace(" ","")==""){
		//title.replace(" ","")==""表示当前的title为空
		title = model.note.title;
		$('#input_note_title').val(title);
	}
	if(title==model.note.title&&body==model.note.body){
		//如果标题和内容完全没变，则什么也不做
		return;
	}
	//否则，只要其中一个有变动，则执行下面
	var url = "note/save.do";
	var data = {id:id,title:title,body:body};
	//console.log(data);
	$.post(url,data,function(result){
		if(result.state==SUCCESS){
			if(result.data==false){
			//	alert('更新失败');
				return;
			}else{
				//console.log('成功');
				model.updateTitle(title);
			}
		}else{
			alert(result.message);
		}
	});
	
}


model.updateTitle=function(title){
	//console.log(title);
	//console.log(this);
	//找到当前选定笔记的序号index
	var index = this.noteIndex;
	//console.log("index:"+index);
	this.notes[index].title = title;
	//更新笔记列表的显示
	this.updateNotes();
	
}

function showAddNoteDialog(){
	$('#can').load('alert/alert_note.jsp',function(){
		//在页面加载组件以后执行
	//	console.log('在页面加载组件以后执行');
		
		$('#can .sure').click(addNoteAction);
	});
	$('.opacity_bg').show();
}

function closeDialog(){
//	console.log('closeDialog');
	$('#can').empty();
	$('.opacity_bg').hide();
}

function addNoteAction(){
	//console.log('addNoteAction');
	/*
	 * 此时去model.showNotes方法中重构	this.notebookIndex = notebookIndex;
	 * 得到当前被点击笔记的序号
	 */
	//console.log(model.notebookIndex);
	var url = "note/add.do";
	var notebookId = model.notebooks[model.notebookIndex].id;
	var title = $('#can #input_note').val();
	if(title.replace(' ','')==''){
		return ;
	}
	var data = {userId:getCookie('userId'),
			notebookId:notebookId,
			title:title};
	//console.log(data);
	$.post(url,data,function(result){
		if(result.state==SUCCESS){
			var note = result.data;
			//console.log(note);
			model.updateNote(note,true);
			closeDialog();
		}else{
			alert(result.message);
		}
	})
	
}

function deleteNote(){
	console.log('deletenote');
	//var $li = $("notes a.checked").parent(); 如果this表示确认删除按钮，就先找a再找其父亲li；
	var $li = $(this).parents('li'); //这里的li表示下拉框中的删除按钮；
	var noteId = $li.data('index');
	console.log(noteId);
	var url = 'note/recycle.do';
	var data = {noteId:noteId};
	$.post(url,data,function(result){
		if(result.state==SUCCESS){
			$('#input_note_title').val("");
			um.setContent("");
			model.showNotes(model.notebookIndex);
			
		}else{
			alert(result.message);
		}
	});

}
