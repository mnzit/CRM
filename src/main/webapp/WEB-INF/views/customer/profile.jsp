<%@include file="../shared/header.jsp" %>
<div class="card">
    <h5 class="card-header text-center">${customer.name}</h5>
    <div class="card-body">
        <div class="row">
            <div class="col-md-6">
                <h6>Id: ${customer.id}</h6>
            </div>
            <div class="col-md-6">
                <h6>Email: ${customer.email}</h6>
            </div>
            <div class="col-md-6">
                <h6>Contact no: ${customer.contactNo}</h6>
            </div>
            <div class="col-md-6">
                <h6>Date created: ${customer.dateCreated}</h6>
            </div>
        </div>
    </div>
</div>
<br/>
<div class="card">
    <h5 class="card-header text-center">Follow-ups</h5>
    <div class="card-body">
        <c:choose>
            <c:when test="${empty conversations}"><div class="text-center font-italic">No follow-ups yet</div></c:when>
            <c:otherwise>
                <table class="table table-hover">
                    <tr class = "font-weight-bold">
                        <td>Id</td>
                        <td>Message</td>
                        <td>Date</td>
                    </tr>
                    <c:forEach items="${conversations}" var="c">
                        <c:forEach items="${types}" var="t">
                            <c:if test="${t.id eq c.messageType.id}"><tr style="background:${t.color}"></c:if>
                            </c:forEach>                       
                            <td>${c.id}</td>
                            <td>${c.message}</td>
                            <td>${c.messageDate}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
        <hr/>
        <form action="${SITE_URL}/addconversation" method="POST">
            <div class="form-group">
                <div class="form-group">
                    <label class = "font-weight-bold">Message</label>
                    <textarea name="message" class="form-control" rows="3" placeholder="Enter message here"></textarea>
                </div>
                <label class = "font-weight-bold">Type</label>
                <select class="form-control form-control-sm" name="type">
                    <c:forEach items="${types}" var="t">
                        <option value="${t.id}">${t.type}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="hidden" name="id" value="${customer.id}">
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
<%@include file="../shared/footer.jsp" %>