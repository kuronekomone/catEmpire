<enctype="multipart/form-data" mathod="post">
<link rel="stylesheet" type="text/css" href="./neptune.css">

<h1>${param.name}�̍쐬</h1>

<form action="create" enctype="multipart/form-data">
	<INPUT TYPE="HIDDEN" NAME="cmd" VALUE="create">
	<INPUT TYPE="HIDDEN" NAME="name" VALUE="${param.name}">
	
	<TEXTAREA ROWS="15" COLS"60" NAME="content"></TEXTAREA>
	<BR>
	
	<INPUT TYPE="SUBMIT" VALUE="�@�쐬�@">
	<INPUT TYPE="BUTTON" VALUE="�L�����Z��"ONCLICK="location.href='refer'">

	<br>
	<A>
	�摜�t�@�C��
	<input type="file" name="path">
	</A>
	

</FORM>