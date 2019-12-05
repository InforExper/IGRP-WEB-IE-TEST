
'use strict';

goog.provide('Blockly.Java.selenium');

goog.require('Blockly.Java');

	// ********************************************** DECLARATE VARIABLES  ********************************
	//*****************************************************************************************************

var GEN = null;

var blockyInit = false;

var COMPARISON = [["==", "=="],["!=", "!="],[">=", ">="], ["<=", "<="],[">=", ">="], [">", ">"], ["<", "<"]];

var RETURNS = [["forward", "forward"],["redirect", "redirect"]];

var PAGES = [];

var CORE_IF = [["verificar se está nulo", "verificar se está nulo"],["verificar se não está nulo", "verificar se não está nulo"]];

var CORE_MSG = [["mensagem sucesso", "mensagem sucesso"],["mensagem de erro", "mensagem erro"]];

var CORE_CONV = [["converter para inteiro", "converter para inteiro"],["converter texto para data", "converter texto para data"],["converter para texto", "converter para texto"]];

var FIND = [["--", "--"],["all", "todos"],["one", "um"]];

var FINDLIST = [["--", "--"],["all", "TODOSS"],["one", "UMM"]];

var TIPO = [["Inteiro", "Inteiro"],["Data", "Data"],["Texto", "Texto"]];

var WHERE = [["=", "WHERE_EQ"],["!=", "WHERE_DIF"],["<", "WHERE_LT"],["<=", "WHERE_LTE"],[">", "WHERE_GT"],[">=", "WHERE_GTE"],["like", "WHERE_LIKE"],["notlike", "WHERE_NOTLIKE"]];

var FILTER = [["andWhere", "andWhere"],["andWhereIsNull", "andWhereIsNull"],["andWhereNotNull", "andWhereNotNull"],["andWhereBetween", "andWhereBetween"],
			  
				["orWhere", "orWhere"],["orWhereIsNull", "orWhereIsNull"],["orWhereNotNull", "orWhereNotNull"],["orWhereBetween", "orWhereBetween"],
			  
				["having", "having"],["where", "where"],["whereIn", "whereIn"],["whereNotIn", "whereNotIn"]];

var ANDOR = [["and", "and"],["or", "or"]];

var TRU_FAL = [["true", "true"],["false", "false"]];

var daoClasses = {};

var IGRP_BLOCKLY_DROPS={
	
	daos : {}
		
};

var AppTitle, PageTitle, pagetitle;

var fields_model = [], form_id = [], key_model = [], fields_table = [], fields_separator = [], fields_formlist = [];

var chart = [], tables_model = [], separator_model = [], formlist_model = [], buttons_model = [], all_buttons = [];

var daos_list = [], bloc_fields = [], imports_insert = [], imports_list = [], fields_esp_row = [], custom_action = [];

var select = [];

var addcombo=0, addseparator=0, addforeign=0, addchart=0, addtable =0, addbutton=0, addmodel=0, addformlist=0, custombutton=0;

Blockly.Blocks.texts.HUE = 200;

var GetJavaType = {
		
	text : 'String',
	
	number : 'Integer',
	
	date : 'String',
	
	file : 'File',
		
	select : 'Select',
	
	email : 'String',
	
	link : 'Link',
	
	checkbox : 'Integer',
	
	img: 'Image',
	
	lookup: 'String',
	
	password: 'String'
		
}

		// ********************************************** PREVIOUS FUNCTIONS  ********************************
		//*****************************************************************************************************

var calcHeight = function() {

	$('#gen-blocky-view').height(function() {

		return $(window).height() - 59 - 37

	});

}

$(window).resize(function() {
	
	calcHeight();
	
});


$('#save_bloco_igrp').on('click',function() {
	
	if (typeof (Storage) !== "undefined") {
		
		var xml = Blockly.Xml.workspaceToDom(Blockly.mainWorkspace);
		
		localStorage.setItem(document.getElementById("content_blocks").value,Blockly.Xml.domToText(xml));
		
		alert("Bloco salvado");
		
		Blockly.mainWorkspace.clear();
		
	}
	
});

$('#restore_bloco_igrp').on('click', function() {
	
	Blockly.mainWorkspace.clear();
	
	var IGRPblockly = document.getElementById("content_blocks").value;
	
	if (typeof (Storage) !== "undefined") {
		
		if (localStorage.data !== null) {
			
		var xml = Blockly.Xml.textToDom(localStorage.getItem(IGRPblockly));
		
		Blockly.Xml.domToWorkspace(Blockly.mainWorkspace, xml);
		
		alert("Bloco Restaurado");
		
		}
		
	}
	
});

$('#refresh_bloco').on('click', function() {
	
	if (typeof (Storage) !== "undefined") {
		
		var xml = Blockly.Xml.workspaceToDom(Blockly.mainWorkspace);
		
		localStorage.setItem(document.getElementById("content_blocks").value,Blockly.Xml.domToText(xml));
		
		Blockly.mainWorkspace.clear();
		
	}
	
	var IGRPblockly = document.getElementById("content_blocks").value;
	
	if (typeof (Storage) !== "undefined") {
		
		if (localStorage.data !== null) {
			
		var xml = Blockly.Xml.textToDom(localStorage.getItem(IGRPblockly));
		
		Blockly.Xml.domToWorkspace(xml,Blockly.mainWorkspace);
		
		var code = '';//Blockly.Java.workspaceToCode(Code.workspace);
		
		content.textContent = code; 
		   
		console.log("Bloco Atualizado");
		
		}
	}
	
});

$('#active_selenium').on('click', function() {
	
	$(this).toggleClass('active');
	
	$("#content_selenium").toggleClass('active');
	
});

		// ************************************* INIT LOAD XML AND REQUEST  ***********************************
		//*****************************************************************************************************

	window.IGRPBlocklyInit = function(){

	 fields_model = [], fields_model.push(['--','--']), chart = [], chart.push(['--','--']), form_id = [], 
	 
	 form_id.push(['--','--']), key_model= [], key_model.push(['--','--']), fields_table = [], fields_table.push(['--','--']),
	 
	 fields_separator = [], fields_separator.push(['--','--']), fields_formlist = [], fields_formlist.push(['--','--']),
	 
	 tables_model = [], bloc_fields = [], separator_model = [], tables_model.push(['--','--']), separator_model.push(['--','--']),
	 
	 formlist_model = [], formlist_model.push(['--','--']), buttons_model = [], buttons_model.push([ '--', '--' ]),
	 
	 all_buttons = [], daos_list = [], daos_list.push([ '--', '--' ]), imports_insert = [], imports_insert.push([ '--', '--' ]),
	 
	 imports_list = [], imports_list.push([ '--', '--' ]), fields_esp_row = [], fields_esp_row.push([ '--', '--' ]),
	 
	 custom_action = [], custom_action.push([ '--', '--' ]), select = [], select.push([ '--', '--' ]),
	 
	 addcombo=0, addseparator=0, addforeign=0, addchart=0, addtable=0, addbutton=0, addmodel=0, addformlist=0, custombutton=0;
	
	var BlocklyXML = $.parseXML(VARS.getGen().getXML());
	
	 AppTitle = $('rows>app', BlocklyXML).text();
	 
	 PageTitle = $('rows>page', BlocklyXML).text();
	 
	 pagetitle = PageTitle.toLowerCase();
	 
	 IGRP_BLOCKLY_DROPS.tablesTest = {};
	 

  //***************************************************** FIELDS_MODEL ***********************************************
	 
	 $('rows>content>*[type]', BlocklyXML).each(function(i, element) {
			
			$(element).find('>fields>*').each(function(x, field) {
				
			var	 tag = $(field).prop('tagName');
			
			var type = $(field).attr('java-type') || $(field).attr('type');
			
			var ChooseType = $(field).attr('type');
			
			var key  = $(field).attr('iskey');
			
			var domain = $(field).attr('domain');
			
			var tagg = $(field).attr('tag');
			
			var multiple = $(field).attr('multiple');
			
			var persist = $(field).attr('persist');
			
			var javaType = GetJavaType[type] || type || 'String';
			
			if(multiple =="true")
			{
				
				fields_model.push([ tag, 'String[]'+'::'+tag]);
				
				addmodel++;
			}
			
			else if(tag == "hidden")
			{
				form_id.push([ tagg, tagg ]);
				
				fields_model.push([ tagg, javaType + '::'+tagg]);
				
				addmodel++;
			}

			else if(tag != "hidden" && multiple !="true")
			{
				fields_model.push([ tag, javaType + '::'+tag]);
				
				addmodel++;
			}

			if(key == "true")
			{
				key_model.push([ tag, tag]);
				
				addforeign++;
				
			}
			
			if(ChooseType == "select" && domain== "" || ChooseType == "checkboxlist" && domain== "" || ChooseType == "radiolist" && domain== "")
			{
				select.push([ tag, tag ]);
				
				addcombo++;		
			}
			
			})
		});	
	 
	 if(addmodel !=0)
	 {
		$('#toolbox').append(
				
			'<category id="model" name="Model '+PageTitle+'" colour="300" class="blocly-dynamic">'
			
				 +'<block type="model_set" prev-statement="" next-statement="" coment="teste" color="300">'
				 
			 		+'<value name="value1" type="value" title="set model">'
			 		
			 			+'<field type="dropdown" name="set_model" options="IGRP_BLOCKLY_DROPS.fields"></field>'
			 			
			 			+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/model_icon.svg"></field>'
			 			
					+'</value>'
					
				 +'</block>'
				 
				 +'<block type="model_get" output="" color="300">'
				 
				 	+'<value name="value1" type="dummy" title="get model">'
				 	
				 		+'<field type="dropdown" name="get_model" options="IGRP_BLOCKLY_DROPS.fields"></field>'
				 		
				 		+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/model_icon.svg"></field>'
				 		
				 	+'</value>'
				 	
				 +'</block>'
				 
			 +'</category>'
			 
			 +'<sep class="blocly-dynamic"></sep>'
			 
		  );
		
		$('#toolbox').append(
				
				'<category id="parameters" name="Parameters" colour="60" class="blocly-dynamic">'	
				
				+'<block type="core_get_param" output="" color="60">' 
				
				+'<value name="value1" type="dummy"  title="get parameter">'
				
					+'<field type="field_text" name="param" options=""></field>'
					
					+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/get-icon.svg"></field>'
					
				+'</value>'
				
				+'</block>'
				
				+'</category>'
				
				+'<sep class="blocly-dynamic"></sep>'
				
				);
			
		}
	 
	//*********************************************** FILL_COMBO ***************************************************
		
		if(addcombo!=0)
		{
			
		$('#toolbox').append(
				
			'<category id="combo" name="Choose-List" colour="100" class="blocly-dynamic">'
				
			+'<block type="fill_combo" color="100" prev-statement="" next-statement="" inline="true">'
			
				+'<value name="value1" type="dummy" title="fill">'
				
					+'<field type="dropdown" name="selecao" options="IGRP_BLOCKLY_DROPS.selecao"></field>'
					
					+'<field type="checkbox" name="selecionar" title="select option?" options="FALSE"></field>'
					
				+'</value>'
				
				+'<value name="value2" type="statement">'
				
					+'<block type="option_combo" color="100" prev-statement="" next-statement="" inline="true">'
					
						+'<value name="value1" type="dummy" title="option">'
						
							+'<field type="field_text" name="opcao_val" options="key"></field>'
							
							+'<field type="field_text" name="opcao_des" options="value"></field>'
							
						+'</value>'
						
					+'</block>'
					
				+'</value>'
				
			+'</block>'
			
			+'<block type="combo_dao" color="100" mutator="where" prev-statement="" next-statement="" inline="true" >'
			
			+'<value name="value1" type="dummy">'
			
				+'<field type="dropdown" name="selecao" title="fill" options="IGRP_BLOCKLY_DROPS.selecao"></field>'
				
				+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/left-arrow.svg"></field>'
				
				+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/dao.svg"></field>'
				
				+'<field type="dropdown" name="dao" title="DAO" options="IGRP_BLOCKLY_DROPS.dao_list"></field>'
				
				+'<field type="checkbox" name="selecionar" title="select option?" options="FALSE"></field>'
				
			+'</value>'
			
			+'<value name="key_val" type="statement" check="Linha">'
			
				+'<block type="option_dao" prev-statement="Linha" next-statement="Linha" color="100" inline="true">'
				
					+'<value type="value" title="key" name="key_val">'
					
					+'</value>'
					
					+'<value type="value" title="value" name="value_val">'
					
				+'</value>'
				
				+'</block>'
				
			+'</value>'
			
			+'</block>'	
			
			+'</category>'
			
			+'<sep class="blocly-dynamic"></sep>'
			
			);
		}
		
	    //********************************************** BUTTONS **********************************************************
	 
	 var str='';
	 
		$('item[rel]', BlocklyXML).each(function(i, element) {
			
			var button = $(element).attr('rel');
			
			var custom = $(element).attr('custom_return');
			
			var page_target = $(element).find('>page').text();
			
			buttons_model.push([ button, button ]);
			
			all_buttons.push(button);
			
			addbutton++;
			
			addmodel++;
			
			if (custom == 'true'){
				
				custombutton ++;
				
			}
			
		});
		
		
		all_buttons.forEach(function(button) {
			
			str += '<value name="'+button+'1" type="dummy" title="action '+button+'" class="blocly-dynamic"></value>'
			
		 			+'<value name="'+button+'" type="statement" class="blocly-dynamic"></value>';
			
		});
		
		$('#controller').append(str);
		
		$('#controller').append(
				
				'<value name="custom1" type="dummy" title="custom action" class="blocly-dynamic"></value>'
				
	 			+'<value name="custom_actions" type="statement" class="blocly-dynamic"></value>'
	 			
		);
		
		
		if(addbutton!=0)
		{
			
		$('#parameters').append(
			
			'<block type="rediret_p" color="60" prev-statement="" next-statement="" inline="true" class="blocly-dynamic">'
			
				+'<value name="value1" type="dummy" >'
				
				+'<field type="field_text" name="param" title="send parameter" options=""></field>'
				
				+'<field type="dropdown" name="button"  title=" in button" options="IGRP_BLOCKLY_DROPS.buttons"></field>'
				
				+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/send-icon.svg"></field>'
				
				+'</value>'
				
			+'</block>'
	
			+'<block type="add_isedit" prev-statement="" next-statement="" color="60" class="blocly-dynamic">'
			
				+'<value name="value3" type="dummy">'
				
				+'<field type="dropdown" name="button" title="send parameter isEdit in button" options="IGRP_BLOCKLY_DROPS.buttons"></field>'
				
				+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/send-icon.svg"></field>'
				
				+'</value>'
				
			+'</block>'
			
			+'<block type="param_dao" color="60" prev-statement="" next-statement="" inline="true" class="blocly-dynamic">'
			
				+'<value name="value1" type="dummy" >'
				
					+'<field type="field_text" name="param" title="send parameter" options=""></field>'
				
				+'</value>'
				
				+'<value type="value" name="dao_field"  title="="></value>'
				
				+'<value type="dummy">'
				
				+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/send-icon.svg"></field>'
				
				+'</value>'
			
			+'</block>'
				
			);
		}
		
		if(custombutton!=0)
			
		{
			
		$('#toolbox').append(
				
				'<category id="custombutton" name="Custom Return" colour="40" class="blocly-dynamic">'	
				
				+'<block type="custombutton" color="40" prev-statement="" next-statement="" inline="true" class="blocly-dynamic">'
				
					+'<value name="value1" type="dummy" >'
					
						+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/custom-icon.svg"></field>'
					
						+'<field type="dropdown" name="return" title ="return" options="IGRP_BLOCKLY_DROPS.returns"></field>'
						
						+'<field type="text" name="param" options="page:"></field>'
						
						+'<field type="dropdown" name="page" options="IGRP_BLOCKLY_DROPS.pages"></field>'
						
					+'</value>'
					
				+'</block>'
				
				+'</category>'
				
				+'<sep class="blocly-dynamic"></sep>'
					
				);
		}
		
	 
		// ********************************************** TABLE  ************************************************************
		
		
	 $('rows>content>*[type="table"]', BlocklyXML).each(function(i, element){
			
			IGRP_BLOCKLY_DROPS.tablesTest[element.tagName] = [];
			
			$(element).find('>fields>*').each(function(x, field) {
				
				var	 tag = $(field).prop('tagName');
				
				var type = $(field).attr('java-type') || $(field).attr('type');
				
				var javaType = GetJavaType[type] || type || 'String';
				
					
				fields_table.push([ tag, javaType + '::'+tag]);
				
				IGRP_BLOCKLY_DROPS.tablesTest[element.tagName].push( [ tag, javaType + '::'+tag] );	
				
			})
	
		});
	 
	$('rows>content>*', BlocklyXML).each(function(i, element){
			
		if($(element).attr('type')== 'table')
		{
			
			var	 table = $(element).prop('tagName');
			
			tables_model.push([ table, table ]);
			
			addtable++;
			
			if(addtable == 1)
			{
			
			$('#toolbox').append('<category id="table" name="Table" colour="140" class="blocly-dynamic"></category>'
					
					+'<sep class="blocly-dynamic"></sep>');
			}
				
			var getColumnsBlock = function(){
				
				var rtn = '';
				
				var first = true;
				
				IGRP_BLOCKLY_DROPS.tablesTest[table].forEach(function(f, fi){

					rtn+= '<block type="rowtable'+f[0]+'" id="'+f[1]+'" prev-statement="Linha" next-statement="Linha" color="140">'
					
								+'<value type="value" name="fields_model">'

									+'<field type="text" options="Set '+f[0]+'"></field>'
								
//									+'<field type="dropdown"  name="coluna" options="IGRP_BLOCKLY_DROPS.tablesTest.'+table+'"></field>'
									
									+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/row_icon.svg"></field>'
									
								+'</value><next>';

				});
				
				IGRP_BLOCKLY_DROPS.tablesTest[table].forEach(function(f, fi){
					
					rtn+='</next></block>';
					
				})

				return rtn;
			}
				
			$('#table').append(
					
					'<category id="'+table+'" name="'+table+'" colour="140" class="blocly-dynamic">'
			
						+'<block type="listar_'+table+'" id="'+table+'" color="140" mutator="where" prev-statement="" next-statement="" inline="true">'
						
							+'<value name="value1" type="dummy">'
							
								+'<field type="dropdown" name="table" title="'+table+'"></field>'
								
								//+'<field type="comment" options="This block is used to list datas from a DAO class in one table."></field>'
								
								+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/left-arrow.svg"></field>'
								
								+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/dao.svg"></field>'
								
								+'<field type="dropdown" name="dao" title="DAO" options="IGRP_BLOCKLY_DROPS.dao_list"></field>'
								
								+'<field type="dropdown" name="find" title="list" options="IGRP_BLOCKLY_DROPS.findList"></field>'
								
								+'<field type="checkbox" name="FILL" title="empty table?" options="FALSE"></field>'
							
							+'</value>'
							
							+'<value name="value2" type="statement" check="Linha" >'
							
								+getColumnsBlock()
							
							+'</value>'
						
					+'</block>'
					
					+'</category>'

					);
			}
	});
			
			// ********************************************** SEPARATOR-LIST  *************************************
			
	$('rows>content>*[type="separatorlist"]', BlocklyXML).each(function(i, element){
		
		IGRP_BLOCKLY_DROPS.tablesTest[element.tagName] = [];
		
		$(element).find('>fields>*').each(function(x, field) {
			
			var	 tag = $(field).prop('tagName');
			
			var type = $(field).attr('java-type') || $(field).attr('type');
			
			var javaType = GetJavaType[type] || type || 'String';
			
			var domain = $(field).attr('domain');
			
			if(type == "select" && domain !="")
			{
				fields_separator.push([tag, 'SelectDomSep*'+domain+'::'+tag]);
				
				IGRP_BLOCKLY_DROPS.tablesTest[element.tagName].push( [tag, 'SelectDomSep*'+domain+'::'+tag] );	
			}
			else{
				
				fields_separator.push([ tag, javaType + '::'+tag]);
				
				IGRP_BLOCKLY_DROPS.tablesTest[element.tagName].push( [ tag, javaType + '::'+tag] );	
				
			}	
		
		})
				
		if($(element).attr('type')== 'separatorlist')
		{
			
			var separator = $(element).prop('tagName');
			
			separator_model.push([ separator, separator ]);
			
			addseparator++;
			
			if(addseparator == 1)
			{
			
			$('#toolbox').append(
					
					'<category id="separator" name="Separator-List" colour="80" class="blocly-dynamic"></category>'
					
					+'<sep class="blocly-dynamic"></sep>'
					
					);
			}
					
			var getSeparatorBlock = function(){
				
				var rtn = '';
				
				var first = true;
				
				IGRP_BLOCKLY_DROPS.tablesTest[separator].forEach(function(f, fi){
					
					rtn+= '<block type="sep_row_'+f[0]+'" id="'+f[1]+'" prev-statement="" next-statement="" color="80">'
					
							+'<value type="value" name="fields_model">'
							
								+'<field type="text" options="Set '+f[0]+'"></field>'
							
								//+'<field type="dropdown" name="coluna" options="IGRP_BLOCKLY_DROPS.tablesTest.'+separator+'"></field>'
								
								+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/row_icon.svg"></field>'
								
							+'</value><next>';''
	
				});
				
				IGRP_BLOCKLY_DROPS.tablesTest[separator].forEach(function(f, fi){
					
					rtn+='</next></block>';
					
				})
				
				return rtn;
			}
			
			$('#separator').append(	
					
					'<category id="'+separator+'" name="'+separator+'" colour="80" class="blocly-dynamic">'
					
						+'<block type="separator_'+separator+'" mutator="where" color="80"  prev-statement="" next-statement="" inline="true">'
						
							+'<value name="id_separator" type="value">'
							
							+'<field type="text" options="list '+separator+'"></field>'
							
							+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/left-arrow.svg"></field>'
							
							+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/dao.svg"></field>'
							
							+'<field type="dropdown" name="dao" title="DAO" options="IGRP_BLOCKLY_DROPS.dao_list"></field>'
							
							+'<field type="text" options="set Id separator"></field>'
							
							+'</value>'
							
							+'<value name="value2" type="statement" >'
							
							+getSeparatorBlock()
							
							+'</value>'
						
						+'</block>'
					
						+'<block type="save_sepator_'+separator+'" color="80"  prev-statement="" next-statement="" inline="true">'
						
							+'<value type="dummy">'
							
								+'<field type="text" options="save '+separator+'"></field>'
								
								+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/right-arrow.svg"></field>'
								
								+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/dao.svg"></field>'
								
								+'<field type="dropdown" name="dao" title="DAO" options="IGRP_BLOCKLY_DROPS.dao_list"></field>'
								
							+'</value>'
							
							+'<value name="value2" type="statement" >'
							
							+'</value>'
						
						+'</block>'
					
						+'<block type="get_row_sep_'+separator+'" output="" color="300">'
						
							+'<value type="dummy" title="get row separator" name="fields_model">'
							
								+'<field type="dropdown" name="get_row_sep" options="IGRP_BLOCKLY_DROPS.tablesTest.'+separator+'"></field>'
								
								+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/row_icon.svg"></field>'
								
							+'</value>'
						
						+'</block>'
					
					+'</category>'
			
				);
			}
		
	});
			
		// ********************************************** FORM-LIST  *************************************
			

	$('rows>content>*[type="formlist"]', BlocklyXML).each(function(i, element) {
		
		IGRP_BLOCKLY_DROPS.tablesTest[element.tagName] = [];
		
		$(element).find('>fields>*').each(function(x, field) {
			
			var	 tag = $(field).prop('tagName');
			
			var type = $(field).attr('java-type') || $(field).attr('type');
			
			var javaType = GetJavaType[type] || type || 'String';
			
			var domain = $(field).attr('domain');
			
			if(type == "select" && domain !="")
			{
				fields_formlist.push([tag, 'SelectDomSep*'+domain+'::'+tag]);
				
				IGRP_BLOCKLY_DROPS.tablesTest[element.tagName].push( [tag, 'SelectDomSep*'+domain+'::'+tag] );
			}
			
			else{
				
				fields_formlist.push([ tag, javaType + '::'+tag]);
			
				IGRP_BLOCKLY_DROPS.tablesTest[element.tagName].push( [ tag, javaType + '::'+tag] );
			}
		
		})
	
		if($(element).attr('type')== 'formlist')
		{
			
			var formlist = $(element).prop('tagName');
			
			formlist_model.push([ formlist, formlist ]);
			
			addformlist++;
			
			if(addformlist == 1)
			{
			
			$('#toolbox').append(
					
					'<category id="formlist" name="Form-List" colour="200" class="blocly-dynamic"></category>'
					
					+'<sep class="blocly-dynamic"></sep>'
					
					);
			}
				
			var getFormlistBlock = function(){
				
				var rtn = '';
				
				var first = true;
				
				IGRP_BLOCKLY_DROPS.tablesTest[formlist].forEach(function(f, fi){
					
					rtn+= '<block type="sep_form_'+f[0]+'" id="'+f[1]+'" prev-statement="" next-statement="" color="200">'
					
							+'<value type="value" name="fields_model">'
							
								+'<field type="text" options="Set '+f[0]+'"></field>'
							
								//+'<field type="dropdown" name="coluna" options="IGRP_BLOCKLY_DROPS.tablesTest.'+formlist+'"></field>'
								
								+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/row_icon.svg"></field>'
								
								+'</value><next>';''
	
				});
				
				IGRP_BLOCKLY_DROPS.tablesTest[formlist].forEach(function(f, fi){
					
					rtn+='</next></block>';
					
				})
				
				return rtn;
			}
			
			$('#formlist').append(	
					
				'<category id="'+formlist+'" name="'+formlist+'" colour="200" class="blocly-dynamic">'
				
					+'<block type="forrmlist_'+formlist+'" mutator="where" color="200"  prev-statement="" next-statement="" inline="true">'
					
						+'<value name="id_formlist" type="value">'
						
							+'<field type="text" options="list '+formlist+'"></field>'
							
							+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/left-arrow.svg"></field>'
							
							+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/dao.svg"></field>'
							
							+'<field type="dropdown" name="dao" title="DAO" options="IGRP_BLOCKLY_DROPS.dao_list"></field>'
							
							+'<field type="text" options="set Id formlist"></field>'
						
						+'</value>'
						
						+'<value name="value2" type="statement" >'
						
						+getFormlistBlock()
						
						+'</value>'
					
					+'</block>'
					
					+'<block type="save_forlist_'+formlist+'" color="200"  prev-statement="" next-statement="" inline="true">'
					
						+'<value type="dummy">'
						
							+'<field type="text" options="save '+formlist+'"></field>'
							
							+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/right-arrow.svg"></field>'
							
							+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/dao.svg"></field>'
							
							+'<field type="dropdown" name="dao" title="DAO" options="IGRP_BLOCKLY_DROPS.dao_list"></field>'	
							
						+'</value>'
						
						+'<value name="value2" type="statement" >'
						
						+'</value>'
					
					+'</block>'
				
					+'<block type="get_row_form_'+formlist+'" output="" color="300">'
					
						+'<value type="dummy" title="get row formlist" name="fields_model">'
						
							+'<field type="dropdown" name="get_row_sep" options="IGRP_BLOCKLY_DROPS.tablesTest.'+formlist+'"></field>'
							
							+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/row_icon.svg"></field>'
							
						+'</value>'
					
					+'</block>'
				
				+'</category>'
		
			);
		}
		
	});
		
		//*********************************************** GRAFICO ***************************************************

	$('rows>content>*[type="chart"]', BlocklyXML).each(function(i, element){
		
	if($(element).attr('type')== 'chart')
		
		{
			var char = $(element).prop('tagName');
			
			chart.push([ char, char ]);
			
			addchart++;
			
			if(addchart == 1)
			{
			
			$('#toolbox').append(
					
					'<category id="dashboard" name="Dashboard" colour="80" class="blocly-dynamic"></category>'
					
					+'<sep class="blocly-dynamic"></sep>'
					
					);
			}
			
			$('#dashboard').append(	
					
					'<category id="'+char+'" name="'+char+'" colour="120" class="blocly-dynamic">'
					
					+'<block type="grafico_'+char+'" color ="120" prev-statement="" next-statement="" >'
					
						+'<value name="value1" type="dummy" >'
						
							+'<field type="text" options="fill '+char+'"></field>'
							
							+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/left-arrow.svg"></field>'
							
							+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/dao.svg"></field>'
							
							+'<field type="dropdown" name="dao" title="DAO" options="IGRP_BLOCKLY_DROPS.dao_list"></field>'
							
						+'</value>'
						
						+'<value name="eixoX"  title="Eixo X" type="value"></value>'
						
						+'<value name="eixoY"  title="Eixo Y" type="value"></value>'
						
					+'</block>'
					
					+'</category>'
					
				+'</category>'
			
				);
		}
	
	});
	
       // *******************************************GET DAO OBJECTS *****************************************
	
	var iurlArr = path.split('/');
	
	var iurl   = iurlArr[0] == '' ? iurlArr[1] : 'IGRP';
	
	$.ajax({url : '/'+iurl+'/app/webapps?r=igrp_studio/Env/Retornarxml&app_name='+AppTitle, headers : {'x-igrp-remote' : 1},
		
	method : 'GET',
	
	dataType : 'xml',
	
	success : function(data) {
		
		var temdao = '';
		
			temdao = $(data).find('dao>').text();
		
		if(temdao != '')
		{
			
			$('#toolbox').append(
					
					'<category id="dao" name="DAO" colour="160" class="blocly-dynamic">'
					
							+'<block type="index_editar" color ="160" mutator="where" prev-statement="" next-statement="" inline="true">'
							
							+'<value type="dummy" >'
							
							+'<field type="text" options="fill model"></field>'
							
							+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/left-arrow.svg"></field>'
							
							+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/dao.svg"></field>'
							
								+'<field type="dropdown" name="dao" title="DAO" options="IGRP_BLOCKLY_DROPS.dao_list"></field>'
								
							//+'<field type="text" title="by:" options=""></field>'
								
							+'</value>'
							
							+'<value name="value2" type="statement">'
							
							 +'<block type="model_set" prev-statement="" next-statement="" color="300">'
							 
						 		+'<value name="value1" type="value" title="set model">'
						 		
						 			+'<field type="dropdown" name="set_model" options="IGRP_BLOCKLY_DROPS.fields"></field>'
						 			
						 			+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/model_icon.svg"></field>'
						 			
								+'</value>'
								
							 +'</block>'
							 
							+'</value>' 
							
							+'</block>'
					
							+'<block type="inserir_dao" mutator="separatori" color ="160" prev-statement="" next-statement="" inline="true">'
							
								+'<value type="dummy" title="save">'
								
									+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/right-arrow.svg"></field>'
									
									+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/dao.svg"></field>'
									
									+'<field type="text" options="DAO"></field>'
									
									+'<field type="dropdown" name="dao" options="IGRP_BLOCKLY_DROPS.dao_list"></field>'
									
									+'<field type="checkbox" name="EDIT" title="edit?" options="FALSE" update-shape="true"></field>'
									
								+'</value>'
								
								+'<value name="value2" type="statement">'
								
								+'</value>'
								
							+'</block>'
							
							+'<block type="param_foreign" output="" color="160" class="blocly-dynamic">'
							
							+'<value name="value1" type="value"  title="get foreign-key">'
							
							+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/foreign-icon.svg"></field>'
							
							+'</value>'	
							
							+'</block>'
						
					// +'<block type="instance_dao" color ="160" prev-statement=""
							
					// next-statement="">'
							
					// +'<value name="findone" type="value" >'
							
					// +'<field type="dropdown" name="dao" title="declarate obj in DAO" options="IGRP_BLOCKLY_DROPS.dao_list"></field>'
							
					// +'<field type="text" options="or find by:"></field>'
							
					// +'</value>'
							
					// +'</block>'
											
					// +'<block type="dao_obj" color ="160" output="" title="obj"></block>'
						
					+'</category><sep class="blocly-dynamic"></sep>'
					
			);
				
				
				
				if(addforeign!=0)
					
				{
					
					$('#parameters').append(
							
						'<block type="enviar_p" color ="60" prev-statement="" next-statement="">'
						
							+'<value name="PARAM" type="dummy">'
							
								+'<field type="dropdown" name="iskey" title="send primary-key" options="IGRP_BLOCKLY_DROPS.keys"></field>'
								
								+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/send-icon.svg"></field>'
								
							+'</value>'
							
						+'</block>'	
						
						+'<block type="editar_dao" color ="60" prev-statement="" next-statement="">'
							
							+'<value type="dummy">'
							
								+'<field type="text" options="send parameter isEdit"></field>'
							
								+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/send-icon.svg"></field>'
							
							+'</value>'
						
						+'</block>'
						
					);
				
					$('#dao').append(
					
						'<block type="apagar" color="160" prev-statement="" next-statement="" inline="true">'
						
						+'<value name="valor1" type="value">'
						
							+'<field type="text" options="delete"></field>'
						
							+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/delete-icon.svg"></field>'
						
							+'<field type="dropdown" name="dao" title="in DAO" options="IGRP_BLOCKLY_DROPS.dao_list"></field>'
							
							+'<field type="dropdown" name="iskey" title="where param" options="IGRP_BLOCKLY_DROPS.keys"></field>'
							
							+'<field type="text" options="="></field>'
							
						+'</value>'
						
						+'</block>'
						
					);
				}
				
	}
		
		$(data).find('dao>*').each(function(i, f) {
			
			var daos = $(f).prop('tagName');
			
			daoClasses[daos] = true;
			
			daos_list.push([ daos, daos ]);
			
			bloc_fields.push(daos);
									
			$('#dao').append('<category id="'+daos+'" name="'+daos+'" colour="150"></category>\n');
			
		});
		
		bloc_fields.forEach(function(daos) { 
			
			var fieldy_list = [];
			
			fieldy_list.push(['--','--' ]);
			
			
			IGRP_BLOCKLY_DROPS.daos[daos] = fieldy_list;
			
			$(data).find('dao>' + daos+ '>*').each(function(i, f) {

				var field = $('nome',f).text(),
					
					type = $('tipo',f).text();
					
				fieldy_list.push([field,type+'::'+field ]);
			
			})
			
			$('#'+daos+'').append(
					
				'<block type="set-dao-'+daos+'" igrp="tete" color="160"  prev-statement="" next-statement="" class="blocly-dynamic">'
				
					+'<value name="value1" type="value" title="set '+daos+'">'
					
						+'<field type="dropdown" name="fields" options="IGRP_BLOCKLY_DROPS.daos.'+daos+'"></field>'
						
						+'<field type="image" name="img" src="'+path+'/core/blockly/blockly/media/dao.svg"></field>'
						
					+'</value>'
					
				+'</block>\n');
			
			$('#'+daos+'').append(
					
					'<block type="get-dao-'+daos+'" color="160" output="" class="blocly-dynamic">'
					
					+'</block>'
					
					);
	});
	
	 IGRP_BLOCKLY_DROPS = $.extend(IGRP_BLOCKLY_DROPS,{
			
			comparison : COMPARISON,
			
			core_msg : CORE_MSG,
			
			core_conv : CORE_CONV,
			
			core_if : CORE_IF,
			
			find : FIND,
			
			tipo : TIPO,
			
			where : WHERE,
			
			returns : RETURNS,
			
			pages : PAGES,
			
			and_or : ANDOR,
			
			true_false : TRU_FAL,
			
			dao_list : daos_list,
			
			buttons : buttons_model,
			
			fields : fields_model,
			
			tables : tables_model,
			
			separators : separator_model,
			
			formlists : formlist_model,
			
			esp_rows : fields_esp_row,
			
			selecao : select,
			
			ID_MODEL : form_id,
			
			findList : FINDLIST,
			
			keys : key_model,
			
			fields_TABLE : fields_table,
			
			fields_SEP : fields_separator,
			
			fields_FORM : fields_formlist,
			
			chart_model : chart
					
		});

		if (!blockyInit) {
			
			Code.init();
			
			blockyInit=true;

			var demoWorkspace = Blockly.mainWorkspace;

			Blockly.Xml.domToWorkspace( $('#inicial_script')[0] ,demoWorkspace);
			
			$('#igrp-form-gen').trigger('blockly-ready');
			
		}else{
			
			var toolbox = $('#toolbox')[0];

			Blockly.mainWorkspace.updateToolbox(toolbox);
			
			SetupBlockly();
			
		}
	},
	
	error : function(data) {
		console.log('Error: '+data);
	}
	});
	
}

var codeBlockStart = '/* Start-Code-Block (',

	codeBlockEnd   = '/* End-Code-Block */';

function GetBlocklyImports(){
	
	try{
		
		var xml = Blockly.Xml.workspaceToDom(Blockly.mainWorkspace),
		
			listarImports = $('block[type*="listar_"]',xml),	
			
			inserirImports = $('block[type="inserir_dao"]',xml),
			
			fillComboImports = $('block[type="fill_combo"]',xml),
			
			separatorImports = $('block[type*="separator_"]',xml),
			
			formlistImports = $('block[type*="forrmlist_"]',xml),
			
			saveseparatorImports = $('block[type*="save_sepator_"]',xml),
			
			saveformlistImports = $('block[type*="save_forlist"]',xml),
			
			graficoImports = $('block[type*="grafico_"]',xml),
			
			combodaoImports = $('block[type="combo_dao"]',xml),
			
			daosImports   = $('block[type*="set-dao-"], block[type*="get-dao-"]',xml),
			
			fieldDaos     = $('field[name="dao"]', xml),
			
			Fields 		  = $('field', xml),
			
			fieldsImportsMap = {
			
				'Date' : true,
				
				'File' : true,
				
				'Link' : true
			}
			
			rtn = '';
		
		if(listarImports[0])
			
			rtn+='<import type="listar">Listar</import>';
		
		if(fillComboImports[0])
			
			rtn+='<import type="fill_combo">Select</import>';
		
		if(separatorImports[0])
			
			rtn+='<import type="separator">Separator</import>';

		if(formlistImports[0])
			
			rtn+='<import type="formlist">Formlist</import>';
		
		if(saveseparatorImports[0]){
			
			saveseparatorImports.each(function(i, sep){
				
				var blockType =$.trim($(sep).attr('type').split('save_sepator_').pop());
				
				rtn+='<import type="save_separator">'+blockType+'</import>';
				
			})
			
		}
		
		if(saveformlistImports[0]){
			
			saveformlistImports.each(function(i, form){
				
				var blockType =$.trim($(form).attr('type').split('save_forlist_').pop());
				
				rtn+='<import type="save_formlist">'+blockType+'</import>';
				
			})
				
		}
		
		if(graficoImports[0]){
			
			graficoImports.each(function(i, grap){
				
				var blockType =$.trim($(grap).attr('type').split('grafico_').pop());
				
				rtn+='<import type="grafico">'+blockType+'</import>';
				
			})
				
		}
		
		if(inserirImports[0])
			
			rtn+='<import type="inserir_dao">Inserir Daos</import>';
		
		if(combodaoImports[0])
			
			rtn+='<import type="combo_dao">Combo Dao</import>';
				
		if(daosImports[0] || fieldDaos[0]){
			
			var incs = {};
			
			daosImports.each(function(i, dao){
				
				var daoClass = $.trim($(dao).attr('type').split('et-dao-').pop());
				
				if(!incs[daoClass])
					
					incs[daoClass] = true;

			});
			
			fieldDaos.each(function(i,fdao){
				
				var daoClss = $(fdao).text();
				
				if(!incs[daoClss])
					
					incs[daoClss] = true;
				
			});
			
			for(var i in incs){
				
				rtn+='<import type="dao">'+i+'</import>';
				
			}
			
		}

		var fieldsInc = {};
		
		Fields.each(function(i,f){
			
			var text = $(f).text();
			
			if(text.indexOf('::') >=0 ){
				
				var strSplit = text.split('::'),
				
					type     = strSplit[0],
					
					val 	 = strSplit[1];
				
				if(fieldsImportsMap[type] && !fieldsInc[type]){
					
					fieldsInc[type] = true;
					
				}
				
				if(daoClasses[type]){
					
					fieldsInc[type] = 'dao';
					
				}

			}
			
		});
		
		for(var x in fieldsInc){

			var type = fieldsInc[x] != true ?  fieldsInc[x] : 'fields';
			
			rtn+='<import type="'+type+'">'+x+'</import>';
			
		}
	
		return '<imports>'+rtn+'</imports>';
			
	}catch(err){
		return '';
	}
	
}

function GetDefaultBlocklyXML(){
	try{
		var xml = Blockly.Xml.workspaceToDom(Blockly.mainWorkspace),
		
			xmlStr = new XMLSerializer().serializeToString(xml);
	  
		xmlStr = xmlStr.replaceAll(' xmlns="http://www.w3.org/1999/xhtml"' ,'');
	 
		return xmlStr;
		
	}catch(err){
		
		return '';
		
	}
	
}

function GetBlocklyXML(){
	
	var xml = Blockly.Xml.workspaceToDom(Blockly.mainWorkspace),
	
		xmlStr = new XMLSerializer().serializeToString(xml);
	  
	 xmlStr = xmlStr.replaceAll('xmlns="http://www.w3.org/1999/xhtml"' ,'');
	  
	  var MainXML = (
			  
	    '<main>'+
	    
	    	'<config>'+
	    	
	    		'<app>'+
	    		
	    			'<title>'+AppTitle+'</title>'+
	    			
	    		'</app>'+
	    		
	    		'<page>'+
	    		
	    			'<title>'+PageTitle+'</title>'+
	    			
	    		'</page>'+
	    		
	    	'</config>'+
	    	
	    	xmlStr+
	    	
	    '</main>'	  
	  
	  );

	  return vkbeautify.xml(MainXML); 
}

function GetBlocklyActionsCode(callback){
	
	var xml = GetBlocklyXML(),
	
		xmlDoc;
	
	if (window.DOMParser) {
		
		// code for modern browsers
		
		var parser = new DOMParser();
		
		xmlDoc = parser.parseFromString(xml,"text/xml");
		
	} else {
	  // code for old IE browsers
		
		xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		
		xmlDoc.async = false;
		
		xmlDoc.loadXML(xml);
	} 

	$('<div/>').XMLTransform({
		
		xml : xmlDoc,
		
		xsl : path+'/core/blockly/transform/xsl/IGRP.blockly.java.xsl',
		
		xslBasePath : path+'/core/blockly/transform/xsl',
		
		complete:function(content){
			
			var html = content.html();
			
			var response = HandleCode(html);
			
			if(callback)
				
				callback(response);
			
		}
	});
	
}

function HandleCode(code){
	
	code = code || GetBlocklyXML();
	
	var startsIndexArray = getIndicesOf( codeBlockStart, code ),
	
		endsIndexArray   = getIndicesOf( codeBlockEnd, code ),
		
		response  		 = {};
	
	if(startsIndexArray.length == endsIndexArray.length){
		
		startsIndexArray.forEach(function(startIndex,i){
			
			var endIndex = endsIndexArray[i],
			
				blockCode = code.substring(startIndex,endIndex),
				
				startDeclarionEnd = ') */',
				
				nameStartIdx = blockCode.indexOf(codeBlockStart),

				nameEndIdx = blockCode.indexOf(startDeclarionEnd),

				actionName = blockCode.substring(nameStartIdx + codeBlockStart.length, nameEndIdx),
				
				startExpression = codeBlockStart+actionName+startDeclarionEnd,
				
				actionCode = blockCode.substring(startExpression.length, blockCode.length);

			response[actionName] = actionCode;
			
		});
		
		return response;
	}
	
}

$.IGRP.on('init', function(){
	
	GEN = VARS.getGen();
	
	GEN.on('ready', function(){
		
		PAGES = function(){
			
			var arr = [];
			
			GEN.DETAILS.linkPageList.forEach(function(item){
			
				arr.push( [item.page,item.page] )
				
			})
			
			return arr;
			
		}();
		
	})

	var pageBlockly = null;
	
	GEN.on('ready', function(){
		
		IGRPBlocklyInit();
		
		$('#igrp-form-gen').on('blockly-ready', function(){
			
			if(pageBlockly){
				
				setTimeout(function(){
					
					Blockly.mainWorkspace.clear();
					
					Blockly.Xml.domToWorkspace(pageBlockly, Blockly.mainWorkspace);
					
				},400)		
				
			}
	
		})
		
	});
	
	$('li[rel="gen-blocky"]').on('click',function() {
		
		$('.blocly-dynamic').remove();
		
		IGRPBlocklyInit();
		
		$('#tab_blocks').click();
		
		setTimeout(function(){
			
			$('#refresh_bloco').click();
			
		}, 400)

	})
	
	$('#igrp-form-gen').on('on-export', function(e, data){
		
		data.blocklyData = GetDefaultBlocklyXML();
		
	})
	
	$('#igrp-form-gen').on('on-import', function(e, data){
		
		if( data.blocklyData ){
			var xml = Blockly.Xml.textToDom( data.blocklyData );
			pageBlockly = xml;
		}
			
	})
	
})
