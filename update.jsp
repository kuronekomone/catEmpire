<h1>${wikiPage.name}�̕ҏW</h1>
<link rel="stylesheet" type="text/css" href="./neptune.css">

<FORM ACTION="update">
	<INPUT TYPE="HIDDEN" NAME="cmd" VALUE="update">
	<INPUT TYPE="HIDDEN" NAME="name" VALUE="${wikiPage.name}">
	
	<TEXTAREA ROWS="15" COLS"60" NAME="content">${wikiPage.name}"</TEXTAREA>
	
	<INPUT TYPE="SUBMIT" VALUE="�@�X�V�@">
	<INPUT TYPE="SUBMIT" VALUE="�@�폜�@" ONLICK="cmd.value='delete'">
	<INPUT TYPE="SUBMIT" VALUE="�L�����Z��">


</FORM>