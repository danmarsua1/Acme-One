<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form >
	<acme:input-textbox code="patron.patronage.form.label.code" path="code" readonly="true"/>
	<jstl:if test="${command != 'create'}">
		<acme:input-textbox code="patron.patronage.form.label.creationMoment" path="creationMoment" readonly="true"/>
	</jstl:if>
	<jstl:if test="${command == 'create'}">
		<acme:input-textbox code="patron.patronage.form.label.initDate" path="initDate"/>
	<acme:input-textbox code="patron.patronage.form.label.finishDate" path="finishDate"/>
	</jstl:if>
	<acme:input-textbox code="patron.patronage.form.label.budget" path="budget"/>
	<jstl:if test="${status !='PROPOSED' && command != 'create'}">
		<acme:input-textbox code="patron.patronage.form.label.status" path="status" readonly="true"/>
	</jstl:if>
	<jstl:if test="${status =='PROPOSED' && command != 'create'}">
		<acme:input-select code="patron.patronage.form.label.status" path="status">
			<acme:input-option code="PROPOSED" value="PROPOSED" selected="true"/>
			<acme:input-option code="ACCEPTED" value="ACCEPTED"/>
			<acme:input-option code="DENIED" value="DENIED"/>
		</acme:input-select>
	</jstl:if>
	
	<acme:input-textbox code="patron.patronage.form.label.legalStuff" path="legalStuff"/>
	<acme:input-textbox code="patron.patronage.form.label.link" path="link"/>
	<acme:button code="patron.patronage.form.label.showInventor" action="/any/user-account/show?id=${inventorId}"/>
	
	
	<jstl:choose>
		<jstl:when test="${acme:anyOf(command,'show, update, delete, publish') && published == false}">
				<acme:submit code="patron.patronage.form.button.delete" action="/patron/patronage/delete"/>
				<acme:submit code="patron.patronage.form.button.update" action="/patron/patronage/update"/>
				<acme:submit code="patron.patronage.form.button.publish" action="/patron/patronage/publish"/>	
		</jstl:when>
		<jstl:when test="${command == 'create'}">
				<acme:submit code="patron.patronage.form.button.create" action="/patron/patronage/create"/>
		</jstl:when>
	</jstl:choose>
</acme:form>

