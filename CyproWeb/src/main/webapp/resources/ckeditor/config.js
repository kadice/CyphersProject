/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
    config.contentsCss = '/ckeditor/styles_editStory.css';
    config.width = 900;     // 900 pixels wide.
    config.height = 500;
    
    config.extraPlugins = 'wordcount,notification';
    config.wordcount = {
    	showParagraphs: false,
        showWordCount: false,
        showCharCount: true,
	    countHTML: true,
        maxWordCount: -1,
        maxCharCount: -1
    };
    
    config.defaultLanguage = 'zh';
    config.fontSize_sizes = '12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;36/36px;48/48px;';
    config.font_names = '新細明體;標楷體;微軟正黑體;Arial;Arial Black;Comic Sans MS;Courier New;Tahoma;Times New Roman;Verdana';
	config.toolbarGroups = [
		{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
		{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },
		{ name: 'forms', groups: [ 'forms' ] },
		{ name: 'links', groups: [ 'links' ] },
		{ name: 'insert', groups: [ 'insert' ] },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'colors', groups: [ 'colors' ] },
		{ name: 'styles', groups: [ 'styles' ] },
		{ name: 'tools', groups: [ 'tools' ] },
		{ name: 'others', groups: [ 'others' ] },
		{ name: 'about', groups: [ 'about' ] }
	];

	config.removeButtons = 'Preview,Print,Templates,Save,NewPage,PasteFromWord,PasteText,Find,Replace,SelectAll,Scayt,CopyFormatting,CreateDiv,BidiLtr,BidiRtl,Language,Anchor,Flash,Smiley,PageBreak,Iframe,ImageButton,Button,Form,Radio,Checkbox,TextField,Textarea,Select,HiddenField,About,Maximize,ShowBlocks';
};