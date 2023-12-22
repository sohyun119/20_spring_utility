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
	 

	<form action="/file/upload1" method="post" enctype="multipart/form-data">
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
	
	<form action="/file/upload2" method="post" enctype="multipart/form-data">
		<h3>다중 파일 업로드1</h3>
		<table border="1" >			
			<tr>
				<td>업로드 파일1</td>
				<td><input type="file" name="files"></td>
			</tr>
			<tr>
				<td>업로드 파일2</td>
				<td><input type="file" name="files"></td>
			</tr>
			<tr>
				<td>업로드 파일3</td>
				<td><input type="file" name="files"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="업로드" ></td>
			</tr>
		</table>
	</form>
	<br><hr><br>	
	
	
	<form action="/file/upload2" method="post" enctype="multipart/form-data">
		<h3>다중파일 업로드2(멀티플)</h3>
		<table border="1" >			
			<tr>
				<td>다중파일 업로드</td>
				<td><input type="file" multiple="multiple" name="files"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="업로드" ></td>
			</tr>
		</table>
	</form>
	<br><hr><br>	
	
	
	<h3>이미지 파일 조회 & 다운로드</h3>
	<table border="1">			
		<tr>
			<th>이미지</th>
			<th>파일명</th>
			<th>다운로드</th>
		</tr>
		<tr>
			<td><img src="/file/thumbnails?fileName=404.PNG" width="200" height="120"/></td>
			<td>404 이미지</td>
			<td><a href="/file/downloadFile?fileName=404.PNG">다운로드</a></td>
		</tr>
		<tr>
			<td><img src="/file/thumbnails?fileName=500.PNG" width="200" height="120"/></td>
			<td>500 이미지</td>
			<td><a href="/file/downloadFile?fileName=500.PNG">다운로드</a></td>
		</tr>
	</table>
	<br><hr><br>
	
	
	<form action="/file/delete" method="post">
		<h3>파일 삭제</h3>
		<table>			
			<tr>
				<td>삭제할 파일명 : </td>
				<td>
					<input type="text" name="deleteFileName">&emsp; 
					<input type="submit" value="삭제" >
				</td>
			</tr>
		</table>	
	</form>	
	<br><hr><br>
	
	
	<form action="/file/update" method="post" enctype="multipart/form-data">
		<h3>파일 수정</h3>
		<table border="1" >			
			<tr>
				<td>삭제할 파일명</td> 
				<td><input type="text" name="deleteFileName" /></td>
			</tr>
			<tr>
				<td>새로 업로드할 파일</td>
				<td><input type="file" name="modifyFile" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" ></td>
			</tr>
		</table>
	</form>	
	
	
	
</body>
 