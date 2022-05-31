<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
    <acme:list-column code="inventor.item.list.label.code" path="code" width="10%"/>
	<acme:list-column code="inventor.item.list.label.name" path="name" width="20%"/>
	<acme:list-column code="inventor.item.list.label.type" path="type" width="10%"/>
	<acme:list-column code="inventor.item.list.label.description" path="description" width="40%"/>
	<acme:list-column code="inventor.item.list.label.technology" path="technology" width="20%"/>
<%--	<acme:list-column code="inventor.item.list.label.published" path="published" width="10%"/>   --%>
</acme:list>

<jstl:if test="${type == 'COMPONENT'}">
    <acme:button code="inventor.item.list.button.create" action="/inventor/item/create?type=COMPONENT"/>
</jstl:if>

<jstl:if test="${type == 'TOOL'}">
    <acme:button code="inventor.item.list.button.create" action="/inventor/item/create?type=TOOL"/>
</jstl:if>