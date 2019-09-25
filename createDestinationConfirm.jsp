<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/table.css">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/form.css">
<title>宛先情報入力確認画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>宛先情報入力確認画面</h1>
	</div>

	<table class="vertical-list">
		<tr>
			<th><s:label value="姓" /></th>
			<td><div class="property">
					<s:property value="#session.familyName" />
				</div></td>
		</tr>
		<tr>
			<th><s:label value="名" /></th>
			<td><div class="property">
					<s:property value="#session.firstName" />
				</div></td>
		</tr>
		<tr>

			<th><s:label value="姓ふりがな" /></th>
			<td><div class="property">
					<s:property value="#session.familyNameKana" />
				</div></td>
		</tr>
		<tr>
			<th><s:label value="名ふりがな" /></th>
			<td><div class="property">
					<s:property value="#session.firstNameKana" />
				</div></td>
		</tr>
		<tr>
			<th><s:label value="住所" /></th>
			<td><div class="property">
					<s:property value="#session.userAddress" />
				</div></td>
		</tr>
		<tr>
			<th><s:label value="電話番号" /></th>
			<td><div class="property">
					<s:property value="#session.telNumber" />
				</div></td>
		</tr>
		<tr>
			<th><s:label value="メールアドレス" /></th>
			<td><div class="property">
					<s:property value="#session.email" />
				</div></td>
		</tr>
	</table>

	<!-- backFlgで値の保持 -->
	<s:form action="CreateDestinationCompleteAction">
		<div class="submit_button">
			<s:submit class="button" value="登録" />
		</div>
	</s:form>
	<s:form action="CreateDestinationAction">
		<s:hidden name="backFlg" value="ok" />
		<div class="submit_button">
			<s:submit class="button" value="戻る" />
		</div>
	</s:form>

</body>
</html>