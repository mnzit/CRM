<%@include file="../shared/header.jsp" %>

<div class="jumbotron">
    <h1 class="display-4 text-center">Customers</h1>
</div>
<table class="table table-hover">
    <tr class = "font-weight-bold">
        <td>Id</td>
        <td>Name</td>
        <td>Email</td>
        <td>Contact no</td>
        <td>Actions</td>
    </tr>
    <c:forEach items="${customers}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.email}</td>
            <td>${c.contactNo}</td>
            <td> 
                <a href="${SITE_URL}/customer/edit/${c.id}" class="btn btn-primary">Edit</a>
                <a href="${SITE_URL}/customer/delete/${c.id}" class="btn btn-danger">Delete</a>
                <a href="${SITE_URL}/customer/profile/${c.id}" class="btn btn-info">Profile</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="../shared/footer.jsp" %>