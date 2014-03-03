/**
 * 以下所有配置，可以由下列格式进行覆盖
 * var editor = CKEDITOR.replace('editor1',{
 * 			width : 300,
			height : 500,
			language = 'en'
		});
 * 插入图片
	CKEDITOR.instances.content.insertHtml(“<img src=…>”);
	设置值、取值
	设置值(content就是前面 CKEDITOR.replace 的第一个参数值，即textarea的name)
	CKEDITOR.instances.content.setData(“千一网络”);
	或
	var editor = CKEDITOR.replace(“content”);
	editor.setData(“fourjoy”);
	editor.getData();
 */

CKEDITOR.editorConfig = function(config) {
	/* 配置语言 */
	config.language = 'zh-cn'; 
	/*界面的语言配置 设置为'zh-cn'即可*/
	config.defaultLanguage = 'zh-cn';
	
	/*宽度*/
	config.width = 'auto';
	/*高度*/
	config.height = 200;
	
	/* 工具栏是否可以被收缩 */
	config.toolbarCanCollapse = true;
	/*工具栏的位置(top、bottom) */
	config.toolbarLocation = 'top';
	/*工具栏默认是否展开*/
	config.toolbarStartupExpanded = true;
	
	/* 取消 “拖拽以改变尺寸”功能 */
	config.resize_enabled = true;
	/*改变大小的最大高度 */
	/*config.resize_maxHeight = 3000;*/
	/*改变大小的最大宽度 */
	/*config.resize_maxWidth = 3000;*/
	/*改变大小的最小高度 */
	/*config.resize_minHeight = 250;*/
	/*改变大小的最小宽度 */
	/*config.resize_minWidth = 750;*/
	
	/*文字方向:从左到右*/
	/*config.contentsLangDirection = 'ltr';*/
	/*是否使用完整的html编辑模式 如使用，其源码将包含：<html><body></body></html>等标签*/
	config.fullPage = false;
	/*是否忽略段落中的空字符 若不忽略 则字符将以''表示*/
	config.ignoreEmptyParagraph = true;
	/*当执行“新建”命令时，编辑器中的内容*/
	config.newpage_html = '';
	/*页面载入时，编辑框是否立即获得焦点*/
	config.startupFocus = false;
	/*载入时，以何种方式编辑 源码和所见即所得 'source'和'wysiwyg' */
	config.startupMode ='wysiwyg';
	/*载入时，是否显示框体的边框，例如p标签的边框*/
	config.startupOutlineBlocks = false;
	/*撤销的记录步数（即：CTRL+Z的功能）*/
	config.undoStackSize = 20;
	
	/*所需要添加的CSS文件 在此添加 可使用相对路径和网站的绝对路径*/
	/*config.contentsCss = './contents.css';*/
	/*CKeditor的配置文件 若不想配置 留空即可*/
	/*CKEDITOR.replace( 'myfiled', { customConfig : './config.js' } );*/
	/*是否载入样式文件 */
	/*config.stylesCombo_stylesSet = 'default';*/
	/*以下为可选
	/*config.stylesCombo_stylesSet = 'mystyles';*/
	/*config.stylesCombo_stylesSet = 'mystyles:/editorstyles/styles.js';*/
	/*config.stylesCombo_stylesSet = 'mystyles:http://www.example.com/editorstyles/styles.js';*/
	
	/*起始的索引值*/
	/*config.tabIndex = 0;*/
	/*当用户键入TAB时，编辑器走过的空格数，(&nbsp;) 当值为0时，焦点将移出编辑框 */
	config.tabSpaces = 4;
	
	config.LinkUpload = true;
	config.ImageUpload = true;
	config.FlashUpload = true;
	config.MediaUpload = true;
	
	/*是否在选择颜色时显示“其它颜色”*/
	config.colorButton_enableMore = true;
	/*界面编辑框的背景色 （点击下上传图片） 默认是'white'，设置格式'rgb(255, 254, 253)'或者 '#FF0000' */
	/*(config.dialog_backgroundCoverColor = '#00FF00';*/
	//*背景的不透明度 数值应该在：0.0～1.0 之间 plugins/dialog/plugin.js*/
	/*config.dialog_backgroundCoverOpacity = 0.1;*/
	
	/*进行表格编辑功能 如：添加行或列 目前仅firefox支持 默认为不开启*/
	config.disableNativeTableHandles = true;
	/*是否开启 图片和表格 的改变大小的功能 config.disableObjectResizing = true*/
	config.disableObjectResizing = true;
	/*在清除图片属性框中的链接属性时 是否同时清除两边的<a>标签*/
	config.image_removeLinkByEmptyURL = true;
	
	/*设置HTML文档类型，目前设置的是从default.jsp中拷贝的*/
	/*
	 * 默认
	 * '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">'
	 */
	config.docType = '<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">';
	
	/*编辑器中回车产生的标签可选：CKEDITOR.ENTER_P、CKEDITOR.ENTER_BR、CKEDITOR.ENTER_DIV*/
	config.enterMode = CKEDITOR.ENTER_P;
	/*是否转换一些特殊字符为ASCII字符 如：”This is Chinese: 汉语.”转换为：”This is Chinese: &#27721;&#35821;.”*/
	config.entities_processNumerical = false;
	/* 使用搜索时的高亮色  */
	/*
	config.find_highlight = {
		element : 'span',
		styles : { 'background-color' : '#FF0000', 'color' : '#00FF00' }
	};
	*/
	
	/*默认的字体名 */
	//config.font_defaultLabel = 'Arial';
	/*字体编辑时的字符集 可以添加常用的中文字符：宋体、楷体、黑体等*/
	//config.font_names = 'Arial;Times New Roman;Verdana';
	/*字体默认大小 */
	/*config.fontSize_defaultLabel = '12px';*/
	/*字体编辑时可选的字体大小 */
	/*config.fontSize_sizes ='8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;28/28px;36/36px;48/48px;72/72px'; */
	/*设置字体大小时 使用的式样 */
	/*
	config.fontSize_style = {
		element   : 'span',
		styles   : { 'font-size' : '12px' },
		overrides : [ { element : 'font', attributes : { 'size' : null } } ]
	};
	*/
	
	/*当从word里复制文字进来时，是否进行文字的格式化去除(默认为忽略格式)*/
	/*config.pasteFromWordIgnoreFontFace = false; */
	/*是否使用<h1><h2>等标签修饰或者代替从word文档中粘贴过来的内容 */
	/*config.pasteFromWordKeepsStructure = false;*/
	/*从word中粘贴内容时是否移除格式*/
	/*config.pasteFromWordRemoveStyle = false;*/
	
	/*是否强制复制来的内容去除格式 (false：不去除)*/
	config.forcePasteAsPlainText =false;
	/*是否强制用“&”来代替“&amp;”*/
	config.forceSimpleAmpersand = false;
	/*对address标签进行格式化*/
	/*config.format_address = { element : 'address', attributes : { class : 'styledAddress' } };*/
	/*对DIV标签自动进行格式化 */
	/*config.format_div = { element : 'div', attributes : { class : 'normalDiv' } };*/
	/*对H1标签自动进行格式化 */
	/*config.format_h1 = { element : 'h1', attributes : { class : 'contentTitle1' } };*/
	/*对H2标签自动进行格式化 */
	/*config.format_h2 = { element : 'h2', attributes : { class : 'contentTitle2' } };*/
	/*对H3标签自动进行格式化*/
	/*config.format_h1 = { element : 'h3', attributes : { class : 'contentTitle3' } };*/
	/*对H4标签自动进行格式化 */
	/*config.format_h1 = { element : 'h4', attributes : { class : 'contentTitle4' } };*/
	/*对H5标签自动进行格式化 */
	/*config.format_h1 = { element : 'h5', attributes : { class : 'contentTitle5' } };*/
	/*对H6标签自动进行格式化 */
	/*config.format_h1 = { element : 'h6', attributes : { class : 'contentTitle6' } };*/
	/*对P标签自动进行格式化*/
	/*config.format_p = { element : 'p', attributes : { class : 'normalPara' } };*/
	/*对PRE标签自动进行格式化*/
	/*config.format_pre = { element : 'pre', attributes : { class : 'code' } };*/
	
	/*自定义模板，参见plugins/templates/templates/default.js中定义的（可以进行修改）*/
	/*默认使用的模板*/
	/*config.templates = 'default';*/
	/*模板文件(可以是多个，用逗号分隔的)，暂时有BUG，不能使用自定义的模板*/
	/*config.templates_files = [ 'template_customer.js'];*/
	/*当使用模板时，“编辑内容将被替换”框 是否选中(选择模板对话框最下面有个复选框)*/
	/*config.templates_replaceContent = true;*/
	
	
	/* 工具栏风格（基础'Basic'、全能'Full'、自定义）*/
	config.toolbar = 'Customer';
	config.toolbar_Customer = [
 		{ name: 'document', items : [ 'Source','-','NewPage','DocProps','Preview','Print','-','Templates' ] },
 		{ name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
 		{ name: 'editing', items : [ 'Find','Replace','SelectAll'] },
 		{ name: 'forms', items : [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 
 	        'HiddenField' ] },
 		'/',
 		{ name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript','-','RemoveFormat' ] },
 		{ name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote','CreateDiv',
 		'-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },
 		{ name: 'links', items : [ 'Link','Unlink','Anchor' ] },
 		{ name: 'insert', items : [ 'Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak','Iframe' ] },
 		'/',
 		{ name: 'styles', items : [ 'Styles','Format','Font','FontSize' ] },
 		{ name: 'colors', items : [ 'TextColor','BGColor' ] },
 		{ name: 'tools', items : [ 'Maximize', 'ShowBlocks'] }
 	];
	config.toolbar_Full = [
 		{ name: 'document', items : [ 'Source','-','Save','NewPage','DocProps','Preview','Print','-','Templates' ] },
 		{ name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
 		{ name: 'editing', items : [ 'Find','Replace','-','SelectAll','-','SpellChecker', 'Scayt' ] },
 		{ name: 'forms', items : [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 
 	        'HiddenField' ] },
 		'/',
 		{ name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript','-','RemoveFormat' ] },
 		{ name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote','CreateDiv',
 		'-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },
 		{ name: 'links', items : [ 'Link','Unlink','Anchor' ] },
 		{ name: 'insert', items : [ 'Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak','Iframe' ] },
 		'/',
 		{ name: 'styles', items : [ 'Styles','Format','Font','FontSize' ] },
 		{ name: 'colors', items : [ 'TextColor','BGColor' ] },
 		{ name: 'tools', items : [ 'Maximize', 'ShowBlocks','-','About' ] }
 	];
	config.toolbar_Basic = [
  		['Bold', 'Italic', '-', 'NumberedList', 'BulletedList', '-', 'Link', 'Unlink','-','About']
  	];
	
	/*快捷键*/
	/*当输入：shift+Enter是插入的标签(CKEDITOR.ENTER_P、CKEDITOR.ENTER_BR、CKEDITOR.ENTER_DIV)*/
	config.shiftEnterMode = CKEDITOR.ENTER_P;
	
	/*可选的表情替代字符 */
	/*
	config.smiley_descriptions = [
	':)', ':(', ';)', ':D', ':/', ':P',
	'', '', '', '', '', '',
	'', ';(', '', '', '', '',
	'', ':kiss', '' ];
	*/
	/*对应的表情图片*/
	/*
	config.smiley_images = [
	'regular_smile.gif','sad_smile.gif','wink_smile.gif','teeth_smile.gif','confused_smile.gif','tounge_smile.gif',
	'embaressed_smile.gif','omg_smile.gif','whatchutalkingabout_smile.gif','angry_smile.gif','angel_smile.gif','shades_smile.gif',
	'devil_smile.gif','cry_smile.gif','lightbulb.gif','thumbs_down.gif','thumbs_up.gif','heart.gif',
	'broken_heart.gif','kiss.gif','envelope.gif'];
	*/
	/*表情的地址*/
	/*config.smiley_path = 'plugins/smiley/images/';*/
	
	/*以下配置，暂时不知什么功能，若分析清楚之后，请移动到上面*/
	/*主题*/
	/*config.theme = 'default';*/
	/*是否对编辑区域进行渲染  */
	config.editingBlock = true;
	/*是否使用HTML实体进行输出  */
	config.entities = true;
	/*定义更多的实体，其中#代替了& */
	/*config.entities_additional = '#39';*/
	/*是否转换一些难以显示的字符为相应的HTML字符 */
	config.entities_greek = true;
	/*是否转换一些拉丁字符为HTML */
	config.entities_latin = false;
	/*添加新组件，非默认 仅示例*/
	/*config.extraPlugins = 'myplugin';*/
	/*用分号分隔的标签名字 在工具栏上显示*/
	/*config.format_tags = 'p;h1;h2;h3;h4;h5;h6;pre;address;div';*/
	/*一组用逗号分隔的标签名称，显示在左下角的层次嵌套中 */
	/*config.menu_groups ='clipboard,form,tablecell,tablecellproperties,tablerow,tablecolumn,table,anchor,link,image,flash,checkbox,radio,textfield,hiddenfield,imagebutton,button,select,textarea';*/
	/*显示子菜单时的延迟，单位：ms */
	/*config.menu_subMenuDelay = 400;*/
	/*对应后台语言的类型来对输出的HTML内容进行格式化*/
	/*
	config.protectedSource.push( /<?[sS]*??>/g );   // PHP Code
	config.protectedSource.push( //g );   // ASP Code
	config.protectedSource.push( /(]+>[s|S]*?</asp:[^>]+>)|(]+/>)/gi );   // ASP.Net Code
	*/
};
