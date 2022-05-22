<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.item.list.label.name" path="name" width="20%"/>
	<acme:list-column code="inventor.item.list.label.type" path="type" width="20%"/>
	<acme:list-column code="inventor.item.list.label.retailPrice" path="retailPrice" width="20%"/>
	<acme:list-column code="inventor.item.list.label.description" path="description" width="30%"/>
	<acme:list-column code="inventor.item.list.label.published" path="published" width="10%"/>
</acme:list>