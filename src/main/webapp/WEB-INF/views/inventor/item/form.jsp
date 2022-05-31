<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:input-textbox code="inventor.item.form.label.code" path="code" readonly="true"/>
	<acme:input-textbox code="inventor.item.form.label.type" path="type" readonly="true"/>
	<acme:input-textbox code="inventor.item.form.label.name" path="name" readonly="true"/>
	<acme:input-textarea code="inventor.item.form.label.description" path="description" readonly="true"/>
	<acme:input-textbox code="inventor.item.form.label.technology" path="technology" readonly="true"/>
	<acme:input-money code="inventor.item.form.label.retailPrice" path="retailPrice" readonly="true"/>
	<acme:input-url code="inventor.item.form.label.link" path="link" readonly="true"/>
	<acme:input-textbox code="inventor.item.form.label.published" path="published" readonly="true"/>
	
	<jstl:if test="${command == 'create'}">
	    <acme:submit code="inventor.item.form.button.create" action="/inventor/item/create?type=${type}"/>
	</jstl:if>
	
	<jstl:if test="${acme:anyOf(command, 'show, update, delete, publish') && published == 'false'}">
	    <acme:submit code="inventor.item.form.button.update" action="/inventor/item/update"/>
	    <acme:submit code="inventor.item.form.button.delete" action="/inventor/item/delete"/>
	    <acme:submit code="inventor.item.form.button.publish" action="/inventor/item/publish"/>
	</jstl:if>
</acme:form>