<%--
- menu.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>


<%@page language="java"
	import="acme.framework.helpers.PrincipalHelper,acme.roles.Provider,acme.roles.Consumer,acme.framework.roles.Administrator,acme.roles.Patron,acme.framework.roles.Authenticated"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link"
				action="http://www.example.com/" />
			<acme:menu-suboption
				code="master.menu.anonymous.daniel-favourite-link"
				action="http://www.twitter.com/" />
			<acme:menu-suboption
				code="master.menu.anonymous.bogdan-favourite-link"
				action="https://www.youtube.com/c/Matthornepottery/" />
			<acme:menu-suboption code="master.menu.anonymous.luis-favourite-link"
				action="https://www.justwatch.com/" />
			<acme:menu-suboption
				code="master.menu.anonymous.ernesto-favourite-link"
				action="https://www.twitch.tv/" />
			<acme:menu-suboption
				code="master.menu.anonymous.regina-favourite-link"
				action="https://www.e-lactancia.org/" />
			<acme:menu-suboption code="master.menu.anonymous.jose-favourite-link"
				action="https://www.juntadeandalucia.es/" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator"
			access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts"
				action="/administrator/user-account/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.dashboard"
				action="/administrator/administrator-dashboard/show" />
			<acme:menu-suboption code="master.menu.administrator.configuration"
				action="/administrator/configuration/show" />
			<acme:menu-separator />
			<acme:menu-suboption
				code="master.menu.administrator.populate-initial"
				action="/administrator/populate-initial" />
			<acme:menu-suboption code="master.menu.administrator.populate-sample"
				action="/administrator/populate-sample" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.shut-down"
				action="/administrator/shut-down" />
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.any" access="hasRole('Any')">
			<acme:menu-suboption code="master.menu.any.user-accounts" action="/any/user-account/list"/>
			<acme:menu-suboption code="master.menu.any.toolkits" action="/any/toolkit/list"/>
			<acme:menu-suboption code="master.menu.any.item" action="/any/item/list"/>
			<acme:menu-suboption code="master.menu.any.chirp" action="/any/chirp/list"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.authenticated" access="hasRole('Authenticated')">
			<acme:menu-suboption code="master.menu.authenticated.announcement" action="/authenticated/announcement/list"/>
			<acme:menu-suboption code="master.menu.authenticated.configuration" action="/authenticated/configuration/show"/>
		</acme:menu-option>

		<sec:authorize access="hasRole('Inventor')">
			<acme:menu-option code="master.menu.inventor">
			    <acme:menu-suboption code="master.menu.inventor.items"
					action="/inventor/item/list" />
				<acme:menu-suboption code="master.menu.inventor.items.create"
					action="/inventor/item/create" />
				<acme:menu-suboption code="master.menu.inventor.toolkits"
				    action="/inventor/toolkit/list" />
				<acme:menu-suboption code="master.menu.inventor.toolkits.create"
				    action="/inventor/toolkit/create" />
				<acme:menu-suboption code="master.menu.inventor.patronages"
					action="/inventor/patronage/list" />
				<acme:menu-suboption code="master.menu.inventor.patronage-reports"
					action="/inventor/patronage-report/list" />
			</acme:menu-option>
		</sec:authorize>

		
		<acme:menu-option code="master.menu.patron" access="hasRole('Patron')">
			<acme:menu-suboption code="master.menu.patron.dashboard"
					action="/patron/patron-dashboard/show" />
			<acme:menu-suboption code="master.menu.patron.patronages"
					action="/patron/patronage/list" />
			<acme:menu-suboption code="master.menu.patron.patronages.create"
					action="/patron/patronage/create"/>
			<acme:menu-suboption code="master.menu.patron.patronage-reports"
					action="/patron/patronage-report/list" />
		</acme:menu-option>
	

		<acme:menu-option code="master.menu.provider"
			access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link"
				action="http://www.example.com/" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer"
			access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link"
				action="http://www.example.com/" />
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up"
			action="/anonymous/user-account/create" access="isAnonymous()" />
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in"
			access="isAnonymous()" />

		<acme:menu-option code="master.menu.user-account"
			access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data"
				action="/authenticated/user-account/update" />
				
			<acme:menu-suboption code="master.menu.user-account.become-provider"
				action="/authenticated/provider/create"
				access="!hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.provider"
				action="/authenticated/provider/update" access="hasRole('Provider')" />
				
			<acme:menu-suboption code="master.menu.user-account.become-consumer"
				action="/authenticated/consumer/create"
				access="!hasRole('Consumer')" />
			<acme:menu-suboption code="master.menu.user-account.consumer"
				action="/authenticated/consumer/update" access="hasRole('Consumer')" />
				
			<acme:menu-suboption code="master.menu.user-account.become-patron"
				action="/authenticated/patron/create"
				access="!hasRole('Patron')" />
			<acme:menu-suboption code="master.menu.user-account.patron"
				action="/authenticated/patron/update" access="hasRole('Patron')" />
				
			<acme:menu-suboption code="master.menu.user-account.become-inventor"
				action="/authenticated/inventor/create"
				access="!hasRole('Inventor')" />
			<acme:menu-suboption code="master.menu.user-account.inventor"
				action="/authenticated/inventor/update" access="hasRole('Inventor')" />
				
				
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out"
			action="/master/sign-out" access="isAuthenticated()" />
	</acme:menu-right>
</acme:menu-bar>

