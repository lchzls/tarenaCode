var SUCCESS = 0; //全局常量
var model = {};//当前页面中的数据模型

$(function(){
	//console.log('init----------');
	loadNotebooksAction(); //eidt_notebook.js
	//写成on('click','li',showNotesAction)，即给现有或未来匹配元素绑定事件
	//不能写成$('#notebooks li').click(function(){});理解这里的区别，下面的会报错。
	//showNotesAction在edit_note.js中定义，同时edit.html中记得引入edit_note.js，且注意引入的先后顺序
	$('#notebooks').on('click','li',showNotesAction); 
	$('#notes').on('click','li',loadNoteAction);  //edit_note.js
	$('#save_note').click(saveNoteAction); //edit_note.js
	//绑定添加笔记按钮事件
	$('#add_note').click(showAddNoteDialog);
	//关闭窗口事件
	$('#can').on('click','.close,.cancle',closeDialog);
	//绑定 笔记子菜单
	$('#notes').on('click','.btn_slide_down',showNoteMenu);
	$('body').click(closeNoteMenu);
	$('#notes').on('click','.btn_delete',deleteNote);
});
function closeNoteMenu(){
	$('#notes .note_menu').hide();
}
function showNoteMenu(){
	console.log('showNoteMenu');
	//在显示子菜单之前，将其他所有子菜单要先隐藏，再显示当前的li的子菜单
	
	$('#notes .note_menu').hide();
		var $li = $(this).parents('li');//获取所点击的li
		console.log($li);
		var $menu = $li.find('.note_menu');
		console.log($menu);
		$menu.show();//显示子菜单
}
//function showNoteMenu(){
//	console.log('showNoteMenu');
//	//button->a->
//	var menus = $('#notes .note_menu');
//	var menu =$(this).parent().next(); 
//	console.log($(this).parent());
//	console.log(menu);
//	menus.each(function(index, e){
//		if(e!=menu[0]){
//			$(e).hide();
//		}
//	});
//	menu.toggle();
////	这里return false是为了不冒泡，否则：
////	本来是应该下拉框，然后由于冒泡事件，因为点击按钮的同时也点击了body，因此，又关闭了。所以，点击没反应。
//	return false;
//}





