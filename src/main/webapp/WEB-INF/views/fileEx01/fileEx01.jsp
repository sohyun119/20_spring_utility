<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<meta charset="utf-8">
<head>
</head>
<body>

	<!-- 
	
		# 파일 업로드시 form태그에서 아래의 두 속성을 반드시 작성해야 한다.
		
		1) method="post
		2) enctype="multipart/form-data"
	
	 -->
	<form action="upload1" method="post" enctype="multipart/form-data">
		<h3>단일 파일 업로드</h3>
		<table border="1" >			
			<tr>
				<td>업로드 파일</td>
				<td><input type="file" name="upFile"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="업로드" ></td>
			</tr>
		</table>
	</form>	
	<br><hr><br>
	
	<form>
		<h3>다중 파일 업로드1</h3>
		<table border="1" >			
			<tr>
				<td>업로드 파일1</td>
				<td></td>
			</tr>
			<tr>
				<td>업로드 파일2</td>
				<td></td>
			</tr>
			<tr>
				<td>업로드 파일3</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="업로드" ></td>
			</tr>
		</table>
	</form>
	<br><hr><br>	
	
	
	<form>
		<h3>다중파일 업로드2(멀티플)</h3>
		<table border="1" >			
			<tr>
				<td>다중파일 업로드</td>
				<td> </td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="업로드" ></td>
			</tr>
		</table>
	</form>
	<br><hr><br>	
	
	
	
</body>
 