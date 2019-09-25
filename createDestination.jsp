<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/error.css">
<link rel="stylesheet" href="./css/form.css">
<link rel="stylesheet" href="./css/table.css">
<title>宛先情報入力画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>宛先情報入力画面</h1>
	</div>
	<!-- メッセージリストから対象のエラーメッセージを表示 -->
	<s:if test="familyNameErrorList!=null && familyNameErrorList.size()>0">
		<div class="error">
			<div class="error-message">
				<s:iterator value="familyNameErrorList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</div>
	</s:if>

	<s:if test="firstNameErrorList!=null && firstNameErrorList.size()>0">
		<div class="error">
			<div class="error-message">
				<s:iterator value="firstNameErrorList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</div>
	</s:if>

	<s:if
		test="familyNameKanaErrorList!=null && familyNameKanaErrorList.size()>0">
		<div class="error">
			<div class="error-message">
				<s:iterator value="familyNameKanaErrorList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</div>
	</s:if>

	<s:if
		test="firstNameKanaErrorList!=null && firstNameKanaErrorList.size()>0">
		<div class="error">
			<div class="error-message">
				<s:iterator value="firstNameKanaErrorList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</div>
	</s:if>

	<s:if
		test="userAddressErrorList!=null && userAddressErrorList.size()>0">
		<div class="error">
			<div class="error-message">
				<s:iterator value="userAddressErrorList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</div>
	</s:if>

	<s:if test="telNumberErrorList!=null && telNumberErrorList.size()>0">
		<div class="error">
			<div class="error-message">
				<s:iterator value="telNumberErrorList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</div>
	</s:if>

	<s:if test="emailErrorList!=null && emailErrorList.size()>0">
		<div class="error">
			<div class="error-message">
				<s:iterator value="emailErrorList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</div>
	</s:if>

	<!-- 正常画面表示 -->
	<s:form action="CreateDestinationConfirmAction">
		<table class="vertical-list">
			<tr>
				<th><s:label value="姓" /></th>
				<td><s:textfield name="familyName"
						value="%{#session.familyName}" placeholder="姓" class="form" /></td>
			</tr>
			<tr>
				<th><s:label value="名" /></th>
				<td><s:textfield name="firstName" value="%{#session.firstName}"
						placeholder="名" class="form" /></td>

			</tr>
			<tr>
				<th><s:label value="姓ふりがな" /></th>
				<td><s:textfield name="familyNameKana"
						value="%{#session.familyNameKana}" placeholder="姓ふりがな"
						class="form" /></td>
			</tr>
			<tr>
				<th><s:label value="名ふりがな" /></th>
				<td><s:textfield name="firstNameKana"
						value="%{#session.firstNameKana}" placeholder="名ふりがな" class="form" /></td>
			</tr>
			<tr>
				<th><s:label value="住所" /></th>
				<td><s:textfield name="userAddress"
						value="%{#session.userAddress}" placeholder="住所" class="form" /></td>
			</tr>
			<tr>
				<th><s:label value="電話番号" /></th>
				<td><s:textfield name="telNumber" value="%{#session.telNumber}"
						placeholder="電話番号" class="form" /></td>
			</tr>
			<tr>
				<th><s:label value="メールアドレス" /></th>
				<td><s:textfield name="email" value="%{#session.email}"
						placeholder="メールアドレス" class="form" /></td>
			</tr>
		</table>
		<div class="submit_button">
			<s:submit class="button" value="確認" />
		</div>
	</s:form>

</body>
</html>